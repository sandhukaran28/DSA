package dp_assignment;

import java.util.Arrays;
import java.util.Scanner;

public class KnapSack_0_1 {

	public static int knap(int w, int wt[], int val[], int n, int cache[][]) {

		if (n < 0 || w <= 0) {

			return 0;
		}

		if (cache[n][w] != -1) {
			return cache[n][w];
		}

		int c1 = 0;
		if (w - wt[n] >= 0) {

			c1 = knap(w - wt[n], wt, val, n , cache) + val[n];
		}
		int c2 = knap(w, wt, val, n - 1, cache);

		return cache[n][w] = Math.max(c1, c2);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int w = sc.nextInt();
		int wt[] = new int[n];
		int val[] = new int[n];
		for (int i = 0; i < n; i++) {
			wt[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			val[i] = sc.nextInt();
		}

		int cache[][] = new int[n][w + 1];
		for (int i = 0; i < n; i++) {

			Arrays.fill(cache[i], -1);
		}
		System.out.println(knap(w, wt, val, n-1, cache));

		sc.close();

	}

}
