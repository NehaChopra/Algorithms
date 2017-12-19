package DP;
import java.util.ArrayList;
import java.util.Scanner;

public class SubstringGame {
	public static void main(String []args[]){
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		ArrayList<String> stringArrays = new ArrayList<String>();
		
		performSusbtring(inputString, stringArrays, 0, 1);
		
//		int questionsAskedCount = input.nextInt();
//		
//		for(int index=0; index<questionsAskedCount; index++){
//			int questionAsked = input.nextInt();
//		}
	}
	
	public static void performSusbtring(String inputString, ArrayList<String> stringArrays, int startIndex, int endIndex){
		if(startIndex == inputString.length()){
			return;
		}
		if(endIndex == inputString.length()){
			startIndex ++;
			endIndex = startIndex + 1;
		}
		stringArrays.add(inputString.substring(startIndex, endIndex));
		performSusbtring(inputString, stringArrays, startIndex, endIndex++);
	}
	
	public static void positionOfSusbtring(){
		
	}
}
