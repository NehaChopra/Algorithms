//https://practice.geeksforgeeks.org/problems/n-queen-problem/0
package Backtracking;

import java.util.Scanner;

class NQueenProblem {
	public static int num;
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
			num = input.nextInt();
			System.out.println();
			nQueenProblem();
		}
	}
	public static void nQueenProblem(){
		boolean[][] board = new boolean[num][num];
		if(DFSUtil(0, board)){
			printBoard(board);
		}
	}
	public static void printBoard(boolean[][] board){
		for(int index=0;index<num;index++){
			for(int jindex=0;jindex<num;jindex++){
				if(board[index][jindex]){
					System.out.print("Q" + "  ");					
				}else{
					System.out.print("1" + "  ");	
				}
			}
			System.out.println();
		}
	}
	public static boolean DFSUtil(int col, boolean[][] board){
		if(col>=num){
			return true;
		}
		for(int rowIndex=0; rowIndex<num; rowIndex++){
			if(isSafe(rowIndex, col, board)){
				board[rowIndex][col] = true;
				if(DFSUtil(col+1, board)){
					return true;
				}
				board[rowIndex][col] = false;
			}
		}
		return false;
	}
	public static boolean isSafe(int row, int col, boolean[][] board){
		for(int colIndex=0; colIndex<col; colIndex++){
			if(board[row][colIndex] != false){
				return false;
			}
		}
		for(int rowIndex=row-1, colIndex=col-1; 
				rowIndex>=0 && colIndex>=0; 
				rowIndex--,colIndex--
			){
				if(board[rowIndex][colIndex] != false){
					return false;
				}
		}
		for(int rowIndex=row+1, colIndex=col-1; 
				rowIndex<num && colIndex>=0; 
				rowIndex++, colIndex--){
			if(board[rowIndex][colIndex] != false){
				return false;
			}
		}
		return true;
	}
}
