//http://www.geeksforgeeks.org/backttracking-set-2-rat-in-a-maze/
package Backtracking;
import java.util.Scanner;

class RatinaMaze {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCasesNumber = input.nextInt();
		for(int testCases = 0; testCases < testCasesNumber; testCases++){
			int row = input.nextInt();
			Graph obj = new Graph(row, row);
			for(int index=0; index<obj.row; index++){
				for(int jIndex=0; jIndex<obj.col; jIndex++){
					obj.maze[index][jIndex] = input.nextInt();
				}
			}
			
			boolean visited[][] = Graph.DFSUtil(row, row, obj);
			printMaze(visited);
		}
	}
	public static void printMaze(boolean visited[][]){
		for(int index=0; index<visited.length; index++){
			for(int jIndex=0; jIndex<visited[index].length; jIndex++){
				System.out.print(visited[index][jIndex] ? 1 + " ": 0 + " ");
			}
			System.out.println();
		}
	}
}
class Graph{
	public int[][] maze;
	int row;
	int col;
	Graph(int row, int col){
		this.row = row;
		this.col = col;
		this.maze = new int[row][col];
	}

	public static boolean[][] DFSUtil(int row, int col, Graph g){
		boolean visited[][] = new boolean[row][col];
		
		DFS(0, 0, g, visited);
		
		return visited;
	}
	
	public static boolean DFS(int row, int col, Graph g, boolean visited[][]){
		if(row == g.row -1 && col == g.col -1){
			visited[row][col] = true;
			return true;
		}else{
			if(isSafe(row, col, g)){
				visited[row][col] = true;
				
				if(DFS(row + 1, col, g, visited)){// move in y direction
					return true;
				}
				
				if(DFS(row, col + 1, g, visited)){// move in x direction
					return true;
				}
				
				visited[row][col] = false;
				return false;
				
			}
		}

		return false;
	}
	
	public static boolean isSafe(int row, int col, Graph g){
		return ( (row >=0 && row<g.row) && (col >=0 && col<g.col) && (g.maze[row][col] == 1));
	}
}