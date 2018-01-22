package game;

class tictactoegame {
	public static final int row=3;
	public static final int col=3;
	public static int[][] board=new int[row][col];
	public static int[] movesBoard=new int[row*col];
	public static final int comp_move = 1; // x-move
	public static final int human_move = 2; // o-move
//	public static 
	public static void main(String []args){
		initializeBoard();
		initializeMoveBoard();
		playgame();
	}
	public static void initializeBoard(){
		for(int index=0; index<row; index++){
			for(int jindex=0; jindex<col;jindex++){
				board[index][jindex] = -1;
			}
		}
	}
	public static void initializeMoveBoard(){
		for(int index=0; index<row*col; index++){
			movesBoard[index] = index;
		}
	}
	public static void playgame(){
		int moveIndex=0;
		while((gameOver() == false) && (moveIndex < 9)){
			
		}
		if((gameOver() == false) && (moveIndex == 9)){
			
		}else{
			
		}
	}
	public static boolean gameOver(){
		return (horizontallyWinner() || verticallyWinner() || diagonallyWinner());
	}
	public static boolean horizontallyWinner(){
		return false;
	}
	public static boolean verticallyWinner(){
		return false;
	}
	public static boolean diagonallyWinner(){
		return false;
	}
}
