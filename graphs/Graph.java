package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {

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

	public void BFS(int src) {

		Queue<Integer> q = new LinkedList<>();
		Set<Integer> vis = new HashSet<>();
		q.add(src);
		vis.add(src);

		while (!q.isEmpty()) {

			int front = q.remove();
			System.out.print(front + " ");

			List<Integer> ls = adjList.getOrDefault(front, new ArrayList<>());

			for (int e : ls) {

				if (!vis.contains(e)) {
					vis.add(e);
					q.add(e);
				}
			}

		}
	}

	public void SSSP(int src) {

		Queue<Integer> q = new LinkedList<>();
		Map<Integer, Integer> dis = new HashMap<>();

		for (int v = 1; v <= V; v++) {

			dis.put(v, Integer.MAX_VALUE);
		}

		q.add(src);
		dis.put(src, 0);

		while (!q.isEmpty()) {

			int front = q.remove();

			List<Integer> ls = adjList.getOrDefault(front, new ArrayList<>());

			for (int e : ls) {

				if (dis.get(e) == Integer.MAX_VALUE) {

					int currDis = dis.get(front) + 1;
					dis.put(e, currDis);
					q.add(e);
					System.out.println("Distance of " + e + " from " + src + " is " + currDis);
				}
			}
		}

	}

	public void dfsHelper(int src) {

		DFS(src, new HashSet<>());
	}

	private void DFS(int src, Set<Integer> vis) {

		System.out.print(src + " ");

		vis.add(src);

		List<Integer> ls = adjList.getOrDefault(src, new ArrayList<>());

		for (int n : ls) {

			if (!vis.contains(n)) {

				DFS(n, vis);
			}
		}

	}

	public int connectedComponents() {

		int cnt = 0;

		Set<Integer> vis = new HashSet<>();

		for (int v = 1; v <= V; v++) {

			if (!vis.contains(v)) {

				DFS(v, vis);
				cnt++;
			}

		}

		return cnt;
	}

	public boolean cycleDetectDFS(int src, int parent, Set<Integer> vis) {

		vis.add(src);
		List<Integer> nei = adjList.getOrDefault(src, new ArrayList<>());

		for (int n : nei) {

			if (!vis.contains(n)) {

				boolean isCycle = cycleDetectDFS(n, src, vis);
				if (isCycle) {
					return true;
				}
			} else {

				if (n != parent) {

					return true;
				}
			}
		}

		return false;
	}

	public boolean hasCycle(int src) {

		Set<Integer> vis = new HashSet<>();

		return cycleDetectDFS(src, src, vis);
	}

	public boolean hasCycleBFS(int src) {

		Set<Integer> vis = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
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

					vis.add(n);
					q.add(n);
					parent[n] = front;
				} else {

					if (parent[front] != n) {

						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {

		Graph graph = new Graph(4);

		graph.addEdge(0, 1, true);
		graph.addEdge(1, 2, true);
		graph.addEdge(2, 3, true);
		System.out.println(graph.hasCycle(0));
		System.out.println(graph.hasCycleBFS(0));
//		graph.addEdge(7, 8, true);

		graph.display();
//		graph.BFS(1);
//		System.out.println();
//		graph.dfsHelper(1);
//		System.out.println();
//		System.out.println(graph.connectedComponents());

	}

}
