package binary_tree;

public class Sum_Root_To_Leaf {

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

	public int ans;

	public int sumNumbers(TreeNode root) {

		ans = 0;
		number(root, 0);
		return ans;
	}

	public void number(TreeNode root, int num) {

		if (root == null) {

			return;
		}

		int n = (num * 10) + root.val;
		if (root.left == null && root.right == null) {

			ans += n;
			return;
		}

		number(root.left, n);
		number(root.right, n);

	}
}
