package binary_tree;

public class Insufficient_Nodes {

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

	public TreeNode sufficientSubset(TreeNode root, int limit) {

		if (!path(root, 0, limit)) {

			return null;
		}
		return root;

	}

	public boolean path(TreeNode root, int cSum, int limit) {

		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null) {

			if (cSum + root.val < limit) {
				return false;
			}
			return true;

		}

		boolean left = path(root.left, cSum + root.val, limit);
		boolean right = path(root.right, cSum + root.val, limit);

		if (left == false) {
			root.left = null;
		}
		if (right == false) {
			root.right = null;
		}

		return left || right;

	}

}
