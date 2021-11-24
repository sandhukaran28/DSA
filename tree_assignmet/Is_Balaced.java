package tree_assignmet;

import java.util.Scanner;

public class Is_Balaced {

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

		class Pair {
			int ht;
			boolean bal;

			public Pair(int ht, boolean bal) {
				this.ht = ht;
				this.bal = bal;
			}

		}

		public boolean isBalanced(Node root) {

			return bal(root).bal;
		}

		public Pair bal(Node root) {
			if (root == null) {
				return new Pair(0,true);
			}

			Pair left = bal(root.left);
			Pair right = bal(root.right);

			int ht = left.ht >= right.ht ? left.ht : right.ht;

			Pair res = new Pair(ht+1,Math.abs(left.ht - right.ht)<=1 && left.bal && right.bal);

			return res;
		}
	}

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();
		System.out.println(bt.isBalanced(bt.root));
	}

}
