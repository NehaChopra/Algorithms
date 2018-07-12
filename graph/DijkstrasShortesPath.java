//https://practice.geeksforgeeks.org/problems/shortest-path-from-1-to-n/0
package graph;

class DijkstrasShortesPath {

	public static void main(String[] args) {
		int matrix[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
         {4, 0, 8, 0, 0, 0, 0, 11, 0},
         {0, 8, 0, 7, 0, 4, 0, 0, 2},
         {0, 0, 7, 0, 9, 14, 0, 0, 0},
         {0, 0, 0, 9, 0, 10, 0, 0, 0},
         {0, 0, 4, 14, 10, 0, 2, 0, 0},
         {0, 0, 0, 0, 0, 2, 0, 1, 6},
         {8, 11, 0, 0, 0, 0, 1, 0, 7},
         {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        
        dijiktraAlgo(matrix, 0, matrix.length);
	}
	
	public static void dijiktraAlgo(int [][]matrix, int src, int size) {
		int []dist = new int[size];
		boolean []visitedSet = new boolean[size];
		
		for(int index=0; index<size; index++) {
			dist[index] = Integer.MAX_VALUE;
			visitedSet[index] = Boolean.FALSE;
		}
		
		dist[0] = 0;
		
		for(int iterate=0; iterate<size; iterate++) {
			int shortDistIndex = findMin(dist, visitedSet);
			visitedSet[shortDistIndex] = true;
			
			for(int var=0; var<size; var++) {
				if(!visitedSet[var] 
						&& 
						matrix[shortDistIndex][var] !=0 
						&&
						dist[shortDistIndex] + matrix[shortDistIndex][var] < dist[var] 
						) {
					 dist[var] = dist[shortDistIndex] + matrix[shortDistIndex][var];
				}
			}
		}
		printDistances(dist);
	}
	
	public static int findMin(int []dist, boolean []visitedSet) {
		int minValue = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int index=0; index<dist.length; index++) {
			if(visitedSet[index] == false && dist[index] < minValue) {
				minValue = dist[index];
				minIndex = index;
			}
		}
		return minIndex;
	}
	
	public static void printDistances(int []dist) {
		for(int index=0; index<dist.length; index++) {
			System.out.println(index + "----------" + dist[index]);
		}
	}
}
