package Heap;

import java.util.Scanner;

class SortingBasedOnBinaryRepresentation {
	public static void main(String []args) {
		Scanner input = new Scanner(System.in);
		int testCasesNumber = input.nextInt();
		for(int testCases = 0; testCases < testCasesNumber; testCases++){
			int arrayLength =  input.nextInt();
			int[] arrayArr = new int[arrayLength];
			int[] bitArr = new int[arrayLength];
			
			for(int index=0; index<arrayLength; index++){
				int element = input.nextInt();
				arrayArr[index] = element;
				bitArr[index] = countBits(element);
			}
			
			
			HeapSortB obj = new HeapSortB();
			obj.sort(bitArr, arrayArr);
			
			for(int index=0; index<arrayLength; index++){
				System.out.print(arrayArr[index] +" ");
			}
			
			System.out.println();
		}
	}
	public static int countBits(int element) {
	    int count = 0;
	    while (element > 0)
	    {
	        if ((element & 1) == 1) {
	        	count += 1;
	        }
	        element = element>>1;
	    }
	    return count;
		
	}
}


class HeapSortB{
	public void sort(int[] inputArray, int[] decInputArray){
		for(int iIndex=inputArray.length/2 - 1; iIndex>=0; iIndex--){
			heapify(inputArray, decInputArray, inputArray.length, iIndex);
		}
		
		for(int jIndex= inputArray.length - 1; jIndex>=0; jIndex--){
			swap(inputArray, decInputArray, jIndex, 0);
			heapify(inputArray, decInputArray, jIndex, 0);
		}
	}
	public static void heapify(int[] inputArray, int[] decInputArray, int end, int index){
		int largest = index;
		int left = getLeft(index);
		int right = getRight(index);
		if(left < end && inputArray[left] > inputArray[largest]){
			largest = left;
		}
		
		if(right < end && inputArray[right] > inputArray[largest]){
			largest = right;
		}
		
		if(left < end && (inputArray[left] == inputArray[largest]) && (decInputArray[left] > decInputArray[largest])) {
			largest = left;
		}
		
		if(right < end && (inputArray[right] == inputArray[largest]) && (decInputArray[right] > decInputArray[largest])){
			largest = right;
		}
		
		if(largest != index){
			swap(inputArray, decInputArray, index, largest);
			heapify(inputArray, decInputArray, end, largest);
		}
	}
	public static void swap(int[] inputArray, int[] decInputArray, int index, int jIndex){
		int temp = inputArray[index];
		inputArray[index] = inputArray[jIndex];
		inputArray[jIndex] = temp;
		
		
		
		int temp1 = decInputArray[index];
		decInputArray[index] = decInputArray[jIndex];
		decInputArray[jIndex] = temp1;
		
	}
	public static int getLeft(int index){
		return (2*index + 1);
	}
	public static int getRight(int index){
		return (2*index + 2);
	}
}