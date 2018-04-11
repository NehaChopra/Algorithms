//https://practice.geeksforgeeks.org/problems/multiply-two-strings/1/?ref=self
package strings;

import java.util.Scanner;

class Multiplytwostrings {
	public static void main(String []args) {
		Scanner input = new Scanner(System.in);
		int testCasesNumber = input.nextInt();
		for(int testCases = 0; testCases < testCasesNumber; testCases++){
			int num1 = input.nextInt();
			int num2 = input.nextInt();
			System.out.println(num1 * num2);
		}
	}
}
