//https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum/0

package Array;

import java.util.HashMap;
import java.util.Scanner;

class Countpairswithgivensum {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases;index++){
			int arrayLength = input.nextInt();
			int sum = input.nextInt();
			int array[] = new int[arrayLength];
			for(int jIndex=0; jIndex<arrayLength; jIndex++){
				array[jIndex] = input.nextInt();
			}
			System.out.println(findGivenSumPair(array, sum));
		}
	}
	public static int findGivenSumPair(int array[], int sum){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int index=0 ;index<array.length; index++){
			if(map.get(array[index])!=null){
				map.put(array[index], map.get(array[index])+1);
			}else{
				map.put(array[index], 1);
			}
		}
		
		int count = 0;
		for(int index=0; index<array.length; index++){
			int num = sum - array[index];
			if(map.get(num) != null){
				count = count + map.get(num);
			}
			if(num == array[index]){
				count = count - 1;
			}
		}
		
		return count / 2;
	}
}
