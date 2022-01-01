package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskuls_Algo {

	static class EdgeList {

		int V;
		List<Edge> edgeList;

		class Edge {

			int u;
			int v;
			int wt;

			public Edge(int u, int v, int wt) {

				this.u = u;
				this.v = v;
				this.wt = wt;
			}

			@Override
			public String toString() {

				return "[" + this.u + "," + this.v + "," + this.wt + "]";
			}
		}

		public EdgeList(int V) {

			this.V = V;
			edgeList = new ArrayList<>();

		}

		public void addEdge(int u, int v, int wt) {

			edgeList.add(new Edge(u, v, wt));
		}

		public int find(int u, int parent[]) {

			if (parent[u] == -1) {
				return u;
			}

			return parent[u] = find(parent[u], parent);
		}

		public boolean union(int u, int v, int[] rank, int[] parent) {

			int gfu = find(u, parent);
			int gfv = find(v, parent);

			if (gfu != gfv) {

				if (rank[gfu] < rank[gfv]) {

					parent[gfu] = gfv;
					rank[gfv] += rank[gfu];
					return true;
				} else {

					parent[gfv] = gfu;
					rank[gfu] += rank[gfv];
					return true;
				}
			}
			return false;
		}

		public int kruskalsAlgorithm(int[] parent, int[] rank) {

			Collections.sort(edgeList, new Comparator<Edge>() {

				@Override
				public int compare(Edge o1, Edge o2) {

					return o1.wt - o2.wt;
				}
			});

			int cost = 0;
			for (Edge e : edgeList) {

				boolean join = union(e.u, e.v, rank, parent);
				if (join) {
					cost += e.wt;
				}

			}

			return cost;
		}

	}

	public static void main(String[] args) {

		EdgeList graph = new EdgeList(9);
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 7, 8);
		graph.addEdge(1, 2, 8);
		graph.addEdge(7, 6, 1);
		graph.addEdge(1, 7, 11);
		graph.addEdge(7, 8, 7);
		graph.addEdge(8, 6, 6);
		graph.addEdge(2, 8, 2);
		graph.addEdge(2, 3, 7);
		graph.addEdge(6, 5, 2);
		graph.addEdge(2, 5, 4);
		graph.addEdge(3, 5, 14);
		graph.addEdge(3, 4, 9);
		graph.addEdge(5, 4, 10);

		int[] parent = new int[9];
		Arrays.fill(parent, -1);
		int[] rank = new int[9];
		Arrays.fill(rank, 1);
		System.out.println(graph.edgeList);
		System.out.println(graph.kruskalsAlgorithm(parent, rank));
		System.out.println(graph.edgeList);

	}

}
