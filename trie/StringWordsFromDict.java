//https://www.geeksforgeeks.org/check-if-the-given-string-of-words-can-be-formed-from-words-present-in-the-dictionary/
/*
 * 
 *
TestCase : 1
1
9
find
a
geeks
all
for
on
geeks
answers
inter
7
find
all
answers
on
geeks
for
geeks 


TestCase : 2
1
9
find
a
geeks
all
for
on
geeks
answers
inter
3
find
a
geek 




 */
package trie;

import java.util.Scanner;

public class StringWordsFromDict {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
			Trie11 obj = new Trie11();
			TrieNode11 root = new TrieNode11();
			obj.root = root;
			int arrayLength = input.nextInt();
			
			for(int jIndex=0; jIndex<arrayLength; jIndex++){
				 String key =input.next();
				 System.out.println(key);
				 obj.insert(key);
			}
			
			int findTextLength = input.nextInt();
			boolean finalOutput = true;
			for(int jIndex=0; jIndex<findTextLength; jIndex++){
				String key = input.next();
				System.out.println(key);
				finalOutput = finalOutput && obj.search(key);
			}
			
			System.out.println(finalOutput);
		}
	}
}
class TrieNode11{
	TrieNode11 children[] = new TrieNode11[26];
	boolean endOfWord;
	TrieNode11(){
		for(int index=0; index<children.length; index++){
			this.children[index] = null;
		}
		this.endOfWord = false;
	}
}

class Trie11{
	TrieNode11 root;
	public void insert(String key){
		TrieNode11 cwral = root;
		for(int index=0; index<key.length();index++){
			int elementIndex = key.charAt(index) - 'a';
			if(cwral.children[elementIndex] == null){
				cwral.children[elementIndex] = new TrieNode11();
			}
			cwral = cwral.children[elementIndex];
		}
		cwral.endOfWord = true;
	}
	public boolean search(String key){
		TrieNode11 cwral = root;
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