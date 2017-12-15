package DP;

import java.util.ArrayList;
import java.util.Scanner;

public class LongestCommonSubsequence {
	
	public static void main(String []args){
		try {
			Scanner input = new Scanner(System.in);
			String inputString = input.nextLine();
			ArrayList<String> stringArrays = new ArrayList<String>();
			
			performSusbtring(inputString, stringArrays, 0, 1);

			System.out.println(stringArrays.size());
			int questionsAskedCount = input.nextInt();
			
			for(int index=0; index<questionsAskedCount; index++){
				String str = input.next();
				int questionAsked = (int) (Long.parseLong(str ) %1000000007) ;
				System.out.println(positionOfSusbtring(stringArrays, questionAsked));
			}
		}catch(Exception e){
			
		}

	}
	
	public static void performSusbtring(String inputString, ArrayList<String> stringArrays, int startIndex, int endIndex){
		try {
			if(endIndex == inputString.length() + 1){
				startIndex = startIndex + 1;
				endIndex = startIndex + 1;
			}
			if(startIndex == inputString.length()){
				return;
			}
			stringArrays.add(inputString.substring(startIndex, endIndex));
			performSusbtring(inputString, stringArrays, startIndex, endIndex+1);
		}catch(Exception e){
			
		}
	}
	
	public static String positionOfSusbtring(ArrayList<String> stringArrays, int position){
		String output = "-1";
		try{
			if(position - 1 >= stringArrays.size()){
				return output;
			}
			output = stringArrays.get(position - 1);
		}catch(Exception e){
			
		}
		return output;
	}	
}