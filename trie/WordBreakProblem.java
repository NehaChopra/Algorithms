//https://www.geeksforgeeks.org/word-break-problem-trie-solution/
package trie;

class WordBreakProblem {
	public static void main(String []args){
		String dictionary[] = {"mobile","samsung","sam",
            "sung","man","mango",
            "icecream","and","go","i",
            "like","ice","cream"};
		
		TrieNodeTest root = new TrieNodeTest();
		TrieTest obj = new TrieTest();
		obj.root = root;
		
		for(int index=0; index<dictionary.length; index++) {
			obj.insert(dictionary[index]);
		}
	    
//		String input = "ilike";
//		String input = "ilikesamsung";
//		String input = "samsungandmango";
		String input = "samsungandmangok";
		System.out.println(obj.search(input));
	}
}

class TrieNodeTest{
	TrieNodeTest children[] = new TrieNodeTest[26];
	boolean endOfWord;
	TrieNodeTest(){
		for(int index=0; index<children.length; index++){
			this.children[index] = null;
		}
		this.endOfWord = false;
	}
}

class TrieTest{
	TrieNodeTest root;
	public void insert(String key){
		TrieNodeTest cwral = root;
		for(int index=0; index<key.length();index++){
			int elementIndex = key.charAt(index) - 'a';
			if(cwral.children[elementIndex] == null){
				cwral.children[elementIndex] = new TrieNodeTest();
			}
			cwral = cwral.children[elementIndex];
		}
		cwral.endOfWord = true;
	}
	public boolean search(String key){
		if(key.equals("")) {
			return true;
		}
		TrieNodeTest cwral = root;
		for(int index=0; index<key.length();index++){
			int elementIndex = key.charAt(index) - 'a';
			if(cwral.children[elementIndex] == null){
				return false;
			}
			cwral = cwral.children[elementIndex];
			if(cwral!=null && cwral.endOfWord) {
				return search(key.substring(index+1, key.length()));
			}
		}
		return (cwral!=null && cwral.endOfWord);
	}
}
