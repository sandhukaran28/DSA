package hashing;

import java.util.Arrays;

public class Longest_Consecutive_Subsequence {

	public int longestConsecutive(int[] arr) {

		Arrays.sort(arr);

		int n = arr.length;
		if (n == 0) {
			return 0;
		}

		int curr = 1;
		int max = 0;

		for (int i = 1; i < n; i++) {

			if (arr[i] - arr[i - 1] == 1) {

				curr++;
			} else if (arr[i] == arr[i - 1]) {
				continue;
			} else {

				max = Math.max(max, curr);
				curr = 1;
			}
		}

		max = Math.max(max, curr);

		return max;
	}

}
