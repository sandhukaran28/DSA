package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Alien_Dictionary {

	public static class Graph {

		int V;
		Map<Character, List<Character>> adjList;

		public Graph(int V) {

			this.V = V;
			adjList = new HashMap<>();

		}

		public void addEdge(char u, char v, boolean isBir) {

			List<Character> nu = adjList.getOrDefault(u, new ArrayList<>());

			if (!nu.contains(v)) {

				nu.add(v);
				adjList.put(u, nu);
			}

			if (isBir) {

				List<Character> nv = adjList.getOrDefault(v, new ArrayList<>());

				if (!nv.contains(u)) {

					nv.add(u);
					adjList.put(v, nv);
				}

			}

		}

		public void display() {

			for (char vertex : adjList.keySet()) {

				System.out.println(vertex + " -> " + adjList.get(vertex));
			}
		}

		private int[] indegree() {

			int arr[] = new int[26];

			for (char key : adjList.keySet()) {

				List<Character> ls = adjList.getOrDefault(key, new ArrayList<>());

				for (char n : ls) {
					arr[n - 'a']++;
				}
			}
			return arr;
		}

		public void topologicalSort() {

			int[] ind = indegree();

			Queue<Character> q = new LinkedList<>();

			for (char c : adjList.keySet()) {

				if (ind[c - 'a'] == 0) {
					q.add(c);
				}
			}

			while (!q.isEmpty()) {

				char front = q.poll();
				System.out.print(front);
				List<Character> nei = adjList.getOrDefault(front, new ArrayList<>());

				for (char n : nei) {

					ind[n - 'a']--;

					if (ind[n - 'a'] == 0) {

						q.add(n);
					}
				}

			}
			System.out.println();
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] arr = new String[n];

		for (int i = 0; i < n; i++) {

			arr[i] = sc.next();
		}
		Graph g = new Graph(n);

		for (int i = 0; i < n - 1; i++) {

			String a = arr[i];
			String b = arr[i + 1];

			for (int j = 0; j < Math.min(a.length(), b.length()); j++) {

				if (a.charAt(j) != b.charAt(j)) {

					g.addEdge(a.charAt(j), b.charAt(j), false);
				}
			}
		}

		g.display();
		g.topologicalSort();

		sc.close();

	}

}
