
class ShipPieceP extends ShipPiece{

	public ShipPieceP() {
		this.hitsRequired = SHIP_PIECE_P_HITS_REQ;
		this.shipPieceType = SHIP_PIECE_P;
	}
	public int getHitsRequired() {
		return hitsRequired;
	}
	public void setHitsRequired(int hitsRequired) {
		this.hitsRequired = SHIP_PIECE_P_HITS_REQ;
	}
	public String getShipPieceType() {
		return shipPieceType;
	}
	public void setShipPieceType(String shipPieceType) {
		this.shipPieceType = SHIP_PIECE_P;
	}
}
