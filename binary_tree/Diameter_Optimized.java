package binary_tree;

public class Diameter_Optimized {

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
		int dia;

		public Pair(int ht, int dia) {

			this.ht = ht;
			this.dia = dia;
		}
	}

	public int diameterOfBinaryTree(TreeNode root) {

		return diameter(root).dia;
	}

	public Pair diameter(TreeNode root) {

		if (root == null) {

			return new Pair(0, 0);
		}

		Pair left = diameter(root.left);
		Pair right = diameter(root.right);

		int height = Math.max(left.ht, right.ht);

		int dia = Math.max(left.ht + right.ht, Math.max(left.dia, right.dia));

		return new Pair(height + 1, dia);
	}

}
