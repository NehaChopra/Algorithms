//https://practice.geeksforgeeks.org/problems/segregate-even-and-odd-numbers/0
package paytm;

import java.util.Scanner;

class SegregateEvenAndOddnumbers {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
			int arrayLength = input.nextInt();
			int[] inputArray = new int[arrayLength];
			input.nextLine();
			String[] inputString = input.nextLine().split(" ");;
			for(int jindex=0; jindex<arrayLength; jindex++){
				inputArray[jindex] = Integer.parseInt(inputString[jindex]);
			}
			segregateOddandEven(inputArray);
			for(int pindex=0; pindex<inputArray.length;pindex++){
				System.out.print(inputArray[pindex] + " ");
			}
			System.out.println();
		}
	}
	public static void segregateOddandEven(int[] inputArray){
		int left=0;
		int right = inputArray.length-1;
		
		while(left < right){
			while((left < right) && (inputArray[left]%2==0)){
				left++;
			}
			while((left < right) && (inputArray[right]%2!=0)){
				right--;
			}
			if(left < right){
				int temp = inputArray[left];
				inputArray[left] = inputArray[right];
				inputArray[right] = temp;
				left++;
				right--;
			}
		}
	}
}
