//https://www.geeksforgeeks.org/print-valid-words-possible-using-characters-array/
/*
 * Input : Dict - {"go","bat","me","eat","goal", 
                                "boy", "run"} 
        arr[] = {'e','o','b', 'a','m','g', 'l'} 
Output : go, me, goal. 
 */
package trie;

import java.util.Arrays;
import java.util.Scanner;

public class ValidWordsCharactersofArray {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
			 TrieM obj = new TrieM();
			 TrieNodeM root = new TrieNodeM();
			 obj.root = root;
			int arrayLength = input.nextInt();
			String arrayString[] = new String[arrayLength];
			for(int jIndex=0; jIndex<arrayLength; jIndex++){
				 arrayString[jIndex] = input.next();
				 obj.insert(arrayString[jIndex]);
			}
			int charArrayLength = input.nextInt();
			String arrayChar[] = new String[charArrayLength];
			
			arrayChar = input.nextLine().split(" ");
			for(int jIndex=0; jIndex<arrayLength; jIndex++){
				if(obj.search(arrayString[jIndex], arrayChar)) {
					System.out.println(arrayString[jIndex]);
				}
			}
		}
	}
}
class TrieNodeM{
	TrieNodeM children[] = new TrieNodeM[26];
	boolean endOfWord;
	TrieNodeM(){
		for(int index=0; index<children.length; index++){
			this.children[index] = null;
		}
		this.endOfWord = false;
	}
}

class TrieM{
	TrieNodeM root;
	public void insert(String key){
		TrieNodeM cwral = root;
		for(int index=0; index<key.length();index++){
			int elementIndex = key.charAt(index) - 'a';
			if(cwral.children[elementIndex] == null){
				cwral.children[elementIndex] = new TrieNodeM();
			}
			cwral = cwral.children[elementIndex];
		}
		cwral.endOfWord = true;
	}
	public boolean search(String key, String arrayChar[]){
		TrieNodeM cwral = root;
		boolean contains = true;
		for(int index=0; index<key.length();index++){
			int elementIndex = key.charAt(index) - 'a';
			contains = contains && Arrays.asList().contains(key.charAt(index));
			if(cwral.children[elementIndex] == null){
				return false;
			}else {
				
			}
			cwral = cwral.children[elementIndex];
		}
		return (cwral!=null && cwral.endOfWord && contains);
	}
}