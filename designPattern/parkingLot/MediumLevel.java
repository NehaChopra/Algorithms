package designPattern.parkingLot;

import java.util.ArrayList;
import java.util.List;

class MediumLevel extends MultipleLevels{
	public MediumLevel(int totalSpotsCount, levels slotSize, int price){
		this.totalSpotsCount = totalSpotsCount;
		this.slotSize = slotSize;
		this.listOfSlots = new ArrayList<Integer>(this.totalSpotsCount);
		this.price = price;
	}
}
