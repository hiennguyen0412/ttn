package test3;

import java.util.LinkedList;
import java.util.Scanner;

public class I {
	private static int[] x = {-2, -1, 1, 2, 2, 1, -1, -2};
	private static int[] y = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		while(t-->0){
			String[] s = in.nextLine().split(" ");
			int[][] a = new int[9][9];
			int col1 = getNumber(s[0].charAt(0));
			int row1 = Integer.parseInt(String.valueOf(s[0].charAt(1)));
			int col2 = getNumber(s[1].charAt(0));
			int row2 = Integer.parseInt(String.valueOf(s[1].charAt(1)));
			bfs(a, 9-row1, col1, 9-row2, col2);
			System.out.println(a[9-row2][col2] - 1);
		}
	}
    
    public static void bfs(int[][] a, int r, int c, int r2, int c2){
    	LinkedList<int[]> queue = new LinkedList<>();
    	a[r][c] = 1;
    	int[] t = new int[2];
    	t[0] = r;
    	t[1] = c;
    	queue.add(t);
    	while(!queue.isEmpty()){
    		t = queue.poll();
    		for(int i = 0; i < 8; i++){
    			int row = t[0] + y[i];
    			int col = t[1] + x[i];
    			if(row > 0 && row < 9 && col > 0 && col < 9){
    				if(a[row][col] == 0){
    					a[row][col] = a[t[0]][t[1]] + 1;
    					if(row == r2 && col == c2){
    						return;
    					}
    					queue.add(new int[]{row,col});
    				}
    			}
    		}
    	}
    }
    
    public static int getNumber(char c){
    	return (int)c - 96;
    }
}
