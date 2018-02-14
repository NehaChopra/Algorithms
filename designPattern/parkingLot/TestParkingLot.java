package designPattern.parkingLot;

import java.util.Scanner;
/*
 * 
 * Assumptions:
 * 1. Parking lot has building, where 3 levels exits
 * 2. Level Small for motorcycle, Level Medium for car and Level Large for Bus
 * 3. Multiple levels are defined Small, Medium and Large who's price varies according to space occupied.
 * 
 */
class TestParkingLot {
	public static void main(String []args){
		
		ParkingLot lotBuilding = new ParkingLot(1);
		
		
		
		
		System.out.println("Enter the type of Vehicle arrived: Motorcycle / Car / Bus  and licesenceNumber");
		Scanner input = new Scanner(System.in);
		String data = input.nextLine();
		while((data != null) && (data != "exit")){
			Vehicle vehicle = VehicleFactory.createObject(data, input.nextLine());
			
		}
	}
}
