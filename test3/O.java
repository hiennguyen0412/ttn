package test3;

import java.util.ArrayList;
import java.util.Scanner;

public class O {
	private static int[] parent;
	private static int[] rank;
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
			ArrayList<double[]> list = new ArrayList<>();
			int n = in.nextInt();
			double[][] D = new double[n][n];
			parent = new int[n];
			rank = new int[n];
			for(int i = 0; i < n; i++){
				parent[i] = i;
			}
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					D[i][j] = Double.MAX_VALUE;
				}
			}
			for(int i = 0; i < n; i++){
				double x = in.nextDouble();
				double y = in.nextDouble();
				list.add(new double[]{x, y});
			}
			for(int i = 0; i < n - 1; i++){
				double[] p1 = list.get(i);
				for(int j = i + 1; j < n; j++){
					double[] p2 = list.get(j);
					double d = Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
					D[i][j] = D[j][i] = d;
				}
			}
			double answer = 0;
			int edges = n - 1;
			for(int i = 0; i < n; i++){
				int index = i;
				int a = find(i);
				for(int j = 0; j < n; j++){
					int b = find(j);
					if(a != b && D[i][index] > D[i][j]){
						index = j;
					}
				}
				if(edges != 0 && D[i][index] != Double.MAX_VALUE){
					System.out.println(i + " -> " + index + " : " +D[i][index]);
					answer += D[i][index];
					D[i][index] = D[index][i] = Double.MAX_VALUE;
					union(i, index);
					edges--;
				}
			}
			for(int i = 0; i < n; i++){
				find(i);
			}
			System.out.println(answer);
		}
		
	}
    
    public static int find(int n){
    	if(parent[n] == n){
    		return n;
    	} else {
    		parent[n] = find(parent[n]);
    		return parent[n];
    	}
    }
    
    public static void union(int a, int b){
    	a = find(a);
    	b = find(b);
    	if(a == b){
    		return;
    	}
    	if(rank[a] == rank[b]){
    		rank[a]++;
    	}
    	if(rank[a] > rank[b]){
    		parent[b] = a;
    	} else {
    		parent[a] = b;
    	}
    }
}
