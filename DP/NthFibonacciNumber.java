//https://practice.geeksforgeeks.org/problems/nth-fibonacci-number/0

package DP;

import java.util.Scanner;

public class NthFibonacciNumber {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
			int num = input.nextInt();
			System.out.println(fibonacci(num));
		}
	}
	
	public static int fibonacci(int num){
		if(num <= 1){
			return num;
		}
		return fibonacci(num-1) + fibonacci(num-2);
	}
}

