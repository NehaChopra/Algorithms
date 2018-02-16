//https://www.geeksforgeeks.org/count-pairs-from-two-bsts-whose-sum-is-equal-to-a-given-value-x/
package Array;

import java.util.Scanner;

class CountPairsFromTwoBSTs {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		
		for(int test=0; test<testCases; test++){
			int array1Length = input.nextInt();
			int finalArray1[] = new int[array1Length];
			AVLTreeInsertion obj1 = new AVLTreeInsertion();
			for(int index=0; index<array1Length; index++){
				obj1.root = obj1.createAVL(obj1.root, input.nextInt());
			}
			
			int array2Length = input.nextInt();
			int finalArray2[] = new int[array2Length];
			AVLTreeInsertion obj2 = new AVLTreeInsertion();
			for(int index=0; index<array1Length; index++){
				obj2.root = obj2.createAVL(obj2.root, input.nextInt());
			}
			
			int number = input.nextInt();
			
			AVLTreeInsertion.inorderOrderPrint(obj1.root, finalArray1, 0);
			for(int index=0; index<finalArray1.length; index++){
				System.out.print(finalArray1[index] +" ");
			}
			System.out.println();
			AVLTreeInsertion.inorderOrderPrint(obj2.root, finalArray2, 0);
			for(int index=0; index<finalArray2.length; index++){
				System.out.print(finalArray2[index] +" ");
			}
			System.out.println();
		}
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

class AVLTreeInsertion {
	Node root;
	
	public static Node createAVL(Node root, int data){
		return insert(root, data);
	}
	
	public static void preOrderPrint(Node root){
		if(root!=null){
			System.out.println(root.data);
			preOrderPrint(root.leftChild);
			preOrderPrint(root.rightChild);
		}
	}
	
	public static void inorderOrderPrint(Node root, int finalArray[], int index){
		if(root!=null){
			inorderOrderPrint(root.leftChild, finalArray, index + 1);
			finalArray[index++] = root.data;
			inorderOrderPrint(root.rightChild, finalArray, index + 1);
		}
	}
	
	public static Node insert(Node root, int data){
		if(root==null){
			root = new Node(data);
			return root;
		}else{
			if(data < root.data){
				root.leftChild = insert(root.leftChild, data);
			}else if(data > root.data){
				root.rightChild = insert(root.rightChild, data);
			}
			
			root.height = 1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild));
			
			int balanceFactor = getBalance(root);
			
			if((balanceFactor < -1) && (root.rightChild.data < data)){
				///Right-RightScenario
				return leftRotate(root);
			}
			if((balanceFactor < -1) && (root.rightChild.data > data)){
				///Right-LeftScenario
				root.rightChild = rightRotate(root.rightChild);
				return leftRotate(root);
			}
			if((balanceFactor > 1) && (root.leftChild.data > data)){
				///Left-LeftScenario
				return rightRotate(root);
			}
			if((balanceFactor > 1) && (root.leftChild.data < data)){
				///Left-RightScenario
				root.leftChild = leftRotate(root.leftChild);
				return rightRotate(root);
			}
		}
		return root;
	}
	
	public static int getHeight(Node root){
		if(root==null){
			return 0;
		}
		return root.height;
	}
	
	public static int getBalance(Node root){
		if(root==null){
			return 0;
		}
		return getHeight(root.leftChild) - getHeight(root.rightChild); 
	}
	
	public static Node leftRotate(Node root){
		Node x = root.rightChild;
		Node xLeft = x.leftChild;
		
		x.leftChild = root;
		root.rightChild = xLeft;
		
		root.height = 1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild));;
		x.height = 1 + Math.max(getHeight(x.leftChild), getHeight(x.rightChild));
		
		return x;
	}
	
	public static Node rightRotate(Node root){
		Node x = root.leftChild;
		Node tempNode = x.rightChild;
		
		x.rightChild = root;
		root.leftChild = tempNode;
		
		root.height = 1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild));
		x.height = 1 + Math.max(getHeight(x.leftChild), getHeight(x.rightChild));
		
		return x;
		
	}
}