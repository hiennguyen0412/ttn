package test3;

import java.util.Scanner;

public class F {
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		while (num-- > 0) {
			int n = in.nextInt();
			boolean[] visit = new boolean[n + 1];
			int[][] arr = new int[n + 1][n + 1];

			for (int i = 0; i < n; i++) {
				visit[i] = false;
				for (int j = 0; j < n; j++) {
					arr[i][j] = 0;
				}
			}
			for (int i = 0; i < n - 1; i++) {
				int m;
				int a = in.nextInt();
				int b = in.nextInt();

				m = ++arr[a][0];
				arr[a][m] = b;

				m = ++arr[b][0];
				arr[b][m] = a;
			}
			Try(arr, 1, visit);
			if (cnt == n)
				System.out.println("YES");
			else
				System.out.println("NO");
			cnt = 0;
		}
		in.close();
	}

	public static void Try(int[][] arr, int u, boolean[] visit) {
		visit[u] = true;
		cnt++;
		for (int i = 1; i <= arr[u][0]; i++) {
			int v = arr[u][i];
			if (!visit[v])
				Try(arr, v, visit);
		}
	}
}
