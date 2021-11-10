package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class FIrst_Negitive_In_Every_Window {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();

		while (test-- > 0) {

			int n = sc.nextInt();
			int k = sc.nextInt();

			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {

				arr[i] = sc.nextInt();
			}

			Deque<Integer> dq = new ArrayDeque<>();

			for (int i = 0; i < n; i++) {

				while (!dq.isEmpty() && arr[i] < 0 && arr[dq.getFirst()] >= 0) {

					dq.removeLast();
				}
				if (arr[i] < 0) {
					dq.addLast(i);
				}

				if (!dq.isEmpty() && i - k == dq.getFirst()) {

					dq.removeFirst();
				}

				if (i >= k - 1) {
					if (!dq.isEmpty() && arr[dq.getFirst()] < 0) {

						System.out.print(arr[dq.getFirst()] + " ");
					} else {

						System.out.print(0 + " ");
					}
				}

			}
			System.out.println();
		}

		sc.close();
	}

}
