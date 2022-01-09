package revision;

import java.util.Stack;
//https://practice.geeksforgeeks.org/problems/number-following-a-pattern3126/1#
public class Stk2 {

	static String printMinNumberForPattern(String S) {

		Stack<Integer> st = new Stack<>();
		String ans = "";

		for (int i = 0; i <= S.length(); i++) {
			st.push(i + 1);

			if (i == S.length() || S.charAt(i) == 'I') {

				while (!st.isEmpty()) {

					ans += Integer.toString(st.pop());
				}
			}
		}

		return ans;
	}
}
