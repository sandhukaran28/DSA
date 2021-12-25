package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Topological_Sorting {

	public static class Graph {

		int V;
		Map<Integer, List<Integer>> adjList;

		public Graph(int V) {

			this.V = V;
			adjList = new HashMap<>();

		}

		public void addEdge(int u, int v, boolean isBir) {

			List<Integer> nu = adjList.getOrDefault(u, new ArrayList<>());

			if (!nu.contains(v)) {

				nu.add(v);
				adjList.put(u, nu);
			}

			if (isBir) {

				List<Integer> nv = adjList.getOrDefault(v, new ArrayList<>());

				if (!nv.contains(u)) {

					nv.add(u);
					adjList.put(v, nv);
				}

			}

		}

		public void display() {

			for (int vertex : adjList.keySet()) {

				System.out.println(vertex + " -> " + adjList.get(vertex));
			}
		}

		private int[] indegree() {

			int arr[] = new int[V];

			for (int key = 0; key < V; key++) {

				List<Integer> ls = adjList.getOrDefault(key, new ArrayList<>());

				for (int n : ls) {

					arr[n]++;
				}
			}
			return arr;
		}

		public void topologicalSort() {

			int[] ind = indegree();

			Queue<Integer> q = new LinkedList<>();

			for (int i = 0; i < V; i++) {

				if (ind[i] == 0) {
					q.add(i);
				}
			}

			while (!q.isEmpty()) {

				int front = q.poll();
				System.out.print(front + " ");

				List<Integer> nei = adjList.getOrDefault(front, new ArrayList<>());

				for (int n : nei) {

					ind[n]--;

					if (ind[n] == 0) {

						q.add(n);
					}
				}

			}
			System.out.println();
		}

		public boolean cycleDetection() {

			int[] ind = indegree();
			int cnt = 0;
			Queue<Integer> q = new LinkedList<>();

			for (int i = 0; i < V; i++) {

				if (ind[i] == 0) {
					q.add(i);
				}
			}

			while (!q.isEmpty()) {

				int front = q.poll();
				cnt++;

				List<Integer> nei = adjList.getOrDefault(front, new ArrayList<>());

				for (int n : nei) {

					ind[n]--;

					if (ind[n] == 0) {

						q.add(n);
					}
				}

			}

			return cnt != V;
		}

	}

	public static void main(String[] args) {

		Graph g = new Graph(8);

		g.addEdge(0, 1, false);
		g.addEdge(0, 2, false);
		g.addEdge(2, 3, false);
		g.addEdge(2, 4, false);
		g.addEdge(3, 1, false);
		g.addEdge(5, 3, false);
		g.addEdge(5, 6, false);
		g.addEdge(4, 6, false);
		g.addEdge(6, 7, false);
		g.addEdge(7, 4, false);

		g.display();
		g.topologicalSort();
		System.out.println(g.cycleDetection());
	}

}
