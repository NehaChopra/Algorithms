//https://practice.geeksforgeeks.org/problems/subset-sum-problem/0
package Array;

import java.util.Scanner;


class SubsetSumProblem {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCasesNumber = input.nextInt();
		for(int testCases = 0; testCases < testCasesNumber; testCases++){
			int arrayLength =  input.nextInt();
			int[] array = new int[arrayLength];
			for(int index=0; index<arrayLength; index++){
				array[index] = input.nextInt();
			}
			
			HeapSort obj = new HeapSort();
			obj.sort(array);
			int visited[] = null;
			for(int index=array.length-1; index>=0; index--) {
				visited = new int[array.length];
				findSubsetSum(array, array[index], 0, visited);
			}
			
			
			for(int index=array.length-1; index>=0; index--) {
				if(visited[index] == 1) {
					System.out.print(array[index] + " ");
				}
			}
			System.out.println();
			
		}
	}
	public static void findSubsetSum(int[] inputArray, int sum, int index, int visited[]) {
		if(sum == 0) {
			return;
		}
		for(int jIndex=index; jIndex<inputArray.length; jIndex++) {
			visited[jIndex] = 1;
			findSubsetSum(inputArray, sum - inputArray[index], jIndex+1, visited);
			visited[jIndex] = 0;
		}
	}
}
class HeapSort{
	public void sort(int[] inputArray){
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
		if(left < end && inputArray[left] >= inputArray[largest]){
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
