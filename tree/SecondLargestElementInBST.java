//http://www.geeksforgeeks.org/second-largest-element-in-binary-search-tree-bst/

package tree;

import java.util.Scanner;

public class SecondLargestElementInBST {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCasesNumber = input.nextInt();
		for(int testCases = 0; testCases < testCasesNumber; testCases++){
			int position = input.nextInt();
			int arrayLength =  input.nextInt();
			int[] array = new int[arrayLength];
			for(int index=0; index<arrayLength; index++){
				array[index] = input.nextInt();
			}
			int[] finalArray = new int[arrayLength];
			new SecondLargestElementInBST().largestElementInStream(array, arrayLength, finalArray, position);
			for(int element : finalArray){
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}
	public static void largestElementInStream(int[] array, int arrayLength, int[] finalArray, int position){
		int[] resultSet = new int[position];
		for(int jIndex = 0; jIndex < position; jIndex++){
			resultSet[jIndex] =  array[jIndex];
			finalArray[jIndex] = -1;
		}
		heapsort(resultSet);

		for(int index =position; index < arrayLength; index++){
			pushElement(resultSet, array[index], index, position, finalArray);
		}
		finalArray[finalArray.length - 1] = resultSet[0];
	}
	public static void heapsort(int[] resultSet){
		for(int i=resultSet.length/2 - 1; i>=0; i--){
			heapify(resultSet, i, resultSet.length);
		}
		for(int j=resultSet.length-1; j>=0; j--){
			swapElements(resultSet, 0, j);
			heapify(resultSet, 0, j);
		}
	}
	public static void pushElement(int[] resultSet, int element, int index, int position, int[] finalArray){
		finalArray[index - 1] = resultSet[0];
		if(resultSet[0] < element){
			resultSet[0] = element;
		}
		
		heapsort(resultSet);
	}
	public static void heapify(int[] resultSet, int index, int length){
		int largest = index;
		int leftChild = leftChild(index);
		int rightChild = rightChild(index);
		if(leftChild < length && resultSet[leftChild] > resultSet[largest]){
			largest = leftChild;
		}
		if(rightChild < length && resultSet[rightChild] > resultSet[largest]){
			largest = rightChild;
		}
		if(largest != index){
			swapElements(resultSet, index, largest);
			heapify(resultSet, largest ,length);
		}
		
	}
	public static int leftChild(int index){
		return (2 * index) + 1;
	}
	public static int rightChild(int index){
		return (2 * index) + 2;
	}
	public static void swapElements(int[] resultSet, int iIndex, int jIndex){
		int temp = resultSet[iIndex];
		resultSet[iIndex] = resultSet[jIndex];
		resultSet[jIndex] = temp;
	}
}
