//https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence/0/?ref=self

package dynamicProgramming;

import java.util.Scanner;

class LongestRepeatingSubsequence {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
			int arrayLength1 = input.nextInt();
			input.nextLine();
			char[] inputChar1 = (input.nextLine()).toCharArray();
			System.out.println(LRS(inputChar1, inputChar1, arrayLength1, arrayLength1));
		}
	}
	
	public static int LRS(char[] inputChar1, char[] inputChar2, int arrayLength1, int arrayLength2){
		if(arrayLength1 ==0 || arrayLength2 ==0){
			return 0;
		}
		if((inputChar1[arrayLength1-1] == inputChar2[arrayLength2-1]) && (arrayLength1 != arrayLength2)){
			return 1 + LRS(inputChar1, inputChar2, arrayLength1 -1, arrayLength2 -1);
		}
		return Math.max(LRS(inputChar1, inputChar2, arrayLength1 -1, arrayLength2), 
				LRS(inputChar1, inputChar2, arrayLength1, arrayLength2 -1));
	}
}
