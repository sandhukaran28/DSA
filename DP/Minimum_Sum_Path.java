package DP;

import java.util.Arrays;

public class Minimum_Sum_Path {

	public int minPathSum(int[][] grid) {

		int cache[][] = new int[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {

			Arrays.fill(cache[i], -1);
		}
		return min(grid, grid.length - 1, grid[0].length - 1, cache);
	}

	public int min(int[][] arr, int m, int n, int[][] cache) {

		if (m < 0 || n < 0) {

			return Integer.MAX_VALUE;
		}

		if (m == 0 && n == 0) {

			return arr[m][n];
		}
		if (cache[m][n] != -1) {
			return cache[m][n];
		}

		int c1 = min(arr, m - 1, n, cache);
		int c2 = min(arr, m, n - 1, cache);

		return cache[m][n] = Math.min(c1, c2) + arr[m][n];

	}
}
