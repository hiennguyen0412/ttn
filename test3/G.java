package test3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class G {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
			int n = in.nextInt();
			int m = in.nextInt();
			GraphG graph = new GraphG(n+1);
			for(int i = 0; i < m; i++){
				int v1 = in.nextInt();
				int v2 = in.nextInt();
				graph.addEdge(v1, v2);
			}
			if(graph.isBipartite()){
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}

class GraphG{
	private int numberOfVertices;
	private List<Integer>[] adj;
	private int[] color;
	
	public int[] getColor(){
		return color;
	}
	
	public GraphG(int numberOfVertices){
		this.numberOfVertices = numberOfVertices;
		adj = new ArrayList[numberOfVertices];
		for(int i = 0; i < numberOfVertices; i++){
			adj[i] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge(int v1, int v2){
		adj[v1].add(v2);
		adj[v2].add(v1);
	}
	
	public boolean isBipartite(int v){
		color = new int[numberOfVertices];
		LinkedList<Integer> queue = new LinkedList<>();
		for(int i = 1; i < numberOfVertices; i++){
			color[i] = -1;
		}
		color[v] = 1;
		queue.add(v);
		while(!queue.isEmpty()){
			int vertex = queue.poll();
			for(int t : adj[vertex]){
				if(color[t] == -1){
					color[t] = 1 - color[vertex];
					queue.add(t);
				} else if(color[t] == color[vertex]){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isBipartite(){
		for(int i = 1; i < numberOfVertices; i++){
			if(!isBipartite(i)){
				return false;
			}
		}
		return true;
	}
}
