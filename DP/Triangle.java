package DP;

import java.util.Arrays;
import java.util.List;

public class Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {
		int m = triangle.size();
		int n = triangle.get(m - 1).size();
		int cache[][] = new int[m][n];

		for (int i = 0; i < m; i++) {

			Arrays.fill(cache[i], -1);
		}

		return min(triangle, 0, 0, cache);
	}

	public int min(List<List<Integer>> arr, int row, int col, int[][] cache) {

		if (row >= arr.size()) {
			return 0;
		}

		if (cache[row][col] != -1) {

			return cache[row][col];
		}

		int c1 = min(arr, row + 1, col, cache) + arr.get(row).get(col);
		int c2 = min(arr, row + 1, col + 1, cache) + arr.get(row).get(col);

		return cache[row][col] = Math.min(c1, c2);
	}
}
