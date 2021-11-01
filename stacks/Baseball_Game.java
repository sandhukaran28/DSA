package stacks;

import java.util.Scanner;
import java.util.Stack;

public class Baseball_Game {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();

		String[] s = new String[size];

		for (int i = 0; i < size; i++) {
			s[i] = sc.next();
		}

		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < s.length; i++) {

			char c = s[i].charAt(0);

			if (c == '+') {
				int n1 = st.pop();
				int n2 = st.pop();
				st.push(n2);
				st.push(n1);
				st.push(n1 + n2);
			} else if (c == 'D') {
				st.push(st.peek() * 2);
			} else if (c == 'C') {
				st.pop();
			} else {
				int n;

				if (s[i].length() == 1) {
					n = c - '0';
				} else {

					n = Integer.valueOf(s[i]);
				}

				System.out.println(n);
				st.push(n);
			}
		}

		int sum = 0;
		while (!st.isEmpty()) {
			sum += st.pop();
		}
		System.out.println(sum);

		sc.close();

	}

}
