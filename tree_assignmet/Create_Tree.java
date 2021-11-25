package tree_assignmet;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Create_Tree {

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

		public void display() {

			display(root);

		}

		private void display(Node root) {

			if (root == null) {
				return;
			}

			String str = "";

			if (root.left != null) {

				str += root.left.val;

			} else {
				str += "END";
			}

			str += " => " + root.val + " <= ";
			if (root.right != null) {

				str += root.right.val;
			} else {
				str += "END";
			}

			System.out.println(str);

			display(root.left);
			display(root.right);

		}

		public void input(int post[], int in[]) {

			int left = post[0];
			int right = post[1];
			int val = post[2];

			Node root = new Node(val);
			Node lN = new Node(left);
			Node rN = new Node(right);
			Queue<Node> q = new LinkedList<>();
			root.left = lN;
			root.right = rN;
			q.add(lN);
			q.add(rN);

			for (int i = 3; i < post.length; i += 2) {

				Node curr = null;
				if (!q.isEmpty()) {

					curr = q.remove();
				}
				if (curr != null) {
					Node nl = new Node(post[i]);
					curr.left = nl;
					q.add(nl);
					if (i + 1 < post.length) {

						Node nr = new Node(post[i+1]);
						curr.right = nr;
						q.add(nr);
					}
				}

			}
			
			this.root = root;
			this.display();

		}

	}

	public static void main(String[] args) {

		int n = sc.nextInt();
		int post[] = new int[n];
		int in[] = new int[n];

		for (int i = 0; i < n; i++) {
			post[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			in[i] = sc.nextInt();
		}

		BinaryTree bt = new BinaryTree();
		bt.input(post, in);
	}
}
