package hashing;

import java.util.HashMap;
import java.util.Map;

public class Longest_SubArray_with_Sum_K {

	public static int lenOfLongSubarr(int nums[], int N, int K) {

		Map<Integer, Integer> map = new HashMap<>();

		int sum = 0;
		int max = 0;
		int l = -1, r = -1;
		for (int i = 0; i < nums.length; i++) {

			sum += nums[i];
			if (sum == K) {

				max = Math.max(max, i + 1);

			} else if (map.containsKey(sum - K)) {

				l = map.get(sum - K) + 1;
				r = i;
				max = Math.max(max, r - l + 1);

			}
			if (!map.containsKey(sum))
				map.put(sum, i);

		}

		return max;
	}
}
