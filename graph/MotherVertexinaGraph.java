//https://www.geeksforgeeks.org/find-a-mother-vertex-in-a-graph/
package graph;

import java.util.Iterator;
import java.util.LinkedList;

class GraphDFSUTIL {
	int vert;
	LinkedList<Integer> adj[] = null;
	
	public GraphDFSUTIL(int vert){
		this.vert = vert;
		adj = new LinkedList[vert];
		for(int index=0; index< vert; index++) {
			adj[index] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int vert , int wed) {
		adj[vert].add(wed);
	}
	
	public void DFS(boolean visited[], LinkedList<Integer> queue) {
		
		while(queue.size() > 0) {
			int item = queue.poll();
			
			visited[item] = true;
			System.out.println(item);
			int nextEle;
			
			Iterator<Integer> itr = adj[item].iterator();
			
			while(itr.hasNext()) {
				if( !visited[nextEle = itr.next()] ) {
					queue.push(nextEle);
					DFS(visited, queue);
				}
			}
		}
		
	}
}

class MotherVertexinaGraph {

	public static void main(String[] args) {

	}
}
