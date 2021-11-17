package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class Path_Sum_II {

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

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

		List<List<Integer>> ans = new ArrayList<>();

		List<Integer> curr = new ArrayList<>();

		if (root == null) {

			return ans;
		}

		pathSum2(root, 0, targetSum, curr, ans);
		return ans;

	}

	public void pathSum2(TreeNode root, int cSum, int tSum, List<Integer> curr, List<List<Integer>> ans) {

		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {

			if (cSum + root.val == tSum) {
				curr.add(root.val);
				ans.add(new ArrayList<>(curr));
				curr.remove(curr.size() - 1);
			}

			return;

		}
		curr.add(root.val);
		pathSum2(root.left, cSum + root.val, tSum, curr, ans);
		pathSum2(root.right, cSum + root.val, tSum, curr, ans);
		curr.remove(curr.size() - 1);
	}

}
