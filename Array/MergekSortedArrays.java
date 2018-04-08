//https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1
package Array;

import java.util.Scanner;

class MergekSortedArrays {
	public static void main(String []args) {
		Scanner input = new Scanner(System.in);
		int k = input.nextInt();
		int n = input.nextInt();
		int array[][] = new int[k][n];
		for(int index=0; index<k; index++) {
			for(int jIndex=0; jIndex<n; jIndex++) {
				array[index][jIndex] = input.nextInt();
			}
		}
		mergeKArrays(array, k*n);
	}
	public static void mergeKArrays(int[][] arrays,int k) {
		int mergedArray[] = new int[k];
		int outerArrayIndex=0;
		while(outerArrayIndex < k) {
			for(int index=0; index<arrays.length; index++) {
				for(int jIndex=0; jIndex<arrays[index].length; jIndex++) {
					mergedArray[outerArrayIndex] = arrays[index][jIndex];
					outerArrayIndex++;
				}
			}
		}
		heapify(mergedArray, k);
	}
	public static void heapify(int array[], int length) {
		for(int index=length-1/2; index>=0; index--) {
			heapSort(array, index, length);
		}
		
		
		for(int index=length-1; index>=0; index--) {
			swap(array, 0, index);
			heapSort(array, 0, index);
		}
		
		for(int index=0; index<length; index++) {
			System.out.print(array[index] + " ");
		}
		System.out.println();
	}
	public static void heapSort(int array[], int index, int end) {
		int largest= index;
		int leftChild = leftChild(index);
		int rightChild = rightChild(index);
		if(leftChild < end && array[largest] < array[leftChild]) {
			largest = leftChild;
		}
		if(rightChild < end && array[largest] < array[rightChild]) {
			largest = rightChild;
		}
		if(index != largest) {
			swap(array, index, largest);
			heapSort(array, largest, end);
		}
	}
	public static int leftChild(int index) {
		return (2 * index + 1);
	}
	public static int rightChild(int index) {
		return (2 * index + 2);
	}
	public static void swap(int array[], int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}