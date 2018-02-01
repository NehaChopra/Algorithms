//https://practice.geeksforgeeks.org/problems/finger-game/0
package paytm;

import java.util.Scanner;

class CountNumbersOnFingers {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
			int num  = input.nextInt();
			System.out.println(countNUmOnFingers(num));
		}
	}
	public static int countNUmOnFingers(int num){
		int rem = num % 8;
		if(rem==1){
			return 1;
		}
		if(rem==2 || rem==0){
			return 2;
		}
		if(rem==3 || rem==7){
			return 3;
		}
		if(rem==4 || rem==6){
			return 4;
		}
		if(rem==5){
			return 5;
		}
		return 0;
	}
}
