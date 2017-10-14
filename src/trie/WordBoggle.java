////http://practice.geeksforgeeks.org/problems/word-boggle/0/?ref=self
//package trie;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//class WordBoggle {
//	public static void main(String []args){
//		Scanner input = new Scanner(System.in);
//		int testCases = input.nextInt();
//		for(int index=0; index<testCases; index++){
//			 Trie obj = new Trie();
//			 TrieNode root = new TrieNode();
//			 obj.root = root;
//			int arrayLength = input.nextInt();
//			for(int jIndex=0; jIndex<arrayLength; jIndex++){
//				//System.out.println(input.next());
//				 obj.insert(input.next());
//			}
//			ArrayList<String> list = new ArrayList<String>();
//			
//			TrieNode[] children = obj.root.children;
//			for(int iterator=0; iterator<26; iterator++){
//				if(children[iterator] != null){
//					list.add(String.valueOf((char)('A' +iterator)));
//				}
//			}
//			
//			int n = Integer.parseInt(input.next());
//			int m = Integer.parseInt(input.next());
//			System.out.println(n);
//			System.out.println(m);
//			String array[][] = new String[n][m];
//			for(int i=0; i<n; i++){
//				for(int j=0; j<m; j++){
//					String inputString = input.next();
//					if(!list.contains(inputString)){
//						list.remove(inputString);
//						System.out.println(inputString);
//					}
//					//array[n][m] = inputString;
//				}
//			}
//			System.out.println("..........");
//			for(String el : list){
//				System.out.println(el);
//			}
//		}
//	}
//}
//
//class TrieNode{
//	TrieNode children[] = new TrieNode[26];
//	boolean endOfWord;
//	TrieNode(){
//		for(int index=0; index<children.length; index++){
//			this.children[index] = null;
//		}
//		this.endOfWord = false;
//	}
//}
//
//class Trie{
//	TrieNode root;
//	public void insert(String key){
//		TrieNode cwral = root;
//		for(int index=0; index<key.length();index++){
//			int elementIndex = key.charAt(index) - 'A';
//			if(cwral.children[elementIndex] == null){
//				cwral.children[elementIndex] = new TrieNode();
//			}
//			cwral = cwral.children[elementIndex];
//		}
//		cwral.endOfWord = true;
//	}
//	public boolean search(String key){
//		TrieNode cwral = root;
//		for(int index=0; index<key.length();index++){
//			int elementIndex = key.charAt(index) - 'a';
//			if(cwral.children[elementIndex] == null){
//				return false;
//			}
//			cwral = cwral.children[elementIndex];
//		}
//		return (cwral!=null && cwral.endOfWord);
//	}
//}