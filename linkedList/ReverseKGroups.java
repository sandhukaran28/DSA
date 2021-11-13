package linkedList;

import java.util.Scanner;

public class ReverseKGroups {

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

	public static MyLinkedList.Node actualReverse(MyLinkedList.Node head, MyLinkedList.Node kPlus) {

		MyLinkedList.Node pre = null;
		MyLinkedList.Node curr = head;

		while (curr != kPlus) {

			MyLinkedList.Node nn = curr.next;
			curr.next = pre;
			pre = curr;
			curr = nn;

		}

		head = pre;
		return head;
	}

	public static MyLinkedList.Node kReverse(MyLinkedList.Node node, int k) {

		if (node == null) {
			return null;
		}

		MyLinkedList.Node curr = node;

		for (int i = 0; i < k; i++) {

			if (curr == null) {
				return node;
			}
			curr = curr.next;
		}

		MyLinkedList.Node newHead = actualReverse(node, curr);

		node.next = kReverse(curr, k);

		return newHead;

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n, k;
		n = sc.nextInt();
		k = sc.nextInt();

		MyLinkedList ll = new MyLinkedList();

		for (int i = 0; i < n; i++) {

			ll.addAtLast(sc.nextInt());
		}

		MyLinkedList.Node head = kReverse(ll.head, k);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}

		sc.close();
	}
}
