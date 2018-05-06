//https://practice.geeksforgeeks.org/problems/minimum-platforms/0/?ref=self
package tree;

import java.util.Scanner;

class HeapSort2{
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

class MinimumPlatforms {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCasesNumber = input.nextInt();
		for(int testCases = 0; testCases < testCasesNumber; testCases++){
			int arrayLength =  input.nextInt();
			int[] arrayArr = new int[arrayLength];
			int[] arrayDep = new int[arrayLength];
			
			for(int index=0; index<arrayLength; index++){
				arrayArr[index] = input.nextInt();
			}
			
			for(int index=0; index<arrayLength; index++){
				arrayDep[index] = input.nextInt();
			}
			
			HeapSort2 obj = new HeapSort2();
			obj.sort(arrayArr);
			obj.sort(arrayDep);

			System.out.println(findMinimumPlatform(arrayArr, arrayDep, arrayLength));
		}
	}
	
	public static int findMinimumPlatform(int[] arrayArr , int[] arrayDep, int end) {
		int platform = 1 , result = 1;
		int arr = 1;
		int dep = 0;
		
		while(arr < end && dep < end) {
			if(arrayArr[arr] < arrayDep[dep]) {
				platform = platform + 1;
				arr = arr + 1;
				
				if(result < platform) {
					result = platform;
				}
			}else {
				platform = platform - 1;
				dep = dep + 1;
			}
		}
		return result;
	}
}
