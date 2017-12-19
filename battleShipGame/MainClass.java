package battleShipGame;

import java.util.ArrayList;
import java.util.Scanner;

class MainClass implements Constants{
	/*
	 * whoIsWinner 
	 * @param player1, player1 of the battles 
	 * @param player2, player2 of the battle
	 * @return who wins the battle
	 */
	public static String whoIsWinner(Player player1, Player player2){
		if(player1.allShipsDestroyed()){
			player2.setPoints(player2.getNumOfBattleShips());
			return player2.getPlayerName() + WON_BATTLE;
		}else if(player2.allShipsDestroyed()){
			player1.setPoints(player1.getNumOfBattleShips());
			return player1.getPlayerName() + WON_BATTLE;
		}
		return NO_WINNER;
	}
	/*
	 * Game is start, battleArea is prepared, missiles are prepared for each player
	 */
	public static void startGame(Player player1, Player player2){
		while(player1.getMissileList().size() > 0 || player2.getMissileList().size() > 0){
			if((player1.getMissileList().size() > 0) && (player1.isCanPlay()) || (player2.getMissileList().size() == 0)){
				Missile missile = ((Missile)(player1.getMissileList().poll())); 
				if(player2.getPlayerBattleArea().fire(missile.getRow(), missile.getCol())){
					player1.setCanPlay(CAN_PLAY);
					player2.setCanPlay(CANNOT_PLAY);
				}else{
					player2.setCanPlay(CAN_PLAY);
					player1.setCanPlay(CANNOT_PLAY);
				}
				System.out.println(player1.getPlayerName() +  FIRES_MISSLE + ((char)(65 + missile.getRow())) + (missile.getCol()+1) + WHICH + player2.getPlayerBattleArea().getBattleAffected());
			}else if((player2.getMissileList().size() > 0) && (player2.isCanPlay()) || (player1.getMissileList().size() == 0)){
				Missile missile = ((Missile)(player2.getMissileList().poll())); 
				if(player1.getPlayerBattleArea().fire(missile.getRow(), missile.getCol())){
					player2.setCanPlay(CAN_PLAY);
					player1.setCanPlay(CANNOT_PLAY);
				}else{
					player1.setCanPlay(CAN_PLAY);
					player2.setCanPlay(CANNOT_PLAY);
				}
				System.out.println(player2.getPlayerName() +  FIRES_MISSLE + ((char)(65 + missile.getRow())) + (missile.getCol()+1) + WHICH + player1.getPlayerBattleArea().getBattleAffected());
			}
		}
		System.out.println(whoIsWinner(player1, player2));
	}
	/*
	 * main method
	 */
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		String dimensions = input.nextLine();
		BattleArea[] battleAreas = {new BattleArea(Integer.parseInt(String.valueOf(dimensions.charAt(0))), (dimensions.charAt(2) - 'A' + 1)), new BattleArea(Integer.parseInt(String.valueOf(dimensions.charAt(0))), (dimensions.charAt(2) - 'A' + 1))}; 
		
		int numOfBattleShips = Integer.parseInt(input.nextLine());
		Player[] players = {new Player("Player-1", numOfBattleShips), new Player("Player-2", numOfBattleShips)};
		
		for(int index=0; index<players.length; index++){
			players[index].setPlayerBattleArea(battleAreas[index]);
		}
		
		ArrayList<Ship> shipsPlayer1 = new ArrayList<Ship>();
		ArrayList<Ship> shipsPlayer2 = new ArrayList<Ship>();
		
		String battleShips1 = input.nextLine();
		String[] splitString1 = battleShips1.split(" ");
		if(splitString1[0].equals(SHIP_PIECE_Q)){
			for(int x=0; x<Integer.parseInt(splitString1[1]); x++){
				for(int y=0; y<Integer.parseInt(splitString1[2]); y++){
					ShipPiece shipPiece1 = new ShipPieceQ();
					int row1 = (splitString1[3].charAt(0)-'A') + y;
					int col1 = (Integer.parseInt(String.valueOf(splitString1[3].charAt(1))) -1 ) + x;
					battleAreas[0].shipPlacement(row1, col1, shipPiece1);
					Ship ship1 = new Ship();
					ship1.getShipPiecesLocations().add((battleAreas[0].getLocation())[0][0]);
					shipsPlayer1.add(ship1);
					
					ShipPiece shipPiece2 = new ShipPieceQ();
					int row2 = (splitString1[4].charAt(0)-'A') + y;
					int col2 = (Integer.parseInt(String.valueOf(splitString1[4].charAt(1))) -1 ) + x;
					battleAreas[1].shipPlacement(row2, col2, shipPiece2);
					Ship ship2 = new Ship();
					ship2.getShipPiecesLocations().add((battleAreas[1].getLocation())[row2][col2]);
					shipsPlayer2.add(ship2);
				}
			}
		}
		
		String battleShips2 = input.nextLine();
		String[] splitString2 = battleShips2.split(" ");
		if(splitString2[0].equals(SHIP_PIECE_P)){
			for(int x=0; x<Integer.parseInt(splitString2[1]); x++){
				for(int y=0; y<Integer.parseInt(splitString2[2]); y++){
					ShipPiece shipPiece1 = new ShipPieceP();
					int row1 = (splitString2[3].charAt(0)-'A') + y;
					int col1 = (Integer.parseInt(String.valueOf(splitString2[3].charAt(1))) -1 ) + x;
					battleAreas[0].shipPlacement(row1, col1, shipPiece1);
					Ship ship1 = new Ship();
					ship1.getShipPiecesLocations().add((battleAreas[0].getLocation())[0][0]);
					shipsPlayer1.add(ship1);
					
					ShipPiece shipPiece2 = new ShipPieceP();
					int row2 = (splitString2[4].charAt(0)-'A') + y;
					int col2 = (Integer.parseInt(String.valueOf(splitString2[4].charAt(1))) -1 ) + x;
					battleAreas[1].shipPlacement(row2, col2, shipPiece2);
					Ship ship2 = new Ship();
					ship2.getShipPiecesLocations().add((battleAreas[1].getLocation())[row2][col2]);
					shipsPlayer2.add(ship2);
				}
			}
		}
		
		Ship[] stockArr1 = new Ship[shipsPlayer1.size()];
		Ship[] stockArr2 = new Ship[shipsPlayer2.size()];
		players[0].setShips(shipsPlayer1.toArray(stockArr1));
		players[1].setShips(shipsPlayer2.toArray(stockArr2));

		for(int index=0; index<players.length; index++){
			String missiles = input.nextLine();
			if(!missiles.isEmpty()){
				String[] splitMissiles = missiles.split(" ");
				for(int list=0; list<splitMissiles.length; list++){
					if(!splitMissiles[list].isEmpty()){
						int row = (splitMissiles[list].charAt(0) - 'A');
						int col = (Integer.parseInt(String.valueOf(splitMissiles[list].charAt(1))))-1;
						players[index].assignMissiles(row,col);
					}
				}
			}else{
				missiles = input.nextLine();
			}
		}
		
		startGame(players[0], players[1]);
	}
}
