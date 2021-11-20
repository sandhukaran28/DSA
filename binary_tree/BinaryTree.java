package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {

	private class Node {

		int val;
		Node left;
		Node right;

		public Node(int val) {

			this.val = val;
		}
	}
	
	private class Quad{
		
		Node curr;
		boolean isSelfDone;
		boolean isLeftDone;
		boolean isRightDone;
		
		public Quad(Node nn) {
			
			curr = nn;
		}
		
	}

	public Node root;
	private Scanner sc = new Scanner(System.in);

	public BinaryTree() {

		root = construct();
	}

	private Node construct() {

		int val = sc.nextInt();

		if (val == -1) {
			return null;
		}

		Node nn = new Node(val);

		nn.left = construct();

		nn.right = construct();

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

	public void preOrder(Node root) {

		if (root == null) {
			return;
		}

		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public void inOrder(Node root) {

		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}

	public void postOrder(Node root) {

		if (root == null) {
			return;
		}

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val + " ");
	}

	public int totalNodes(Node root) {

		if (root == null) {
			return 0;
		}
		int left = 0, right = 0;
		if (root.left != null) {
			left = totalNodes(root.left);
		}
		if (root.right != null) {

			right = totalNodes(root.right);
		}

		return left + right + 1;

	}

	public void lvlOrderLineWise() {
		// TODO Auto-generated method stub

		lvlOrderLineWise(root);
	}

	private void lvlOrderLineWise(Node root) {
		// TODO Auto-generated method stub

		List<List<Integer>> ans = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();

		List<Integer> lvlList = new ArrayList<>();
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			Node front = q.remove();
			if (front == null) {

				if (!q.isEmpty()) {

					q.add(null);
				}

				ans.add(lvlList);
				lvlList = new ArrayList<>();
			} else {
				// System.out.print(front.val + " ");
				lvlList.add(front.val);
				if (front.left != null) {
					q.add(front.left);
				}

				if (front.right != null) {
					q.add(front.right);
				}
			}
		}

		System.out.println(ans);
	}
	
	public void preOrderInterative(Node root) {
		
		if(this.root == null) {
			return;
		}
		Stack<Quad> st = new Stack<>();
		st.push(new Quad(root));
		
		while(!st.isEmpty()) {
			
			Quad top = st.peek();
			
			if(!top.isSelfDone) {
				System.out.print(top.curr.val);
				top.isSelfDone = true;
			}
			else if(!top.isLeftDone) {
				 if(top.curr.left!=null) {
					 st.push(new Quad(top.curr.left));
					 top.isLeftDone =true;
				 }
				 else {
					 top.isLeftDone = true;
				 }
			}
			else if(!top.isRightDone) {
				if(top.curr.right!=null) {
					st.push(new Quad(top.curr.right));
					top.isRightDone =true;
				}
				else {
					top.isRightDone = true;
				}
			}
			else {
				st.pop();
			}
			
		}
	}

}
