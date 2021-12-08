package dp;

import java.util.Arrays;

public class Minimun_Falling_Path_Sum {

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

		if (c < 0 || c >= arr.length) {

			return Integer.MAX_VALUE;
		}

		if (r == arr.length - 1) {
			return arr[r][c];
		}

		if (cache[r][c] != -1) {
			return cache[r][c];
		}

		int c1 = sol(arr, r + 1, c - 1, cache);
		int c2 = sol(arr, r + 1, c, cache);
		int c3 = sol(arr, r + 1, c + 1, cache);

		return cache[r][c] = Math.min(c1, Math.min(c2, c3)) + arr[r][c];

	}

}
