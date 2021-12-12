package dp;

public class Arithmetic_Slices {

	int ap;

	public int numberOfArithmeticSlices(int[] nums) {

		ap = 0;
		sol(nums, nums.length - 1, 0);
		return ap;
	}

	public void sol(int arr[], int n, int curr) {

		if (n < 2) {
			return;
		}

		if (arr[n] - arr[n - 1] == arr[n - 1] - arr[n - 2]) {

			sol(arr, n - 1, curr + 1);
			ap += curr + 1;
		} else {
			sol(arr, n - 1, 0);
		}
		return;

	}
}
