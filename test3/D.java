package test3;

import java.util.LinkedList;
import java.util.Scanner;

public class D {
	private static String[] s;
	private static int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
	private static int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};
	private static int index;
	private static boolean[][] visited;
	private static LinkedList<int[]> list;
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = Integer.parseInt(in.nextLine());
		s = new String[m];
		for(int i = 0; i < m; i++){
			s[i] = in.nextLine();
		}
		while(true){
			int n = Integer.parseInt(in.nextLine());
			if(n == 0){
				break;
			}
			char[][] c = new char[n][n];
			for(int i = 0; i < n; i++){
				c[i] = in.nextLine().toCharArray();
			}
			visited = new boolean[n][n];
			int k = 0;
			while(k < m){
				index = 0;
				list = new LinkedList<>();
				boolean check = false;
				for(int i = 0; i < n; i++){
					for(int j = 0; j < n; j++){
						if(c[i][j] == s[k].charAt(0)){
							index++;
							dfs(c, i, j, k);
							if(list.size() == m){
								index = 0;
								k++;
								list.forEach(p -> {
									System.out.print(c[p[0]][p[1]]);
								});
								list = new LinkedList<>();
							}
						}
					}
				}
			}
		}
	}
    
    public static void dfs(char[][] c, int row, int col, int k){
    	list.add(new int[]{row, col});
    	visited[row][col] = true;
        for(int i = 0; i < 8; i++){
        	int rs = row + y[i];
        	int cs = col + x[i];
        	if(rs >= 0 &&  cs>= 0 && rs < c.length && cs < c.length){
        		if(c[rs][cs] == s[k].charAt(index) && !visited[rs][cs]){
        			for(int ro = 0; ro < c.length; ro++){
        				for(int co = 0; co < c.length; co++){
        					if((ro == rs && co == cs) || (ro == row && co == col)){
        						System.out.print(String.valueOf(c[ro][co]).toUpperCase());
        					} else {
        						System.out.print(c[ro][co]);
        					}
        				}
        				System.out.println();
        			}
        			System.out.println("---");
        			index++;
        			list.add(new int[]{rs, cs});
        			visited[rs][cs] = true;
        			dfs(c, rs, cs, k);
        		}
        	}
        }
    }
}

