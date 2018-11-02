package test3;

import java.util.Scanner;

public class A {
	static int[] chuaxet = new int[10004];
	static char[][] ao = new char[102][102];
	static int[][] dinh = new int[102][102];

	static void A_x() {
		for (int i = 1; i <= 10000; i++) {
			chuaxet[i] = 1;
		}
	}

	static int R, C;

	static int xqX[] = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int xqY[] = { 1, 1, 0, -1, -1, -1, 0, 1 };

	static void DFS_RA(int r, int c) {
		for (int i = 0; i < 8; i++) {
			int X = c + xqX[i];
			int Y = r + xqY[i];
			if ((X >= 1 && X <= C) && (Y >= 1 && Y <= R) && chuaxet[dinh[Y][X]] == 1 && ao[Y][X] == 'W') {
				chuaxet[dinh[Y][X]] = 0; // Dinh da duyet
				DFS_RA(Y, X);
			}
		}
	}

	static void check() {
		int dem = 0;
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (ao[i][j] == 'W' && chuaxet[dinh[i][j]] == 1) {
					dem++;
					chuaxet[dinh[i][j]] = 0; // Dinh da duyet
					DFS_RA(i, j);
				}
			}
		}
		System.out.println(dem);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		R = in.nextInt();
		C = in.nextInt();
		in.nextLine();
		int stt = 0;
		for (int i = 1; i <= R; i++) {
			String s = in.nextLine();
			for (int j = 1; j <= C; j++) {
				ao[i][j] = s.charAt(j - 1);
				stt++;
				dinh[i][j] = stt; // khoi tao dinh
			}
		}
		A_x();
		check();
		in.close();
	}
}
