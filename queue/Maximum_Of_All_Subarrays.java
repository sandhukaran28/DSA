package queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Maximum_Of_All_Subarrays {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {

			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();

		ArrayList<Integer> al = new ArrayList<>();

		Deque<Integer> dq = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {

			while (!dq.isEmpty() && arr[dq.getLast()] < arr[i]) {

				dq.removeLast();
			}

			dq.addLast(i);

			if (dq.getFirst() == i - k) {

				dq.removeFirst();
			}

			if (i >= k - 1) {
				al.add(arr[dq.getFirst()]);
			}

		}

		for (int i = 0; i < al.size(); i++) {
			System.out.print(al.get(i) + " ");
		}

		sc.close();

	}

}
