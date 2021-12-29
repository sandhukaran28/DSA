package graphs;

import java.util.Arrays;

public class Redundant_Connection {

	public class Dsu {

		int parent[];
		int V;

		public Dsu(int v) {

			V = v;
			parent = new int[V];
			Arrays.fill(parent, -1);

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
			}

			else {

				return true;
			}

			return false;
		}

	}

	public int[] findRedundantConnection(int[][] arr) {

		int n = arr.length;
		Dsu dsu = new Dsu(n + 1);

		for (int i = 0; i < n; i++) {

			boolean res = dsu.union(arr[i][0], arr[i][1]);

			if (res == true) {

				int ans[] = new int[2];
				ans[0] = arr[i][0];
				ans[1] = arr[i][1];

				return ans;
			}
		}

		return new int[2];
	}
}
