//http://practice.geeksforgeeks.org/problems/drive-the-car/0

package tree;

import java.util.Scanner;
public class DriveTheCar {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCasesNumber = input.nextInt();
		for(int testCases = 0; testCases < testCasesNumber; testCases++){
			int arrayLength =  input.nextInt();
			int kilometerDistance = input.nextInt();
			int[] array = new int[arrayLength];
			for(int index=0; index<arrayLength; index++){
				array[index] = input.nextInt();
			}
			HeapSort obj = new HeapSort();
			obj.sort(array);
			if(array[array.length - 1] <= kilometerDistance){
				System.out.println(-1);
			}else{
				System.out.println(array[array.length - 1] - kilometerDistance);
			}
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
