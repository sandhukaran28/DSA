package binary_tree;

import java.util.Scanner;

public class Create_Tree_Pre_In {

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
		public int find(int arr[],int n,int l, int r) {
			
			for(int i=l;i<=r;i++) {
				if(arr[i] == n) {
					return i;
				}
			}
			return 0;
		}
		
		int preS = 0;
		
		public Node construct(int in[], int pre[], int inS,int inE) {
			
			if(inS > inE) {
				
				return null;
			}
			
			Node nn = new Node(pre[preS++]);
			
			if(inS == inE) {
				return nn;
			}
			
			int idx= this.find(in, nn.val,inS,inE);
			nn.left = construct(in,pre, inS, idx-1);
			nn.right = construct(in,pre, idx+1, inE);
			
			return nn;
		}
		
	}

		public static void main(String[] args) {

			int n = sc.nextInt();
			int pre[] = new int[n];

			for (int i = 0; i < n; i++) {

				pre[i] = sc.nextInt();
			}
			
			n =sc.nextInt();
 
			int in[] = new int[n];

			for (int i = 0; i < n; i++) {

				in[i] = sc.nextInt();
			}
			
			 BinaryTree bt =new BinaryTree();
			 bt.preS =0;
			bt.root = bt.construct(in, pre, 0, in.length-1);
			bt.display();
		}

	}
