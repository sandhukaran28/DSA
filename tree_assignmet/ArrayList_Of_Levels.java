package tree_assignmet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ArrayList_Of_Levels {

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

		public List<List<Integer>> lvlOrder(Node root) {

			List<List<Integer>> ans = new ArrayList<>();
			if (root == null)
				return ans;
			List<Integer> currL = new ArrayList<>(); 
			Queue<Node> q = new LinkedList<>();
			q.add(root);
			q.add(null);

			while (!q.isEmpty()) {

				Node curr = q.remove();

				if (curr == null) {

					ans.add(currL);
					currL =new ArrayList<>();
					if (!q.isEmpty()) {
						q.add(null);
					}
					continue;
				}

				currL.add(curr.val);
				if (curr.left != null)
					q.add(curr.left);
				if (curr.right != null)
					q.add(curr.right);

			}
			
			return ans;
		}

	}

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();
		
		List<List<Integer>> al = bt.lvlOrder(bt.root);
		
		System.out.println(al);
		}
	

}
