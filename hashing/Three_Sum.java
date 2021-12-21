package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {

	public List<List<Integer>> threeSum(int[] arr) {

		Arrays.sort(arr);
		int n = arr.length;
		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < n; i++) {

			int l = i + 1;
			int r = n - 1;

			if (i > 0 && arr[i] == arr[i - 1]) {
				continue;
			}

			while (l < r) {

				int sum = arr[i] + arr[l] + arr[r];

				if (sum == 0) {

					ans.add(Arrays.asList(arr[i], arr[l], arr[r]));
					l++;
					r--;
					while (l < r && arr[l] == arr[l - 1]) {

						l++;
					}
				} else if (sum > 0) {

					r--;
				} else {

					l++;
				}

			}

		}

		return ans;
	}

}
