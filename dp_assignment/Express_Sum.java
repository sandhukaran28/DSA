package dp_assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Express_Sum {

	public static long sol(int n, long[] dp) {

		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}
		if (dp[n] != -1) {
			return dp[n];
		}

		long c1 = sol(n - 1, dp);
		long c2 = sol(n - 3, dp);
		long c3 = sol(n - 4, dp);

		return dp[n] = c1 + c2 + c3;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long dp[] = new long[n + 1];
		Arrays.fill(dp, -1);

		System.out.println(sol(n, dp));
		sc.close();

	}

}
