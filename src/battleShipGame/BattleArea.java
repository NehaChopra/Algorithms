
class BattleArea implements Constants{
	private Location[][] location;
	private String battleAffected;
	
	public BattleArea(int row, int col) {
		location = new Location[row][col];
		initializeLocation();
	}
	public Location[][] getLocation() {
		return location;
	}
	public void setLocation(Location[][] location) {
		this.location = location;
	}
	public void initializeLocation(){
		for(int iIndex=0; iIndex<location.length;iIndex++){
			for(int jIndex=0; jIndex<location[iIndex].length;jIndex++){
				location[iIndex][jIndex] = new Location();
			}
		}
	}
	public void printLocation(){
		for(int iIndex=0; iIndex<location.length;iIndex++){
			for(int jIndex=0; jIndex<location[iIndex].length;jIndex++){
				System.out.print(location[iIndex][jIndex] + "   ");
			}
			System.out.println();
		}
	}
	public void shipPlacement(int row, int col, ShipPiece typeOfShipPiece){
		location[row][col].setTypeOfShipPiece(typeOfShipPiece);
		location[row][col].setHasShip(true);
		location[row][col].setLocationName(typeOfShipPiece.shipPieceType);
		location[row][col].setCurrentStatus(-1);
	}
	public boolean fire(int row, int col){
		if(location[row][col].isHasShip()){
			return markHit(row, col);
		}else{
			return markMiss(row, col);
		}
	}
	public boolean markHit(int row, int col){
		location[row][col].markHit();
		if(location[row][col].getCurrentStatus() == HIT){
			location[row][col].destroyShipAtLocation();
		}
		setBattleAffected(HIT_STATUS);
		return true;
	}
	public boolean markMiss(int row, int col){
		location[row][col].markMiss();
		setBattleAffected(MISS_STATUS);
		return false;
	}
	public String getBattleAffected() {
		return battleAffected;
	}
	public void setBattleAffected(String battleAffected) {
		this.battleAffected = battleAffected;
	}
}
