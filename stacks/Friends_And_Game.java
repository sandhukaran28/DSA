package stacks;

import java.util.Scanner;
import java.util.Stack;

public class Friends_And_Game {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while (t-- > 0) {

			String s = sc.next();

			Stack<Integer> st = new Stack<>();

			for (int i = 0; i <= s.length(); i++) {

				st.push(i + 1);

				if (i == s.length() || (s.charAt(i) - '0') % 2 == 0) {

					while (!st.isEmpty()) {
						System.out.print(st.pop());
					}

				}
			}
		}

		sc.close();
	}

}
