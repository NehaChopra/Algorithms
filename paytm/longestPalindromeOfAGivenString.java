//https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string/0
package paytm;


import java.util.Scanner;

class longestPalindromeOfAGivenString {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
		
			String inputString = input.next();
			System.out.println(longestPalidromicSubstring(inputString));
		}
	}
	public static String longestPalidromicSubstring(String inputString){
		int maxLength = 0;
		int startPoint=0;
		int endPoint = 0;
		for(int index=0; index<inputString.length(); index++){
			/* even points
			 * 
			 */
			int low = index;
			int high = index+1;
			while(low>-1 && high<inputString.length() && (inputString.charAt(low) == inputString.charAt(high))){
				if(high-low + 1 > maxLength){
					startPoint = low;
					endPoint = high;
					maxLength = high-low + 1;
				}
				low = low -1;
				high = high +1;
			}
			
			
			/* odd points
			 * 
			 */
			low = index;
			high = index+2;
			while(low>-1 && high<inputString.length() && (inputString.charAt(low) == inputString.charAt(high))){
				if(high-low + 1 > maxLength){
					startPoint = low;
					endPoint = high;
					maxLength = high-low + 1;
				}
				low = low -1;
				high = high +1;
			}
		}
		return inputString.substring(startPoint, endPoint+1);
	}
}
