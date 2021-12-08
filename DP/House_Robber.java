package dp;

import java.util.Arrays;

public class House_Robber {

	public int rob(int[] nums) {
		int cache[] = new int[nums.length + 1];
		Arrays.fill(cache, -1);
		return max(nums, 0, cache);

	}

	public int max(int[] nums, int curr, int[] cache) {

		if (curr >= nums.length) {

			return 0;
		}
		if (cache[curr + 1] != -1) {

			return cache[curr + 1];
		}

		int l = max(nums, curr + 2, cache) + nums[curr];

		int r = max(nums, curr + 1, cache);

		return cache[curr + 1] = Math.max(l, r);
	}
}
