package hashing;

import java.util.HashMap;
import java.util.Map;

public class Longest_Consecutive_Subsequence_Map {

	public int longestConsecutive(int[] arr) {

		Map<Integer, Boolean> map = new HashMap<>();

		int n = arr.length;
		for (int e : arr) {

			map.put(e, true);
		}
		int max = 0;
		for (int i = 0; i < n; i++) {

			if (map.containsKey(arr[i] - 1)) {

				map.put(arr[i], false);
			} else {
				int curr = 1;

				while (map.containsKey(arr[i] + curr)) {

					curr++;
				}

				max = Math.max(max, curr);

			}
		}

		return max;

	}

}
