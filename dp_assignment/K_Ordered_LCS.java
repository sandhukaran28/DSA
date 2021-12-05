package dp_assignment;

import java.util.Arrays;
import java.util.Scanner;

public class K_Ordered_LCS {

	public static int sol(int[] s, int i, int n, int t[], int j, int m, int k, int[][][] dp) {

		if (i == n || j == m) {
			return 0;
		}

		if (dp[i][j][k] != -1) {
			return dp[i][j][k];
		}

		int c1 = 0;
		if (s[i] == t[j]) {

			c1 = sol(s, i + 1, n, t, j + 1, m, k, dp) + 1;
		}
		int c2 = sol(s, i + 1, n, t, j, m, k, dp);
		int c3 = sol(s, i, n, t, j + 1, m, k, dp);

		int c4 = 0;
		if (k > 0) {
			c4 = sol(s, i + 1, n, t, j + 1, m, k - 1, dp) + 1;
		}

		return dp[i][j][k] = Math.max(c1, Math.max(c2, Math.max(c3, c4)));
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int s[] = new int[n];
		int t[] = new int[m];

		for (int i = 0; i < n; i++) {
			s[i] = sc.nextInt();
		}
		for (int j = 0; j < m; j++) {

			t[j] = sc.nextInt();
		}
		int max = Math.max(n, m);
		int dp[][][] = new int[n][m][k + 1];

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < m; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		System.out.println(sol(s, 0, n, t, 0, m, k, dp));

		sc.close();

	}

}
