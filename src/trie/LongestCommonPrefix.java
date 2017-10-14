//http://www.geeksforgeeks.org/longest-common-prefix-set-5-using-trie/
package trie;

import java.util.Scanner;

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
	public String search(String key){
		StringBuffer finalString = new StringBuffer("");
		TrieNode cwral = root;
		for(int index=0; index<key.length();index++){
			int elementIndex = key.charAt(index) - 'a';
			if(cwral.children[elementIndex] == null){
				finalString = new StringBuffer(key.substring(0, index));
				break;
			}
			if(countChildren(cwral) > 1){
				finalString = new StringBuffer(key.substring(0, index));
				break;
			}
			cwral = cwral.children[elementIndex];
		}
		if(cwral!=null && cwral.endOfWord && lastNode(cwral)){
			return key;
		}
		return finalString.toString();
	}
	public static boolean lastNode(TrieNode root){
		for(int index=0;index<26;index++){
			if(root.children[index] != null){
				return false;
			}
		}
		return true;
	}
	public static int countChildren(TrieNode cwral){
		int count = 0;
		for(int index=0; index<26; index++){
			if (cwral.children[index]!=null){
				count = count + 1;
			}
		}
		return count; 
	}
}
class LongestCommonPrefix {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
		    TrieNode root = new TrieNode();
    		Trie obj = new Trie();
    		obj.root = root;
    		int arrayLength = input.nextInt();
			for(int jIndex=0; jIndex<arrayLength; jIndex++){
				String value = input.next();
				obj.insert(value);
				if(jIndex == arrayLength - 1){
					String output = obj.search(value);
					if(output.length() >= 1){
					    System.out.println(output);
					}else{
					    System.out.println(-1);
					}
				}
			}
		}
	}
}

