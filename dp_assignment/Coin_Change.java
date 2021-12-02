package dp_assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Coin_Change {

	public static int sol(int arr[], int curr, int sum, int[][] dp) {

		if (curr >= arr.length || sum < 0) {
			return 0;
		}
		if (sum == 0) {
			return 1;
		}
		if (dp[curr][sum] != -1) {
			return dp[curr][sum];
		}

		int c1 = 0;
		if (arr[curr] <= sum) {
			c1 = sol(arr, curr, sum - arr[curr], dp);
		}

		int c2 = sol(arr, curr + 1, sum, dp);

		return dp[curr][sum] = c1 + c2;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();
		int n = sc.nextInt();
		int arr[] = new int[n];
		int dp[][] = new int[n][sum+1];
		for(int i=0;i<n;i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int i = 0; i < n; i++) {

			arr[i] = sc.nextInt();
		}
		System.out.println(sol(arr, 0, sum, dp));
		sc.close();

	}

}
