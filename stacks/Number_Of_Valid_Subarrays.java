package stacks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Number_Of_Valid_Subarrays {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		long arr[] = new long[n];

		for (int i = 0; i < n; i++) {

			arr[i] = sc.nextInt();

		}
		long[] res = new long[n];
		Arrays.fill(res, -1);
		Stack<Integer> st = new Stack<>();

		st.push(0);

		for (int i = 1; i < n; i++) {

			while (!st.isEmpty() && arr[st.peek()] > arr[i]) {

				res[st.peek()] = i;
				st.pop();
			}
			st.push(i);
		}

		long sum = 0;
		for (int i = 0; i < n; i++) {

			if (res[i] == -1) {
				sum += n - i;
			} else {
				sum += (res[i] - i);
			}

		}

		System.out.println(sum);

		sc.close();

	}

}
