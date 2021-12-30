package hashing_Assignment;

public class Prims {

	public static int sol(int arr[][], int n) {

		boolean vis[] = new boolean[n];
		vis[0] = true;

		int ans = 0;

		for (int v = 1; v < n; v++) {

			int s = 0, e = 0;

			for (int i = 0; i < n; i++) {

				if (vis[i]) {

					for (int j = 0; j < n; j++) {

						if (!vis[j] && arr[i][j] < arr[s][e]) {

							s = i;
							e = j;
						}
					}

				}
			}

			ans += arr[s][e];
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
