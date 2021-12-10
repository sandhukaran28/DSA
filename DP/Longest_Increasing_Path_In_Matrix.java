package dp;

import java.util.Arrays;

public class Longest_Increasing_Path_In_Matrix {

	public int longestIncreasingPath(int[][] matrix) {

		int n = matrix.length;
		int m = matrix[0].length;
		int dp[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		int max = 0;
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < m; j++) {

				max = Math.max(max, sol(matrix, i, j, n, m, -1, dp));
			}
		}

		return max;

	}

	public int sol(int[][] arr, int i, int j, int n, int m, int parent, int[][] dp) {

		if (i < 0 || j < 0 || i >= n || j >= m || (arr[i][j] <= parent && parent != -1)) {
			return 0;
		}

		if (dp[i][j] != -1) {

			return dp[i][j];
		}

		int c1 = sol(arr, i + 1, j, n, m, arr[i][j], dp); // down
		int c2 = sol(arr, i - 1, j, n, m, arr[i][j], dp); // up
		int c3 = sol(arr, i, j + 1, n, m, arr[i][j], dp); // Right
		int c4 = sol(arr, i, j - 1, n, m, arr[i][j], dp); // left
		return dp[i][j] = Math.max(c1, Math.max(c2, Math.max(c3, c4))) + 1;
	}

}
