//https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
package graph;

import java.util.Iterator;
import java.util.LinkedList;

class Graph {
	int vert;
	LinkedList<Integer> adj[] = null;
	
	public Graph(int vert){
		this.vert = vert;
		adj = new LinkedList[vert];
		for(int index=0; index< vert; index++) {
			adj[index] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int vert , int wed) {
		adj[vert].add(wed);
	}
	
	public void BFS(int ele) {
		boolean visited[] = new boolean[vert];
		visited[ele] = true;
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.push(ele);
		
		int nextEle;
		
		while(queue.size() > 0) {
			int item = queue.poll();
			System.out.println(item);
			
			Iterator<Integer> itr = adj[item].iterator();
			
			while(itr.hasNext()) {
				if( !visited[nextEle = itr.next()] ) {
					visited[nextEle] = true;
					queue.push(nextEle);
				}
			}
		}
		
	}
}
class BreadthFirstSearch {
	public static void main(String args[]) {
		
		Graph obj = new Graph(4);
		obj.addEdge(0, 1);
		obj.addEdge(0, 2);
		obj.addEdge(1, 2);
		obj.addEdge(2, 0);
		obj.addEdge(2, 3);
		obj.addEdge(3, 3);
		
		obj.BFS(2);
	}
}


