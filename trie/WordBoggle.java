//http://practice.geeksforgeeks.org/problems/word-boggle/0/?ref=self
package trie;

import java.util.Scanner;

/*
 * Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
       boggle[][]   = {{'G','I','Z'},
                       {'U','E','K'},
                       {'Q','S','E'}};
      isWord(str): returns true if str is present in dictionary
                   else false.
 */
class WordBoggle {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for(int index=0; index<testCases; index++){
			TrieWB obj = new TrieWB();
			 TrieNodeWB root = new TrieNodeWB();
			 obj.root = root;
			int arrayLength = input.nextInt();
			String arrayString[] = new String[arrayLength];
			for(int jIndex=0; jIndex<arrayLength; jIndex++){
				 arrayString[jIndex] = input.next();
				 obj.insert(arrayString[jIndex]);
			}
			
//			DFSUtil();
		}
	}
	public static void DFSUtil(int visited[][], int grah[][],int row, int col) {
		int rowIndexArray[] = {0, 1, 1, 1, 0, -1, -1, -1};
		int colIndexArray[] = {1, 1, 0, -1,  -1, -1, 0, 1};
		
		for(int index=0; index<rowIndexArray.length; index++) {
			int rowIndex = row + rowIndexArray[index];
			int colIndex= col + colIndexArray[index];
			
			if(isSafe(visited, rowIndex, colIndex)) {
				visited[rowIndex][colIndex] = 1;
				
				
				
				visited[rowIndex][colIndex] = 0;
			}
		}
	}
	public static boolean isSafe(int visited[][], int rowIndex, int colIndex) {
		return ((rowIndex > -1 && rowIndex < visited.length) && (colIndex > -1 && colIndex < visited.length) && (visited[rowIndex][colIndex] == 0));
	}
}

class TrieNodeWB{
	TrieNodeWB children[] = new TrieNodeWB[26];
	boolean endOfWord;
	TrieNodeWB(){
		for(int index=0; index<children.length; index++){
			this.children[index] = null;
		}
		this.endOfWord = false;
	}
}

class TrieWB{
	TrieNodeWB root;
	public void insert(String key){
		TrieNodeWB cwral = root;
		for(int index=0; index<key.length();index++){
			int elementIndex = key.charAt(index) - 'A';
			if(cwral.children[elementIndex] == null){
				cwral.children[elementIndex] = new TrieNodeWB();
			}
			cwral = cwral.children[elementIndex];
		}
		cwral.endOfWord = true;
	}
	public boolean search(String key){
		TrieNodeWB cwral = root;
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