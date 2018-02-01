//https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1
package paytm;

import java.util.LinkedList;
import java.util.Queue;

class Node{
	int data;
	Node leftChild;
	Node rightChild;
	Node(int data){
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
}
class PrintRightViewOfABinaryTree {
	public static void main(String []args){
		 	Node root = new Node(10);
	        root.leftChild = new Node(2);
	        root.rightChild = new Node(3);
	        root.leftChild.leftChild = new Node(7);
	        root.leftChild.rightChild = new Node(8);
	        root.rightChild.rightChild = new Node(15);
	        root.rightChild.leftChild = new Node(12);
	        root.rightChild.rightChild.leftChild = new Node(14);
	        rightViewOfBT(root);
	}
	public static void rightViewOfBT(Node root){
		if(root ==null){
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int index=0; index<size; index++){
				Node data = queue.poll();
				if(index==(size-1)){
					System.out.print(data.data+" ");
				}
				if(data.leftChild != null){
					queue.add(data.leftChild);
				}
				if(data.rightChild != null){
					queue.add(data.rightChild);
				}
			}
		}
	}
}
