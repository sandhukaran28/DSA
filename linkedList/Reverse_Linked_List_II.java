package linkedList;

public class Reverse_Linked_List_II {

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

	public ListNode actualReverse(ListNode head, ListNode kPlus) {

		ListNode pre = null;
		ListNode curr = head;

		while (curr != kPlus) {

			ListNode nn = curr.next;
			curr.next = pre;
			pre = curr;
			curr = nn;
		}

		return pre;

	}

	public ListNode reverseBetween(ListNode head, int left, int right) {

		if (head == null || head.next == null) {

			return head;
		}

		ListNode currL = head;
		ListNode prev = null;
		for (int i = 1; i < left; i++) {
			if (i == left - 1) {
				prev = currL;
			}
			currL = currL.next;
		}

		ListNode currR = currL;

		for (int i = 0; i <= right - left; i++) {

			currR = currR.next;
		}
		ListNode newHead = actualReverse(currL, currR);

		ListNode curr = newHead;
		while (curr != null && curr.next != null) {
			curr = curr.next;
		}
		if (prev != null) {
			prev.next = newHead;
		} else {
			head = newHead;
		}
		curr.next = currR;

		return head;

	}

}
