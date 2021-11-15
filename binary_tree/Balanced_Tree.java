package binary_tree;

public class Balanced_Tree {

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

	public int maxDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		return Math.max(left, right) + 1;
	}

	public boolean isBalanced(TreeNode root) {

		if (root == null) {
			return true;
		}

		int lh = maxDepth(root.left);
		int rh = maxDepth(root.right);

		boolean bal = Math.abs(lh - rh) <= 1;

		return bal && isBalanced(root.left) && isBalanced(root.right);

	}
}
