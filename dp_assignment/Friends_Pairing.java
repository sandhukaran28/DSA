package dp_assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Friends_Pairing {

	public static long sol(int n, long dp[]) {

		System.out.println("n: "+n);
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
		System.out.println("c1: "+c1);
		long c2 =  sol(n - 2, dp);
		System.out.println("c2: "+c2);
		c2*=(n-1);
		return dp[n] = c1 + c2;

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();
		while (test-- > 0) {

			int n = sc.nextInt();
			long dp[] = new long[n + 1];
			Arrays.fill(dp, -1);
			System.out.println(sol(n, dp));
		}
		sc.close();
	}
}
