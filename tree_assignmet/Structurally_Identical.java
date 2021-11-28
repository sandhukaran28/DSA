package tree_assignmet;

import java.util.Scanner;

public class Structurally_Identical {

	public static Scanner sc = new Scanner(System.in);

	public static class BinaryTree {

		public class Node {

			int val;
			Node left;
			Node right;

			public Node(int val) {

				this.val = val;
			}
		}

		public Node root;

		public BinaryTree() {

			root = construct();
		}

		public Node construct() {

			int val = sc.nextInt();

			Node nn = new Node(val);
			boolean left = sc.nextBoolean();
			if (left) {
				nn.left = construct();
			} else {
				nn.left = null;
			}
			boolean right = sc.nextBoolean();
			if (right) {
				nn.right = construct();
			} else {
				nn.right = null;
			}

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

		public boolean identical(Node t1, Node t2) {

			if (t1 == null && t2 == null) {
				return true;
			}

			if (t1 == null || t2 == null) {

				return false;
			}

			boolean left = identical(t1.left, t2.left);
			boolean right = identical(t1.right, t2.right);

			return left && right;
		}

	}

	public static void main(String[] args) {

		BinaryTree t1 = new BinaryTree();
		BinaryTree t2 = new BinaryTree();

		System.out.println(t1.identical(t1.root, t2.root));

	}

}
