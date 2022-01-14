package revision;

public class Ll_Add_Two_Numbers {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static Node reverse(Node head) {

		Node prev = null;
		Node curr = head;

		while (curr != null) {

			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		head = prev;
		return head;

	}

	// Function to add two numbers represented by linked list.
	static Node addTwoLists(Node first, Node second) {

		Node n1 = reverse(first);
		Node n2 = reverse(second);
		Node ans = new Node(0);
		Node head = ans;
		int r = 0;
		while (n1 != null && n2 != null) {

			int n = n1.data + n2.data + r;
			r = 0;
			if (n < 10) {

				ans.next = new Node(n);
			} else {

				r += n / 10;
				ans.next = new Node(n % 10);
			}
			n1 = n1.next;
			n2 = n2.next;
			ans = ans.next;
		}

		if (n1 != null) {

			while (n1 != null) {
				int n = r + n1.data;
				r = 0;
				if (n < 10) {

					ans.next = new Node(n);
				} else {

					r += n / 10;
					ans.next = new Node(n % 10);
				}
				ans = ans.next;
				n1 = n1.next;
			}
		}

		if (n2 != null) {

			while (n2 != null) {

				int n = r + n2.data;
				r = 0;
				if (n < 10) {

					ans.next = new Node(n);
				} else {

					r += n / 10;
					ans.next = new Node(n % 10);
				}

				ans = ans.next;
				n2 = n2.next;
			}
		}
		if (r > 0) {
			ans.next = new Node(r);
		}
		head = head.next;
		return reverse(head);
	}

}
