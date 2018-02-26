////http://www.geeksforgeeks.org/avl-tree-set-1-insertion/
//
//package tree;
//
//class Node{
//	int data;
//	Node leftChild;
//	Node rightChild;
//	int height;
//	Node(int data){
//		this.data = data;
//		this.leftChild = null;
//		this.rightChild = null;
//		this.height = 1;
//	}
//}
//
//class AVLTreeInsertion {
//	Node root;
//	public static void main(String args[]){
//		AVLTreeInsertion obj = new AVLTreeInsertion();
//		obj.root = obj.createAVL(obj.root, 10);
//		obj.root = obj.createAVL(obj.root, 20);
//		obj.root = obj.createAVL(obj.root, 30);
//		obj.root = obj.createAVL(obj.root, 40);
//		obj.root = obj.createAVL(obj.root, 50);
//		obj.root = obj.createAVL(obj.root, 25);
//		
//		preOrderPrint(obj.root);
//	}
//	
//	public static Node createAVL(Node root, int data){
//		return insert(root, data);
//	}
//	
//	public static void preOrderPrint(Node root){
//		if(root!=null){
//			System.out.println(root.data);
//			preOrderPrint(root.leftChild);
//			preOrderPrint(root.rightChild);
//		}
//	}
//	
//	public static Node insert(Node root, int data){
//		if(root==null){
//			root = new Node(data);
//			return root;
//		}else{
//			if(data < root.data){
//				root.leftChild = insert(root.leftChild, data);
//			}else if(data > root.data){
//				root.rightChild = insert(root.rightChild, data);
//			}
//			
//			root.height = 1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild));
//			
//			int balanceFactor = getBalance(root);
//			
//			if((balanceFactor < -1) && (root.rightChild.data < data)){
//				///Right-RightScenario
//				return leftRotate(root);
//			}
//			if((balanceFactor < -1) && (root.rightChild.data > data)){
//				///Right-LeftScenario
//				root.rightChild = rightRotate(root.rightChild);
//				return leftRotate(root);
//			}
//			if((balanceFactor > 1) && (root.leftChild.data > data)){
//				///Left-LeftScenario
//				return rightRotate(root);
//			}
//			if((balanceFactor > 1) && (root.leftChild.data < data)){
//				///Left-RightScenario
//				root.leftChild = leftRotate(root.leftChild);
//				return rightRotate(root);
//			}
//		}
//		return root;
//	}
//	
//	public static int getHeight(Node root){
//		if(root==null){
//			return 0;
//		}
//		return root.height;
//	}
//	
//	public static int getBalance(Node root){
//		if(root==null){
//			return 0;
//		}
//		return getHeight(root.leftChild) - getHeight(root.rightChild); 
//	}
//	
//	public static Node leftRotate(Node root){
//		Node x = root.rightChild;
//		Node xLeft = x.leftChild;
//		
//		x.leftChild = root;
//		root.rightChild = xLeft;
//		
//		root.height = 1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild));;
//		x.height = 1 + Math.max(getHeight(x.leftChild), getHeight(x.rightChild));
//		
//		return x;
//	}
//	
//	public static Node rightRotate(Node root){
//		Node x = root.leftChild;
//		Node tempNode = x.rightChild;
//		
//		x.rightChild = root;
//		root.leftChild = tempNode;
//		
//		root.height = 1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild));
//		x.height = 1 + Math.max(getHeight(x.leftChild), getHeight(x.rightChild));
//		
//		return x;
//		
//	}
//}
