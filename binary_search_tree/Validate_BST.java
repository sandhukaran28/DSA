package binary_search_tree;

public class Validate_BST {

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

	public boolean isValidBST(TreeNode root) {

		return inRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean inRange(TreeNode root, long l, long r) {

		if (root == null) {
			return true;
		}

		if (root.val <= l || root.val >= r) {

			return false;

		}

		boolean left = inRange(root.left, l, root.val);
		boolean right = inRange(root.right, root.val, r);

		return left && right;

	}
}
