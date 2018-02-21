//https://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
package Graph;

import java.util.Scanner;


class MinCostPath {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCasesNumber = input.nextInt();
		for(int testCases = 0; testCases < testCasesNumber; testCases++){
			int arrayLength =  input.nextInt();
			int[][] array = new int[arrayLength][arrayLength];
			for(int index=0; index<arrayLength; index++){
				for(int jindex=0; jindex<arrayLength; jindex++){
					array[index][jindex] = input.nextInt();
				}
			}
			
			System.out.println(findMinCostPath(array, arrayLength-1, arrayLength-1));
			
		}
	}
	public static int findMinCostPath(int inputArray[][], int row, int col){
		if(row < 0 || col < 0){
			return Integer.MAX_VALUE;
		}else if(row == 0 && col == 0){
			return inputArray[row][col];
		}else{
			return inputArray[row][col] + Math.min(findMinCostPath(inputArray, row-1, col), 
										(Math.min(findMinCostPath(inputArray, row-1, col-1), 
												findMinCostPath(inputArray, row, col -1))));
		}
	}
}
