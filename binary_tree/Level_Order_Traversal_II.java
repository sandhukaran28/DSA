package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Level_Order_Traversal_II {

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

	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) {

			return ans;
		}
		Stack<Integer> st = new Stack<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		while (!q.isEmpty()) {

			TreeNode curr = q.remove();

			if (curr == null) {

				if (!q.isEmpty()) {

					q.add(null);
					st.push(null);
				}
				continue;
			}

			st.push(curr.val);
			if (curr.right != null) {

				q.add(curr.right);
			}
			if (curr.left != null) {

				q.add(curr.left);
			}

		}

		List<Integer> curr = new ArrayList<>();

		while (!st.isEmpty()) {

			if (!st.isEmpty() && st.peek() == null) {

				st.pop();
				ans.add(curr);
				curr = new ArrayList<>();
				continue;
			}

			curr.add(st.pop());
		}
		ans.add(curr);
		return ans;
	}

}
