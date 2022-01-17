package revision;

public class BT_Path_Sum {

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

	public boolean hasPathSum(TreeNode root, int tSum) {

		if (root == null) {

			return false;
		}

		if (root.left == null && root.right == null) {

			return tSum - root.val == 0;
		}

		boolean left = hasPathSum(root.left, tSum - root.val);
		boolean right = hasPathSum(root.right, tSum - root.val);

		return left || right;
	}
}
