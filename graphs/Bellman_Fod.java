package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bellman_Fod {

	public static class EdgeList {

		public class Edge {

			int u;
			int v;
			int wt;

			public Edge(int u, int v, int wt) {

				this.u = u;
				this.v = v;
				this.wt = wt;
			}

		}

		int V;
		public List<Edge> edgelist;

		public EdgeList(int V) {
			this.V = V;
			edgelist = new ArrayList<>();
		}

		public void addEdge(int u, int v, int wt) {

			edgelist.add(new Edge(u, v, wt));
		}

		public boolean cycleDetection(int src) {

			int[] dis = new int[V];

			Arrays.fill(dis, Integer.MAX_VALUE);
			dis[src] = 0;

			for (int i = 1; i <= V; i++) {
				int flag = 0;
				if (i == V) {
					return true;
				}

				for (Edge e : edgelist) {

					if (dis[e.u] != Integer.MAX_VALUE && dis[e.v] > dis[e.u] + e.wt) {

						dis[e.v] = dis[e.u] + e.wt;
						flag = 1;
					}
				}

				if (flag == 0) {
					break;
				}
			}

			return false;

		}

		public void algo(int src) {

			int[] dis = new int[V];

			Arrays.fill(dis, Integer.MAX_VALUE);
			dis[src] = 0;

			for (int i = 1; i <= V - 1; i++) {

				for (Edge e : edgelist) {

					if (dis[e.u] != Integer.MAX_VALUE && dis[e.v] > dis[e.u] + e.wt) {

						dis[e.v] = dis[e.u] + e.wt;
					}
				}
			}

			for (int i = 0; i < V; i++) {
				System.out.println("dis of " + i + " from " + src + " is " + dis[i]);
			}
		}

	}

	public static void main(String[] args) {

		EdgeList g = new EdgeList(3);
		g.addEdge(0, 1, 10);
		g.addEdge(1, 2, 20);
		g.addEdge(2, 0, -90);
		g.algo(0);
		System.out.println(g.cycleDetection(0));
	}

}
