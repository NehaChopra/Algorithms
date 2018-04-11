//http://www.geeksforgeeks.org/auto-complete-feature-using-trie/
package trie;

class TrieNode{
	boolean isEndOfWord;
	TrieNode children[] = new TrieNode[26];
	TrieNode(){
		this.isEndOfWord = false;
		for(int index=0; index<26; index++){
			this.children[index] = null;
		}
	}
}

class Trie{
	TrieNode root;
	public void insert(String key){
		TrieNode node_crawler = root;
		for(int index=0;index<key.length();index++){
			int element_index = key.charAt(index) - 'a';
			if(node_crawler.children[element_index] == null){
				node_crawler.children[element_index] = new TrieNode();
			}
			node_crawler = node_crawler.children[element_index];
		}
		node_crawler.isEndOfWord = true;
	}
	
	public boolean search(String key){
		TrieNode node_crawler = root;
		for(int index=0;index<key.length();index++){
			int element_index = key.charAt(index) - 'a';
			if(node_crawler.children[element_index] == null){
				return false;
			}
			node_crawler = node_crawler.children[element_index];
		}
		return ((node_crawler!=null) && (node_crawler.isEndOfWord));
	}
	
	public void printAutoSuggestList(String key){
		TrieNode node_crawler = root;
		for(int index=0;index<key.length();index++){
			int element_index = key.charAt(index) - 'a';
			if(node_crawler.children[element_index] != null){
				node_crawler = node_crawler.children[element_index];
			}
		}
		if(node_crawler.isEndOfWord && lastNode(node_crawler)){
			System.out.println(key);
		}else if(!lastNode(node_crawler)){
			suggestRecords(node_crawler, key);
		}
	}
	public static void suggestRecords(TrieNode root, String key){
		if(root.isEndOfWord){
			System.out.println(key);
		}
		if(lastNode(root)){
			return;
		}
		for(int index=0; index<26; index++){
			if(root.children[index] != null){
				suggestRecords(root.children[index], key + String.valueOf((char)('a' + index)));
			}
		}
	}
	public static boolean lastNode(TrieNode root){
		for(int index=0;index<26;index++){
			if(root.children[index] != null){
				return false;
			}
		}
		return true;
	}
}
class AutoComplete {
	public static void main(String []args){
		TrieNode root = new TrieNode();
		Trie obj = new Trie();
		obj.root = root;
	 	obj.insert("hello");
	 	obj.insert("dog");
	 	obj.insert("hell");
	 	obj.insert("cat");
	 	obj.insert("a");
	 	obj.insert("help");
	 	obj.insert("helps");
	 	obj.insert("helping");
	 	
	 	obj.printAutoSuggestList("h");
	 	
	 	System.out.println("==========================================================");
	 	obj.printAutoSuggestList("hel");
	}
}
