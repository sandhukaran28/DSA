package linkedList;

import java.util.LinkedList;
import java.util.Scanner;

public class Sum_Of_Two_Linked_Lists {

	public static void add(LinkedList<Integer> l1, LinkedList<Integer> l2, int carry) {

		if (l1.size() == 0 && l2.size() == 0) {

			if (carry != 0) {
				System.out.print(carry + " ");
			}
			return;
		}

		int n1 = 0, n2 = 0;

		if (l1.size() != 0) {
			n1 = l1.removeLast();
		}

		if (l2.size() != 0) {
			n2 = l2.removeLast();

		}

		int sum = n1 + n2 + carry;

		if (sum < 9) {

			add(l1, l2, 0);
			System.out.print(sum + " ");

		} else {
			add(l1, l2, sum / 10);

			System.out.print(sum % 10 + " ");
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n, m;
		n = sc.nextInt();
		m = sc.nextInt();

		LinkedList<Integer> l1 = new LinkedList<>();
		LinkedList<Integer> l2 = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			l1.add(sc.nextInt());

		}

		for (int i = 0; i < m; i++) {
			l2.add(sc.nextInt());
		}

		add(l1, l2, 0);
		sc.close();

	}

}
