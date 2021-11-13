package linkedList;

import java.util.Scanner;

public class Triplets_From_Three_Linked_Lists {

	public static class MyLinkedList {

		static class Node {

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

		public void display() {

			Node i = head;

			while (i != null) {

				System.out.print(i.val + "->");
				i = i.next;
			}
			System.out.println();
		}

	}

	public static void sum(MyLinkedList.Node l1, MyLinkedList.Node l2, MyLinkedList.Node l3, int target) {

		boolean find =false;
		MyLinkedList.Node t2 = l2;
		MyLinkedList.Node t3 = l3;
	while(l1!=null) {

		while(l2!=null) {
	
			while(l3!=null) {
				
				if(l1.val + l2.val + l3.val == target) {
				
					System.out.println(l1.val+" "+l2.val+" "+l3.val);
					find = true;
					break;
				}
				l3=l3.next;
			}
			if(find)
				break;
			
			l2 =l2.next;
			l3 =t3;
		}

		if(find)
			break;
		
		l1 = l1.next;
		l2=t2;
	}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n1, n2, n3;
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		n3 = sc.nextInt();

		MyLinkedList l1 = new MyLinkedList();
		MyLinkedList l2 = new MyLinkedList();
		MyLinkedList l3 = new MyLinkedList();
		for (int i = 0; i < n1; i++) {

			l1.addAtLast(sc.nextInt());

		}
		for (int i = 0; i < n2; i++) {

			l2.addAtLast(sc.nextInt());

		}
		for (int i = 0; i < n3; i++) {

			l3.addAtLast(sc.nextInt());

		}
		int target = sc.nextInt();
		sum(l1.head, l2.head, l3.head, target);
		sc.close();

	}

}
