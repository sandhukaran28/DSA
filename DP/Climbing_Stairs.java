package dp;

import java.util.Arrays;

public class Climbing_Stairs {

	public int climbStairs(int n) {

		int cache[] = new int[n + 1];
		Arrays.fill(cache, -1);
		return ways(n, cache);
	}

	public int ways(int r, int[] cache) {

		if (r == 0) {
			return 1;
		}

		if (r < 0) {
			return 0;
		}

		if (cache[r] != -1) {

			return cache[r];
		}

		int l = ways(r - 1, cache);
		int ri = ways(r - 2, cache);

		return cache[r] = l + ri;
	}
}
