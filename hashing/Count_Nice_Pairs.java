package hashing;

import java.util.HashMap;
import java.util.Map;

public class Count_Nice_Pairs {

	public int rev(int n) {

		int rev = 0;

		while (n > 0) {
			int r = n % 10;
			rev = (rev * 10) + r;
			n /= 10;
		}

		return rev;
	}

	public int countNicePairs(int[] nums) {

		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		int cnt = 0;
		for (int i = 0; i < n; i++) {

			int curr = nums[i];
			int diff = nums[i] - rev(nums[i]);

			if (map.containsKey(diff)) {

				cnt = (cnt + map.get(diff)) % 1000000007;
			}

			map.put(diff, map.getOrDefault(diff, 0) + 1);

		}
		return cnt % 1000000007;
	}

}
