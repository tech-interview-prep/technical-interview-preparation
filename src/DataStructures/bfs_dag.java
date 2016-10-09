import java.util.*;
import java.io.*;


public class bfs_dag {
	
	private int V;
	private LinkedList<Integer> adj[];

	bfs_dag(int v){
		V = v;
		adj = new LinkedList[v];
		for(int i = 0; i < v; i++){
			adj[i] = new LinkedList();
		}
	}

	void addEdge(int v, int w){
		adj[v].add(w);
	}

	void BFS(int startVertex){
		boolean visited[] = new boolean[V];
		LinkedList<Integer>queue = new LinkedList<Integer>();

		visited[startVertex] = true;
		queue.add(startVertex);

		while(!queue.isEmpty()){
			startVertex = queue.poll();
			Iterator<Integer>i = adj[s].listIterator();
			while(i.hasNext()){
				int n = i.next();
				if(!visited[n]){
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}




}