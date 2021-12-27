package graphs;

import java.util.Arrays;

public class DSU_Optimized {

	int V;
	int[] parent;
	int[] rank;
	int[] ht;

	public DSU_Optimized(int V) {

		this.V = V;
		parent = new int[V];
		rank = new int[V];
		ht = new int[V];
		Arrays.fill(rank, 1);
		Arrays.fill(parent, -1);
	}

	public int find(int u) {

		if (parent[u] == -1) {

			return u;
		}

		return parent[u] = find(parent[u]);
	}

	public void union(int u, int v) {

		int gfu = find(u);
		int gfv = find(v);

		if (gfu != gfv) {

			parent[gfu] = gfv;
		}

	}

	public void unionByRank(int u, int v) {

		int gfu = find(u);
		int gfv = find(v);

		if (gfu != gfv) {

			if (rank[gfu] > rank[gfv]) {

				parent[gfv] = gfu;
				rank[gfu] +=rank[gfv];
			} else {

				parent[gfu] = gfv;
				rank[gfv] += rank[gfu];
			}
		}

	}
	
	public void unionByHeight(int u,int v) {
		
		int gfu = find(u);
		int gfv = find(v);

		if (gfu != gfv) {

			if(ht[gfu] > ht[gfv]) {
				
				parent[gfv] = gfu;
			}
			else if(ht[gfu] < ht[gfv]) {
				
				parent[gfu] = gfv;
			}
			else {
				
				parent[gfv] = gfu;
				ht[gfu]++;
				
			}
		}
		
	}

	public static void main(String[] args) {
		
		DSU_Optimized dsu = new DSU_Optimized(5);
		
		dsu.union(0, 1);
		
	}

}
