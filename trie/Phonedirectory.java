//https://practice.geeksforgeeks.org/problems/phone-directory/0
package trie;

import java.util.Scanner;

class TrieNode{
	boolean endOfWord;
	TrieNode[] children = new TrieNode[26];
	
	TrieNode() {
		this.endOfWord = false;
		for(int index=0; index<26; index++) {
			children[index] = null;
		}
	}
}

class Trie{
	TrieNode root;
	
	public void insert(String key) {
		TrieNode crawler = root;
		for(int index=0; index<key.length(); index++) {
			int elementIndex = key.charAt(index) - 'a';
			if(crawler.children[elementIndex] == null) {
				crawler.children[elementIndex] = new TrieNode();
			}
			crawler = crawler.children[elementIndex]; 
		}
		crawler.endOfWord = true;
	}
	
	public boolean search(String key) {
		TrieNode crawler = root;
		for(int index=0; index<key.length(); index++) {
			int elementIndex = key.charAt(index) - 'a';
			if(crawler.children[elementIndex] == null) {
				return false;
			}
			crawler = crawler.children[elementIndex]; 
		}
		return (crawler!= null && crawler.endOfWord);
	}
	
	public void autoSuggest(String key) {
		TrieNode crawler = root;
		for(int index=0; index<key.length(); index++) {
			int elementIndex = key.charAt(index) - 'a';
			if(crawler.children[elementIndex] != null) {
				crawler = crawler.children[elementIndex]; 
			}else {
				System.out.print("0");
				return;
			}
		}
		if(crawler!=null && lastNode(crawler)) {
			System.out.print(key + " ");
		}else if(!lastNode(crawler)) {
			printSuggestedWords(crawler, key);
		}
	}
	
	public boolean lastNode(TrieNode root) {
		for(int index=0; index<26; index++) {
			if(root.children[index] != null) {
				return false;
			}
		}
		return true;
	}
	public void printSuggestedWords(TrieNode root, String key) {
		if(root.endOfWord) {
				System.out.print(key + " ");
		}
		if(lastNode(root)) {
			return;
		}
		for(int index=0; index<26; index++) {
			if(root.children[index] != null) {
				printSuggestedWords(root.children[index], key + String.valueOf((char)(index + 'a')));
			}
		}
	}
}
class Phonedirectory {
	public static void main(String []args) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++) {
			TrieNode root = new TrieNode();
			Trie obj = new Trie();
			obj.root = root;
			int arrayLength = input.nextInt();
			for(int jindex=0; jindex<arrayLength; jindex++) {
				obj.insert(input.next());
			}
			
		 	String inputString = input.next();
		 	StringBuffer str = new StringBuffer();
		 	for(int mindex=0; mindex<inputString.length(); mindex++) {
		 		str.append(inputString.charAt(mindex));
		 		obj.autoSuggest(str.toString());
		 		System.out.println();
		 	}
		}
	}
}
