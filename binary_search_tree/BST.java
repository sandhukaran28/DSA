package binary_search_tree;

public class BST {

	private class Node {

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

	public void InOrder(Node root) {

		if (root == null) {
			return;
		}

		InOrder(root.left);
		System.out.print(root.val + " ");
		InOrder(root.right);
	}

	public int max(Node root) {

		if (root == null) {
			return -1;
		}

		while (root.right != null) {

			root = root.right;
		}

		return root.val;
	}

	public int min(Node root) {

		if (root == null) {
			return -1;
		}

		while (root.left != null) {
			root = root.left;
		}

		return root.val;
	}
}
