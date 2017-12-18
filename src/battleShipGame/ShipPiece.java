/*
 * This class would determine the type of ship.
 * The strength associated with the ship.
 * Type-Q ship requires 2 accurate missiles hit to get destroyed 
 * Type-P ship part will get destroyed only by 1 missile hit. 
 * 
 */
abstract class ShipPiece implements Constants{
	protected int hitsRequired;
	protected String shipPieceType;
	public ShipPiece() {
		// TODO Auto-generated constructor stub
	}
}
