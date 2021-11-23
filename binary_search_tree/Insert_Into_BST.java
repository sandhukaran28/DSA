package binary_search_tree;

public class Insert_Into_BST {

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

	public TreeNode insertIntoBST(TreeNode root, int val) {

		if (root == null) {
			TreeNode nn = new TreeNode(val);
			return nn;
		}
		insert(root, val);
		return root;
	}

	public void insert(TreeNode root, int val) {

		if (val < root.val) {

			if (root.left != null) {

				insert(root.left, val);
			} else {

				TreeNode nn = new TreeNode(val);
				root.left = nn;
				return;

			}

		} else if (val > root.val) {

			if (root.right != null) {

				insert(root.right, val);
			} else {

				TreeNode nn = new TreeNode(val);
				root.right = nn;
				return;

			}

		}

	}
}
