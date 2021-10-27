package stacks;

import java.util.Scanner;
import java.util.Stack;

public class Evaluate_An_Expression {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while (t-- > 0) {

			String s = sc.next();

			Stack<Integer> st = new Stack<>();

			for (int i = 0; i < s.length(); i++) {

				if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {

					int n1 = st.pop();
					int n2 = st.pop();

					int res = 0;

					if (s.charAt(i) == '+') {
						res = n1 + n2;
					} else if (s.charAt(i) == '-') {
						res = n2 - n1;
					} else if (s.charAt(i) == '*') {
						res = n1 * n2;
					} else if (s.charAt(i) == '/') {
						res = n2 / n1;
					}

					st.push(res);
				} else {
					st.push(s.charAt(i) - '0');
				}
			}
			System.out.println(st.pop());
		}

		sc.close();

	}

}
