package test3;

import java.util.Scanner;

public class H {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
			int n = in.nextInt();
			int m = in.nextInt();
			int[][] a = new int[n+2][m+2];
			for(int i = 1; i <= n; i++){
				for(int j = 1; j <= m; j++){
					a[i][j] = in.nextInt();
				}
			}
			Map map = new Map(n+2, m+2, a);
			map.findIsland();
			System.out.println(map.getTotalIsland());
		}
	}
}

class Map{
	private int rows;
	private int cols;
	private int[][] matrix;
	private boolean[][] visited;
	private int totalIsland;
	private int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
	private int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public Map(int rows, int cols, int[][] matrix){
		this.rows = rows;
		this.cols = cols;
		this.matrix = matrix;
		visited = new boolean[rows][cols];
	}
	
	public void findIsland(){
		for(int i = 0; i < rows; i++){
			for(int j = 0;  j < cols; j++){
				if(!visited[i][j] && matrix[i][j] == 1){
					dfs(i, j, visited);
					totalIsland++;
				}
			}
		}
	}
	
	public void dfs(int i, int j, boolean[][] visited){
		visited[i][j] = true;
		for(int k = 0; k < 8; k++){
			if(matrix[i+y[k]][j+x[k]] == 1 && !visited[i+y[k]][j+x[k]]){
				visited[i+y[k]][j+x[k]] = true;
				dfs(i+y[k], j+x[k], visited);
			}
		}
	}
	
	public int getTotalIsland(){
		return totalIsland;
	}
}

