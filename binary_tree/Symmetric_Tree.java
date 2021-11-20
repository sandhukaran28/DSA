package binary_tree;

public class Symmetric_Tree {

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

	public boolean isSymmetric(TreeNode root) {

		return sym(root.left, root.right);
	}

	public boolean sym(TreeNode left, TreeNode right) {

		if (left == null && right == null) {

			return true;
		} else if (left == null && right != null || left != null && right == null) {
			return false;
		}

		if (left.val != right.val) {

			return false;
		}

		boolean Lsym = sym(left.left, right.right);
		boolean Rsym = sym(left.right, right.left);

		return Lsym && Rsym;
	}
}
