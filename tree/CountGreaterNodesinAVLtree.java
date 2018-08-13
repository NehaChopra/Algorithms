//https://www.geeksforgeeks.org/count-greater-nodes-in-avl-tree/
package tree;

class NodeAVL{
	int data;
	NodeAVL leftChild;
	NodeAVL rightChild;
	int height;
	int size;
	NodeAVL(int data){
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
		this.height = 1;
		this.size = 0;
	}
}

class AVLGreater{
	NodeAVL root;
	public static NodeAVL insert(NodeAVL root, int data){
		if(root == null){
			NodeAVL node = new NodeAVL(data);
			return node;
		}else{
			if(root.data > data){
				root.leftChild = insert(root.leftChild, data);
			}else if(root.data < data){
				root.rightChild = insert(root.rightChild, data);
			}else{
				return root;
			}
			
			root.height = 1 + Math.max(getHeight(root.rightChild), getHeight(root.leftChild));
			root.size = 1 + getSize(root.rightChild) + getSize(root.leftChild);
			int balanceFactor = getHeight(root.leftChild) - getHeight(root.rightChild);
			
			if(balanceFactor > 1 && root.leftChild.data > data){
				//Left-Left Scenario
				return rotateRight(root);
			}
			if(balanceFactor > 1 && root.leftChild.data < data){
				//Left-right Scenario
				root.leftChild = rotateLeft(root.leftChild);
				return rotateRight(root);
			}
			if(balanceFactor < -1 && root.rightChild.data > data){
				//right- left Scenario
				root.rightChild = rotateRight(root.rightChild);
				return rotateLeft(root);
			}
			if(balanceFactor < -1 && root.rightChild.data < data){
				//right- right Scenario
				return rotateLeft(root);
			}
			
		}
		return root;
	}
	public static int getHeight(NodeAVL root){
		if(root==null){
			return 0;
		}
		return root.height;
	}
	public static int getSize(NodeAVL root){
		if(root==null){
			return 0;
		}
		return root.size;
	}
	public static NodeAVL rotateLeft(NodeAVL root){
		NodeAVL x = root.rightChild;
		NodeAVL y = x.leftChild;
		
		root.rightChild = y;
		x.leftChild = root;
		
		root.height = 1 + Math.max(getHeight(root.rightChild), getHeight(root.leftChild));
		x.height = 1 + Math.max(getHeight(root.rightChild), getHeight(root.leftChild));
		
		return x;
		
	}
	public static NodeAVL rotateRight(NodeAVL root){
		NodeAVL x = root.leftChild;
		NodeAVL y = x.rightChild;
		
		root.leftChild = y;
		x.rightChild = root;
		
		root.height = 1 + Math.max(getHeight(root.rightChild), getHeight(root.leftChild));
		x.height = 1 + Math.max(getHeight(root.rightChild), getHeight(root.leftChild));
		
			
		return x;
	}
}
class CountGreaterNodesinAVLtree {
	public static void main(String args[]){
		AVLGreater obj = new AVLGreater();
		obj.root = obj.insert(obj.root, 9);
		obj.root = obj.insert(obj.root, 5);
		obj.root = obj.insert(obj.root, 10);
		obj.root = obj.insert(obj.root, 0);
		obj.root = obj.insert(obj.root, 6);
		obj.root = obj.insert(obj.root, 11);
		obj.root = obj.insert(obj.root, -1);
		obj.root = obj.insert(obj.root, 1);
		obj.root = obj.insert(obj.root, 2);
		
		preOrderPrint(obj.root);
	}
	public static void preOrderPrint(NodeAVL root){
		if(root!=null){
			preOrderPrint(root.leftChild);
			System.out.println(root.data + "............. "+root.height);
			preOrderPrint(root.rightChild);
		}
	}
//	public static int findLargestTheNode(int data, NodeAVL root, int count){
//		
//	}
//	public static int countLargerElements(NodeAVL root, int key){
//	}
}
