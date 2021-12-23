package hashing_Assignment;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Number_Of_Subarrays {

	public static long sol(int arr[], int t) {

		int n = arr.length;

		long cnt = 0;
		long sum = 0;

		Map<Long, Long> map = new HashMap<>();

		for (int i = 0; i < n; i++) {

			sum += arr[i];

			if (sum == t) {
				cnt++;

			}
			if (map.containsKey(sum - t)) {

				long curr = map.get(sum - t);

				cnt += curr;
			}
			
			map.put(sum, map.getOrDefault(sum, (long) 0)+1);

		}

		return cnt;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int t = sc.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {

			arr[i] = sc.nextInt();
		}

		System.out.println(sol(arr, t));

		sc.close();

	}

}
