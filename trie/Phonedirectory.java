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
	
}
class Phonedirectory {
	
}
