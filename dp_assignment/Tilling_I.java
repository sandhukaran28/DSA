package dp_assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Tilling_I {

	public static int sol(int n, int[] dp) {

		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}

		if (dp[n] != -1) {
			return dp[n];
		}

		int c1 = sol(n - 1, dp);
		int c2 = sol(n - 2, dp);

		return dp[n] = c1 + c2;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int dp[] = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println(sol(n, dp));

		sc.close();

	}

}
