package tree_assignmet;

import java.util.Arrays;
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

		public void replace(Node root) {
			
			replaceLarge(root, 0);
			this.display(root);

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
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		bst.construct(arr);
		bst.replace(bst.root);

		sc.close();
	}

}
