/*
 *Player contains details of ships available, missiles available, points he scored, his battle area and opp battle area.
 */

import java.util.LinkedList;
import java.util.Queue;

class Player {
	private int numOfBattleShips;
	private Ship[] ships;
	private BattleArea playerBattleArea;
	private Queue<Missile> missileList;
	private int points;
	private String playerName;
	private boolean canPlay;

	public Player(String playerName, int numOfBattleShips) {
		this.playerName = playerName;
		this.numOfBattleShips= numOfBattleShips;
		this.missileList = new LinkedList<Missile>();
		this.canPlay = true;
	}
	public int getNumOfBattleShips() {
		return numOfBattleShips;
	}
	public void setNumOfBattleShips(int numOfBattleShips) {
		this.numOfBattleShips = numOfBattleShips;
	}
	public Ship[] getShips() {
		return ships;
	}
	public void setShips(Ship[] ships) {
		this.ships = ships;
	}
	public BattleArea getPlayerBattleArea() {
		return playerBattleArea;
	}
	public void setPlayerBattleArea(BattleArea playerBattleArea) {
		this.playerBattleArea = playerBattleArea;
	}
	public Queue<Missile> getMissileList() {
		return missileList;
	}
	public void setMissileList(Queue<Missile> missileList) {
		this.missileList = missileList;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public void increasePoints() {
		this.points = points + 1;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public void assignMissiles(int row, int col){
		missileList.add(new Missile(row, col));
	}
	public boolean isCanPlay() {
		return canPlay;
	}
	public void setCanPlay(boolean canPlay) {
		this.canPlay = canPlay;
	}
	public boolean allShipsDestroyed(){
		boolean shipDestroyed = true;
		for(Ship ship:ships){
			shipDestroyed = shipDestroyed && ship.isShipDestroyed();
		}
		return shipDestroyed;
	}
}
