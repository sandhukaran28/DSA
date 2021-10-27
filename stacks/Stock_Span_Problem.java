package stacks;

import java.util.Scanner;
import java.util.Stack;

public class Stock_Span_Problem {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {

			arr[i] = sc.nextInt();
		}

		int span[] = new int[n];
		Stack<Integer> st = new Stack<>();

//		Span of first element will always be one as there are no other elements to its left
		span[0] = 1;
		st.push(0);

		for (int i = 1; i < n; i++) {

			while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {

				st.pop();
			}

			if (!st.isEmpty()) {
				span[i] = i - st.peek();
			} else {
				span[i] = i + 1;

			}
			st.push(i);
		}

		for (int i = 0; i < n; i++) {

			System.out.print(span[i] + " ");
		}

		sc.close();

	}

}
