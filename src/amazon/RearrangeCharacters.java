package amazon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


class RearrangeCharacters {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		int testCasesNumber = input.nextInt();
		for(int testCases = 0; testCases < testCasesNumber; testCases++){
			String inputString = input.nextLine();
		}
	}
	public static void rearrangeCharacter(String inputString){
		 Deque<String> stack = new ArrayDeque<String>();
		 StringBuffer finalString = new StringBuffer("");
		 int beginIndex =0 ;
		 int endIndex = 1;
		 while(endIndex <= inputString.length()){
			 if(stack.size() == 0){
				 stack.push(inputString.substring(beginIndex, endIndex));
			 }else{
				 String element = stack.pop();
				 if(finalString.length() == 0){
					 finalString.append(element);
				 }else if(finalString.substring(beginIndex-1, endIndex-1) != element){
					 finalString.append(element);
				 }else{
					 stack.push(element);
				 }
			 }
			 beginIndex++;
			 endIndex++;
		 }
	}
}
