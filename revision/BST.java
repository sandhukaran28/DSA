package revision;

import java.util.Arrays;
import java.util.Scanner;

public class BST {

	public class Node {
		int val;
		Node left;
		Node right;

		public Node(int val) {

			this.val = val;
		}
	}

	Node root;

	public BST(int[] arr) {

		root = construct(arr, 0, arr.length - 1);
	}

	public Node construct(int[] arr, int l, int r) {

		if (l <= r) {
			
			int mid = (l + r) / 2;

			Node nn = new Node(arr[mid]);
			nn.left = construct(arr, l, mid - 1);
			nn.right = construct(arr, mid + 1, r);

			return nn;
		}

		return null;

	}

	public void inOrder(Node root) {

		if (root == null) {

			return;
		}

		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}
	
	public int max(Node root) {
		
			if(root == null) {
				return 0;
			}
			
			if(root.right == null) {
				
				return root.val;
			}
			
			return max(root.right);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {

			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		BST bst = new BST(arr);
		bst.inOrder(bst.root);
		System.out.println();
		System.out.println(bst.max(bst.root));
		sc.close();
	}

}
