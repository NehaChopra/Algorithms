package designPattern.parkingLot;

enum VehicleSize  {
	Small,
	Medium,
	Large
};
abstract class Vehicle {
	protected String lincensePlateNo;
	protected VehicleSize size;
	public String getLincensePlateNo() {
		return lincensePlateNo;
	}
	public void setLincensePlateNo(String lincensePlateNo) {
		this.lincensePlateNo = lincensePlateNo;
	}
	public VehicleSize getSize() {
		return size;
	}
	public void setSize(VehicleSize size) {
		this.size = size;
	}
}
