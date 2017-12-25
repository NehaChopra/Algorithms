//https://www.geeksforgeeks.org/grouping-countries/
package ThoughtWorks;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class GroupingCountries {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
			int arrayLength = input.nextInt();
			int inputArray[] = new int[arrayLength];
			for(int jindex=0; jindex<arrayLength; jindex++){
				inputArray[jindex] = input.nextInt();
			}
			System.out.println(distinctCoutriesGroup(inputArray));
		}
	}
	public static String distinctCoutriesGroup(int inputArray[]){
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int index=0; index<inputArray.length;index++){
			if(map.containsKey(inputArray[index])){
				map.put(inputArray[index], map.get(inputArray[index]) + 1);
			}else{
				map.put(inputArray[index], 1);
			}
		}
		Set<Integer> keySet = map.keySet();
		Iterator itr = keySet.iterator();
		while(itr.hasNext()){
			int element = (int) itr.next();
			if(element>1){
				if((element==map.get(element))){
					count = count + 1;
				}else{
					count = 0;
					break;
				}
			}else{
				count = count + map.get(element);
			}
		}
		return (count > 0) ? String.valueOf(count) : "Invalid Answer";
	}
}
