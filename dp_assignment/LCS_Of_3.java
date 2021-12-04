package dp_assignment;

import java.util.Arrays;
import java.util.Scanner;

public class LCS_Of_3 {

	public static int sol(String a, int i, String b, int j, String c, int k, int[][][] dp) {

		if (i >= a.length() || j >= b.length() || k >= c.length()) {

			return 0;
		}

		if (dp[i][j][k] != -1) {
			return dp[i][j][k];
		}

		int c1 = 0;
		if (a.charAt(i) == b.charAt(j) && b.charAt(j) == c.charAt(k)) {

			c1 = sol(a, i + 1, b, j + 1, c, k + 1, dp) + 1;
		}
		int c2 = sol(a, i + 1, b, j, c, k, dp);
		int c3 = sol(a, i, b, j + 1, c, k, dp);
		int c4 = sol(a, i, b, j, c, k + 1, dp);
		int c5 = sol(a, i + 1, b, j + 1, c, k, dp);
		int c6 = sol(a, i + 1, b, j, c, k + 1, dp);
		int c7 = sol(a, i, b, j + 1, c, k + 1, dp);

		return dp[i][j][k] = Math.max(c1, Math.max(c2, Math.max(c3, Math.max(c4, Math.max(c5, Math.max(c6, c7))))));
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String a = sc.next();
		String b = sc.next();
		String c = sc.next();
		int[][][] dp = new int[a.length()][b.length()][c.length()];
		for (int i = 0; i < a.length(); i++) {

			for (int j = 0; j < b.length(); j++) {

				Arrays.fill(dp[i][j], -1);
			}
		}
		System.out.println(sol(a, 0, b, 0, c, 0, dp));
		sc.close();

	}

}
