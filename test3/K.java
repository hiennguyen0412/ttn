package test3;

import java.util.Arrays;
import java.util.Scanner;

public class K {
	private static int[] parent;
	private static int[] rank;
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
			int n = in.nextInt();
			int m = in.nextInt();
			parent = new int[n+1];
			rank = new int[n+1];
			for(int i = 1; i <= n; i++){
				parent[i] = i;
			}
			for(int i = 0; i < m; i++){
				int a = in.nextInt();
				int b = in.nextInt();
				union(a, b);
			}
			for(int i = 1; i <= n; i++){
				find(i);
			}
			Arrays.sort(parent);
			int count = 1;
			int max = 0;
			for(int i = 1; i <= n-1; i++){
				if(parent[i] == parent[i+1]){
					count++;
				} else {
					count = 1;
				}
				if(count > max){
					max = count;
				}
			}
			System.out.println(max);
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
