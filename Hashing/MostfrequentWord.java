//https://practice.geeksforgeeks.org/problems/most-frequent-word-in-an-array-of-strings/0
package Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class MostfrequentWord {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
			int arrayLength = input.nextInt();
			String[] inputString = input.nextLine().trim().split(" ");
			System.out.println(findOccurence(inputString));
		}
	}
	public static String findOccurence(String[] inputString) {
		Map<String, Integer> map= new HashMap<String, Integer>();
		for(String ele : inputString) {
			if(map.containsKey(ele)) {
				map.put(ele, map.get(ele) + 1);
			}else {
				map.put(ele, 1);
			}
		}
		
		int max = 0;
		String maxValue = "";
		
		Set<String> set = map.keySet();
		for(String ele : set) {
			if(map.get(ele) > max) {
				max = map.get(ele);
				maxValue = ele;
			}
		}
		
		return maxValue;
	}
}
