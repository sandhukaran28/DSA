package binary_search_tree;

public class BST_to_GST {

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

	public TreeNode bstToGst(TreeNode root) {

		sum(root, 0);
		return root;
	}

	public int sum(TreeNode root, int cSum) {

		if (root == null) {
			return cSum;
		}

		int r = sum(root.right, cSum);
		cSum = r + root.val;
		root.val = cSum;
		int left = sum(root.left, cSum);
		return left;

	}
}
