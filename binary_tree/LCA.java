package binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LCA {
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
		

		public BinaryTree() {

			root = construct();
		}

		public Node construct() {

			int val = sc.nextInt();

			Node nn = new Node(val);
			boolean left = sc.nextBoolean();
			if(left) {
			nn.left = construct();
			}
			else {
				nn.left = null;
			}
			boolean right = sc.nextBoolean();
			if(right) {
			nn.right = construct();
			}
			else {
				nn.right =null;
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
	

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();

	}
	
	}
}
