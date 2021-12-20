package hashing;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum_One_Pass {

	public int[] twoSum(int[] nums, int target) {
		int n = nums.length;
		Map<Integer, Integer> hs = new HashMap<>();
		int arr[] = new int[2];
		for (int i = 0; i < n; i++) {

			if (hs.containsKey(target - nums[i])) {

				arr[0] = i;
				arr[1] = hs.get(target - nums[i]);
				return arr;

			}

			hs.put(nums[i], i);
		}

		return arr;
	}

}
