//https://practice.geeksforgeeks.org/problems/design-a-tiny-url-or-url-shortener/0
package paytm;

import java.util.Scanner;

class URLshortener {
	static String characSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	static char[] charSet = characSet.toCharArray();
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases;index++){
			int inputCode = input.nextInt();
			String shortUrl = shortenURL(inputCode);
			System.out.println(shortUrl);
			System.out.println(lengthenURL(shortUrl));
		}
	}
	public static String shortenURL(int inputCode){
		StringBuffer output = new StringBuffer("");
		while(inputCode >0){
			output.append(characSet.charAt(inputCode%characSet.length()));
			inputCode = inputCode / characSet.length();
		}
		return output.reverse().toString();
	}
	public static int lengthenURL(String shortUrl){
		int result = 0;
		for(int index=0; index<shortUrl.length(); index++){
			if(shortUrl.charAt(index) >='a' && shortUrl.charAt(index) <='z'){
				result = ((result * characSet.length()) + (shortUrl.charAt(index) - 'a'));
			}else if(shortUrl.charAt(index) >='A' && shortUrl.charAt(index) <='Z'){
				result = ((result * characSet.length()) + (shortUrl.charAt(index) - 'A'));
			}else if(shortUrl.charAt(index) >='1' && shortUrl.charAt(index) <='9'){
				result = ((result * characSet.length()) + (shortUrl.charAt(index) - '1'));
			}
		}
		return result;
	}
}
