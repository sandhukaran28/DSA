package trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	public class Node {

		char val;
		int cnt;
		Map<Character, Node> children;
		boolean isMarked;

		public Node(char val) {
			this.cnt = 1;
			this.val = val;
			children = new HashMap<>();
		}
	}

	Node root;

	public Trie() {

		root = new Node('*');
	}

	public void insert(String word) {

		Node curr = root;

		for (char cc : word.toCharArray()) {

			if (!curr.children.containsKey(cc)) {

				Node nn = new Node(cc);
				curr.children.put(cc, nn);
				curr = nn;
			} else {
				curr.cnt++;
				curr = curr.children.get(cc);

			}
		}

		curr.isMarked = true;

	}

	public boolean find(String word) {

		Node curr = root;

		for (char cc : word.toCharArray()) {

			if (curr.children.containsKey(cc)) {

				curr = curr.children.get(cc);
			} else {
				return false;
			}
		}

		return curr.isMarked;
	}

	public boolean startsWith(String word) {

		Node curr = root;

		for (char cc : word.toCharArray()) {

			if (curr.children.containsKey(cc)) {

				curr = curr.children.get(cc);
			} else {
				return false;
			}
		}

		return true;
	}

	public void delete(String word) {

		if (!this.find(word)) {
			return;
		}

		Node curr = root;

		for (char cc : word.toCharArray()) {

			Node child = curr.children.get(cc);

			if (child.cnt == 1) {

				curr.children.remove(cc);
				break;

			} else {

				child.cnt--;
				curr = child;
			}
		}

	}

	public static void main(String[] args) {

		Trie t = new Trie();

		t.insert("karan");
		System.out.println(t.find("karan"));
		t.insert("karn");
		System.out.println(t.find("karn"));
		t.delete("karn");
		System.out.println(t.find("karn"));

	}

}
