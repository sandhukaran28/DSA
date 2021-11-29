package DP;

import java.util.Arrays;

public class Coin_Change_2 {

	public int change(int amount, int[] coins) {

		int n = coins.length;
		int cache[][] = new int[n][amount + 1];
		for (int i = 0; i < n; i++) {

			Arrays.fill(cache[i], -1);

		}
		return coinsC(amount, coins.length - 1, coins, cache);
	}

	public int coinsC(int am, int n, int coins[], int cache[][]) {

		if (am < 0 || n < 0) {

			return 0;
		}
		if (am == 0) {
			return 1;
		}

		if (cache[n][am] != -1) {

			return cache[n][am];
		}

		int c1 = 0;

		if (am - coins[n] >= 0) {

			c1 = coinsC(am - coins[n], n, coins, cache);
		}
		int c2 = coinsC(am, n - 1, coins, cache);

		return cache[n][am] = c1 + c2;
	}
}
