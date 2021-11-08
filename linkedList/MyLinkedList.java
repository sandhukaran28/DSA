package linkedList;

public class MyLinkedList {

	class Node {

		int val;
		Node next;

		public Node(int val) {

			this.val = val;
			next = null;
		}

	}

	private Node head;

	public int size() {
		Node i = head;

		int size = 0;
		while (i != null) {
			size++;
			i = i.next;
		}
		return size;
	}

	public void addAtFirst(int val) {

		Node nn = new Node(val);
		nn.next = head;
		head = nn;
	}

	public void addAtLast(int val) {

		Node nn = new Node(val);

		if (head == null) {
			addAtFirst(val);
		} else {
			Node i = head;
			while (i.next != null) {
				i = i.next;
			}

			i.next = nn;

		}

	}

	public void AddAtIndex(int val, int idx) throws Exception {

		if (idx < 0 || idx >= size()) {
			throw new Exception("Invalid Index");
		}
		if (idx == 0) {
			addAtFirst(val);
		} else if (idx == size()) {
			addAtLast(val);
		} else {

			Node nn = new Node(val);
			Node pre = getNodeAtIndex(idx - 1);
			Node curr = getNodeAtIndex(idx);
			nn.next = curr;
			pre.next = nn;

		}

	}

	public void display() {

		Node i = head;

		while (i != null) {

			System.out.print(i.val + " ");
			i = i.next;
		}
		System.out.println();
	}

	public int getFirst() throws Exception {

		if (head == null) {
			throw new Exception("LinkedList Empty");
		}

		return head.val;
	}

	public int getLast() throws Exception {
		if (head == null) {
			throw new Exception("LinkedList Empty");
		}
		Node i = head;
		while (i.next != null) {
			i = i.next;
		}
		return i.val;
	}

	public int getAtIndex(int idx) throws Exception {
		if (head == null) {
			throw new Exception("LinkedList Empty");
		}
		if (idx < 0 || idx >= size()) {
			throw new Exception("Invalid Index");
		}

		Node i = head;

		for (int k = 1; k <= idx; k++) {
			i = i.next;
		}

		return i.val;
	}

	public Node getNodeAtIndex(int idx) throws Exception {

		if (head == null) {
			throw new Exception("LinkedList Empty");
		}

		if (idx < 0 || idx >= size()) {
			throw new Exception("Invalid Index");
		}
		Node i = head;
		for (int it = 1; it <= idx; it++) {
			i = i.next;
		}

		return i;
	}

}
