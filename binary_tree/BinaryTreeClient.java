package binary_tree;

public class BinaryTreeClient {

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();

//		bt.preOrder(bt.root);
//		System.out.println();
//		bt.inOrder(bt.root);
//		System.out.println();
//		bt.postOrder(bt.root);
//		System.out.println(bt.totalNodes(bt.root));

		bt.preOrderInterative(bt.root);
	}

}
