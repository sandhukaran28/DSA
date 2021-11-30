package tree_assignmet;

import java.util.Scanner;


public class Replace_With_Sum {

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
		public void replace(Node root) {
			
			replaceLarge(root, 0);
			this.display(root);

		}
		public Node addToBST(Node root, int val) {
			
			if(root == null) {
				
				return new Node(val);
			}
		
			
			if(val <= root.val) {
				
				root.left = addToBST(root.left, val);
		
			}
			else {
				
				root.right = addToBST(root.right, val);
			}
			return root;
		}

		public int replaceLarge(Node root, int sum) {

			if (root == null) {
				return sum;
				}

				int right = replaceLarge(root.right, sum);
				int temp = root.val;
				root.val = right;
				sum  = temp + right;
				int left = replaceLarge(root.left, sum);

				return left;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		BST bst = new BST();
		int n = sc.nextInt();
		n--;
		int val = sc.nextInt();
	     bst.root = bst.addToBST(null, val);
	     while(n-->0) {
	    	 
	    	 val = sc.nextInt();
	    	 bst.addToBST(bst.root, val);   	 
	     }
	     	bst.replace(bst.root);
		sc.close();
	}

}
