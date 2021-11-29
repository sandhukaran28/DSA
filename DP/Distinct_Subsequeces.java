package DP;

import java.util.Arrays;

public class Distinct_Subsequeces {

	public int numDistinct(String s, String t) {

		int cache[][] = new int[s.length()][t.length()];

		for (int i = 0; i < s.length(); i++) {

			Arrays.fill(cache[i], -1);
		}
		return sub(s, 0, t, 0, cache);
	}

	public int sub(String s, int currS, String t, int currT, int cache[][]) {

		if (currT == t.length()) {

			return 1;
		}
		if (currS >= s.length()) {

			return 0;
		}

		if (cache[currS][currT] != -1) {

			return cache[currS][currT];
		}

		int c1 = 0;
		if (s.charAt(currS) == t.charAt(currT)) {

			c1 = sub(s, currS + 1, t, currT + 1, cache);
		}

		int c2 = sub(s, currS + 1, t, currT, cache);

		return cache[currS][currT] = c1 + c2;

	}
}
