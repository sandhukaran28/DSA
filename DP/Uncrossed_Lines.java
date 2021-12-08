package dp;

import java.util.Arrays;

public class Uncrossed_Lines {

	public int maxUncrossedLines(int[] t1, int[] t2) {

		int dp[][] = new int[t1.length][t2.length];

		for (int i = 0; i < t1.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		return sol(t1, 0, t2, 0, dp);
	}

	public int sol(int s[], int currS, int t[], int currT, int dp[][]) {

		if (currS >= s.length || currT >= t.length) {
			return 0;
		}

		if (dp[currS][currT] != -1) {

			return dp[currS][currT];
		}

		int c1 = 0;
		if (s[currS] == t[currT]) {

			c1 = sol(s, currS + 1, t, currT + 1, dp) + 1;
		}

		int c2 = sol(s, currS + 1, t, currT, dp);
		int c3 = sol(s, currS, t, currT + 1, dp);

		return dp[currS][currT] = Math.max(c1, Math.max(c2, c3));

	}

}
