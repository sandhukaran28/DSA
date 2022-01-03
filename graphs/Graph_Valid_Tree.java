package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph_Valid_Tree {

	public static class Graph {

		int V;
		Map<Integer, List<Integer>> adjList;

		public Graph(int V) {

			this.V = V;
			adjList = new HashMap<>();
		}

		public void addEdge(int u, int v) {

			List<Integer> l1 = adjList.getOrDefault(u, new ArrayList<>());
			l1.add(v);
			adjList.put(u, l1);

			List<Integer> l2 = adjList.getOrDefault(v, new ArrayList<>());
			l2.add(u);
			adjList.put(v, l2);

		}

		public boolean cycle(int src) {

			Queue<Integer> q = new LinkedList<>();
			Set<Integer> vis = new HashSet<>();
			int[] parent = new int[V];
			for (int i = 0; i < V; i++) {

				parent[i] = i;
			}

			q.add(src);
			vis.add(src);

			while (!q.isEmpty()) {

				int front = q.poll();

				List<Integer> nei = adjList.getOrDefault(front, new ArrayList<>());

				for (int n : nei) {

					if (!vis.contains(n)) {

						q.add(n);
						vis.add(n);
						parent[n] = front;
					} else {

						if (parent[front] != n) {
							return false;
						}
					}
				}
			}
			return vis.size() == V;

		}

	}

	public boolean validTree(int n, int[][] edges) {
		if (n < edges.length - 1) {
			System.out.println("here");
			return false;
		}
		Graph g = new Graph(n);
		for (int i = 0; i < edges.length; i++) {

			g.addEdge(edges[i][0], edges[i][1]);
		}
		return g.cycle(0);

	}

}
