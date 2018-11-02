package test3;


import java.util.Scanner;

public class L {
	private static int[] parent;
	private static int[] rank;
	private static int[] edges;
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
			int n = in.nextInt();
			int m = in.nextInt();
			parent = new int[n+1];
			rank = new int[n+1];
			edges = new int[n+1];
			int[] e = new int[n+1];
			int[] vertices = new int[n+1];
			for(int i = 1; i <= n; i++){
				parent[i] = i;
			}
			boolean check = true;
			for(int i = 0; i < m; i++){
				int x = in.nextInt();
				int y = in.nextInt();
				//Lay duoc cac canh tuy nhien se bi thieu 1 so truong hop chang han 1-3 2-4 3-4 thi parent[4] khong phai la 1 => find 1 vong nua;
				union(x, y);
			}
			//Duyet lai 1 lan nua de lay duoc tat ca cac dinh trong 1 thanh phan lien thong va tong so canh
			for(int i = 1; i <= n; i++){
				int p = find(i);
				e[p] += edges[i];
				vertices[p]++;
			}
			for(int i = 1; i <= n; i++){
				if(e[i] != 0){
					//Neu so canh trong 1 thanh phan lien thong khac tong so canh ma n dinh phai co la n*(n-1)/2 thi se khong hoan hao
					if(e[i] != (vertices[i] * (vertices[i] - 1 )/ 2)){
						check = false;
					}
				}
			}
			if(check){
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			
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
    		edges[a]++;
    		return;
    	}
    	if(rank[a] == rank[b]){
    		rank[a]++;
    	}
    	if(rank[a] > rank[b]){
    		parent[b] = a;
    		edges[a]++;
    	} else {
    		parent[a] = b;
    		edges[b]++;
    	}
    }
}
