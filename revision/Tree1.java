package revision;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tree1 {

	public class Node {

		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
		}
	}

	private Scanner sc = new Scanner(System.in);

	Node root;

	public Tree1() {

		root = construct();
	}

	public Node construct() {

		int val = sc.nextInt();

		if (val == -1) {
			return null;
		}

		Node nn = new Node(val);
		nn.left = construct();
		nn.right = construct();

		return nn;

	}

	public void preOrder(Node root) {

		if (root == null) {

			return;
		}

		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public void inOrder(Node root) {

		if (root == null) {

			return;
		}

		preOrder(root.left);
		System.out.print(root.val + " ");
		preOrder(root.right);
	}

	public void postOrder(Node root) {

		if (root == null) {

			return;
		}

		preOrder(root.left);

		preOrder(root.right);
		System.out.print(root.val + " ");
	}

	public void lvlOrder(Node root) {
		
		if(root == null) {
			return;
		}
		Queue<Node> q = new LinkedList<>();
		
		q.add(root);
		
		while(!q.isEmpty()) {
			
		Node front = q.remove();
		System.out.println(front.val);
		
		if(front.left !=  null) {
			
			q.add(front.left);
		}
		
		if(front.right != null) {
			
			q.add(front.right);
		}
		

		}
	}
	
	public static void main(String[] args) {
		Tree1 t = new Tree1();
		t.preOrder(t.root);
		System.out.println();
		t.inOrder(t.root);
		System.out.println();
		t.postOrder(t.root);
		System.out.println();
		t.lvlOrder(t.root);
	}

}
