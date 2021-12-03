package dp_assignment;

import java.util.Arrays;
import java.util.Scanner;

public class GoldMine_Problem {

	public static int sol(int[][] arr, int i, int j, int n, int m,int dp[][]) {

		if (i < 0 || i >= n || j >= m) {
			return 0;
		}
		if(dp[i][j] != -1) {
			return dp[i][j];
		}

		int c1 = sol(arr, i - 1, j + 1, n, m,dp);
		int c2 = sol(arr, i, j + 1, n, m,dp);
		int c3 = sol(arr, i + 1, j + 1, n, m,dp);

		return dp[i][j] =  Math.max(c1,Math.max(c2, c3))+ arr[i][j];
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();

		while (test-- > 0) {

			int n = sc.nextInt();
			int m = sc.nextInt();
			int dp[][] =new int[n][m];
			int arr[][] = new int[n][m];

			for (int i = 0; i < n; i++) {

				Arrays.fill(dp[i], -1);
				
				for (int j = 0; j < m; j++) {

					arr[i][j] = sc.nextInt();
				}
			}
			int max = 0;
			for (int i = 0; i < n; i++) {

				max = Math.max(max, sol(arr, i, 0, n, m,dp));
			}
			System.out.println(max);
		}
		sc.close();
	}

}
