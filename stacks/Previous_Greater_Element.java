package stacks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Previous_Greater_Element {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {

			arr[i] = sc.nextInt();
		}

		int pge[] = new int[n];

		Arrays.fill(pge, -1);

		Stack<Integer> st = new Stack<>();

		st.push(0);

		for (int i = 1; i < n; i++) {

			while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {

				st.pop();
			}

			if (!st.isEmpty()) {

				pge[i] = arr[st.peek()];
			}
			st.push(i);

		}

		for (int i = 0; i < n; i++) {

			System.out.print(pge[i] + " ");
		}

		sc.close();

	}

}
