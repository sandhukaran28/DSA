package graphs;

import java.util.Arrays;

public class Most_Stones_Removed {

	public class DSU {

		int V;
		int[] parent;
		int[] rank;
		int cnt;

		public DSU(int V) {

			this.V = V;
			parent = new int[V];
			rank = new int[V];
			Arrays.fill(rank, 1);
			Arrays.fill(parent, -1);
			cnt = 0;
		}

		public int find(int u) {

			if (parent[u] == -1) {

				return u;
			}

			return parent[u] = find(parent[u]);
		}

		public void unionByRank(int u, int v) {

			int gfu = find(u);
			int gfv = find(v);

			if (gfu != gfv) {

				if (rank[gfu] > rank[gfv]) {

					parent[gfv] = gfu;
					rank[gfu] += rank[gfv];
					cnt++;
				} else {

					parent[gfu] = gfv;
					rank[gfv] += rank[gfu];
					cnt++;
				}
			}

		}

	}

	public int removeStones(int[][] arr) {

		int n = arr.length;

		DSU dsu = new DSU(n);

		for (int i = 0; i < n; i++) {

			for (int j = i + 1; j < n; j++) {

				if (arr[i][0] == arr[j][0] || arr[i][1] == arr[j][1])

					dsu.unionByRank(i, j);
			}
		}

		return dsu.cnt;
	}

}
