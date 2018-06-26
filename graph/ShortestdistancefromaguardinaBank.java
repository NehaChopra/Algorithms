//https://www.geeksforgeeks.org/find-shortest-distance-guard-bank/
package graph;

import java.util.LinkedList;
import java.util.Queue;

class QueueNode{
	int xCod;
	int yCod;
	int dist;
	
	QueueNode(int xCod, int yCod, int dist){
		this.xCod = xCod;
		this.yCod = yCod;
		this.dist = dist;
	}
}

class ShortestdistancefromaguardinaBank {
	public static void main(String []args) {
	   char matrix[][] =
	      {
	          {'O', 'O', 'O', 'O', 'G'},
	          {'O', 'W', 'W', 'O', 'O'},
	          {'O', 'O', 'O', 'W', 'O'},
	          {'G', 'W', 'W', 'W', 'O'},
	          {'O', 'O', 'O', 'O', 'G'}
	      };
	   Queue<QueueNode> queue = new LinkedList();
	   
	   int board[][] = createBoard(matrix, 5, 5, queue);
	   
	   findDistance(board, queue);
	   
	   for(int index=0; index<5; index++) {
	   	for(int jindex=0; jindex<5; jindex++) {
	   		System.out.print(board[index][jindex] + "      ");
	   	}
	   	System.out.println();
	   }
	   
	   
	   
	   
	   
	}
	
	public static int[][] createBoard(char matrix[][], int row, int col, Queue<QueueNode> queue) {
		int board[][] = new int[row][col];
		for(int index=0; index<row; index++) {
			for(int jindex=0; jindex<col; jindex++) {
				board[index][jindex] = -2;
				if(matrix[index][jindex] == 'W') {
					board[index][jindex] = -1;
				}
				if(matrix[index][jindex] == 'G') {
					board[index][jindex] = 0;
					queue.add(new QueueNode(index, jindex, 0));
				}
			}
		}
		
		return board;
	}
	
	public static void findDistance(int board[][], Queue<QueueNode> queue) {
		int row[] = {-1, 0, 1, 0};
		int col[] = {0, 1, 0, -1};
		
		while(!queue.isEmpty()) {
			QueueNode node = queue.poll();
			for(int index=0; index<row.length; index++) {
				int finalRow = node.xCod + row[index];
				int finalCol = node.yCod + col[index];
				int dist = node.dist;
				
				if(isSafe(board, 5, 5, finalRow, finalCol)) {
					board[finalRow][finalCol] = dist + 1;
					queue.add(new QueueNode(finalRow, finalCol, dist + 1));
				}
			}
		}
	}
	
	
	public static boolean isSafe(int board[][], int row, int col, int finalRow, int finalCol) {
		if((finalRow > -1 && finalRow < row) && (finalCol > -1 && finalCol < col) && (board[finalRow][finalCol] == -2)) {
			return true;
		}
		return false;
	}
}
