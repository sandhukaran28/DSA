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

	public static void main(String[] args) {

		Graph graph = new Graph(6);

		graph.addEdge(1, 2, true);
		graph.addEdge(1, 4, true);
		graph.addEdge(2, 3, true);
		graph.addEdge(3, 4, true);
		graph.addEdge(4, 5, true);
		graph.addEdge(5, 6, true);

		graph.display();
		graph.BFS(1);
		System.out.println();
		graph.SSSP(1);

	}

}
