//https://www.geeksforgeeks.org/find-shortest-safe-route-in-a-path-with-landmines/
package Backtracking;

class ShortestSafeRoute {

	public static void findShortestPath(int array[][], int row, int col) {
		boolean visited[][] = new boolean[row][col];
		
		for(int index=0; index<row; index++) {
			findShortestPathUTIL(array, );
		}
	}
	
	public static void findShortestPathUTIL(int array[][], boolean visited[][], int row, int col) {
		
	}
	public static void main(String[] args) {
		int array[][] =  
			{
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
		        { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }
		    };
		int colTrick[]= {};
		int rowTrick[]= {};
		initilizeBoard(array, row, col);
		findShortestPath(array, array.length, array[0].length);
	}
	
	public static void initilizeBoard(int array[][], int row, int col) {
		for(int index=0; index<row; index++) {
			for(int jindex=0; jindex<row; jindex++) {
				if() {
					
				}
			}
		}
	}
}
