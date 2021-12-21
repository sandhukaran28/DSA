package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four_Sum {

	public List<List<Integer>> fourSum(int[] arr, int t) {

		Arrays.sort(arr);
		int n = arr.length;
		List<List<Integer>> ans = new ArrayList<>();

		for (int j = 0; j < n - 3; j++) {

			if (j > 0 && arr[j] == arr[j - 1]) {
				continue;
			}

			for (int i = j + 1; i < n - 2; i++) {

				int l = i + 1;
				int r = n - 1;

				if (i > j + 1 && arr[i] == arr[i - 1]) {
					continue;
				}

				while (l < r) {

					int sum = arr[i] + arr[l] + arr[r] + arr[j];

					if (sum == t) {

						ans.add(Arrays.asList(arr[j], arr[i], arr[l], arr[r]));
						l++;
						r--;
						while (l < r && arr[l] == arr[l - 1]) {

							l++;
						}
					} else if (sum > t) {

						r--;
					} else {

						l++;
					}

				}

			}
		}

		return ans;

	}

}
