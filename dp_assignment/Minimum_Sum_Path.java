package dp_assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Minimum_Sum_Path {

	public static int sol(int[][] arr, int i, int j, int[][] dp) {

		if (i < 0 || j < 0) {
			return Integer.MAX_VALUE;
		}

		if (i == 0 && j == 0) {
			return arr[i][j];
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int c1 = sol(arr, i - 1, j, dp);
		int c2 = sol(arr, i, j - 1, dp);

		return dp[i][j] = Math.min(c1, c2) + arr[i][j];

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int dp[][] = new int[n][m];
		int arr[][] = new int[n][m];

		for (int i = 0; i < n; i++) {

			Arrays.fill(dp[i], -1);

			for (int j = 0; j < m; j++) {

				arr[i][j] = sc.nextInt();
			}
		}

		System.out.println(sol(arr, n - 1, m - 1, dp));

		sc.close();

	}

}
