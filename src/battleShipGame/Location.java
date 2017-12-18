/*
 *  This class would determine single element of the grid.
 *  For Instance Grid 2 * 2, A1 Row A and Column 1 would represent a single location of a grid.
 *  
 *  Location would contain the information whether part of a ship or whole ship is placed.
 *  Will also contain the information whether the location is hit / missed / partially hit point
 *  If location is hit = 1
 *  If location is missed = 0
 *  If location already estimated  = 10
 */
class Location implements Constants{
	private ShipPiece typeOfShipPiece;
	private int currentStatus;
	private String locationName;
	private boolean hasShip;
	public Location() {
		this.hasShip = false;
		this.currentStatus = -2;
		this.locationName = "-2";
	}
	public ShipPiece getTypeOfShipPiece() {
		return typeOfShipPiece;
	}
	public void setTypeOfShipPiece(ShipPiece typeOfShipPiece) {
		this.typeOfShipPiece = typeOfShipPiece;
	}
	public int getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(int currentStatus) {
		this.currentStatus = currentStatus;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public boolean isHasShip() {
		return hasShip;
	}
	public void setHasShip(boolean hasShip) {
		this.hasShip = hasShip;
	}
	public void markHit(){
		if(currentStatus == -1){
			if(typeOfShipPiece.shipPieceType.equals(SHIP_PIECE_Q)){
				setCurrentStatus(PARTIALLY_HIT);
			}else{
				setCurrentStatus(HIT);
			}
		}else{
			setCurrentStatus(HIT);
		}
	}
	public void markMiss(){
		setCurrentStatus(MISS);
	}
	public boolean shipDestroyedAtLocation(){
		return ((getCurrentStatus()==HIT) ? true:false) ;
	}
	public void destroyShipAtLocation(){
		this.hasShip = false;
		this.currentStatus = -2;
		this.locationName = "-2";
	}
	public String toString(){
		return this.locationName;
	}
}
