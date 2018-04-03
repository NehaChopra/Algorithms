//https://practice.geeksforgeeks.org/problems/merge-sort/1
package Array;

import java.util.Scanner;

class MergeSort {
	public static void main(String []args) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int test = 0; test<testCases; test++){
			int arrayLength = input.nextInt();
			int array[] = new int[arrayLength];
			for(int index=0; index<arrayLength; index++){
				array[index] = input.nextInt();
			}
			sort(array, 0, (arrayLength-1));
			for(int index=0; index<arrayLength; index++){
				System.out.print(array[index] + " ");
			}
			System.out.println();
		}
	}
	public static void sort(int array[], int lowIndex, int rightIndex) {
		if(lowIndex < rightIndex) {
			int middle = (lowIndex + rightIndex) / 2;
			sort(array,lowIndex, middle);
			sort(array, middle+1, rightIndex);
			merge(array, lowIndex, middle, rightIndex);
		}
	}
	public static void merge(int array[], int lowIndex, int middle, int rightIndex) {
		int lowArrayLength = middle -lowIndex + 1;
		int rightArrayLength = rightIndex - middle;
		int lowArray[] = new int[lowArrayLength];
		int rightArray[] = new int[rightArrayLength];
		
		for(int index=0; index<lowArrayLength; index++) {
			lowArray[index] = array[lowIndex + index];
		}
		for(int index=0; index<rightArrayLength; index++) {
			rightArray[index] = array[middle + 1 + index];
		}
		
		int low = 0;
		int right = 0;
		int k = lowIndex;
		
		while((low < lowArrayLength) && (right < rightArrayLength)) {
			if(lowArray[low] <= rightArray[right]) {
				array[k] = lowArray[low];
				low ++ ;
			}else {
				array[k] = rightArray[right];
				right ++ ;
			}
			k++;
		}
		
		while(low < lowArrayLength) {
			array[k] = lowArray[low];
			low ++ ;
			k++;
		}
		
		while(right < rightArrayLength) {
			array[k] = rightArray[right];
			right ++ ;
			k++;
		}
	}
}
