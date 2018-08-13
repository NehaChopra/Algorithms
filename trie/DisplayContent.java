//https://www.geeksforgeeks.org/trie-display-content/
/*
 * 1
5
answer
any
bye
their
there
 */
package trie;

import java.util.Scanner;

public class DisplayContent {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
			TrieDisplay obj = new TrieDisplay();
			TrieNodeDisplay root = new TrieNodeDisplay();
			obj.root = root;
			int arrayLength = input.nextInt();
			for(int jIndex=0; jIndex<arrayLength; jIndex++){
				 obj.insert(input.next());
			}
			char array[] = new char[26];
			obj.trieDisplay(root, array, 0);
		}
	}
}

class TrieNodeDisplay{
	TrieNodeDisplay children[] = new TrieNodeDisplay[26];
	boolean endOfWord;
	TrieNodeDisplay(){
		for(int index=0; index<children.length; index++){
			this.children[index] = null;
		}
		this.endOfWord = false;
	}
}

class TrieDisplay{
	TrieNodeDisplay root;
	public void insert(String key){
		TrieNodeDisplay cwral = root;
		for(int index=0; index<key.length();index++){
			int elementIndex = key.charAt(index) - 'a';
			if(cwral.children[elementIndex] == null){
				cwral.children[elementIndex] = new TrieNodeDisplay();
			}
			cwral = cwral.children[elementIndex];
		}
		cwral.endOfWord = true;
	}
	public boolean search(String key){
		TrieNodeDisplay cwral = root;
		for(int index=0; index<key.length();index++){
			int elementIndex = key.charAt(index) - 'a';
			if(cwral.children[elementIndex] == null){
				return false;
			}
			cwral = cwral.children[elementIndex];
		}
		return (cwral!=null && cwral.endOfWord);
	}
	
	public void trieDisplay(TrieNodeDisplay root, char array[], int levelindex) {
		if(root.endOfWord) {
			for(int jIndex=0; jIndex<levelindex; jIndex++) {
				System.out.print(array[jIndex]);
			}
			System.out.println("");
		}
		for(int index=0; index<26; index++) {
			if(root.children[index]!=null) {
				array[levelindex] = (char)('a' + index);
				trieDisplay(root.children[index], array, levelindex+1);
			}
		}
	}
}