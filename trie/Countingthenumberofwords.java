//https://www.geeksforgeeks.org/counting-number-words-trie/
package trie;

import java.util.Scanner;

public class Countingthenumberofwords {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
			TrieD obj = new TrieD();
			TrieNodeD root = new TrieNodeD();
			obj.root = root;
			int arrayLength = input.nextInt();
			for(int jIndex=0; jIndex<arrayLength; jIndex++){
				 obj.insert(input.next());
			}
			char array[] = new char[26];
			obj.trieDisplay(root, array, 0);
			System.out.println(obj.count);
		}
	}
}
class TrieNodeD{
	TrieNodeD children[] = new TrieNodeD[26];
	boolean endOfWord;
	TrieNodeD(){
		for(int index=0; index<children.length; index++){
			this.children[index] = null;
		}
		this.endOfWord = false;
	}
}
class TrieD{
	TrieNodeD root;
	int count=0;
	public void insert(String key){
		TrieNodeD cwral = root;
		for(int index=0; index<key.length();index++){
			int elementIndex = key.charAt(index) - 'a';
			if(cwral.children[elementIndex] == null){
				cwral.children[elementIndex] = new TrieNodeD();
			}
			cwral = cwral.children[elementIndex];
		}
		cwral.endOfWord = true;
	}
	public boolean search(String key){
		TrieNodeD cwral = root;
		for(int index=0; index<key.length();index++){
			int elementIndex = key.charAt(index) - 'a';
			if(cwral.children[elementIndex] == null){
				return false;
			}
			cwral = cwral.children[elementIndex];
		}
		return (cwral!=null && cwral.endOfWord);
	}
	
	public void trieDisplay(TrieNodeD root, char array[], int levelindex) {
		if(root.endOfWord) {
			count++;
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