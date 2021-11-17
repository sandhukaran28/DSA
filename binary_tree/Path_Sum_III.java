package binary_tree;

public class Path_Sum_III {

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

	int cnt;

	public int pathSum(TreeNode root, int targetSum) {
		cnt = 0;
		sum(root, targetSum);
		return cnt;
	}

	public void sum(TreeNode root, int tSum) {

		if (root == null) {
			return;
		}

		pathSum3(root, 0, tSum);
		sum(root.left, tSum);
		sum(root.right, tSum);

	}

	public void pathSum3(TreeNode root, int cSum, int tSum) {

		if (root == null) {
			return;
		}
		cSum += root.val;

		if (cSum == tSum) {
			cnt++;
		}

		pathSum3(root.left, cSum, tSum);
		pathSum3(root.right, cSum, tSum);

	}

}
