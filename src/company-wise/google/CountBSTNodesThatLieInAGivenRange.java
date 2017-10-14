//http://www.geeksforgeeks.org/count-bst-nodes-that-are-in-a-given-range/
package google;

import java.util.Scanner;

class Node{
	int data;
	Node leftChild;
	Node rightChild;
	int size;
	int height;
	Node(int data){
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
		this.size = 1;
		this.height = 1;
	}
}
class AVL{
	Node root;
	public static Node insert(Node root, int data){
		if(root == null){
			root = new Node(data);
			return root;
		}else {
			if(root.data < data){
				root.rightChild = insert(root.rightChild, data);
			}else if(root.data >= data){
				root.leftChild = insert(root.leftChild, data);
			}
			root.height = 1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild));
			root.size = 1 + getSize(root.leftChild) + getSize(root.rightChild);
			int balanceFactor = getBalanceFactor(root);
			
			if(balanceFactor > 1 && root.leftChild.data > data){//left-left scenario
				return rotateRight(root);
			}
			if(balanceFactor > 1 && root.leftChild.data < data){//left-right scenario
				root.leftChild = rotateLeft(root.leftChild);
				return rotateRight(root);
			}
			if(balanceFactor < -1 && root.rightChild.data < data){//right-right scenario
				return rotateLeft(root);
			}
			if(balanceFactor < -1 && root.rightChild.data > data){//right-left scenario
				root.rightChild = rotateRight(root.rightChild);
				return rotateLeft(root);
			}
		}	
		return root;
	}
	public static void preOrderPrint(Node root){
		if(root!=null){
			preOrderPrint(root.leftChild);
			System.out.println(root.data + " " + root.size);
			preOrderPrint(root.rightChild);
		}
	}
	public static int getHeight(Node root){
		if(root == null){
			return 0;
		}
		return root.height;
	}
	public static int getSize(Node root){
		if(root == null){
			return 0;
		}
		return root.size;
	}
	public static int getBalanceFactor(Node root){ 
		if(root == null){
			return 0;
		}
		return (getHeight(root.leftChild) - getHeight(root.rightChild));
	}
	public static Node rotateRight(Node root){
		Node x = root.leftChild;
		Node y = x.rightChild;
		
		root.leftChild = y;
		x.rightChild = root;
		
		root.height = 1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild));
		x.height = 1 + Math.max(getHeight(x.leftChild), getHeight(x.rightChild));
		
		root.size = 1 + getSize(root.leftChild) + getSize(root.rightChild);
		x.size = 1 + getSize(x.leftChild) + getSize(x.rightChild);

		return x;
		
	}
	public static Node rotateLeft(Node root){
		Node x = root.rightChild;
		Node y = x.leftChild;
		
		root.rightChild = y;
		x.leftChild = root;
		
		root.height = 1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild));
		x.height = 1 + Math.max(getHeight(x.leftChild), getHeight(x.rightChild));
		
		root.size = 1 + getSize(root.leftChild) + getSize(root.rightChild);
		x.size = 1 + getSize(x.leftChild) + getSize(x.rightChild);

		return x;
	}
	public static int getCountOfNode(Node root, int startRange, int endRange){
		if(root == null){
			return 0;
		}

		return (root.data >= startRange && root.data <=  endRange) ? 1 + getCountOfNode(root.leftChild, startRange, endRange) + getCountOfNode(root.rightChild, startRange, endRange) : getCountOfNode(root.leftChild, startRange, endRange) + getCountOfNode(root.rightChild, startRange, endRange);
		
	}
}

class CountBSTNodesThatLieInAGivenRange {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		int testCasesNumber = input.nextInt();
		for(int testCases = 0; testCases < testCasesNumber; testCases++){
			int arrayLength =  input.nextInt();
			AVL obj = new AVL();
			int array[] = new int[arrayLength];
			for(int index=0; index<arrayLength; index++){
				obj.root = obj.insert(obj.root, input.nextInt());
				array[index] = input.nextInt();
			}
			int startRange = input.nextInt();
			int endRange = input.nextInt();
			//obj.preOrderPrint(obj.root);
			System.out.println(obj.getCountOfNode(obj.root, startRange, endRange));
		}
	}
}