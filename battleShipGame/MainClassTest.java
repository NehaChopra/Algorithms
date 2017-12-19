//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//
//import org.junit.Test;
//
//public class MainClassTest {
//
//	@Test
//	public void mainClasstest1() {
//		BattleArea battleArea = new BattleArea(5, 5);
//		BattleArea battleArea1 = new BattleArea(5, 5);
//		int numOfBattleShips = 2;
//		
//		ArrayList<Player> players = new ArrayList<Player>();
//		players.add(new Player("Player-1", numOfBattleShips));
//		players.add(new Player("Player-2", numOfBattleShips));
//		
//		
//		Player player1 = players.get(0);
//		Player player2 = players.get(1);
//		
//		//////////////////////////////////////////////// Player-1///////////////////////////////////////////////////////
//		ShipPiece shipPiece1 = new ShipPieceQ();
//		battleArea.shipPlacement(0, 0, shipPiece1);
//		Ship ship1 = new Ship();
//		ship1.getShipPiecesLocations().add((battleArea.getLocation())[0][0]);
//		
//		ShipPiece shipPiece3 = new ShipPieceP();
//		battleArea.shipPlacement(3, 3, shipPiece3);
//		
//		ShipPiece shipPiece4 = new ShipPieceP();
//		battleArea.shipPlacement(3, 4, shipPiece4);
//		
//		Ship ship3 = new Ship();
//		ship3.getShipPiecesLocations().add((battleArea.getLocation())[3][3]);
//		ship3.getShipPiecesLocations().add((battleArea.getLocation())[3][4]);
//		
//		Ship[] ships = {ship1, ship3};
//		player1.setShips(ships);
//		
//		//////////////////////////////////////////////// Player-2///////////////////////////////////////////////////////
//		ShipPiece shipPiece2 = new ShipPieceQ();
//		battleArea1.shipPlacement(1, 1, shipPiece2);
//		Ship ship2 = new Ship();
//		ship2.getShipPiecesLocations().add((battleArea1.getLocation())[1][1]);
//		
//		
//		ShipPiece shipPiece5 = new ShipPieceP();
//		battleArea1.shipPlacement(2, 2, shipPiece5);
//		
//		ShipPiece shipPiece6 = new ShipPieceP();
//		battleArea1.shipPlacement(2, 3, shipPiece6);
//		
//		Ship ship4 = new Ship();
//		ship4.getShipPiecesLocations().add((battleArea1.getLocation())[2][2]);
//		ship4.getShipPiecesLocations().add((battleArea1.getLocation())[2][3]);
//		
//		Ship[] ships1 = {ship2, ship4};
//		player2.setShips(ships1);
//		
//		player1.setPlayerBattleArea(battleArea);
//		player2.setPlayerBattleArea(battleArea1);
//		player1.assignMissiles(0, 0);
//		player1.assignMissiles(1, 1);
//		player1.assignMissiles(1, 1);
//		player1.assignMissiles(1, 2);
//		
//		
//		player2.assignMissiles(0, 0);
//		player2.assignMissiles(1, 1);
//		player2.assignMissiles(1, 2);
//		player2.assignMissiles(0, 0);
//		player2.assignMissiles(3, 0);
//		player2.assignMissiles(4, 0);
//		player2.assignMissiles(3, 3);
//		player2.assignMissiles(3, 3);
//		player2.assignMissiles(3, 4);
//		player2.assignMissiles(3, 4);
//		
//		MainClass.startGame(player1, player2);
//		assertTrue( player1.allShipsDestroyed() == true );
//		assertTrue( player2.allShipsDestroyed() == false );
//	}
//}
