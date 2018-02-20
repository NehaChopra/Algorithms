//https://practice.geeksforgeeks.org/problems/print-binary-tree-levels-in-sorted-order/0
package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class PrintBinaryTreelevelsinSortedOrder {
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
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int test = 0; test<testCases; test++){
			int arrayLength = input.nextInt();
			int array[] = new int[arrayLength];
			for(int index=0; index<arrayLength; index++){
				array[index] = input.nextInt();
			}
			sortedTreePerLevel(array, 0, 0, 1);
		}
	}
	public static void sortedTreePerLevel(int inputArray[], int start, int end, int size){
		if(start >= inputArray.length && end > inputArray.length){
			return;
		}
		size = Math.min(size, inputArray.length);
		int array[] = new int[size];
		for(int index=0; index<array.length; index++){
			array[index] = -1;
		}
		for(int index=0, jIndex=start; index<array.length && jIndex<=end; index++, jIndex++){
			if(jIndex < inputArray.length){
				array[index] = inputArray[jIndex]; 
			}
		}
		sortAndprintArray(array);
		sortedTreePerLevel(inputArray, getLeft(start), getRight(end), 2*size);
	}
	public static int getLeft(int index){
		return (2*index + 1);
	}
	public static int getRight(int index){
		return (2*index + 2);
	}
	public static void sortAndprintArray(int inputArray[]){
		sort(inputArray);
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int index=0; index<inputArray.length; index++){
			if(map.get(inputArray[index]) == null){
				map.put(inputArray[index], 1);
			}else{
				map.put(inputArray[index], map.get(inputArray[index]) + 1);
			}
			if(map.get(inputArray[index]) != null && map.get(inputArray[index]) == 1){
				if(inputArray[index] >= 0){
					System.out.print(inputArray[index] + " ");
				}
			}
		}
		System.out.println();
	}
}
