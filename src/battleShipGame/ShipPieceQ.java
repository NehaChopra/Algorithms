class ShipPieceQ extends ShipPiece{

	public ShipPieceQ() {
		this.hitsRequired = SHIP_PIECE_Q_HITS_REQ;
		this.shipPieceType = SHIP_PIECE_Q;
	}
	public int getHitsRequired() {
		return hitsRequired;
	}
	public void setHitsRequired(int hitsRequired) {
		this.hitsRequired = SHIP_PIECE_Q_HITS_REQ;
	}
	public String getShipPieceType() {
		return shipPieceType;
	}
	public void setShipPieceType(String shipPieceType) {
		this.shipPieceType = SHIP_PIECE_Q;
	}
}