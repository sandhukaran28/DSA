package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subarray_Sum {

	public List<Integer> subarraySum(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();

		int sum = 0;
		int l = -1, r = -1;
		for (int i = 0; i < nums.length; i++) {

			sum += nums[i];

			if (sum == 0) {

				l = 0;
				r = i;
				break;
			} else if (map.containsKey(sum)) {

				l = map.get(sum) + 1;
				r = i;
				break;
			} else {
				map.put(sum, i);
			}
		}

		List<Integer> ls = new ArrayList<>();
		ls.add(l);
		ls.add(r);

		return ls;
	}
}
