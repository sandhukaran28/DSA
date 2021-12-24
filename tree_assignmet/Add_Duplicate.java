package tree_assignmet;

import java.util.Scanner;

public class Add_Duplicate {

	public static class BST {

		private static class Node {

			int val;
			Node left;
			Node right;

			public Node(int val) {

				this.val = val;
			}
		}

		public Node root;

		public void display(Node root) {

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

		public void construct(int[] arr) {

			this.root = construct(arr, 0, arr.length - 1);
		}

		private Node construct(int[] arr, int l, int r) {

			if (l <= r) {

				int mid = (l + r) / 2;

				Node nn = new Node(arr[mid]);
				nn.left = construct(arr, l, mid - 1);
				nn.right = construct(arr, mid + 1, r);

				return nn;
			}
			return null;

		}

		public Node addToBST(Node root, int val) {

			if (root == null) {

				return new Node(val);
			}

			if (val <= root.val) {

				root.left = addToBST(root.left, val);

			} else {

				root.right = addToBST(root.right, val);
			}
			return root;
		}

		public void duplicate(Node root) {

			if (root == null) {
				return;
			}

			Node left = root.left;

			Node dup = new Node(root.val);
			root.left = dup;
			dup.left = left;

			if (dup.left != null) {

				duplicate(root.left.left);
			}

			duplicate(root.right);
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		BST bst = new BST();
		int n = sc.nextInt();
		n--;
		int val = sc.nextInt();
		bst.root = bst.addToBST(null, val);
		bst.addToBST(bst.root, val);

		while (n-- > 0) {

			val = sc.nextInt();
			bst.addToBST(bst.root, val);
			bst.addToBST(bst.root, val);

		}

		bst.display(bst.root);
		sc.close();

	}

}
