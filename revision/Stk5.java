package revision;

import java.util.Stack;
//https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1#
public class Stk5 {

	int celebrity(int M[][], int n) {
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < n; i++) {

			st.push(i);
		}

		while (st.size() > 1) {

			int a = st.pop();
			int b = st.pop();

			if (M[a][b] == 1) {
				st.push(b);
			} else {

				st.push(a);
			}
		}

		int p = st.pop();

		for (int i = 0; i < n; i++) {

			if (M[p][i] == 1) {

				return -1;
			}
		}

		for (int i = 0; i < n; i++) {

			if (i != p && M[i][p] == 0) {

				return -1;
			}
		}

		return p;
	}

}
