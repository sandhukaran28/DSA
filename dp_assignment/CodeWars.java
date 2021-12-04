package dp_assignment;

import java.util.Scanner;

public class CodeWars {

	public static int sol(String a, int i, String b, int j, int n1, int n2) {

		if (i == n1 && j == n2) {

			return 0;
		}

		if (j >= n2) {
			return Math.abs(n1 - i);
		}
		if (i >= n1) {
			return Integer.MAX_VALUE;
		}

		int c1 = Integer.MAX_VALUE;
		if (a.charAt(i) == b.charAt(j)) {

			c1 = sol(a, i + 1, b, j + 1, n1, n2);
		}
		int c2 = Integer.MAX_VALUE, c3 = Integer.MAX_VALUE, c4 = Integer.MAX_VALUE, c5 = Integer.MAX_VALUE,
				c6 = Integer.MAX_VALUE;
		if (n1 < n2) {

			c2 = sol(a, i + 1, b, j + 1, n1, n2); // Replace
			c2 = sol(a, i + 1, b, j + 1, n1 + 1, n2); // insert
		} else if (n1 > n2) {

			c4 = sol(a, i + 1, b, j, n1, n2); // Delete
			c5 = sol(a, i + 1, b, j + 1, n1, n2); // Replace
		} else {
			c6 = sol(a, i + 1, b, j + 1, n1, n2); // Replace
		}

		int ans = Math.min(c1, Math.min(c2, Math.min(c3, Math.min(c4, Math.min(c5, c6)))));
		if (a.charAt(i) == b.charAt(j)) {

			return ans;
		} else {
			return ans + 1;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String s1 = sc.next();
		String s2 = sc.next();

		System.out.println(sol(s1, 0, s2, 0, s1.length(), s2.length()));

		sc.close();

	}

}
