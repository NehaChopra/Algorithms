//https://practice.geeksforgeeks.org/problems/array-of-alternate-ve-and-ve-nos/0
package Array;

import java.util.Scanner;

class RearrangePositiveAndNegativeNumbers {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int test = 0; test<testCases; test++){
			int arrayLength = input.nextInt();
			int array[] = new int[arrayLength];
			for(int index=0; index<arrayLength; index++){
				array[index] = input.nextInt();
			}
			int negIndex = arrangeElements(array);
			int negIteration = negIndex;
			for(int index=0; index<arrayLength; index++){
				if(array[index] >= 0){
					System.out.print(array[index] + " ");
				}
				if(negIndex<arrayLength){
					System.out.print(array[negIndex] + " ");
					negIndex ++;
				}
			}
			System.out.println();
		}
	}
	public static int arrangeElements(int array[]){
		int index=-1;
		for(int crawl=0; crawl<array.length; crawl++){
			if(array[crawl] >= 0){
				index = index + 1;
				swapElements(array, index, crawl);
			}
		}
		return (index+1);
	}
	public static void swapElements(int array[], int index, int jIndex){
		for(int loopIndex=jIndex; loopIndex>index; loopIndex--){
			int temp = array[loopIndex];
			array[loopIndex] = array[loopIndex-1];
			array[loopIndex-1] = temp;
		}
	}
}
