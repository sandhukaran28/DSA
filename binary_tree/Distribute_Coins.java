package binary_tree;

public class Distribute_Coins {

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

	int moves;

	public int distributeCoins(TreeNode root) {
		moves = 0;
		cnt(root);
		return moves;

	}

	public int cnt(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int left = cnt(root.left);
		int right = cnt(root.right);

		moves += Math.abs(left) + Math.abs(right);

		return (root.val + left + right - 1);

	}
}
