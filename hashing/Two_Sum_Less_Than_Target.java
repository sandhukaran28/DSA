package hashing;

public class Two_Sum_Less_Than_Target {

	public static int sol(int arr[], int t) {

		int n = arr.length;
		int l = 0;
		int r = n - 1;
		int cnt = 0;
		while (l < r) {

			int sum = arr[l] + arr[r];
			if (sum <= t) {
				cnt += r - l;
				r--;
			} else if (sum > t) {
				r--;
			} else {

				l++;
			}

		}

		return cnt;

	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6 };

		System.out.println(sol(arr, 6));

	}

}
