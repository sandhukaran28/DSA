package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Course_Schedule_I {

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

		public boolean topologicalSort() {

			int[] arr = indegree();

			Queue<Integer> q = new LinkedList<>();

			for (int i = 0; i < V; i++) {

				if (arr[i] == 0) {

					q.add(i);
				}
			}

			int cnt = 0;
			while (!q.isEmpty()) {

				int front = q.poll();
				cnt++;
				List<Integer> ls = adjList.getOrDefault(front, new ArrayList<>());

				for (int n : ls) {

					arr[n]--;
					if (arr[n] == 0) {
						q.add(n);
					}
				}
			}

			return cnt == V;

		}

	}

	public boolean canFinish(int n, int[][] arr) {

		Graph g = new Graph(n);

		for (int i = 0; i < arr.length; i++) {

			g.addEdge(arr[i][1], arr[i][0], false);

		}

		return g.topologicalSort();
	}

}
