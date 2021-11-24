package tree_assignmet;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Print_All_Leaf {

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
		
		public void print(Node root) {
			
			if(root == null) {
				return;
			}
			if(root.left ==null && root.right ==null) {
				System.out.print(root.val+" ");
			}
			print(root.left);
			print(root.right);
		}

	}
	
	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		bt.print(bt.root);
	}

}
