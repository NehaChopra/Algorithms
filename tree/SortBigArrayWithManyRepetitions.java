//http://www.geeksforgeeks.org/how-to-sort-a-big-array-with-many-repetitions/

package tree;

import java.util.Scanner;

class Node{
	int data;
	Node leftChild;
	Node rightChild;
	int count;
	int height;
	Node(int data){
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
		this.count = 1;
		this.height = 1;
	}
}
class AVLTree{
	Node root;
	public static Node createAVL(Node root, int data){
		return insert(root, data);
	}
	public static Node insert(Node root, int data){
		if(root ==null){
			root = new Node(data);
			return root;
		}else{
			if(data > root.data){
				root.rightChild = insert(root.rightChild, data);
			}else if(data < root.data){
				root.leftChild = insert(root.leftChild, data);
			}else if(data == root.data){
				root.count = root.count + 1;
			}
		}
		
		root.height = 1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild));
		int balanceFactor = getBalanceFactor(root);
		
		if(balanceFactor < -1 && root.rightChild.data < data){
			//Right-Right Scenario
			root = leftRotate(root);
		}
		
		if(balanceFactor < -1 && root.rightChild.data > data){
			//Right-Left Scenario
			root.rightChild = rightRotate(root.rightChild);
			root = leftRotate(root);
		}
		
		if(balanceFactor > 1 && root.leftChild.data > data){
			//Left-Left Scenario
			root = rightRotate(root);
		}
		
		if(balanceFactor > 1 && root.leftChild.data < data){
			//Left-Right Scenario
			root.leftChild = leftRotate(root.leftChild);
			root = rightRotate(root);
		}
		
		return root;
	}
	public static int getHeight(Node root){
		if(root == null){
			return 0;
		}
		return root.height;
	}
	public static int getBalanceFactor(Node root){
		if(root == null){
			return 0;
		}
		return getHeight(root.leftChild) - getHeight(root.rightChild);
	}
	public static Node leftRotate(Node root){
		Node x = root.rightChild;
		Node temp = x.leftChild;
		
		x.leftChild = root;
		root.rightChild = temp;
		
		root.height = 1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild));
		x.height = 1 + Math.max(getHeight(x.leftChild), getHeight(x.rightChild));
		
		return x;
	}
	public static Node rightRotate(Node root){
		Node x = root.leftChild;
		Node temp = x.rightChild;
		
		x.rightChild = root;
		root.leftChild = temp;
		
		root.height = 1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild));
		x.height = 1 + Math.max(getHeight(x.leftChild), getHeight(x.rightChild));
		
		return x;
	}
	public static void inorderTraversal(Node root){
		if(root != null){
			inorderTraversal(root.leftChild);
			for(int index= 0; index<root.count; index++){
				System.out.print(root.data + " ");
			}
			inorderTraversal(root.rightChild);
		}
	}
}
class SortBigArrayWithManyRepetitions {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCasesNumber = input.nextInt();
		for(int testCases = 0; testCases < testCasesNumber; testCases++){
			int arrayLength =  input.nextInt();
			int[] array = new int[arrayLength];
			for(int index=0; index<arrayLength; index++){
				array[index] = input.nextInt();
			}
			new SortBigArrayWithManyRepetitions().iterateArray(array, arrayLength);
		}
	}
	public void iterateArray(int[] array, int arrayLength){
		AVLTree obj = new AVLTree();
		for(int index =0; index < arrayLength; index++){
			obj.root = obj.createAVL(obj.root, array[index]);
		}
		obj.inorderTraversal(obj.root);
	}
}
