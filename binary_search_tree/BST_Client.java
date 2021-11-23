package binary_search_tree;

public class BST_Client {

	public static void main(String[] args) {

		BST bst = new BST();

		int arr[] = { 10, 20, 25, 30, 35, 40, 45 };

		bst.construct(arr);
//		bst.display(bst.root);
		bst.InOrder(bst.root);
		System.out.println();
		System.out.println(bst.max(bst.root));
		System.out.println(bst.min(bst.root));
	}

}
