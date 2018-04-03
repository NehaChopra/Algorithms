//https://practice.geeksforgeeks.org/problems/find-the-minimum-time/0
package oracle;

import java.util.Scanner;

class FindTheMinimumTime {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
			int scan1 = input.nextInt();;
			int scan2 = input.nextInt();;
			int docs = input.nextInt();;
			
			System.out.println(scanTotalTime(scan1, scan2, docs));
		}
		
	}
	public static int scanTotalTime(int scan1, int scan2, int docs){
		if(docs == 1){
			return Math.min(scan1, scan2);
		}else if(docs == 2){
			return Math.min(docs * Math.min(scan1, scan2), Math.max(scan1, scan2));
		}else{
			return docs * Math.min(scan1, scan2);
		}
	}
}
