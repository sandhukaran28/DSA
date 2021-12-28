package graphs;

import java.util.Arrays;

public class Min_Spanning_Tree {

	public int parent[];
	public int rank[];
	int V;

	public Min_Spanning_Tree(int V) {

		this.V = V;
		parent = new int[V];
		Arrays.fill(parent, -1);
		rank = new int[V];
		Arrays.fill(rank, 1);
	}

	public boolean unionByRank(int u, int v) {

		int gfu = find(u);
		int gfv = find(v);

		if (gfu != gfv) {

			if (rank[gfu] > rank[gfv]) {

				parent[gfv] = gfu;
				rank[gfu] += rank[gfv];
				return true;
			} else {

				parent[gfu] = gfv;
				rank[gfv] += rank[gfu];
				return true;
			}
		}
		return false;

	}

	public int find(int u) {

		if (parent[u] == -1) {

			return u;
		}

		return parent[u] = find(parent[u]);

	}

	public boolean union(int u, int v) {

		int gfu = find(u);
		int gfv = find(v);

		if (gfu != gfv) {

			parent[gfu] = gfv;
			return true;

		}

		return false;

	}

	public static void main(String[] args) {

		int arr[][] = { { 1, 2, 6 }, { 3, 4, 4 }, { 1, 3, 3 }, { 0, 1, 1 }, { 0, 2, 2 }, { 2, 4, 5 } };

		Min_Spanning_Tree mst = new Min_Spanning_Tree(5);
		Arrays.sort(arr, (a, b) -> Double.compare(a[2], b[2]));

		int cost = 0;

		for (int i = 0; i < arr.length; i++) {

			if (mst.unionByRank(arr[i][0], arr[i][1])) {
				cost += arr[i][2];
				System.out.println(arr[i][0] + " -> " + arr[i][1] + " cost: " + cost);

			}
		}

		System.out.println(cost);

	}

}
