package linkedList;

import java.util.Scanner;

public class Intersection_of_Two_Linked_Lists {

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

		public void AddAtIndex(int val, int idx) throws Exception {

			if (idx < 0 || idx >= size()) {
				throw new Exception("Invalid Index");
			}
			if (idx == 0) {
				addAtFirst(val);
			} else if (idx == size()) {
				addAtLast(val);
			} else {

				Node nn = new Node(val);
				Node pre = getNodeAtIndex(idx - 1);
				Node curr = getNodeAtIndex(idx);
				nn.next = curr;
				pre.next = nn;

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

		public int getFirst() throws Exception {

			if (head == null) {
				throw new Exception("LinkedList Empty");
			}

			return head.val;
		}

		public int getLast() throws Exception {
			if (head == null) {
				throw new Exception("LinkedList Empty");
			}
			Node i = head;
			while (i.next != null) {
				i = i.next;
			}
			return i.val;
		}

		public int getAtIndex(int idx) throws Exception {
			if (head == null) {
				throw new Exception("LinkedList Empty");
			}
			if (idx < 0 || idx >= size()) {
				throw new Exception("Invalid Index");
			}

			Node i = head;

			for (int k = 1; k <= idx; k++) {
				i = i.next;
			}

			return i.val;
		}

		public Node getNodeAtIndex(int idx) throws Exception {

			if (head == null) {
				throw new Exception("LinkedList Empty");
			}

			if (idx < 0 || idx >= size()) {
				throw new Exception("Invalid Index");
			}
			Node i = head;
			for (int it = 1; it <= idx; it++) {
				i = i.next;
			}

			return i;
		}

		public int deleteFirst() throws Exception {
			if (head == null) {
				throw new Exception("LinkedList Empty");
			}
			Node i = head;
			head = head.next;
			i.next = null;
			int temp = i.val;
			i = null;
			return temp;

		}

		public int deleteLast() throws Exception {

			if (size() == 1) {
				return deleteFirst();
			}
			Node i = getNodeAtIndex(size() - 2);
			int temp = getNodeAtIndex(size() - 1).val;
			i.next = null;
			return temp;
		}

		public int deleteAIndex(int idx) throws Exception {

			if (idx == 0) {
				return deleteFirst();
			} else if (idx == size() - 1) {
				return deleteLast();
			} else {

				Node pre = getNodeAtIndex(idx - 1);
				Node curr = pre.next;
				Node nx = pre.next.next;

				pre.next = nx;
				curr.next = null;
				int temp = curr.val;
				curr = null;
				return temp;
			}

		}

		public void reverse() {

			if (head == null || head.next == null) {
				return;
			}

			Node pre = null;
			Node curr = head;

			while (curr != null) {
				Node nx = curr.next;
				curr.next = pre;
				pre = curr;
				curr = nx;
			}
			head = pre;
		}

		public int middle() {

			Node slow = head;
			Node fast = head;

			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}

			return slow.val;
		}

	}

	public static int getIntersectionNode(MyLinkedList.Node headA, int s1, MyLinkedList.Node headB, int s2) {
		MyLinkedList.Node x = headA, y = headB;
		if (s1 == s2) {

			while (x != null && y != null) {
				if (x.val == y.val) {
					return x.val;
				}
				x = x.next;
				y = y.next;
			}

			return -1;
		} else {

			if (s1 > s2) {

				for (int i = 1; i <= s1 - s2; i++) {

					x = x.next;
				}
			} else {

				for (int i = 1; i <= s2 - s1; i++) {

					y = y.next;
				}
			}

			while (x != null && y != null) {

				if (x.val == y.val) {
					return x.val;
				}
				x = x.next;
				y = y.next;
			}

			return -1;

		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n, m;
		n = sc.nextInt();

		MyLinkedList l1 = new MyLinkedList();
		MyLinkedList l2 = new MyLinkedList();

		for (int i = 0; i < n; i++) {
			l1.addAtLast(sc.nextInt());

		}
		m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			l2.addAtLast(sc.nextInt());
		}

		System.out.println(getIntersectionNode(l1.head, l1.size(), l2.head, l2.size()));
		sc.close();

	}
}
