package hashing_Assignment;

import java.util.HashMap;
import java.util.Map;

public class Max_Length_Subarray {

	int solve(int[] arr, int k) {
		int n = arr.length;
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum == k) {
				max = Math.max(max, i + 1);
			} else if (map.containsKey(sum - k)) {
				max = Math.max(max, i - map.get(sum - k));
			} else {
				map.put(sum, i);
			}
		}
		return max;
	}

}
