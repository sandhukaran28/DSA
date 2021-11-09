package linkedList;

public class Remove_Linked_List_Elements {

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

	public ListNode removeElements(ListNode head, int val) {

		ListNode i = head;

		while (i != null) {

			if (i.val == val && i == head) {

				head = head.next;
			}

			else {
				while (i.next != null && i.next.val == val) {

					i.next = i.next.next;
				}
			}

			i = i.next;
		}

		return head;

	}

}
