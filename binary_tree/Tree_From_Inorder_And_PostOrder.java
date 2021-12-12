package binary_tree;

public class Tree_From_Inorder_And_PostOrder {

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

	public int find(int arr[], int k) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == k) {

				return i;
			}
		}

		return -1;
	}

	int k = 0;

	public TreeNode buildTree(int[] in, int[] post) {
		k = post.length - 1;
		return sol(in, post, 0, in.length - 1);
	}

	public TreeNode sol(int[] in, int[] post, int i, int j) {

		if (k < 0 || i > j) {
			return null;
		}

		TreeNode root = new TreeNode(post[k--]);
		int idx = find(in, root.val);

		root.right = sol(in, post, idx + 1, j);
		root.left = sol(in, post, i, idx - 1);

		return root;

	}

}
