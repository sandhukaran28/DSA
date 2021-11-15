package binary_tree;

import binary_tree.PathSum.TreeNode;

public class Diameter {

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

	public int diameterOfBinaryTree(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int lh = maxDepth(root.left);
		int rh = maxDepth(root.right);

		int left = diameterOfBinaryTree(root.left);
		int right = diameterOfBinaryTree(root.right);

		int curr = lh + rh;
		return Math.max(curr, Math.max(left, right));

	}

}
