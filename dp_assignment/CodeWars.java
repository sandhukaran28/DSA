package dp_assignment;

import java.util.Arrays;
import java.util.Scanner;

public class CodeWars {

	public static long sol(String a, int i, String b, int j, int n1, int n2,long[][]dp) {

		if (i == n1 - 1 && j == n2 - 1) {

			return 0;
		}

		if (i >= n1 || j >= n2) {
			return Integer.MAX_VALUE;
		}
		
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		
		long c0 = Integer.MAX_VALUE;
		if (a.charAt(i) == b.charAt(j)) {

			c0 = sol(a, i + 1, b, j + 1, n1, n2,dp);
		}

		long c1 = sol(a, i, b, j + 1, n1, n2,dp) + 1; // Insert
		long c2 = sol(a, i + 1, b, j, n1, n2,dp) + 1; // Delete
		long c3 = sol(a, i + 1, b, j + 1, n1, n2,dp) + 1; // replace

		return dp[i][j] =  Math.min(c0, Math.min(c1, Math.min(c2, c3)));
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String s1 = sc.next();
		String s2 = sc.next();
		int max = Math.max(s1.length(), s2.length());
		long dp[][] =new long[max][max];
		for(int i=0;i<max;i++) {
			
			Arrays.fill(dp[i], -1);
		}
		System.out.println(sol(s1, 0, s2, 0, s1.length(), s2.length(),dp));

		sc.close();

	}

}
