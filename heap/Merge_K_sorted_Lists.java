package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge_K_sorted_Lists {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

	}

	public static class Node {

		ListNode node;
		int val;

		public Node(ListNode node, int val) {

			this.node = node;
			this.val = val;
		}

		public String toString() {

			return "[" + val + "]";
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {

		int n = lists.length;
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			public int compare(Node o1, Node o2) {

				return o1.val - o2.val;
			};
		});
		ListNode ans = new ListNode();
		ListNode head = ans;
		for (int i = 0; i < n; i++) {
			ListNode node = lists[i];
			if (node != null)
				pq.add(new Node(node, node.val));
		}
		while (!pq.isEmpty()) {

			Node node = pq.poll();
			ans.next = new ListNode(node.val);
			ans = ans.next;
			ListNode ln = node.node;

			if (ln.next != null) {

				pq.add(new Node(ln.next, ln.next.val));
			}
		}

		return head = head.next;
	}

}
