//https://www.geeksforgeeks.org/find-duplicate-rows-binary-matrix/
package trie;

public class DuplicateBinaryMatrix {

	public static void main(String[] args) {
		int matrix[][] = 
			{
				{1, 1, 0, 1, 0, 1},
			    {0, 0, 1, 0, 0, 1},
			    {1, 0, 1, 1, 0, 0},
			    {1, 1, 0, 1, 0, 1},
			    {0, 0, 1, 0, 0, 1},
			    {0, 0, 1, 0, 0, 1}
			};
		
		TrieB obj = new TrieB();
		TrieNodeB node= new TrieNodeB();
		obj.root = node;
		for(int index=0; index<matrix.length; index++) {
			findAndInsert(matrix[index], obj, node, index);
		}
	}
	public static void findAndInsert(int array[], TrieB obj, TrieNodeB node, int index) {
		boolean duplicate =  obj.search(array);
		if(!duplicate) {
			obj.insert(array);
		}else {
			System.out.println("There is a duplicate row at position:" +( index + 1 ));
		}
	}
}
class TrieNodeB{
	TrieNodeB children[] = new TrieNodeB[2];
	boolean endOfWord;
	TrieNodeB(){
		for(int index=0; index<children.length; index++){
			this.children[index] = null;
		}
		this.endOfWord = false;
	}
}

class TrieB{
	TrieNodeB root;
	public void insert(int key[]){
		TrieNodeB cwral = root;
		for(int index=0; index<key.length;index++){
			int elementIndex = key[index] - 0;
			if(cwral.children[elementIndex] == null){
				cwral.children[elementIndex] = new TrieNodeB();
			}
			cwral = cwral.children[elementIndex];
		}
		cwral.endOfWord = true;
	}
	public boolean search(int key[]){
		TrieNodeB cwral = root;
		for(int index=0; index<key.length;index++){
			int elementIndex = key[index] - 0;
			if(cwral.children[elementIndex] == null){
				return false;
			}
			cwral = cwral.children[elementIndex];
		}
		return (cwral!=null && cwral.endOfWord);
	}
}