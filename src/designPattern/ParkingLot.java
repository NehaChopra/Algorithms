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
