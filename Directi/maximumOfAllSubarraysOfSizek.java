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
	public static void printMaxOfSubArray(int arrayLength, int[] inputArray, int subArrayLength){
		int[] subArrayInputArray = new int[subArrayLength];
		for(int index=0; index<subArrayLength; index++){
			subArrayInputArray[index] = inputArray[index];
		}
		for(int index=subArrayLength;index<arrayLength;index++){
			System.out.println(findTheLargestInSubArray(subArrayInputArray,subArrayLength));
			subArrayInputArray[0] = inputArray[index];
		}
	}
	public static int findTheLargestInSubArray(int[] subArrayInputArray,int subArrayLength){
		for(int index=subArrayLength-1;index>0;index--){
			
		}
		for(int index=subArrayLength-1;index>0;index--){
			swap()
			heapify();
		}
		return subArrayInputArray[0];
	}
	public static void heapify(){
		int 
	}
}
