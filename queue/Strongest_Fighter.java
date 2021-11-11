package queue;

import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;

public class Strongest_Fighter {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {

			arr[i] = sc.nextInt();
		}

		int k = sc.nextInt();

		Deque<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {

			while (!q.isEmpty() && arr[q.getLast()] < arr[i]) {

				q.removeLast();
			}

			q.add(i);

			if (i - k == q.getFirst()) {
				q.removeFirst();
			}

			if (i + 1 >= k) {

				System.out.print(arr[q.getFirst()] + " ");
			}

		}

		sc.close();

	}

}
