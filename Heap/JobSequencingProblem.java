//https://practice.geeksforgeeks.org/problems/job-sequencing-problem/0
package Heap;

import java.util.Scanner;

class JobSequencingProblem {
	public static void main(String []args) {
		Scanner input = new Scanner(System.in);
		int testCasesNumber = input.nextInt();
		for(int testCases = 0; testCases < testCasesNumber; testCases++){
			int arrayLength =  input.nextInt();
			int[] names = new int[arrayLength];
			int[] deadline = new int[arrayLength];
			int[] profit = new int[arrayLength];
			
			for(int index=0; index<arrayLength; index++) {
				names[index] = input.nextInt();
				deadline[index] = input.nextInt();
				profit[index] = input.nextInt();
			}
			
			evaluteJobSequencing(names, deadline, profit, arrayLength);
		}
	}
	
	public static void evaluteJobSequencing(int[] names, int[] deadline, int[] profit, int arrayLength) {
		HeapSort2 obj = new HeapSort2();
		obj.sort(profit, names, deadline);
		
		int finalArray[] = new int[arrayLength];
		for(int index=arrayLength-1; index>=0; index--) {
			int element = profit[index];
			int deadlineElement = deadline[index];
			
			if(deadlineElement > arrayLength) {
				deadlineElement = arrayLength;
			}
			if(finalArray[deadlineElement - 1] == 0) {
				finalArray[deadlineElement - 1] = element;
			}else if(finalArray[deadlineElement - 1] != 0) {
				int loop = deadlineElement - 1;
				while(loop > 0 && finalArray[loop] != 0) {
					loop= loop -1;
				}
				if(finalArray[loop] == 0) {
					finalArray[loop] = element;
				}
			}
		}
		
		int finalSum = 0;
		int finalLength = 0;
		for(int index=0; index<arrayLength; index++) {
			finalSum = finalSum + finalArray[index];
			if(finalArray[index] != 0) {	
				finalLength = finalLength + 1;
			}
		}
		
		System.out.println(finalLength + " " + finalSum);
	}
}

class HeapSort2{
	public void sort(int[] inputArray, int[] names, int[] deadline){
		for(int iIndex=inputArray.length/2 - 1; iIndex>=0; iIndex--){
			heapify(inputArray, names, deadline, inputArray.length, iIndex);
		}
		
		for(int jIndex= inputArray.length - 1; jIndex>=0; jIndex--){
			swap(inputArray, names, deadline, jIndex, 0);
			heapify(inputArray, names, deadline, jIndex, 0);
		}
	}
	public static void heapify(int[] inputArray, int[] names, int[] deadline, int end, int index){
		int largest = index;
		int left = getLeft(index);
		int right = getRight(index);
		if(left < end && inputArray[left] > inputArray[largest]){
			largest = left;
		}
		
		if(right < end && inputArray[right] > inputArray[largest]){
			largest = right;
		}
		
		if(largest != index){
			swap(inputArray,  names, deadline, index, largest);
			heapify(inputArray, names, deadline, end, largest);
		}
	}
	public static void swap(int[] inputArray, int[] names, int[] deadline, int index, int jIndex){
		int temp = inputArray[index];
		inputArray[index] = inputArray[jIndex];
		inputArray[jIndex] = temp;
		
		
		int tempName = names[index];
		names[index] = names[jIndex];
		names[jIndex] = tempName;
		
		
		int tempDeadine = deadline[index];
		deadline[index] = deadline[jIndex];
		deadline[jIndex] = tempDeadine;
		
	}
	public static int getLeft(int index){
		return (2*index + 1);
	}
	public static int getRight(int index){
		return (2*index + 2);
	}
}


