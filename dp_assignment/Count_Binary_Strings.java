package dp_assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Count_Binary_Strings {

	public static long sol(int n, int prev, long[][] dp) {

		if (n == 0) {
			return 1;
		}

		if (dp[n][prev] != -1) {

			return dp[n][prev];
		}

		long c1 = 0, c2 = 0;

		c1 = sol(n - 1, 0, dp);

		if (prev != 1) {

			c2 = sol(n - 1, 1, dp);
		}

		return dp[n][prev] = c1 + c2;

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();
		while (test-- > 0) {

			int n = sc.nextInt();
			long dp[][] = new long[n + 1][2];

			for (int i = 0; i <= n; i++) {
				Arrays.fill(dp[i], -1);
			}
			System.out.println(sol(n, 0, dp));
		}
		sc.close();

	}

}
