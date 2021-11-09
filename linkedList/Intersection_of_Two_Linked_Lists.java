package linkedList;

public class Intersection_of_Two_Linked_Lists {

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

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode x = headA, y = headB;
		int s1 = 0, s2 = 0;

		while (x != null) {

			s1++;
			x = x.next;
		}

		while (y != null) {

			s2++;
			y = y.next;

		}

		x = headA;
		y = headB;
		if (x == y) {
			while (x != null && y != null) {

				if (x == y) {
					return x;
				}
				x = x.next;
				y = y.next;
			}

			return null;
		} else {

			if (s1 > s2) {

				for (int i = 1; i <= s1 - s2; i++) {

					x = x.next;
				}
			} else {

				for (int i = 1; i <= s2 - s1; i++) {

					y = y.next;
				}
			}

			while (x != null && y != null) {

				if (x == y) {
					return x;
				}
				x = x.next;
				y = y.next;
			}

			return null;

		}
	}
}
