package dp;

import java.util.HashMap;

public class HouseRobber_III {

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

	public int rob(TreeNode root) {
		HashMap<TreeNode, Integer> dp = new HashMap<>();
		return sol(root, dp);

	}

	public int sol(TreeNode root, HashMap<TreeNode, Integer> dp) {

		if (root == null) {

			return 0;
		}

		if (dp.containsKey(root)) {

			return dp.get(root);
		}

		int c1 = 0;
		int c2 = root.val;

		c1 = sol(root.left, dp) + sol(root.right, dp);

		if (root.left != null) {
			c2 += sol(root.left.left, dp) + sol(root.left.right, dp);
		}

		if (root.right != null) {

			c2 += sol(root.right.left, dp) + sol(root.right.right, dp);
		}

		int res = Math.max(c1, c2);
		dp.put(root, res);
		return res;
	}

}
