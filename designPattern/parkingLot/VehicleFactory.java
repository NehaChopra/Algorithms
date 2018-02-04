package designPattern.parkingLot;

class VehicleFactory {
	public static Vehicle createObject(String typeOfVehicle, String lincensePlateNo){
		if(typeOfVehicle.equalsIgnoreCase("Motorcycle")){
			return new Motorcycle(lincensePlateNo, VehicleSize.Small);
		}else if(typeOfVehicle.equalsIgnoreCase("Car")){
			return new Car(lincensePlateNo, VehicleSize.Medium);
		}else if(typeOfVehicle.equalsIgnoreCase("Bus")){
			return new Bus(lincensePlateNo, VehicleSize.Large);
		}else{
			return null;
		}
	}
}
