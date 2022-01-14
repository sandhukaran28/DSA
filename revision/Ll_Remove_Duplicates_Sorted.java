package revision;

public class Ll_Remove_Duplicates_Sorted {

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	Node removeDuplicates(Node head) {
		Node curr = head;
		while (curr != null) {

			if (curr.next != null && curr.data == curr.next.data) {

				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}

		return head;
	}
}
