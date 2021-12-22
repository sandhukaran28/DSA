package hashing;

import java.util.Arrays;

public class Closest_2_Sum {

	public static void sol(int[] arr, int t) {
		Arrays.sort(arr);
		int n = arr.length;
		int min = arr[1] + arr[0];
		int l = 0;
		int r = n - 1;

		while (l < r) {

			int sum = arr[l] + arr[r];

			if ((Math.abs(t - min) > Math.abs(t - sum))) {

				min = sum;
			}

			if (sum < t) {
				l++;
			} else {

				r--;
			}
		}

		System.out.println(min);
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6 };

		sol(arr, 12);
	}

}
