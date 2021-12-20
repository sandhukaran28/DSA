package binary_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Vertical_Level_Traversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	class Pair1 {

		TreeNode root;
		int vl;
		int hl;

		public Pair1(TreeNode root, int vl, int hl) {

			this.root = root;
			this.vl = vl;
			this.hl = hl;
		}
	}

	class Pair2 {

		int root;
		int hl;

		public Pair2(int root, int hl) {

			this.root = root;
			this.hl = hl;
		}
	}

	public List<List<Integer>> verticalTraversal(TreeNode root) {

		Queue<Pair1> q = new LinkedList<>();
		Map<Integer, List<Pair2>> map = new TreeMap<>();
		List<List<Integer>> ans = new ArrayList<>();
		q.add(new Pair1(root, 0, 0));

		while (!q.isEmpty()) {

			Pair1 pair = q.remove();
			TreeNode curr = pair.root;

			List<Pair2> l = map.getOrDefault(pair.vl, new ArrayList<>());
			l.add(new Pair2(curr.val, pair.hl));
			map.put(pair.vl, l);
			if (curr.left != null) {

				q.add(new Pair1(curr.left, pair.vl - 1, pair.hl + 1));
			}
			if (curr.right != null) {

				q.add(new Pair1(curr.right, pair.vl + 1, pair.hl + 1));
			}

		}
		List<List<Pair2>> list = new ArrayList<>();
		list.addAll(map.values());
		for (int i = 0; i < list.size(); i++) {

			List<Pair2> curr = list.get(i);
			Collections.sort(curr, new Comparator<Pair2>() {

				@Override
				public int compare(Pair2 o1, Pair2 o2) {

					if (o1.hl == o2.hl) {

						return o1.root - o2.root;
					}

					return 0;
				}
			});
			List<Integer> val = new ArrayList<>();
			for (int j = 0; j < curr.size(); j++) {

				val.add(curr.get(j).root);
			}
			ans.add(val);
		}

		return ans;
	}

}
