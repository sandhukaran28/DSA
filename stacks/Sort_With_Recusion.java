package stacks;

import java.util.Stack;

public class Sort_With_Recusion {

	public Stack<Integer> sort(Stack<Integer> st) {
		if (!st.isEmpty()) {

			int n = st.pop();
			sort(st);
			sortedIn(st, n);
		}

		return st;
	}

	public static void sortedIn(Stack<Integer> st, int n) {

		if (st.isEmpty() || st.peek() < n) {

			st.push(n);
			return;
		}

		int temp = st.pop();

		sortedIn(st, n);
		st.push(temp);
	}
}
