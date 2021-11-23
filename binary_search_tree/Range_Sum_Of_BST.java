package binary_search_tree;

public class Range_Sum_Of_BST {

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

	int sum;

	public int rangeSumBST(TreeNode root, int low, int high) {

		sum = 0;
		sumAdd(root, low, high);
		return sum;
	}

	public void sumAdd(TreeNode root, int low, int high) {

		if (root == null) {
			return;
		}

		if (root.val < low) {

			sumAdd(root.right, low, high);
		} else if (root.val > high) {

			sumAdd(root.left, low, high);
		} else {

			sum += root.val;
			sumAdd(root.left, low, high);
			sumAdd(root.right, low, high);
		}

	}
}
