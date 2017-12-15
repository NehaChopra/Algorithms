//https://practice.geeksforgeeks.org/problems/edit-distance/0


package dynamicProgramming;

import java.util.Scanner;

class EditDistance {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
			int arrayLength1 = Integer.parseInt(input.next());
			int arrayLength2 = Integer.parseInt(input.next());
			input.nextLine();
			String inputString = input.nextLine();
			String[] finalString = inputString.split(" ", -1);
			char[] inputChar1 = (finalString[0]).toCharArray();
			char[] inputChar2 = (finalString[1]).toCharArray();

			System.out.println(editsOperation(inputChar1, inputChar2, arrayLength1, arrayLength2));
		}
	}
	
	public static int editsOperation(char[] inputChar1, char[] inputChar2, int arrayLength1, int arrayLength2){
		if(arrayLength1==0){
			return arrayLength2;
		}
		if(arrayLength2==0){
			return arrayLength1;
		}
		if(inputChar1[arrayLength1-1] == inputChar2[arrayLength2-1]){
			return editsOperation(inputChar1, inputChar2, arrayLength1-1, arrayLength2-1);
		}
		return 1 + Math.min(
				Math.min(
						editsOperation(inputChar1, inputChar2, arrayLength1, arrayLength2 -1),//Insert 
						editsOperation(inputChar1, inputChar2, arrayLength1 -1, arrayLength2)), //Remove
				editsOperation(inputChar1, inputChar2, arrayLength1 -1, arrayLength2 -1));//Replace
	}
}
