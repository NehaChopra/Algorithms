//https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
package graph;

import java.util.Iterator;
import java.util.LinkedList;

class GraphDFS {
	int vert;
	LinkedList<Integer> adj[] = null;
	
	public GraphDFS(int vert){
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
	
	public int findMotherIndex() {
		boolean visited[] = new boolean[vert];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		int lastIndex =0 ;
		for(int index=0; index<vert; index++) {
			if(!visited[index]) {
				queue.push(index);
				DFS(visited, queue);
				lastIndex = index;
			}
		}
		
		boolean visited1[] = new boolean[vert];
		queue.push(lastIndex);
		DFS(visited1, queue);
		
		for(int index=0; index<vert; index++) {
			if(!visited1[index]) {
				lastIndex = -1;
			}
		}
		return lastIndex;
	}
}
class DepthFirstSearch {
	public static void main(String args[]) {
		
		GraphDFS obj = new GraphDFS(7);
		obj.addEdge(0, 1);
		obj.addEdge(0, 2);
		obj.addEdge(1, 3);
		obj.addEdge(4, 1);
		obj.addEdge(6, 4);
		obj.addEdge(5, 6);
		obj.addEdge(5, 2);
		obj.addEdge(6, 0);
		
		System.out.println(obj.findMotherIndex());
	}
}


