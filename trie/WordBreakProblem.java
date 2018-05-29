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

		System.out.println(wordBreak("ilikesamsung", obj));
//		wordBreak("ilikesamsung", root)? cout <<"Yes\n": cout << "No\n";
//	    wordBreak("iiiiiiii", root)? cout <<"Yes\n": cout << "No\n";
//	    wordBreak("", root)? cout <<"Yes\n": cout << "No\n";
//	    wordBreak("ilikelikeimangoiii", root)? cout <<"Yes\n": cout << "No\n";
//	    wordBreak("samsungandmango", root)? cout <<"Yes\n": cout << "No\n";
//	    wordBreak("samsungandmangok", root)? cout <<"Yes\n": cout << "No\n";
	    
	    
	}
	public static boolean wordBreak(String key, TrieTest obj) {
		boolean result = true;
		
		StringBuffer str = new StringBuffer();
		for(int index=0; index<key.length(); index++) {
			str.append(key.charAt(index));
			if(obj.search(str.toString())) {
				System.out.print(str.toString() + " ");
				str.setLength(0);
			}else {
//				str.append(key.charAt(index));
			}
		}
		
		return result;
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
		TrieNodeTest cwral = root;
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
