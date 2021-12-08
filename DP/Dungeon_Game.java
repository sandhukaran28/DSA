package dp;

import java.util.Arrays;

public class Dungeon_Game {

	public int calculateMinimumHP(int[][] arr) {

		int n = arr.length;
		int dp[][] = new int[n + 1][arr[arr.length - 1].length];

		for (int i = 0; i < n; i++) {

			Arrays.fill(dp[i], -1);
		}
		return dungeon(arr, 0, 0, n, arr[arr.length - 1].length, dp);

	}

	public int dungeon(int[][] arr, int i, int j, int m, int n, int[][] dp) {

		if (i == m - 1 && j == n - 1) {

			return arr[i][j] >= 0 ? 1 : Math.abs(arr[i][j]) + 1;
		}
		if (i >= m || j >= n) {

			return Integer.MAX_VALUE;
		}

		if (dp[i][j] != -1) {

			return dp[i][j];

		}

		int c1 = dungeon(arr, i + 1, j, m, n, dp);
		int c2 = dungeon(arr, i, j + 1, m, n, dp);

		int res = Math.min(c1, c2) - arr[i][j];

		dp[i][j] = res > 0 ? res : 1;
		return dp[i][j];
	}

}
