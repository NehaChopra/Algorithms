package Backtracking;

class Knightstour {
	static int row = 8;
	static int col = 8;
	
	static int[][] board = new int[row][col];
	
	static int[] rowPossibleIteration = {2, 1, -1, -2, -2, -1, 1, 2};
	static int[] colPossibleIteration = {1, 2, 2, 1, -1, -2, -2, -1};

	public static void main(String []args){
		
		initializeGame();
		
		solKnightProblem();
		
	}
	
	public static void initializeGame(){
		for(int rowIndex=0; rowIndex<row; rowIndex++){
			for(int colIndex=0; colIndex<row; colIndex++){
				setValueToBoard(rowIndex, colIndex, -1);
			}
		}
	}
	
	public static boolean isSafeToIterate(int rowIndex, int colIndex){
		return (( rowIndex >=0 && rowIndex < row ) && ( colIndex >=0 && colIndex < col ) && (board[rowIndex][colIndex] == -1));
	}
	public static void solKnightProblem(){
		int moveCount = 0;
		setValueToBoard(0, 0, moveCount);
		
		if(solKnightDFSUtil(0,0, moveCount + 1)){
			printBoard();
		}else{
			System.out.println("No Solution");
		}
		
	}
	public static boolean solKnightDFSUtil(int rowIndex, int colIndex, int moveCount){
		for(int index=0; index<8; index++){
			int nextRow = rowIndex + rowPossibleIteration[index];
			int nextCol = colIndex + colPossibleIteration[index];
			
			if(row * col == moveCount){
				return true;
			}
			
			if(isSafeToIterate(nextRow, nextCol)){
				setValueToBoard(nextRow, nextCol, moveCount);
				
				if(solKnightDFSUtil(nextRow, nextCol, moveCount + 1)){
					return true;
				}else{
					setValueToBoard(nextRow, nextCol, -1);
				}
			}
		}
		
		return false;
	}
	public static void setValueToBoard(int nextRow, int nextCol, int moveCount){
		board[nextRow][nextCol] = moveCount;
	}
	public static void printBoard(){
		for(int rowIndex=0; rowIndex<row; rowIndex++){
			for(int colIndex=0; colIndex<row; colIndex++){
				System.out.print(board[rowIndex][colIndex] + "     ");
			}
			System.out.println();
		}
	}
}
