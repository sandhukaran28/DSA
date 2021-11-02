package stacks;

import java.util.Scanner;
import java.util.Stack;

public class Basic_Calculator {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		int sum = 0, sign = 1;

		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			char ch = s.charAt(i);

			if (ch == ' ') {
				continue;
			}

			if (Character.isDigit(s.charAt(i))) {

				int num = 0;
				while (i < s.length() && Character.isDigit(s.charAt(i))) {

					num = (num * 10) + Character.getNumericValue(s.charAt(i));
					i++;

				}

				if (i < s.length()) {
					i--;
				}
				sum += sign * num;
			}

			if (ch == '-') {
				sign = -1;
			}

			if (ch == '+') {
				sign = 1;
			}

			if (ch == '(') {

				st.push(sum);
				st.push(sign);
				sum = 0;
				sign = 1;
			}

			if (ch == ')') {
				sum = st.pop() * sum;
				sum += st.pop();
			}
		}

		System.out.println(sum);

		sc.close();
	}

}
