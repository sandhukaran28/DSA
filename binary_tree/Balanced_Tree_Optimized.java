package binary_tree;

public class Balanced_Tree_Optimized {

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

	public class Pair {

		int ht;
		boolean bal;

		public Pair(int ht, boolean bal) {

			this.ht = ht;
			this.bal = bal;
		}
	}

	public boolean isBalanced(TreeNode root) {

		return balanced(root).bal;

	}

	public Pair balanced(TreeNode root) {

		if (root == null) {
			return new Pair(0, true);
		}

		Pair left = balanced(root.left);
		Pair right = balanced(root.right);

		int height = Math.max(left.ht, right.ht) + 1;
		boolean bal = left.bal && right.bal && Math.abs(left.ht - right.ht) <= 1;
		return new Pair(height, bal);
	}

}
