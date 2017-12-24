//https://practice.geeksforgeeks.org/problems/word-boggle/0
package Backtracking;

import java.util.Scanner;


/*
 * 
 * 1
4
GEEKS FOR QUIZ GO
3 3
G I Z U E K Q S E
 */
class WordBoggle {
	public static int rowN;
	public static int colN;
	public static String[][] board;
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		TrieNode obj = new TrieNode();
		Trie trieObj = new Trie();
		trieObj.root = obj;
		for(int index=0; index<testCases; index++){
			int dictLength = input.nextInt();
			input.nextLine();
			String[] inputToken = input.nextLine().split(" ");
			for(int jindex=0; jindex<inputToken.length; jindex++){
				trieObj.insert(trieObj.root, inputToken[jindex]);
			}
			rowN = Integer.parseInt(input.next());
			colN = Integer.parseInt(input.next());
			input.nextLine();
			String[] matrixChars = (input.nextLine()).split(" ");
			prepareMatrix(matrixChars);
			searchDict(board, trieObj.root);
		}
	}
	public static void prepareMatrix(String[] matrixChars){
		board = new String[rowN][colN];
		for(int index=0; index<rowN; index++){
			for(int jindex=0; jindex<colN; jindex++){
				board[index][jindex] = matrixChars[index*2 +index + jindex];
			}
		}
		
		for(int index=0; index<rowN; index++){
			for(int jindex=0; jindex<colN; jindex++){
				System.out.print(board[index][jindex] + " ");
			}
			System.out.println();
		}
	}
	public static void searchDict(String[][] board, TrieNode root){
		boolean[][] visisted = new boolean[rowN][colN];
		StringBuffer str = new StringBuffer("");
		if(DFSUtil(0,0, board,visisted,str,root)){
			
		}
	}
	public static boolean DFSUtil(int row, int col, String[][] board, boolean[][] visisted,StringBuffer str, TrieNode root){
		if(isSafe(row,col,visisted)){
			String charac = board[row][col];
			int elementIndex =  charac.charAt(0) - 'A';
			if(root.children[elementIndex] != null){
				str.append(charac);
			}
			if(root.endOfWord){
				
			}
			visisted[row][col] = true;
			root = root.children[elementIndex];
			if(DFSUtil(row,col+1, board,visisted,str,root)){
				return true;
			}
			if(DFSUtil(row+1,col, board,visisted,str,root)){
				return true;
			}
			if(DFSUtil(row+1,col+1, board,visisted,str,root)){
				return true;
			}
			if(DFSUtil(row+1,col-1, board,visisted,str,root)){
				return true;
			}
			if(DFSUtil(row,col-1, board,visisted,str,root)){
				return true;
			}
			if(DFSUtil(row-1,col-1, board,visisted,str,root)){
				return true;
			}
			if(DFSUtil(row-1,col, board,visisted,str,root)){
				return true;
			}
			if(DFSUtil(row-1,col+1, board,visisted,str,root)){
				return true;
			}
			visisted[row][col] = false;
		}
		return false;
	}
	public static boolean isSafe(int row, int col, boolean[][] visisted){
		return ((row>=0 && row<rowN) && (col>=0 && col<colN) && (!visisted[row][col]));
	}
}
class TrieNode{
	TrieNode[] children;
	boolean endOfWord;
	public TrieNode(){
		children = new TrieNode[26];
		for(int index=0; index<26; index++){
			children[index] = null;
		}
		endOfWord = false;
	}
}
class Trie{
	TrieNode root;
	public void insert(TrieNode root, String keyInput){
		TrieNode pcrawl = root;
		for(int index=0; index<keyInput.length(); index++){
			int elementIndex= keyInput.charAt(index) - 'A';
			if(pcrawl.children[elementIndex]==null){
				pcrawl.children[elementIndex] = new TrieNode();
			}
			pcrawl = pcrawl.children[elementIndex];
		}
		pcrawl.endOfWord = true;
	}
}
