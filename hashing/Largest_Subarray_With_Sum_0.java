package hashing;

import java.util.HashMap;
import java.util.Map;

public class Largest_Subarray_With_Sum_0 {

	int maxLen(int nums[], int n) {
		Map<Integer, Integer> map = new HashMap<>();

		int sum = 0;
		int max = 0;
		int l = -1, r = -1;
		for (int i = 0; i < nums.length; i++) {

			sum += nums[i];

			if (sum == 0) {

				max = Math.max(max, i + 1);

			} else if (map.containsKey(sum)) {

				l = map.get(sum) + 1;
				r = i;
				max = Math.max(max, r - l + 1);

			} else {
				map.put(sum, i);
			}
		}

		return max;
	}

}
