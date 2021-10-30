package stacks;

import java.util.Scanner;
import java.util.Stack;

public class Daily_Temperatures {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {

			arr[i] = sc.nextInt();
		}

		Stack<Integer> st = new Stack<>();
		int res[] = new int[n];

		st.push(0);
		for (int i = 1; i < n; i++) {

			while (!st.isEmpty() && arr[st.peek()] < arr[i]) {

				res[st.peek()] = i - st.peek();
				st.pop();
			}

			st.push(i);

		}

		for (int i = 0; i < n; i++) {

			System.out.println(res[i] + " ");
		}

		sc.close();

	}

}
