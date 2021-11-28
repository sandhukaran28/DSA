package tree_assignmet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Print_Till_k {

	public static class BST {

		private class Node {

			int val;
			Node left;
			Node right;

			public Node(int val) {

				this.val = val;
			}
		}

		public Node root;

		public void display(Node root) {

			if (root == null) {
				return;
			}

			String str = "";

			if (root.left != null) {

				str += root.left.val;

			} else {
				str += '_';
			}

			str += "->" + root.val + "<-";
			if (root.right != null) {

				str += root.right.val;
			} else {
				str += '_';
			}

			System.out.println(str);

			display(root.left);
			display(root.right);

		}

		public void construct(int[] arr) {

			this.root = construct(arr, 0, arr.length - 1);
		}

		private Node construct(int[] arr, int l, int r) {

			if (l <= r) {

				int mid = (l + r) / 2;

				Node nn = new Node(arr[mid]);
				nn.left = construct(arr, l, mid - 1);
				nn.right = construct(arr, mid + 1, r);

				return nn;
			}
			return null;

		}

		public void tillK(Node root, Node curr, int node, int k, List<Integer> l) {

			if (curr == null) {
				return;
			}

			int res = findDist(root, curr.val, node);

			if (res == k) {
				l.add(curr.val);
			}

			tillK(root, curr.left, node, k, l);
			tillK(root, curr.right, node, k, l);

		}

		int findDist(Node root, int a, int b) {
			Node Lca = lca(root, a, b);
			int left, right;
			if (root.val == a) {
				left = 0;
			} else {
				left = dist(Lca, a, 0);
			}
			if (root.val == b) {
				right = 0;
			} else {
				right = dist(Lca, b, 0);
			}

			return left + right;

		}

		int dist(Node root, int b, int dis) {

			if (root == null) {
				return dis - 1;
			}

			if (root.val == b) {
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

			if (root.val == a || root.val == b) {
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

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {

			arr[i] = sc.nextInt();
		}

		int node = sc.nextInt();
		int k = sc.nextInt();

		BST bst = new BST();
		bst.construct(arr);
		List<Integer> l = new ArrayList<>();
		bst.tillK(bst.root, bst.root, node, k, l);
		Collections.sort(l);
		for (int i = 0; i < l.size(); i++) {

			System.out.println(l.get(i));
		}

		sc.close();

	}

}
