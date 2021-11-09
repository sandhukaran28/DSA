package linkedList;

public class Remove_Duplicates_From_Sorted_Lists {

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

	public ListNode deleteDuplicates(ListNode head) {

		ListNode i = head;

		while (i != null) {

			while (i.next != null && i.next.val == i.val) {

				i.next = i.next.next;
			}
			i = i.next;
		}

		return head;
	}
}
