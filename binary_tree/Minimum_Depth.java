package binary_tree;

public class Minimum_Depth {

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

	public int minDepth(TreeNode root) {

		int ans = depth(root);
		return ans == Integer.MAX_VALUE ? 0 : ans;
	}

	public int depth(TreeNode root) {

		if (root == null) {

			return Integer.MAX_VALUE;
		}

		if (root.left == null && root.right == null) {

			return 1;
		}

		int left = depth(root.left);
		int right = depth(root.right);

		return Math.min(left, right) + 1;

	}
}
