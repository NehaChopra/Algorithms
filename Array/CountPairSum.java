//https://practice.geeksforgeeks.org/problems/count-pair-sum/0
package Array;

import java.util.HashMap;
import java.util.Scanner;

class CountPairSum {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases;index++){
			int arrayLength1 = input.nextInt();
			int arrayLength2 = input.nextInt();
			int array1[] = new int[arrayLength1];
			int array2[] = new int[arrayLength2];
			for(int jIndex=0; jIndex<arrayLength1; jIndex++){
				array1[jIndex] = input.nextInt();
			}
			for(int jIndex=0; jIndex<arrayLength2; jIndex++){
				array2[jIndex] = input.nextInt();
			}
			
			int sum = input.nextInt();
			System.out.println(findGivenSumPair(array1,array2, sum));
		}
	}
	public static int findGivenSumPair(int array1[], int array2[], int sum){
		int count =0;
		for(int index=0; index<array1.length; index++){
			int num = sum - array1[index];
			for(int jindex=array2.length-1; jindex>-1; jindex--){
				if(num>array2[jindex]){
					break;
				}
				if(num == array2[jindex]){
					count = count + 1;
				}
			}
		}
		return count;
	}
}
