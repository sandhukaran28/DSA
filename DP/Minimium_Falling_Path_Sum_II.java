package DP;

import java.util.Arrays;

public class Minimium_Falling_Path_Sum_II {

	public int minFallingPathSum(int[][] matrix) {

		int min = Integer.MAX_VALUE;
		int n = matrix.length;
		int cache[][] = new int[n][n];

		for (int i = 0; i < n; i++) {

			Arrays.fill(cache[i], -1);
		}
		for (int i = 0; i < n; i++) {

			int curr = sol(matrix, 0, i, cache);
			min = Math.min(curr, min);
		}

		return min;
	}

	public int sol(int[][] arr, int r, int c, int[][] cache) {

		if (r == arr.length - 1) {
			return arr[r][c];
		}

		if (cache[r][c] != -1) {
			return cache[r][c];
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (i != c) {

				int curr = sol(arr, r + 1, i, cache);
				min = Math.min(curr, min);
			}
		}

		return cache[r][c] = min + arr[r][c];

	}
}
