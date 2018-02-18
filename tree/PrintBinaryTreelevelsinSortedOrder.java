//https://practice.geeksforgeeks.org/problems/print-binary-tree-levels-in-sorted-order/0
package tree;

import java.util.Scanner;

class PrintBinaryTreelevelsinSortedOrder {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int test = 0; test<testCases; test++){
			int arrayLength = input.nextInt();
			int array[] = new int[arrayLength];
			for(int index=0; index<arrayLength; index++){
				array[index] = input.nextInt();
			}
			sortedTreePerLevel(array, 0, 0);
		}
	}
	public static void sortedTreePerLevel(int inputArray[], int index, int lastIndex){
		if(index==0){
			System.out.println(inputArray[0]);
			if(getRight(index) < inputArray.length){
				sortedTreePerLevel(inputArray, getRight(index), index);
			}else if(getLeft(index) < inputArray.length){
				sortedTreePerLevel(inputArray, getLeft(index), index);
			}else{
				return;
			}
		}else{
			if(index < inputArray.length){
				for(int root= index; root>lastIndex; root-- ){
					System.out.print(inputArray[root] +" ");
				}
				System.out.println();
			}
			if(getRight(index) < inputArray.length){
				sortedTreePerLevel(inputArray, getRight(index), index);
			}else if(getLeft(index) < inputArray.length){
				sortedTreePerLevel(inputArray, getLeft(index), index);
			}else{
				return;
			}
		}
	}
	public static int getLeft(int index){
		return (2*index + 1);
	}
	public static int getRight(int index){
		return (2*index + 2);
	}
}
