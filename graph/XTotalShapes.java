//https://practice.geeksforgeeks.org/problems/x-total-shapes/0
package graph;

import java.util.Scanner;

class XTotalShapes {
	public static void main(String []args) {
		Scanner input = new Scanner(System.in);
		int testCasesNumber = input.nextInt();
		for(int testCases = 0; testCases < testCasesNumber; testCases++){
			int rowLength =  input.nextInt();
			int colLength =  input.nextInt();
			int[][] array = new int[rowLength][colLength];
			for(int index=0; index<rowLength; index++){
				for(int jindex=0; jindex<colLength; jindex++){
					String ele = input.next();input.
					if(ele.equals("O")) {
						array[index][jindex] = 0;
					}
					if(ele.equals("X")) {
						array[index][jindex] = 1;
					}
				}
			}
			
			Graph1 obj = new Graph1(rowLength, colLength, array);
			boolean [][]visited = new boolean [rowLength][colLength];
			obj.BFS(0, 0, visited);
			
			for(int index=0; index<rowLength; index++) {
				for(int jindex=0; jindex<rowLength; jindex++) {
					System.out.print(visited[index][jindex] +" ");
				}
				System.out.println();
			}
		}
	}
}

class Graph1{
	int rowLength;
	int colLength;
	int [][]matrix;
	
	public Graph1(int row, int col, int [][]matrix) {
		this.rowLength = row;
		this.colLength = col;
		this.matrix = matrix;
	}
	
	public boolean isSafeToVisit(int row, int col, boolean [][]visited) {
		return ((row > -1 && row < rowLength) && (col > -1 && col < colLength) && (matrix[row][col] == 1) && (visited[row][col] == false));
	}
	
	public boolean BFS(int row, int col, boolean [][]visited) {
		if((row == (rowLength -1)) && (row == (rowLength -1))) {
			visited[row][col]=true;
			return true;
		}else {
			if(isSafeToVisit(row, col, visited)) {
				if(BFS(row+1, col, visited)){
					return true;
				}
				if(BFS(row+1, col+1, visited)) {
					return true;
				}
				if(BFS(row, col+1, visited)) {
					return true;
				}
				if(BFS(row+1, col-1, visited)) {
					return true;
				}
				
				visited[row][col]=false;
				return false;
			}
		}
		return false;
	}
}
