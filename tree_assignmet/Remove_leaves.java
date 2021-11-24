package tree_assignmet;

import java.util.Scanner;

import tree_assignmet.Is_Balaced.BinaryTree.Node;
import tree_assignmet.Is_Balaced.BinaryTree.Pair;

public class Remove_leaves {
	

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

		public void removeLeaf(Node root) {
			
			if(root == null || (root.left == null && root.right == null)) {
				this.display(null);
			}
			
			remove(root);
			this.display(root);
			
		}
		
		private boolean remove(Node root) {
			
			if(root == null) {
				return true;
			}
			
			if(root.left == null && root.right ==null) {
				return true;
			}
			boolean left = remove(root.left);
			boolean right = remove(root.right);
			return true;
		}
	
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
