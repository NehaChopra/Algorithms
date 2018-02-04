//https://www.hackerrank.com/contests/hourrank-26/challenges/combo-meal
package HourRank26;

import java.util.Scanner;

class ComboMeal {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
			int burger = input.nextInt();
			int soda = input.nextInt();
			int comboMeal = input.nextInt();
			System.out.println(findFixedProfitCharged(burger, soda, comboMeal));
		}
	}
	public static int findFixedProfitCharged(int burger, int soda, int comboMeal){
		int profit = 0;
		return (soda - (comboMeal - burger));
	}
}
