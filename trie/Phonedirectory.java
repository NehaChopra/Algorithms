//https://practice.geeksforgeeks.org/problems/phone-directory/0
package trie;

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
				return;
			}
		}
		if(crawler!=null && lastNode(crawler)) {
			System.out.println(key);
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
			System.out.println(key);
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
		TrieNode root = new TrieNode();
		Trie obj = new Trie();
		obj.root = root;
	 	obj.insert("geeikistest");
	 	obj.insert("geeksforgeeks");
	 	obj.insert("geeksfortest");
	 	
	 	obj.autoSuggest("geeips");
	}
}
