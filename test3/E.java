package test3;

import java.util.Scanner;

public class E {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();           // n đỉnh
            int m = in.nextInt();           // m cạnh
            
            // tạo ma trận các đỉnh
            int[][] a  = new int[1001][1001];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    a[i][j] = 0;
                }
            }
            
            // tạo cạnh nối giữa các đỉnh
            for (int i = 1; i <= m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();

                a[u][v] = 1;
                a[v][u] = 1;
            }

            int q = in.nextInt();
            while (q-- > 0) {
                int x = in.nextInt();
                int y = in.nextInt();

                // lưu trạng thái đỉnh
                int[] N = new int[1001];
                for (int i = 1; i <= n; i++) {
                    N[i] = 1;
                }
                
                // duyệt từng đỉnh thông qua các cạnh
                DFS(x, n, N, a);
                if (N[y] == 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static void DFS(int x, int n, int[] N, int[][] a) {
        N[x] = 0;
        for (int i = 1; i <= n; i++) {
            if (a[x][i] == 1 && N[i] == 1) {
                DFS(i, n, N, a);
            }
        }
    }
}
