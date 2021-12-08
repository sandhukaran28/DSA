package dp;

import java.util.Arrays;

public class Delete_And_Earn {

	public int deleteAndEarn(int[] nums) {

		int max = nums[0];
		for (int i = 0; i < nums.length; i++) {

			max = Math.max(nums[i], max);
		}

		int fre[] = new int[max + 1];
		for (int i = 0; i < nums.length; i++) {

			fre[nums[i]] += nums[i];
		}
		int cache[] = new int[max + 1];
		Arrays.fill(cache, -1);

		return delete(fre, 0, cache);

	}

	public int delete(int arr[], int curr, int cache[]) {

		if (curr >= arr.length) {

			return 0;
		}
		if (cache[curr] != -1) {

			return cache[curr];

		}

		int c1 = delete(arr, curr + 2, cache) + arr[curr];

		int c2 = delete(arr, curr + 1, cache);

		return cache[curr] = Math.max(c1, c2);

	}
}
