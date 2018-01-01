//https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k/0
package Directi;

import java.util.Scanner;

class maximumOfAllSubarraysOfSizek {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
			int arrayLength = input.nextInt();
			int subArrayLength = input.nextInt();
			int[] intputArray = new int[arrayLength];
			for(int jIndex=0; jIndex<arrayLength; jIndex++){
				intputArray[jIndex] = input.nextInt();
			}
		}
	}
	public static void printMaxOfSubArray(){
		
	}
}
