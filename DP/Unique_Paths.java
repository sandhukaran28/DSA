package DP;

import java.util.Arrays;

public class Unique_Paths {

	public int uniquePaths(int m, int n) {

		int cache[][] = new int[m][n];

		for (int i = 0; i < m; i++) {

			Arrays.fill(cache[i], -1);
		}
		return path(m - 1, n - 1, cache);
	}

	public int path(int m, int n, int cache[][]) {

		if (m == 0 && n == 0) {

			return 1;

		}

		if (m < 0 || n < 0) {

			return 0;
		}

		if (cache[m][n] != -1) {
			return cache[m][n];
		}

		int c1 = path(m - 1, n, cache);
		int c2 = path(m, n - 1, cache);

		return cache[m][n] = c1 + c2;
	}
}
