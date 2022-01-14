package revision;

public class ReversekGroups {

	class Node {
		int data;
		Node next;

		Node(int key) {
			data = key;
			next = null;
		}
	}

	public static Node rev(Node curr, Node kPlus) {

		Node pre = null;
		while (curr != kPlus) {

			Node next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}

		return pre;
	}

	public static Node reverse(Node node, int k) {
		if (node == null) {

			return null;

		}
		Node kPlus = node;

		for (int i = 0; i < k; i++) {

			if (kPlus == null) {
				break;
			}

			kPlus = kPlus.next;

		}

		Node nHead = rev(node, kPlus);

		node.next = reverse(kPlus, k);

		return nHead;
	}
}
