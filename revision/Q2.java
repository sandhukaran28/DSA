package revision;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Q2 {

	static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {

		ArrayList<Integer> ans = new ArrayList<>();
		Deque<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {

			int curr = arr[i];

			while (!q.isEmpty() && arr[q.getLast()] < curr) {

				q.removeLast();
			}
			q.addLast(i);

			if (i - k == q.getFirst()) {
				q.removeFirst();
			}

			if (i + 1 >= k) {

				ans.add(arr[q.getFirst()]);
			}

		}

		return ans;
	}

}
