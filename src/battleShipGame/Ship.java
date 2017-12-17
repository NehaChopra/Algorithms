import java.util.ArrayList;
import java.util.Iterator;

class Ship {
	private ArrayList<Location> shipPiecesLocations;
	public Ship() {
		shipPiecesLocations = new ArrayList<Location>();
		setShipPiecesLocations(shipPiecesLocations);
	}
	public ArrayList<Location> getShipPiecesLocations() {
		return shipPiecesLocations;
	}
	public void setShipPiecesLocations(ArrayList<Location> shipPiecesLocations) {
		this.shipPiecesLocations = shipPiecesLocations;
	}
	public boolean isShipDestroyed(){
		boolean destroyed =true;
		for(int index=0; index<shipPiecesLocations.size(); index++){
			destroyed  = destroyed && (!((Location)(shipPiecesLocations.get(index))).isHasShip());
		}
		return destroyed;
	}
}
