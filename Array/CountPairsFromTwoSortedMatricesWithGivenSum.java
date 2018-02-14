//https://www.geeksforgeeks.org/count-pairs-two-sorted-matrices-given-sum/

package Array;

import java.util.HashMap;
import java.util.Scanner;

class CountPairsFromTwoSortedMatricesWithGivenSum {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
			int row = input.nextInt();
			int col = input.nextInt();
			int findElement = input.nextInt();
			
			int array1[][] = new int[row][col];
			int array2[][] = new int[row][col];
			
			for(int jIndex=0; jIndex<row; jIndex++){
				for(int kIndex=0; kIndex<col; kIndex++){
					array1[jIndex][kIndex] = input.nextInt();
				}
			}
			
			for(int jIndex=0; jIndex<row; jIndex++){
				for(int kIndex=0; kIndex<col; kIndex++){
					array2[jIndex][kIndex] = input.nextInt();
				}
			}
			
			System.out.println(findPairInMatrix(array1, array2, row, col, findElement));
		}
	}
	public static int findPairInMatrix(int array1[][], int array2[][], int row, int col, int findElement){
		int count = 0;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int jIndex=0; jIndex<row; jIndex++){
			for(int kIndex=0; kIndex<col; kIndex++){
				if(map.get(array1[jIndex][kIndex]) != null){
					map.put(array1[jIndex][kIndex], map.get(array1[jIndex][kIndex]) +1);
				}else{
					map.put(array1[jIndex][kIndex], 1);
				}
			}
		}
		
		for(int jIndex=0; jIndex<row; jIndex++){
			for(int kIndex=col-1; kIndex>=0; kIndex--){
				int num = findElement - array2[jIndex][kIndex];
				if(map.get(num) != null){
					count = count + 1;
				}
			}
		}
		
		return count;
	}
}
