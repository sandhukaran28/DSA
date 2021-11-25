package binary_tree;

public class Minimum_Distance_Between_Two_Nodes {

	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	int findDist(Node root, int a, int b) {
		Node Lca = lca(root, a, b);
		int left, right;
		if (root.data == a) {
			left = 0;
		} else {
			left = dist(Lca, a, 0);
		}
		if (root.data == b) {
			right = 0;
		} else {
			right = dist(Lca, b, 0);
		}

		return left + right;

	}

	int minDiv;

	int dist(Node root, int b, int dis) {

		if (root == null) {
			return dis - 1;
		}

		if (root.data == b) {
			return dis;
		}

		int left = dist(root.left, b, dis + 1);
		if (left > dis) {
			return left;
		}

		int right = dist(root.right, b, dis + 1);

		if (right > dis) {
			return right;
		}

		return dis - 1;

	}

	Node lca(Node root, int a, int b) {

		if (root == null) {
			return null;
		}

		if (root.data == a || root.data == b) {
			return root;
		}

		Node l = lca(root.left, a, b);
		Node r = lca(root.right, a, b);

		if (l != null && r != null) {

			return root;
		}
		if (l == null)
			return r;

		return l;
	}
}
