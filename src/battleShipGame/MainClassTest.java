import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MainClassTest {

	@Test
	public void mainClasstest1() {
		BattleArea battleArea = new BattleArea(5, 5);
		int numOfBattleShips = 2;
		
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player("Player-1", numOfBattleShips));
		players.add(new Player("Player-2", numOfBattleShips));
		
//		for(int index=0; index<numOfBattleShips;index++){
//			for(int playerIndex=0;playerIndex<players.size();playerIndex++){
//				ShipPiece shipPiece1 = new ShipPieceQ();
//				battleArea.shipPlacement(0, 0, shipPiece1);
//				Ship ship = new Ship();
//				ship.getShipPiecesLocations().add((battleArea.getLocation())[0][0]);
//				System.out.println(ship.isShipDestroyed());
//			}
//		}
		//////////////////////////////////////////////// Player-1///////////////////////////////////////////////////////
		ShipPiece shipPiece1 = new ShipPieceQ();
		battleArea.shipPlacement(0, 0, shipPiece1);
		Ship ship1 = new Ship();
		ship1.getShipPiecesLocations().add((battleArea.getLocation())[0][0]);
		
		
		ShipPiece shipPiece3 = new ShipPieceQ();
		battleArea.shipPlacement(4, 4, shipPiece3);
		
		ShipPiece shipPiece4 = new ShipPieceQ();
		battleArea.shipPlacement(4, 5, shipPiece4);
		
		Ship ship3 = new Ship();
		ship3.getShipPiecesLocations().add((battleArea.getLocation())[4][4]);
		ship3.getShipPiecesLocations().add((battleArea.getLocation())[4][5]);
		
		
		
		//////////////////////////////////////////////// Player-2///////////////////////////////////////////////////////
		ShipPiece shipPiece2 = new ShipPieceQ();
		battleArea.shipPlacement(1, 2, shipPiece2);
		Ship ship2 = new Ship();
		ship2.getShipPiecesLocations().add((battleArea.getLocation())[1][2]);
		
		
		ShipPiece shipPiece5 = new ShipPieceQ();
		battleArea.shipPlacement(3, 3, shipPiece5);
		
		ShipPiece shipPiece6 = new ShipPieceQ();
		battleArea.shipPlacement(3, 4, shipPiece6);
		
		Ship ship4 = new Ship();
		ship3.getShipPiecesLocations().add((battleArea.getLocation())[3][3]);
		ship3.getShipPiecesLocations().add((battleArea.getLocation())[3][4]);
		
		for(int playerIndex=0;playerIndex<players.size();playerIndex++){
			BattleArea ba = ((Player)(players.get(playerIndex))).getPlayerBattleArea();
			ba.printLocation();
			System.out.println("=====================================================");
		}
	}
}
