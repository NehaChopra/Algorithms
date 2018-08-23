//https://www.geeksforgeeks.org/palindrome-pair-in-an-array-of-words-or-strings/
/*
 * 1
6
geekf geeks or keeg abc bc

	

1
6
abc xyxcba geekst or keeg bc
 */
package trie;

import java.util.Scanner;

public class Palindromepair {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
			TriePP obj = new TriePP();
			 TrieNodePP root = new TrieNodePP();
			 obj.root = root;
			int arrayLength = input.nextInt();
			for(int jIndex=0; jIndex<arrayLength; jIndex++){
				 StringBuilder value = new StringBuilder(input.next());
				 String originalValue = value.toString();
				 String reverseValue = value.reverse().toString();
				 if(obj.contains(reverseValue.toString())) {
					 System.out.println("Yes");
				 }
				 obj.insert(originalValue.toString());
			}
			
		}
	}
}
class TrieNodePP{
	TrieNodePP children[] = new TrieNodePP[26];
	boolean endOfWord;
	TrieNodePP(){
		for(int index=0; index<children.length; index++){
			this.children[index] = null;
		}
		this.endOfWord = false;
	}
}

class TriePP{
	TrieNodePP root;
	public void insert(String key){
		TrieNodePP cwral = root;
		for(int index=0; index<key.length();index++){
			int elementIndex = key.charAt(index) - 'a';
			if(cwral.children[elementIndex] == null){
				cwral.children[elementIndex] = new TrieNodePP();
			}
			cwral = cwral.children[elementIndex];
		}
		cwral.endOfWord = true;
	}
	public boolean search(String key){
		TrieNodePP cwral = root;
		for(int index=0; index<key.length();index++){
			int elementIndex = key.charAt(index) - 'a';
			if(cwral.children[elementIndex] == null){
				return false;
			}
			cwral = cwral.children[elementIndex];
		}
		return (cwral!=null && cwral.endOfWord);
	}
	
	public boolean contains(String key){
		TrieNodePP cwral = root;
		for(int index=0; index<key.length();index++){
			int elementIndex = key.charAt(index) - 'a';
			if(cwral.children[elementIndex] == null){
				return false;
			}
			cwral = cwral.children[elementIndex];
		}
		return true;
	}
}