package mmt;

import java.util.Scanner;

class MinimumCostPath {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
			int arraySize  = input.nextInt();
			int array[][] = new int[arraySize][arraySize];
			for(int jindex=0; jindex<arraySize; jindex++) {
				for(int kindex=0; kindex<arraySize; kindex++) {
					array[jindex][kindex] = input.nextInt();
				}
			}
			int board[][] = new int[arraySize][arraySize];
			board[0][0] = 1;
			System.out.println(DFS(0, 0, board, arraySize, array, array[0][0]));
		}	
	}
	
	public static int DFS(int row, int col, int board[][], int arraySize, int array[][], int finalDistance) {
		if(row>=arraySize-1 && col>=arraySize-1) {
			return finalDistance;
		}
		int colSuggest[] = {-1, 1, 0, 0};
		int rowSuggest[] = {0, 0, -1, 1};
		
		int min=Integer.MAX_VALUE;
		int minRow=arraySize;
		int minCol=arraySize;
		
		for(int index=0; index<rowSuggest.length; index++) {
			int finalRow = row + rowSuggest[index];
			int finalCol = col + colSuggest[index];
			
			if(isSafe(finalRow, finalCol, board, arraySize)) {
				if(array[finalRow][finalCol] <= min) {
					min = array[finalRow][finalCol];
					minRow = finalRow;
					minCol = finalCol;
				}
			}
		}
		
		finalDistance = finalDistance + min;
		board[minRow][minCol] = 1;
		return DFS(minRow, minCol, board, arraySize, array, finalDistance);
	}

	
	public static boolean isSafe(int finalRow, int finalCol, int board[][], int arraySize) {
		if((finalRow >-1 && finalRow<arraySize) && (finalCol >-1 && finalCol<arraySize) && (board[finalRow][finalCol] == 0)) {
			return true;
		}
		return false;
	}
}


