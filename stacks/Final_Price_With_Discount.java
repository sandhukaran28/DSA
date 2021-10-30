package stacks;

import java.util.Scanner;
import java.util.Stack;

public class Final_Price_With_Discount {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {

			arr[i] = sc.nextInt();
		}

		Stack<Integer> st = new Stack<>();

		st.push(0);

		for (int i = 1; i < n; i++) {

			while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {

				arr[st.peek()] -= arr[i];
				st.pop();
			}

			st.push(i);
		}

		for (int i = 0; i < n; i++) {

			System.out.print(arr[i] + " ");
		}
		sc.close();

	}

}
