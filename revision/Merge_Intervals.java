package revision;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Merge_Intervals {

	public class Pair {

		int st;
		int en;

		public Pair(int st, int en) {

			this.st = st;
			this.en = en;
		}
	}

	public int[][] merge(int[][] arr) {

		int n = arr.length;
		Arrays.sort(arr, Comparator.comparingDouble(o -> o[1]));
		Stack<Pair> st = new Stack<>();
		st.push(new Pair(arr[0][0], arr[0][1]));

		for (int i = 1; i < n; i++) {
			int cs = arr[i][0];
			int ce = arr[i][1];

			while (!st.isEmpty() && cs <= st.peek().en) {
				Pair top = st.pop();
				int ts = top.st;
				int te = top.en;
				int ms = Math.min(cs, ts);
				int me = Math.max(ce, te);
				cs = ms;
				ce = me;
			}
			st.push(new Pair(cs, ce));

		}

		int[][] ans = new int[st.size()][2];

		int x = 0;

		while (!st.isEmpty()) {

			Pair top = st.pop();

			ans[x][0] = top.st;
			ans[x][1] = top.en;
			x++;

		}

		return ans;
	}

}
