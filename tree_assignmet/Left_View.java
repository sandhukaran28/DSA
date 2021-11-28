package tree_assignmet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Left_View {

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

			root = construct();
		}

		public Node construct() {

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
					Node nn = new Node(left);
					curr.left = nn;
					q.add(nn);
				}
				int right = sc.nextInt();
				if (right != -1) {
					Node nn = new Node(right);
					curr.right = nn;
					q.add(nn);
				}

			}
			return root;
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

		public List<Integer> leftView(Node root) {

			 ArrayList<Integer> res = new ArrayList<>();
	           
	           if (root == null) {
					return res;
				}
				Queue<Node> q = new LinkedList<>();
				q.add(root);

				while (!q.isEmpty()) {

				res.add(q.peek().val);

					int n = q.size();

					for (int i = 0; i < n; i++) {
						Node curr = q.remove();

						if (curr.left != null)
							q.add(curr.left);

						if (curr.right != null) {
							q.add(curr.right);
						}

					}
				}
	            
	            return res;
	            
		}

	}

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();
		List<Integer>  l=  bt.leftView(bt.root);
		for(int i=0;i<l.size();i++) {
			System.out.print(l.get(i)+" ");
		}
	}

}
