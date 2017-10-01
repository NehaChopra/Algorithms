//http://practice.geeksforgeeks.org/problems/consecutive-1s-not-allowed/0

package flipkart;

import java.util.Scanner;

public class Consecutive1snotAllowed {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCasesNumber = input.nextInt();
		for(int testCases = 0; testCases < testCasesNumber; testCases++){
			System.out.println(findFibonacci(input.nextInt(), 0 ,1));
		}
	}
	public static int findFibonacci(int num, int start, int next){
		int index = 0;
		while(index++ < num +2){
			int temp = next%1000000007;
			next = next%1000000007 + start%1000000007;
			start = temp;
		}
		return start;
	}
}
