//https://www.geeksforgeeks.org/graph-and-its-representations/
package graph;

import java.util.LinkedList;

class GraphRepresentation {
	int vertices;
	LinkedList<Integer> list[];
	
	GraphRepresentation(int vertices){
		this.vertices = vertices;
		list = new LinkedList[vertices];
		for(int index=0; index<vertices;index++){
			list[index] = new LinkedList<Integer>();
		}
	}
	public void addEdge(int src, int dest){
		list[src].addFirst(dest);
		list[dest].addFirst(src);
	}
	public void printGraph(){
		for(int index=0; index<vertices; index++){
			for(Integer element : list[index]){
				System.out.println(element);
			}
			System.out.println("\n");
		}
	}
	public static void main(String []args){
		GraphRepresentation node = new GraphRepresentation(5);
		node.addEdge( 0, 1);
		node.addEdge( 0, 4);
		node.addEdge( 1, 2);
		node.addEdge( 1, 3);
		node.addEdge( 1, 4);
		node.addEdge( 2, 3);
		node.addEdge( 3, 4);
		node.printGraph();
	}
}
