package tree_assignmet;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Zig_zag {

	public static Scanner sc = new Scanner(System.in);

	public static class BinaryTree {

		public class Node {

			int val;
			Node left;
			Node right;

			public Node(int val) {

				this.val = val;
			}
		}

		public Node root;

		public BinaryTree() {

			root = construct();
		}

		public Node construct() {

			int val = sc.nextInt();

			Node nn = new Node(val);
			boolean left = sc.nextBoolean();
			if (left) {
				nn.left = construct();
			} else {
				nn.left = null;
			}
			boolean right = sc.nextBoolean();
			if (right) {
				nn.right = construct();
			} else {
				nn.right = null;
			}

			return nn;

		}

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

		public void lvlOrder(Node root) {

			int lvl = 1;
			if (root == null)
				return;
			Deque<Node> q = new ArrayDeque<>();
			q.add(root);
			Node Null = new Node(-100);
			q.add(Null);

			while (!q.isEmpty()) {

				Node curr = q.removeFirst();

				if (curr.val == -100) {

					lvl++;
					if (!q.isEmpty()) {
						q.addLast(new Node(-100));
					}
					continue;
				}
				System.out.print(curr.val + " ");
				if (lvl % 2 == 0) {
					if (curr.left != null)
						q.addFirst(curr.left);
					if (curr.right != null)
						q.addFirst(curr.right);
				} else {
					
						if(!q.isEmpty() && q.peek().val == -100)
						{
							if (curr.right != null)
								q.addFirst(curr.right);
							if (curr.left != null)
								q.addFirst(curr.left);	
						}
						if (curr.right != null)
						q.addFirst(curr.right);
					if (curr.left != null)
						q.addFirst(curr.left);
				}

			}

		}

	}

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();

		bt.lvlOrder(bt.root);
	}

}
