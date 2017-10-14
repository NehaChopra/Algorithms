//http://practice.geeksforgeeks.org/problems/trie-insert-and-search/0
package trie;

import java.util.Scanner;

class InsertAndSearchTrie {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
			 Trie obj = new Trie();
			 TrieNode root = new TrieNode();
			 obj.root = root;
			int arrayLength = input.nextInt();
			for(int jIndex=0; jIndex<arrayLength; jIndex++){
				 obj.insert(input.next());
			}
			System.out.println(obj.search(input.nextLine()) ? 1 : 0);
		}

	}
}
class TrieNode{
	TrieNode children[] = new TrieNode[26];
	boolean endOfWord;
	TrieNode(){
		for(int index=0; index<children.length; index++){
			this.children[index] = null;
		}
		this.endOfWord = false;
	}
}

class Trie{
	TrieNode root;
	public void insert(String key){
		TrieNode cwral = root;
		for(int index=0; index<key.length();index++){
			int elementIndex = key.charAt(index) - 'a';
			if(cwral.children[elementIndex] == null){
				cwral.children[elementIndex] = new TrieNode();
			}
			cwral = cwral.children[elementIndex];
		}
		cwral.endOfWord = true;
	}
	public boolean search(String key){
		TrieNode cwral = root;
		for(int index=0; index<key.length();index++){
			int elementIndex = key.charAt(index) - 'a';
			if(cwral.children[elementIndex] == null){
				return false;
			}
			cwral = cwral.children[elementIndex];
		}
		return (cwral!=null && cwral.endOfWord);
	}
}