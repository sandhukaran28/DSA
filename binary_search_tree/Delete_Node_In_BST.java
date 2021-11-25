package binary_search_tree;

public class Delete_Node_In_BST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public TreeNode leftMost(TreeNode root) {

		while (root.left != null) {

			root = root.left;
		}

		return root;
	}

	public TreeNode deleteNode(TreeNode root, int key) {

		if (root == null) {
			return null;
		}

		if (key < root.val) {

			root.left = deleteNode(root.left, key);
		} else if (key > root.val) {

			root.right = deleteNode(root.right, key);
		} else {

			if (root.left == null && root.right == null) {

				return null;
			}

			if (root.left == null) {

				return root.right;

			}
			if (root.right == null) {

				return root.left;
			}

			TreeNode min = leftMost(root.right);
			root.val = min.val;

			root.right = deleteNode(root.right, min.val);

		}
		return root;
	}
}
