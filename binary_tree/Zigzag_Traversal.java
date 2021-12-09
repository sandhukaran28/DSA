package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Zigzag_Traversal {

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

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		int lvl = 1;
		List<Integer> currL = new ArrayList<>();
		while (!q.isEmpty()) {

			if (q.peek() == null) {

				q.remove();
				ans.add(currL);
				currL = new ArrayList<>();
				if (!q.isEmpty()) {

					q.add(null);
				}
				lvl++;
				continue;

			}

			Stack<TreeNode> st = new Stack<>();

			while (!q.isEmpty() && q.peek() != null) {

				TreeNode curr = q.remove();
				st.push(curr);
			}

			while (!st.isEmpty()) {

				TreeNode curr = st.pop();
				currL.add(curr.val);

				if (lvl % 2 != 0) {
					if (curr.left != null) {
						q.add(curr.left);
					}
					if (curr.right != null) {
						q.add(curr.right);
					}
				} else {

					if (curr.right != null) {
						q.add(curr.right);
					}
					if (curr.left != null) {
						q.add(curr.left);

					}
				}

			}
		}

		return ans;

	}

}
