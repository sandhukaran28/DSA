package revision;

public class Detect_Loop {

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
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
}
