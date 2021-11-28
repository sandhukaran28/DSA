package tree_assignmet;

import java.util.Scanner;

public class Create_Tree {

	public static Scanner sc = new Scanner(System.in);

	public static class BinaryTree {

		private class Node {

			int val;
			Node left;
			Node right;

			public Node(int val) {

				this.val = val;
			}
		}

		public Node root;

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
				str += "END";
			}

			str += " => " + root.val + " <= ";
			if (root.right != null) {

				str += root.right.val;
			} else {
				str += "END";
			}

			System.out.println(str);

			display(root.left);
			display(root.right);

		}

		public void input(int post[], int in[]) {

			Node root = new Node(post[post.length - 1]);

		}

	}

	public static void main(String[] args) {

		int n = sc.nextInt();
		int post[] = new int[n];
		int in[] = new int[n];

		for (int i = 0; i < n; i++) {
			post[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			in[i] = sc.nextInt();
		}

		BinaryTree bt = new BinaryTree();
		bt.input(post, in);
	}
}
