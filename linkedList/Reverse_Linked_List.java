package linkedList;

public class Reverse_Linked_List {

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

	public ListNode reverseList(ListNode head) {

		ListNode pre = null;
		ListNode curr = head;

		while (curr != null) {

			ListNode nx = curr.next;
			curr.next = pre;
			pre = curr;
			curr = nx;

		}
		head = pre;

		return head;

	}

}
