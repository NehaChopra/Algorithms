package tree;

import java.util.Scanner;

public class kLargestElements {
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int testCasesNumber = input.nextInt();
		for(int testCases = 0; testCases < testCasesNumber; testCases++){
			int arrayLength =  input.nextInt();
			int largestElementsCount = input.nextInt();
			int[] array = new int[arrayLength];
			for(int index=0; index<arrayLength; index++){
				array[index] = input.nextInt();
			}
			new kLargestElements().iterateArray(array, arrayLength, largestElementsCount);
		}
	}
	public void iterateArray(int[] array, int arrayLength, int largestElementsCount){
		AVLTree obj = new AVLTree();
		for(int index=0; index<arrayLength; index++){
			obj.root = obj.insert(obj.root, array[index]);
		}
		obj.printPostOrderTraversal(obj.root, largestElementsCount);
		obj.count = 0;
		System.out.println();
	}
}
class Node{
	int data;
	Node leftChild;
	Node rightChild;
	int height;
	Node(int data){
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
		this.height = 1;
	}
}
class AVLTree{
	Node root;
	static int count = 0;
	public static Node insert(Node root, int data){
		if(root ==null){
			root = new Node(data);
			return root;
		}else{
			if(data <= root.data){
				root.leftChild = insert(root.leftChild, data);
			}else if(data > root.data){
				root.rightChild = insert(root.rightChild, data);
			}
		}
		root.height = 1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild));
		int balanceFactor = getBalanceFactor(root);
		
		if(balanceFactor > 1 && root.leftChild.data < data){
			//Left-Right
			root.leftChild = leftRotate(root.leftChild);
			root = rightRotate(root);
		}
		
		if(balanceFactor > 1 && root.leftChild.data > data){
			//Left-Left
			root = rightRotate(root);
		}
		
		if(balanceFactor < -1 && root.rightChild.data < data){
			//Right-Right
			root = leftRotate(root);
		}
		
		if(balanceFactor < -1 && root.rightChild.data > data){
			//Right-Left
			root.rightChild = rightRotate(root.rightChild);
			root = leftRotate(root);
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
		return (getHeight(root.leftChild) - getHeight(root.rightChild));
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
	public void printPostOrderTraversal(Node root, int largestElementsCount){
		if(root == null || count > largestElementsCount){
			return;
		}
		printPostOrderTraversal(root.rightChild, largestElementsCount);
		if(count < largestElementsCount){
			System.out.print(root.data + " "); 
		}
		count++;
		printPostOrderTraversal(root.leftChild, largestElementsCount);
	}
}