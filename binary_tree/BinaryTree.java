package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

	private class Node {

		int val;
		Node left;
		Node right;

		public Node(int val) {

			this.val = val;
		}
	}

	public Node root;
	private Scanner sc = new Scanner(System.in);

	public BinaryTree() {

		root = construct();
	}

	private Node construct() {

		int val = sc.nextInt();

		if (val == -1) {
			return null;
		}

		Node nn = new Node(val);

		nn.left = construct();

		nn.right = construct();

		return nn;

	}

	public void display() {

		display(root);

	}

	private void display(Node root) {

		if (root == null) {
			return;
		}

		String str = "";

		if (root.left != null) {

			str += root.left.val;

		} else {
			str += '_';
		}

		str += "->" + root.val + "<-";
		if (root.right != null) {

			str += root.right.val;
		} else {
			str += '_';
		}

		System.out.println(str);

		display(root.left);
		display(root.right);

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

		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}

	public void postOrder(Node root) {

		if (root == null) {
			return;
		}

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val + " ");
	}

	public int totalNodes(Node root) {

		if (root == null) {
			return 0;
		}
		int left = 0, right = 0;
		if (root.left != null) {
			left = totalNodes(root.left);
		}
		if (root.right != null) {

			right = totalNodes(root.right);
		}

		return left + right + 1;

	}

	public void lvlOrderLineWise() {
		// TODO Auto-generated method stub

		lvlOrderLineWise(root);
	}

	private void lvlOrderLineWise(Node root) {
		// TODO Auto-generated method stub

		List<List<Integer>> ans = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();

		List<Integer> lvlList = new ArrayList<>();
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			Node front = q.remove();
			if (front == null) {

				if (!q.isEmpty()) {

					q.add(null);
				}

				ans.add(lvlList);
				lvlList = new ArrayList<>();
			} else {
				// System.out.print(front.val + " ");
				lvlList.add(front.val);
				if (front.left != null) {
					q.add(front.left);
				}

				if (front.right != null) {
					q.add(front.right);
				}
			}
		}

		System.out.println(ans);
	}

}
