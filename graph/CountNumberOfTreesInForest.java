//https://www.geeksforgeeks.org/count-number-trees-forest/
package graph;

import java.util.Iterator;
import java.util.LinkedList;

class GraphDFSTree {
	int vert;
	LinkedList<Integer> adj[] = null;
	
	public GraphDFSTree(int vert){
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
	
	public int countTrees() {
		boolean visited[] = new boolean[vert];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int finalTreeCount = 0;
		for(int index=0; index<vert; index++) {
			if(!visited[index]) {
				queue.push(index);
				DFS(visited, queue);
				finalTreeCount++;
			}
		}
		return finalTreeCount;
	}
}
class CountNumberOfTreesInForest {

	public static void main(String[] args) {
		GraphDFSTree obj = new GraphDFSTree(5);
		obj.addEdge(0, 1);
		obj.addEdge(0, 2);
		obj.addEdge(3, 4);
		
		System.out.println(obj.countTrees());
	}
}
