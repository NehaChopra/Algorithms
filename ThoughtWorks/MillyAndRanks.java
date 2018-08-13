package ThoughtWorks;

import java.util.Scanner;

class MillyAndRanks {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
			int arrayLength = input.nextInt();
			int inputArray[] = new int[arrayLength];
			for(int jindex=0; jindex<arrayLength; jindex++){
				inputArray[jindex] = input.nextInt();
			}
			
			HeapSort.sort(inputArray);
			
			System.out.println(minIteration(inputArray, arrayLength));
		}
	}
	
	public static int minIteration(int inputArray[], int arrayLength) {
		int lastEstimated = inputArray[arrayLength-1];
		int finalIteration = 0;
		
		for(int index=1; index<arrayLength; index++) {
			if(inputArray[index-1] == lastEstimated) {
				lastEstimated = index-1;
				break;
			}
			finalIteration = finalIteration + ((inputArray[index-1] + 1) - inputArray[index]);
			inputArray[index] = (inputArray[index-1] + 1);
		}
		int last = lastEstimated;
		
		for(int index=arrayLength-1; index>last; index--) {
			finalIteration = finalIteration + ((inputArray[lastEstimated] + 1) - inputArray[index]);
			inputArray[index] = inputArray[lastEstimated] + 1;
			lastEstimated = index; 
		}
		return finalIteration;
	}
}

class HeapSort{
	public static void sort(int[] inputArray){
		for(int iIndex=inputArray.length/2 - 1; iIndex>=0; iIndex--){
			heapify(inputArray, inputArray.length, iIndex);
		}
		
		for(int jIndex= inputArray.length - 1; jIndex>=0; jIndex--){
			swap(inputArray, jIndex, 0);
			heapify(inputArray, jIndex, 0);
		}
	}
	public static void heapify(int[] inputArray, int end, int index){
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
			swap(inputArray, index, largest);
			heapify(inputArray, end, largest);
		}
	}
	public static void swap(int[] inputArray, int index, int jIndex){
		int temp = inputArray[index];
		inputArray[index] = inputArray[jIndex];
		inputArray[jIndex] = temp;
	}
	public static int getLeft(int index){
		return (2*index + 1);
	}
	public static int getRight(int index){
		return (2*index + 2);
	}
}


/*
2
2
1 1
3
1 1 2
*/