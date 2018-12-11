package graph;

import java.awt.List;
import java.util.LinkedList;

public class Graph {

	int vertex;
	LinkedList<Integer> adjList[];
	
	public Graph(int V) {
		vertex=V;
		adjList=new LinkedList[V];
			
		for (int i = 0; i < V; i++) {
			adjList[i]= new LinkedList<Integer>();
		}
	
	}
	
	public void addDirectEdge(int x, int y) {
		adjList[x].add(y);
		//adjList[y].add(x);
	}
	
	public void addExtravertedEdge(int x, int y) {
		adjList[x].add(y);
		adjList[y].add(x);
	}
	
	public boolean dfs(int source, int dest) {
		boolean visited[] = new boolean[vertex];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int path[] = new int[vertex];
		int counter=0;
		visited[source]=true;
		queue.add(source);
		
		while(!queue.isEmpty()) {
			source=queue.pop();
			path[counter]=source;
			counter++;
			
			if(source==dest) {
				System.out.println("there is a path");
				for (int i = 0; i < path.length; i++) {
					System.out.println(path[i]);
				}
				return true;
			}
		
			for (Integer x : adjList[source]) {
				if(visited[x]!=true) {
					queue.add(x);
					visited[x]=true;
				}
			}
		}
		System.out.println("No path");
		return true;
	}
	
	public void printGraph() {
		int counter=0;
		for (LinkedList<Integer> linkedList : adjList) {	
			System.out.println("Vertex " + counter+ "-> "+ linkedList);
			counter++;
		}
	}
}
