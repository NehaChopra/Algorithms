
//https://practice.geeksforgeeks.org/problems/design-elevator

package designPattern;

interface ElevatorConstants{
	public static final int START_POINT = 0;
	public static final int MAX_CAPACITY = 20;
	public static final int MAX_FLOORS = 20;
	public static final String UP = "up";
	public static final String DOWN = "down";
	public static final String NONE = "none";
}
class Elevator implements ElevatorConstants{
	private String direction;
	private int currentFloor;
	private boolean[] floors = new boolean[20];
	private boolean isLimitCrossed;
	private boolean isMoving;
	public Elevator(int currentFloor, String direction){
		this.currentFloor = currentFloor;
		this.direction = direction;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public int getCurrentFloor() {
		return currentFloor;
	}
	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	public boolean[] getFloors() {
		return floors;
	}
	public void setFloors(boolean[] floors) {
		this.floors = floors;
	}
	public boolean isLimitCrossed() {
		return isLimitCrossed;
	}
	public void setLimitCrossed(boolean isLimitCrossed) {
		this.isLimitCrossed = isLimitCrossed;
	}
	public boolean isMoving() {
		return isMoving;
	}
	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}
	public void pressDemandFloorNumber(int floorNumber){
		setDirection((getCurrentFloor() < floorNumber) ? (UP) : (DOWN));
		floors[floorNumber] = true;
		
		calculateRoute();
	}
	public void pressDemandFloorNumber(int[] floorNumbers){
		
	}
	public void calculateRoute(){
		String buildPath = "";
		if(getDirection().equals(UP)){
			for(int index=getCurrentFloor(); index<MAX_FLOORS; index++){
				if(floors[index]){
					setCurrentFloor(index);
					buildPath = buildPath.concat(this.toString());
					printRoute(buildPath.toString());
				}
			}
		}
		if(getDirection().equals(DOWN)){
			for(int index=getCurrentFloor(); index==START_POINT; index--){
				if(floors[index]){
					setCurrentFloor(index);
					buildPath = buildPath.concat(this.toString());
					printRoute(buildPath.toString());
				}
			}
		}
	}
	public void printRoute(String buildPath){
		System.out.println(buildPath);
	}
	public String toString(){
		return "Elevator: Floor: "+getCurrentFloor()+" direction: "+getDirection() + "\n";
	}
}
public class DesignElevator implements ElevatorConstants{
	public static void main(String []args){
		Elevator obj = new Elevator(START_POINT, NONE);
		obj.pressDemandFloorNumber(2);
		obj.pressDemandFloorNumber(12);
		obj.pressDemandFloorNumber(19);
		obj.pressDemandFloorNumber(0);
	}
}