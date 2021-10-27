package stacks;

import java.util.*;

public class Number_following_a_pattern {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String s = sc.next();

		Stack<Integer> st = new Stack<>();
		int n = s.length();

		for (int i = 0; i <= n; i++) {

			st.push(i + 1);

			if (i == n || s.charAt(i) == 'I') {

				while (!st.isEmpty()) {

					System.out.print(st.pop());
				}
			}
		}

		sc.close();
	}

}
