package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Right_Side_View {

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

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ans = new ArrayList<>();

		if (root == null) {
			return ans;
		}

		Queue<TreeNode> q = new LinkedList<>();

		q.add(root);
		q.add(null);

		while (!q.isEmpty()) {

			TreeNode front = q.remove();

			if (front == null) {

				if (!q.isEmpty()) {
					q.add(null);
				}
			} else {

				if (q.peek() != null) {

					if (front.left != null) {

						q.add(front.left);
					}
				} else {
					ans.add(front.val);
				}

				if (front.left != null) {

					q.add(front.left);
				}
				if (front.right != null) {

					q.add(front.right);
				}
			}
		}
		return ans;

	}

}
