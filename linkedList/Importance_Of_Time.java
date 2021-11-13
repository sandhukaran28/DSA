package linkedList;

import java.util.Scanner;

public class Importance_Of_Time {

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

				System.out.print(i.val + "->");
				i = i.next;
			}
			System.out.println();
		}

	}

	public static int cost(MyLinkedList.Node calling, MyLinkedList.Node ideal) {

		int cost = 0;

		MyLinkedList.Node last = calling;
		while (last.next != null) {
			last = last.next;
		}

		while (calling != null) {

			while (calling.val != ideal.val) {

				MyLinkedList.Node nn = calling.next;
				last.next = calling;
				calling.next = null;

				calling = nn;
				cost += 1;
				last = last.next;

			}

			calling = calling.next;
			ideal = ideal.next;
			cost += 1;

		}

		return cost;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		MyLinkedList calling = new MyLinkedList();
		MyLinkedList ideal = new MyLinkedList();

		for (int i = 0; i < n; i++) {

			calling.addAtLast(sc.nextInt());
		}
		for (int i = 0; i < n; i++) {

			ideal.addAtLast(sc.nextInt());
		}

		System.out.println(cost(calling.head, ideal.head));

		sc.close();

	}

}
