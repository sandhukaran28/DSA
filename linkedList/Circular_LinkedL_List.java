package linkedList;

import java.util.HashSet;
import java.util.Scanner;

public class Circular_LinkedL_List {

	public static class MyLinkedList {

		static class Node {

			int val;
			Node next;

			public Node(int val) {

				this.val = val;
				next = null;
			}

		}

		private Node head;

		public int size() {
			Node i = head;

			int size = 0;
			while (i != null) {
				size++;
				i = i.next;
			}
			return size;
		}

		public void addAtFirst(int val) {

			Node nn = new Node(val);
			nn.next = head;
			head = nn;
		}

		public void addAtLast(int val) {

			Node nn = new Node(val);

			if (head == null) {
				addAtFirst(val);
			} else {
				Node i = head;
				while (i.next != null) {
					i = i.next;
				}

				i.next = nn;

			}

		}

		public void display() {

			Node i = head;

			while (i != null) {

				System.out.print(i.val + " ");
				i = i.next;
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = 0;

		MyLinkedList ll = new MyLinkedList();
		HashSet<Integer> hs = new HashSet<>();
		while (n != -1) {

			n = sc.nextInt();
			if (n == -1) {
				break;
			}
			if (hs.contains(n)) {
				continue;
			} else {
				ll.addAtLast(n);
				hs.add(n);
			}

		}
		ll.display();

		sc.close();
	}

}
