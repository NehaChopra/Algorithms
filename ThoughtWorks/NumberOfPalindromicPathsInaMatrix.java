package ThoughtWorks;

//https://practice.geeksforgeeks.org/problems/number-of-palindromic-paths-in-a-matrix/0
import java.util.Scanner;

public class NumberOfPalindromicPathsInaMatrix{  
	public static int rowL;
	public static int colL;
	public static String[][] matrix;
	public static int count;
	public static void main(String args[]){  
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
			rowL = input.nextInt();
			colL = input.nextInt();
			input.nextLine();
			String[] inputString = input.nextLine().split(" ");
			prepareMatrix(inputString);
			String outputString = "";
			count = 0;
			palidromicPathTraversal(0,0,outputString);
			System.out.println(count);
		}
	}  
	public static void prepareMatrix(String[] inputString){
		matrix = new String[rowL][colL];
		int strLength=0;
		for(int index=0; index<rowL; index++){
			for(int jindex=0; jindex<colL && strLength<inputString.length; jindex++,strLength++){
				matrix[index][jindex] = inputString[strLength];
			}
		}
	}
	public static boolean palidromicPathTraversal(int row, int col, String outputString){
		if((row+1) < rowL || (col+1) < colL){
			if((row+1) < rowL){
				palidromicPathTraversal(row+1, col, outputString + (matrix[row][col]));
			}
			if((col+1) < colL){
				palidromicPathTraversal(row, col+1, outputString + (matrix[row][col]));
			}
		}else{
			outputString = outputString + (matrix[rowL-1][colL-1]);
			if(isPalidrome(outputString.toString())){
//				System.out.println(outputString.toString());
				count = count + 1;
				return true;
			}
		}
		return false;
	}
	public static boolean isPalidrome(String inputString){
		boolean result = true;
		for(int index=0; index<(inputString.length())/2;index++){
			if(inputString.charAt(index) != inputString.charAt(inputString.length()-1- index)){
				result = result && false;
			}
		}
		return result;
	}
}  