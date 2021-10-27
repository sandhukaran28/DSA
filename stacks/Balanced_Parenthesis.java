package stacks;

import java.util.Scanner;
import java.util.Stack;

public class Balanced_Parenthesis {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String s = sc.next();

		if (s.charAt(0) == '}' || s.charAt(0) == ']' || s.charAt(0) == ')') {
			System.out.println("No");
		}

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			if (!st.isEmpty()) {

				if (s.charAt(i) == '}' && st.peek() == '{' || s.charAt(i) == ']' && st.peek() == '['
						|| s.charAt(i) == ')' && st.peek() == '(') {

					st.pop();
				} else {
					st.push(s.charAt(i));
				}
			} else {
				st.push(s.charAt(i));
			}

		}

		if (st.isEmpty()) {
			System.out.println("Yes");

		} else {
			System.out.println("No");
		}

		sc.close();

	}

}
