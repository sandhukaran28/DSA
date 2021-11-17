package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Left_Side_View {

	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	ArrayList<Integer> leftView(Node root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<Node> q = new LinkedList<>();

		q.add(root);

		while (!q.isEmpty()) {

			int n = q.size();
			res.add(q.peek().data);

			for (int i = 0; i < n; i++) {

				Node nn = q.remove();
				if (nn.left != null) {
					q.add(nn.left);
				}
				if (nn.right != null) {
					q.add(nn.right);
				}
			}
		}

		return res;

	}
}
