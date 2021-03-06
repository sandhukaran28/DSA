package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Right_Side_View {
	public static Scanner sc = new Scanner(System.in);

	public static class BinaryTree {

		private class Node {

			int val;
			Node left;
			Node right;

			public Node(int val) {

				this.val = val;
			}
		}

		public Node root;

		public BinaryTree() {

			root = lvlOrderConstruct();
		}

		public Node lvlOrderConstruct() {

			int val = sc.nextInt();
			if (val == -1) {
				return null;
			}
			Node root = new Node(val);

			Queue<Node> q = new LinkedList<>();

			q.add(root);

			while (!q.isEmpty()) {

				Node curr = q.remove();
				int left = sc.nextInt();
				if (left != -1) {
					Node nl = new Node(left);
					curr.left = nl;
					q.add(nl);
				}

				int right = sc.nextInt();
				if (right != -1) {
					Node nr = new Node(right);
					curr.right = nr;
					q.add(nr);
				}
			}
			return root;

		}

		public List<Integer> rightSideView(Node root) {
			List<Integer> ans = new ArrayList<>();

			if (root == null) {
				return ans;
			}

			Queue<Node> q = new LinkedList<>();

			q.add(root);
			q.add(null);

			while (!q.isEmpty()) {

				Node front = q.remove();

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

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();
		List<Integer> l = bt.rightSideView(bt.root);
		for (int i = 0; i < l.size(); i++) {
			System.out.print(l.get(i) + " ");
		}
	}

}
