package binary_search_tree;

public class Search_In_BST {

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

	public TreeNode searchBST(TreeNode root, int val) {

		if (root == null) {
			return null;
		}

		if (val < root.val) {
			return searchBST(root.left, val);
		} else if (val > root.val) {

			return searchBST(root.right, val);
		} else {
			return root;
		}
	}
}
