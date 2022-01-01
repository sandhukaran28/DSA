package graphs;

public class Dijkstra_Algo {

	public static void algo(int graph[][], int src) {

		int n = graph.length;
		boolean[] vis = new boolean[n];
		int[] dis = new int[n];
		vis[src] = true;

		for (int i = 0; i < n; i++) {

			dis[i] = graph[src][i];
		}

		for (int i = 1; i < n; i++) {

			int minD = Integer.MAX_VALUE;
			int tar = -1;

			for (int v = 0; v < n; v++) {

				if (!vis[v] && dis[v] < minD) {

					minD = dis[v];
					tar = v;
				}
			}
			System.out.println("Node  chosen is " + tar);
			vis[tar] = true;

			for (int v = 0; v < n; v++) {

				if (!vis[v] && dis[v] != Integer.MAX_VALUE && dis[tar] + graph[tar][v] < dis[v]) {

					dis[v] = dis[tar] + graph[tar][v];
				}
			}

		}

		for (int i = 0; i < graph.length; i++) {
			System.out.println("dis of " + i + " from " + src + " is " + dis[i]);
		}
	}

	public static void main(String[] args) {

		int[][] conn = { { 0, 5, 10, 0, 0 }, { 5, 0, 3, 11, 0 }, { 10, 3, 0, 2, 0 }, { 0, 11, 2, 0, 3 },
				{ 0, 0, 0, 3, 0 } };

		for (int r = 0; r < conn.length; r++) {
			for (int c = 0; c < conn[0].length; c++) {

				if (conn[r][c] == 0) {
					conn[r][c] = Integer.MAX_VALUE;
				}
			}
		}

		algo(conn, 1);

	}

}
