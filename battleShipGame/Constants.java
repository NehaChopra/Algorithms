package battleShipGame;
/*
	 *  Global Constant Variables
	 *  location is hit = 1
	 *  location is missed = 0
	 *  location is partially hit = 10
	 */
interface Constants {
	public static final int HIT = 1;
	public static final int MISS = 0;
	public static final int PARTIALLY_HIT = 10;

	public static final int SHIP_PIECE_Q_HITS_REQ = 2;
	public static final int SHIP_PIECE_P_HITS_REQ = 1;
	
	public static final String SHIP_PIECE_Q = "Q";
	public static final String SHIP_PIECE_P = "P";

	public static final String HIT_STATUS = "hit";
	public static final String MISS_STATUS = "miss";
	
	public static final boolean CAN_PLAY = true;
	public static final boolean CANNOT_PLAY = false;
	
	public static final String NO_MISSLE = " no more missiles left to launch ";
	public static final String WON_BATTLE = " won the battle ";
	public static final String FIRES_MISSLE = " fires a missile with target ";
	public static final String WHICH = " which got ";
	public static final String NO_WINNER = "No One is Winner";
}
