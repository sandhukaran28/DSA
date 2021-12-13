package dp;

import java.util.HashMap;
import java.util.List;

public class Word_Break {

	public boolean wordBreak(String s, List<String> wordDict) {

		HashMap<String, Boolean> dp = new HashMap<>();
		return sol(s, "", wordDict, wordDict.size(), dp);
	}

	public boolean sol(String s, String t, List<String> dic, int size, HashMap<String, Boolean> dp) {

		if (t.length() > s.length()) {
			return false;
		}

		if (t.length() == s.length()) {

			if (s.equals(t)) {

				return true;
			}
			return false;
		}
		if (dp.containsKey(t)) {

			return dp.get(t);
		}

		for (int i = 0; i < size; i++) {
			String curr = t + dic.get(i);
			if (s.length() >= curr.length() && s.substring(0, curr.length()).equals(curr)) {
				boolean currA = sol(s, curr, dic, size, dp);
				if (currA == true) {
					dp.put(t, true);
					return true;
				}
			}

		}
		dp.put(t, false);
		return false;
	}

}
