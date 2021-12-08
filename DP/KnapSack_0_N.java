package dp;

import java.util.Arrays;

public class KnapSack_0_N {

	static int knapSack(int n, int W, int val[], int wt[]) {

		int cache[][] = new int[n][W + 1];
		for (int i = 0; i < n; i++) {

			Arrays.fill(cache[i], -1);
		}
		return knap(W, wt, val, n - 1, cache);
	}

	static int knap(int w, int wt[], int val[], int n, int cache[][]) {

		if (n < 0 || w <= 0) {

			return 0;
		}

		if (cache[n][w] != -1) {
			return cache[n][w];
		}

		int c1 = 0;
		if (w - wt[n] >= 0) {

			c1 = knap(w - wt[n], wt, val, n, cache) + val[n];
		}
		int c2 = knap(w, wt, val, n - 1, cache);

		return cache[n][w] = Math.max(c1, c2);
	}
}
