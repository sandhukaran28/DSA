package stacks;

import java.util.Scanner;
import java.util.Stack;

public class Kartik_Sir_And_Coding {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();

		Stack<Integer> st = new Stack<>();

		while (q-- > 0) {

			int n = sc.nextInt();

			if (n == 2) {
				int p = sc.nextInt();
				st.push(p);

			} else {
				if (!st.isEmpty()) {
					System.out.println(st.pop());
				} else {
					System.out.println("No Code");
				}
			}

		}

		sc.close();

	}

}
