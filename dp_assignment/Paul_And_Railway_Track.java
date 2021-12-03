package dp_assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Paul_And_Railway_Track {

	public static int sol(int[] x, int i, int[] y, int j, int[][] dp) {

		if (i >= x.length || j >= y.length) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		int c1 = 0;
		if (x[i] == y[j]) {
			c1 = sol(x, i + 1, y, j + 1, dp) + 1;
		}
		int c2 = sol(x, i + 1, y, j, dp);
		int c3 = sol(x, i, y, j + 1, dp);

		return dp[i][j] = Math.max(c1, Math.max(c2, c3));
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int x[] = new int[n];

		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
		}
		int y[] = new int[m];

		for (int i = 0; i < m; i++) {
			y[i] = sc.nextInt();
		}
		int dp[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(sol(x, 0, y, 0, dp));
		sc.close();

	}

}
