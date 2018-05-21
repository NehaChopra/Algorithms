//https://practice.geeksforgeeks.org/problems/sorted-matrix/0
package tree;

import java.util.Scanner;

class sortedOrderFromRowAndColumnWiseSortedMatrix {
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
			
			
			HeapSort1 obj = new HeapSort1();
			int finalArray[] = obj.sort(array, arrayLength);
			for(int element: finalArray){
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}
}
class HeapSort1{
	public static int[] convert2DtoD(int[][] inputArray, int arrayLength) {
		int finalArray[] = new int[arrayLength*arrayLength];
		int i = -1;
		for(int index=0; index<arrayLength; index++){
			for(int jindex=0; jindex<arrayLength; jindex++){
				finalArray[++i] = inputArray[index][jindex];
			}
		}
		
		return finalArray;
	}
	public int[] sort(int[][] inputArray, int arrayLength){
		int finalArray[] = convert2DtoD(inputArray, arrayLength);
		
		for(int iIndex=finalArray.length/2 - 1; iIndex>=0; iIndex--){
			heapify(finalArray, finalArray.length, iIndex);
		}
		
		for(int jIndex= finalArray.length - 1; jIndex>=0; jIndex--){
			swap(finalArray, jIndex, 0);
			heapify(finalArray, jIndex, 0);
		}
		
		return finalArray;
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