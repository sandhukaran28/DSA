package revision;

import java.util.HashSet;
import java.util.Set;

public class LL_Loop_Remove {

	class Node {
		int data;
		Node next;
	}

	public static boolean detectLoop(Node head) {
		Node s = head;
		Node f = head;

		while (f != null && f.next != null) {

			f = f.next.next;
			s = s.next;

			if (f == s) {
				return true;
			}
		}

		return false;
	}

	public static void removeLoop(Node head) {
		// code here
		// remove the loop without losing any nodes
		boolean hasLoop = detectLoop(head);

		if (hasLoop == false)
			return;

		Set<Node> set = new HashSet<>();

		while (head != null) {

			if (!set.contains(head)) {
				set.add(head);
			}

			if (set.contains(head.next)) {
				head.next = null;
				break;
			}
			head = head.next;
		}

	}

}
