package designPattern.parkingLot;

class ParkingLot {
	protected ParkingSpace parkingSpace[];
	public ParkingSpace[] getParkingSpace() {
		return parkingSpace;
	}
	public void setParkingSpace(ParkingSpace[] parkingSpace) {
		this.parkingSpace = parkingSpace;
	}
	public ParkingLot(){
	}
	public ParkingLot(int spaceLength){
		parkingSpace = new ParkingSpace[spaceLength];
		for(int index=0; index<spaceLength; index++){
			parkingSpace[index] = new ParkingSpace("A", 1);
		}
	}
	public void parkVehicle(Vehicle vehicle){
		if(parkingSpace[0].levels[0].availableSpotsCount == 0){
			System.out.println("NO Parking Space left out .............");
			return;
		}
		
	}
	public void unparkVehicle(Vehicle vehicle){
		
	}
}
