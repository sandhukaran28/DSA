package dp;

import java.util.Arrays;
import java.util.Scanner;

public class Fibbonacci {

	public static int fibbo(int n, int[] cache) {

		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}

		if (cache[n] != -1) {
			return cache[n];
		}

		int l = fibbo(n - 1, cache);
		int r = fibbo(n - 2, cache);

		return cache[n] = l + r;

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int cache[] = new int[n + 1];
		Arrays.fill(cache, -1);
		System.out.println(fibbo(n, cache));

		sc.close();

	}

}
