package dp;

import java.util.Arrays;
import java.util.Scanner;

public class Min_Cost_Climbing_Stairs {

	public static int sol(int[] cost, int n, int[] dp) {

		if (n >= cost.length) {
			return 0;
		}

		if (dp[n] != -1) {

			return dp[n];
		}

		int c1 = sol(cost, n + 1, dp);
		int c2 = sol(cost, n + 2, dp);

		return dp[n] = Math.min(c1, c2) + cost[n];
	}
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int n =sc.nextInt();
		int cost[] = new int[n];
		for(int i=0;i<n;i++) {
			cost[i] =sc.nextInt();
		}
		int dp[] = new int[n];
		Arrays.fill(dp, -1);
		System.out.println(Math.min(sol(cost, 0, dp), sol(cost, 1, dp)));
		sc.close();
	}

}
