package designPattern.parkingLot;

import java.util.HashMap;
enum levels  {
	Small,
	Medium,
	Large
};
abstract class MultipleLevels {
	protected int totalSpotsCount;
	protected levels slotSize;
	protected HashMap<String, Integer> listOfSlots;
	protected int price;
	protected int availableSpotsCount;
	
	public int getTotalSpotsCount() {
		return totalSpotsCount;
	}
	public void setTotalSpotsCount(int totalSpotsCount) {
		this.totalSpotsCount = totalSpotsCount;
	}
	public levels getSlotSize() {
		return slotSize;
	}
	public void setSlotSize(levels slotSize) {
		this.slotSize = slotSize;
	}
	public HashMap<String, Integer> getListOfSlots() {
		return listOfSlots;
	}
	public void setListOfSlots(HashMap<String, Integer> listOfSlots) {
		this.listOfSlots = listOfSlots;
	}
	public int getAvailableSpotsCount() {
		return availableSpotsCount;
	}
	public void setAvailableSpotsCount(int availableSpotsCount) {
		this.availableSpotsCount = availableSpotsCount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
