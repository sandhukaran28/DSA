package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Accounts_Merge {

	public class DSU {

		int V;
		int[] parent;
		int[] rank;

		public DSU(int V) {

			this.V = V;
			parent = new int[V];
			rank = new int[V];
			Arrays.fill(rank, 1);
			Arrays.fill(parent, -1);
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
				} else {

					parent[gfu] = gfv;
					rank[gfv] += rank[gfu];
				}
			}

		}

	}

	public List<List<String>> accountsMerge(List<List<String>> accounts) {

		Map<String, Integer> hm = new HashMap<>();
		DSU dsu = new DSU(accounts.size());

		for (int i = 0; i < accounts.size(); i++) {

			List<String> ls = accounts.get(i);

			for (int j = 1; j < ls.size(); j++) {

				String mail = ls.get(j);

				if (!hm.containsKey(mail)) {

					hm.put(mail, i);
				} else {

					dsu.unionByRank(i, hm.get(mail));
				}

			}
		}
		Map<Integer, List<String>> ans = new HashMap<>();
		for (String str : hm.keySet()) {

			int key = hm.get(str);

			int gfu = dsu.find(key);

			List<String> curr = ans.getOrDefault(gfu, new ArrayList<>());
			curr.add(str);
			Collections.sort(curr);
			ans.put(gfu, curr);

		}
		List<List<String>> res = new ArrayList<>();
		for (int key : ans.keySet()) {

			List<String> curr = ans.get(key);
			String name = accounts.get(key).get(0);
			curr.add(0, name);
			res.add(curr);
		}

		return res;
	}

}
