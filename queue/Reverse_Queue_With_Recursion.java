package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Reverse_Queue_With_Recursion {

	public static void reverse(Queue<Integer> q) {

		if (q.isEmpty()) {
			return;
		}

		int n = q.poll();
		reverse(q);
		q.offer(n);

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {

			q.add(sc.nextInt());
		}
		reverse(q);
		while (!q.isEmpty()) {

			System.out.print(q.poll() + " ");
		}
		System.out.println("END");

		sc.close();
	}

}
