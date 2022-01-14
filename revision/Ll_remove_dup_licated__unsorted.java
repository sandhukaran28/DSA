package revision;

import java.util.HashSet;
import java.util.Set;

public class Ll_remove_dup_licated__unsorted {

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public Node removeDuplicates(Node head) {

		Set<Integer> set = new HashSet<>();

		Node curr = head;

		while (curr != null) {

			set.add(curr.data);
			if (curr.next != null && set.contains(curr.next.data)) {

				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}
		return head;

	}
}
