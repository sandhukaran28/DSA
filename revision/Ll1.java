package revision;

public class Ll1 {

	public class Node {

		int val;
		Node next;

		public Node(int val) {

			this.val = val;
		}
	}

	Node head;
	int size;

	public Ll1() {

		size = 0;
		head = null;
	}

	public void addFirst(int val) {
		Node nn = new Node(val);

		nn.next = head;
		head = nn;
		size++;
	}

	public void add(int val) {
		if (this.head == null) {
			this.addFirst(val);
			return;
		}
		Node curr = head;
		while (curr.next != null) {

			curr = curr.next;
		}

		Node nn = new Node(val);
		curr.next = nn;
		size++;

	}
	
	public void reverse() {
		
		Node prev = null;
		Node curr = head;
		
		while(curr != null) {
			
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		head = prev;
		
		this.display();
	}

	public void display() {

		Node curr = head;

		while (curr != null) {
			System.out.print(curr.val + "->");
			curr = curr.next;
		}
		System.out.println();
	}
	
	public void middle() {
		Node slow = head;
		Node fast=  head;
		
		while(fast!=null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		System.out.println(slow.val);
	}

	public static void main(String[] args) {

		Ll1 ll = new Ll1();
		
		ll.add(1);
		ll.add(2);
		ll.addFirst(0);
		ll.add(3);
		ll.display();
		ll.middle();
	}

}
