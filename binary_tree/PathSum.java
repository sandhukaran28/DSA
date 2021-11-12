package binary_tree;

public class PathSum {

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

	public boolean pathSum(TreeNode root, int tSum, int cSum) {

		if (root == null) {

			return false;
		}

		if (root.left == null && root.right == null) {

			if (cSum + root.val == tSum) {

				return true;
			}
		}

		boolean lA = pathSum(root.left, tSum, cSum + root.val);
		boolean rA = pathSum(root.right, tSum, cSum + root.val);

		return lA || rA;
	}

	public boolean hasPathSum(TreeNode root, int targetSum) {

		return pathSum(root, targetSum, 0);

	}

}
