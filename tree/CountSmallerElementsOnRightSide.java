//http://www.geeksforgeeks.org/count-smaller-elements-on-right-side/

package tree;
import java.util.Scanner;


class CountSmallerElementsOnRightSide {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		int testCasesNumber = input.nextInt();
		for(int testCases = 0; testCases < testCasesNumber; testCases++){
			int arrayLength =  input.nextInt();
			int[] array = new int[arrayLength];
			for(int index=0; index<arrayLength; index++){
				array[index] = input.nextInt();
			}
			new CountSmallerElementsOnRightSide().iterateArray(array, arrayLength);
		}

	}
	public void iterateArray(int[] array, int arrayLength){

		AVLTreeInsertion obj = new AVLTreeInsertion();
		
		int[] countArray = new int[arrayLength];
		for(int index=arrayLength-1; index>=0; index--){
			obj.root = obj.createAVL(obj.root, array[index], countArray, index);
		}

		//obj.preOrderPrint(obj.root);
		for(int jIndex=0; jIndex<arrayLength; jIndex++){
			System.out.print(countArray[jIndex] + " ");
		}
		System.out.println();
	}
}
class Node{
	int data;
	Node leftChild;
	Node rightChild;
	int height;
	int size;
	Node(int data){
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
		this.height = 1;
		this.size = 1;
	}
}

class AVLTreeInsertion {
	Node root;
	
	public static Node createAVL(Node root, int data, int[] count, int index){
		return insert(root, data, count, index);
	}
	
	public static void preOrderPrint(Node root){
		if(root!=null){
			System.out.println(root.data);
			preOrderPrint(root.leftChild);
			preOrderPrint(root.rightChild);
		}
	}
	
	public static Node insert(Node root, int data, int[] count, int index){
		if(root==null){
			root = new Node(data);
			return root;
		}else{
			if(data <= root.data){//to encounter duplicate elements
				root.leftChild = insert(root.leftChild, data, count, index);
			}else if(data > root.data){
				root.rightChild = insert(root.rightChild, data, count, index);
				
				count[index] = count[index] + getSize(root.leftChild) + 1;
				
			}
			
			root.height = 1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild));
			root.size = 1 + getSize(root.leftChild) + getSize(root.rightChild);
			
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
	
	public static int getSize(Node root){
		if(root==null){
			return 0;
		}
		return root.size;
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
		
		root.height = 1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild));
		x.height = 1 + Math.max(getHeight(x.leftChild), getHeight(x.rightChild));
		
		root.size = 1 + getSize(root.leftChild) + getSize(root.rightChild);
		x.size = 1 + getSize(x.leftChild) + getSize(x.rightChild);
		
		return x;
	}
	
	public static Node rightRotate(Node root){
		Node x = root.leftChild;
		Node tempNode = x.rightChild;
		
		x.rightChild = root;
		root.leftChild = tempNode;
		
		root.height = 1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild));
		x.height = 1 + Math.max(getHeight(x.leftChild), getHeight(x.rightChild));
		
		root.size = 1 + getSize(root.leftChild) + getSize(root.rightChild);
		x.size = 1 + getSize(x.leftChild) + getSize(x.rightChild);
		
		return x;
		
	}
}
