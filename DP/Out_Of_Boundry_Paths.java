package dp;

import java.util.Arrays;

public class Out_Of_Boundry_Paths {

	int M = 1000000007;

	public int findPaths(int m, int n, int k, int i, int j) {

		int dp[][][] = new int[m + 1][n + 1][k + 1];

		for (int id = 0; id <= m; id++) {

			for (int jd = 0; jd <= n; jd++) {

				Arrays.fill(dp[id][jd], -1);
			}
		}
		return sol(m, n, k, i, j, dp) % M;

	}

	public int sol(int m, int n, int k, int i, int j, int dp[][][]) {

		if (i < 0 || i >= m || j < 0 || j >= n) {

			return 1;
		}

		if (k == 0) {

			return 0;
		}
		if (dp[i][j][k] != -1) {

			return dp[i][j][k];
		}

		int ans = 0;
		ans = (ans + sol(m, n, k - 1, i - 1, j, dp)) % M;
		ans = (ans + sol(m, n, k - 1, i + 1, j, dp)) % M;
		ans = (ans + sol(m, n, k - 1, i, j - 1, dp)) % M;
		ans = (ans + sol(m, n, k - 1, i, j + 1, dp)) % M;

		return dp[i][j][k] = ans % M;
	}

}
