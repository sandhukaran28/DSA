package dp_assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Longest_Subsequence {

	public static int len(int[] arr, int curr, int prev, int[][] dp) {

		if (curr >= arr.length) {

			return 0;
		}

		if (dp[curr + 1][prev + 1] != Integer.MIN_VALUE) {

			return dp[curr + 1][prev + 1];
		}
		int c1 = 0;
		if (prev == -1 || arr[curr] > arr[prev])
			c1 = len(arr, curr + 1, curr, dp) + 1;
		int c2 = len(arr, curr + 1, prev, dp);

		return dp[curr + 1][prev + 1] = Math.max(c1, c2);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int dp[][] = new int[arr.length + 1][arr.length + 1];

		for (int i = 0; i <= arr.length; i++) {
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		}
		for (int i = 0; i < n; i++) {

			arr[i] = sc.nextInt();
		}
		System.out.println(len(arr, 0, -1, dp));
		sc.close();
	}

}
