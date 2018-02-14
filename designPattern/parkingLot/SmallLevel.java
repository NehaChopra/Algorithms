package designPattern.parkingLot;

import java.util.ArrayList;
import java.util.List;

class SmallLevel extends MultipleLevels{
	public SmallLevel(int totalSpotsCount, levels slotSize,int price){
		this.totalSpotsCount = totalSpotsCount;
		this.slotSize = slotSize;
		this.listOfSlots = new ArrayList<Integer>(this.totalSpotsCount);
		this.price = price;
	}
}
