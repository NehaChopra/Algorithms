package designPattern.parkingLot;

class ParkingSpace {
	protected String spaceLabel;
	protected MultipleLevels levels[];
	protected int entranceGates[];
	public String getSpaceLabel() {
		return spaceLabel;
	}
	public void setSpaceLabel(String spaceLabel) {
		this.spaceLabel = spaceLabel;
	}
	public MultipleLevels[] getLevels() {
		return levels;
	}
	public void setLevels(MultipleLevels[] levels) {
		this.levels = levels;
	}
	public int[] getEntranceGates() {
		return entranceGates;
	}
	public void setEntranceGates(int[] entranceGates) {
		this.entranceGates = entranceGates;
	}
	public ParkingSpace(){
	}
	public ParkingSpace(String spaceLabel, int gates){
		this.spaceLabel = spaceLabel;
		levels[0] = LevelsFactory.createObject("Small");
		levels[1] = LevelsFactory.createObject("Medium");
		levels[2] = LevelsFactory.createObject("Large");
		entranceGates = new int[gates];
	}
}
