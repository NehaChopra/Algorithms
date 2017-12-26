
//http://www.geeksforgeeks.org/design-parking-lot-using-object-oriented-principles/

package designPattern;

import java.util.ArrayList;

interface VehicleConstants{
	public static final String VEHICLE_SMALL = "SMALL";
	public static final String VEHICLE_MEDIUM = "MEDIUM";
	public static final String VEHICLE_LARGE = "LARGE";
	
	public static final int BIKE_AREA = 1;
	public static final int CAR_AREA = 2;
	public static final int BUS_AREA = 3;
}

interface ParkingLotsConstants{
	public static final String LEVEL1 = "LEVEL1";
	public static final String LEVEL2 = "LEVEL2";
	public static final String LEVEL3 = "LEVEL3";
	
	public static final int LEVEL1_SPACE = 20;
	public static final int LEVEL2_SPACE = 20;
	public static final int LEVEL3_SPACE = 20;
}

abstract class Vehicle{
	protected String vehiclePlateNo;
	protected int spotSizeReq;
	protected String sizeModel;
	public String getVehiclePlateNo() {
		return vehiclePlateNo;
	}
	public void setVehiclePlateNo(String vehiclePlateNo) {
		this.vehiclePlateNo = vehiclePlateNo;
	}
	public int getSpotSizeReq() {
		return spotSizeReq;
	}
	public String getSizeModel() {
		return sizeModel;
	}
	abstract public boolean canIFit();
}

class Bike extends Vehicle{
	public Bike(String vehiclePlateNo){
		this.vehiclePlateNo = vehiclePlateNo;
		this.spotSizeReq = VehicleConstants.BIKE_AREA;
		this.sizeModel = VehicleConstants.VEHICLE_SMALL;
	}
	public boolean canIFit(){
		return true;
	}
}
class Car extends Vehicle{
	public Car(String vehiclePlateNo){
		this.vehiclePlateNo = vehiclePlateNo;
		this.spotSizeReq = VehicleConstants.CAR_AREA;
		this.sizeModel = VehicleConstants.VEHICLE_MEDIUM;
	}
	public boolean canIFit(){
		return true;
	}
}
class Bus extends Vehicle{
	public Bus(String vehiclePlateNo){
		this.vehiclePlateNo = vehiclePlateNo;
		this.spotSizeReq = VehicleConstants.BUS_AREA;
		this.sizeModel = VehicleConstants.VEHICLE_LARGE;
	}
	public boolean canIFit(){
		return true;
	}
}
class ParkingLot {
	private String level;
	private int spotNumber;
	private Vehicle vehicle;
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public int getSpotNumber() {
		return spotNumber;
	}
	public void setSpotNumber(int spotNumber) {
		this.spotNumber = spotNumber;
	}
	public boolean isAvailable(){
		return vehicle == null;
	}
	public boolean canIFit(Vehicle vehicle){
		return vehicle.canIFit();
	}
}

class ParkingFieldPlacement{
	ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
	
}



/*
 * package Elevator;
public class Constants {
	public static final int FLOORS = 40;
	public static final int ELEVATORS = 16;
	public static final int NUM_PEOPLE = 10;
	public static final int MAX_PEOPLE = 5;
	public static final int MIN_FLOOR = FLOORS + 1;
	public static final int MAX_FLOOR = -1;
	
}

package Elevator;
public interface IElevatorController {
	public void status ();
	public Elevator getElevator(int elevatorID);
	public void update(int elevatorId, int floor);
	public void pickup(int floor , boolean direction);
	public void reset(int elevatorId, int floor);
	public void step();
}

package Elevator;
public interface ElevatorEventListener {
	public void onStopped(Object sender);
}

package Elevator;

public class Elevator {
	public enum DIRECTION {
		NONE, UP, DOWN
	}
	private DIRECTION direction = DIRECTION.NONE;
	private Boolean move = false;
	
	private boolean [] floors;
	private int countUp = 0;
	private int countDown = 0;		
	private int cf = 0;
	private int min = Constants.MIN_FLOOR;
	private int max = Constants.MAX_FLOOR;
	private int numFloors;
	
	private ElevatorEventListener elEventListener;
	
	public Elevator(int numFloors) {
		if(numFloors<0)  throw new IllegalArgumentException();
		this.numFloors = numFloors;
		floors = new boolean [numFloors];
	}


	public Integer getCurrentFloor() {
		return cf;
	}
	
	public int getGoalFloor() {
		if(direction == DIRECTION.UP ) return max;
		if(direction == DIRECTION.DOWN ) return min;
		return -1;
	}

	public void moveNext(){		
		if(!move) {
			move = (direction != DIRECTION.NONE);
			return;
		}
		if(direction == DIRECTION.UP) {
			if(floors[++cf]) {
				floors[cf] = false;
				if(--countUp == 0) {
					direction = (countDown == 0)?(DIRECTION.NONE):(DIRECTION.DOWN);
					max = Constants.MAX_FLOOR;
				}
				move = false;
				if(elEventListener != null) elEventListener.onStopped(this);
			}
			return;
		}
		if (direction == DIRECTION.DOWN) {
			if(floors[--cf]) {
				floors[cf] = false;
				if(++countDown == 0) { 
					direction = (countUp == 0)?(DIRECTION.NONE):(DIRECTION.UP);
					min = Constants.MIN_FLOOR;
				}
				move = false;
				if(elEventListener != null) elEventListener.onStopped(this);
			}
		}
	}

	public void setGoalFloor(int gf) {
		if((gf<0) || (gf >= numFloors ) ) throw new IllegalArgumentException();
		if(cf == gf) return;
		if(floors[gf]) return;
		floors[gf] = true;
		if(gf>cf) { countUp++;  	max = (gf>max)?(gf):(max); }
		if(gf<cf) { countDown--; 	min = (gf<min)?(gf):(min); }
		if(direction == DIRECTION.NONE)
			direction = (gf>cf)?(DIRECTION.UP):(DIRECTION.DOWN);
	}
	
	public void reset() {
		cf = countUp = countDown = 0;
		move = false;
		direction = DIRECTION.NONE;
		floors = new boolean [numFloors];
		max = Constants.MAX_FLOOR; min = Constants.MIN_FLOOR;
	}
	
	public void moveToFloor(int floor) {
		if((floor<0) || (floor >= numFloors ) ) throw new IllegalArgumentException();
		reset();
		cf = floor;
	}
	
	public boolean getMove() {
		return move;
	}
	public DIRECTION getDirection() {
		return direction;
	}

	public void setElEventListener(ElevatorEventListener elEventListener) {
		this.elEventListener = elEventListener;
	}
}

package Elevator;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class ElevatorController implements IElevatorController, ElevatorEventListener {
	private int numElevators;
	private int numFloors;
	private Elevator [] elevators = null;
	private ArrayList<Queue<Integer>> passengers = null;
		
	private void  initElevators(int numElevators, int numFloors) {
		if(numElevators<0)  throw new IllegalArgumentException();
		elevators = new Elevator [numElevators];
		for (int i=0; i<numElevators;i++) {
			Elevator el = new Elevator(numFloors);
			el.setElEventListener(this);
			elevators[i] = el;
		}
	}
	
	private void initFloors(int numFloors) {
		if(numFloors<0)  throw new IllegalArgumentException();
		passengers = new ArrayList<Queue<Integer>> (numFloors);
		for(int i=0;i<numFloors;i++) passengers.add(i, new Queue<Integer>());
	}

	public ElevatorController (int numElevators, int numFloors) {
		initFloors(numFloors);
		initElevators(numElevators, numFloors);
		this.numElevators = numElevators;
		this.numFloors = numFloors;
	}
	
	private int calculateRoute(int afloor, int bfloor) {
		return Math.abs(afloor - bfloor);
	}
	
	private int calculateRoute(int xfloor, int xefloor, int tfloor) {
		return calculateRoute(xefloor, tfloor) + calculateRoute(xfloor, tfloor);
	}
	
	
	public Queue<Integer> getPassengers(int floor) {
		if((floor<0) || (floor >= numFloors )  ) throw new IllegalArgumentException();
		return passengers.get(floor);
	}

	public void setPassengers(Queue<Integer> pssgrs, int floor) {
		if(pssgrs == null) throw new NullPointerException();
		if((floor<0) || (floor >= numFloors )  ) throw new IllegalArgumentException();
		this.passengers.add(floor, pssgrs);
	}
	
	@Override
	public  void status() {
		int i = 0;
		for(Elevator el:elevators) {
			StdOut.print( " elID =  " + i++ + " CurrentFloor = " + el.getCurrentFloor() + " Moving =  " + el.getMove()  +  " DIRECTION = " + el.getDirection() + "\n");
		}
	}
	
	@Override
	public Elevator getElevator(int elevatorId) {
		if((elevatorId<0) || (elevatorId >= numElevators ) ) throw new NoSuchElementException();
		return elevators[elevatorId];
	}
	
	@Override
	public void reset(int elevatorId, int floor) {
		if((elevatorId<0) || (elevatorId >= numElevators ) ) throw new NoSuchElementException();
		Elevator elevator = elevators[elevatorId];
		elevator.moveToFloor(floor);
	}
	
	@Override
	public void pickup(int floor, boolean direction) {
		if((floor<0) || (floor >= numFloors )) throw new IllegalArgumentException();
		// shufling the order of elevators in the case where most of the elevators are on the same floors and they are picked up at the same time from different floors
		// this is going to run several elevators instead of only the first !
		int [] elevatorIDs = new int[numElevators];
		for(int i=0; i<numElevators; i++) elevatorIDs[i] = i;
		StdRandom.shuffle(elevatorIDs);
		
		Elevator.DIRECTION userDirection = (direction) ? (Elevator.DIRECTION.UP):(Elevator.DIRECTION.DOWN);
		int minDistance = numFloors;
		Elevator closestElevator = null;
		int d;
		for (int elID : elevatorIDs ) {
			Elevator elevator = elevators[elID];
			if(	(elevator.getMove() == false) || 
				((userDirection == Elevator.DIRECTION.UP) && (elevator.getDirection() == Elevator.DIRECTION.UP) && (floor >= elevator.getCurrentFloor())) || 
				((userDirection == Elevator.DIRECTION.DOWN) && (elevator.getDirection() == Elevator.DIRECTION.DOWN) && (floor <= elevator.getCurrentFloor())) ) 
					d =	calculateRoute(floor,elevator.getCurrentFloor());
			else 
					d = calculateRoute(floor, elevator.getCurrentFloor(), elevator.getGoalFloor());
			
			if(d<minDistance) {
				minDistance = d;
				closestElevator = elevator;
			}
		}
		
		closestElevator.setGoalFloor(floor);
	}
	
	@Override
	public void update(int elevatorId, int floor) {
		if((floor<0) || (floor >= numFloors )) throw new IllegalArgumentException();
		if((elevatorId<0) || (elevatorId >= numElevators ) ) throw new NoSuchElementException();
		
		Elevator el = elevators[elevatorId];
		el.setGoalFloor(floor);
	}

	@Override
	public void step() {
		for(Elevator elevator : elevators) elevator.moveNext();
	}
	
	@Override
	public void onStopped(Object sender) {
		/// onboarding waiting people
		Queue<Integer> psQueue = getPassengers(((Elevator)sender).getCurrentFloor());
		if(psQueue == null) return;
		if(psQueue.isEmpty()) return;
		for(Integer goalFloor : psQueue){
			((Elevator)sender).setGoalFloor(goalFloor);
		}
	}
}
*/
