//https://practice.geeksforgeeks.org/problems/excel-sheet/0
package Directi;

import java.util.Scanner;

class ExcelSheet {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
			int num = input.nextInt();
			System.out.println(findExcelCol(num));
		}
	}
	public static String findExcelCol(int num){
		StringBuffer outputString = new StringBuffer("");
		while(num > 0){
			int rem = num % 26;
			if(rem>0 && rem<26){
				outputString.append((char)(65 + (rem-1)));
				num = num / 26;
			}
			if(rem==0){
				outputString.append('Z');
				num = (num / 26) - 1;
			}
		}
		return outputString.reverse().toString();
	}
}	
