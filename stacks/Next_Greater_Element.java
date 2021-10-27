package stacks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Next_Greater_Element {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {

			arr[i] = sc.nextInt();
		}

		int nge[] = new int[n];

		Arrays.fill(nge, -1);

		Stack<Integer> st = new Stack<>();

		st.push(0);

		for (int i = 1; i < n; i++) {

			while (!st.isEmpty() && arr[i] > arr[st.peek()]) {

				nge[st.pop()] = arr[i];

			}

			st.push(i);

		}

		for (int i = 0; i < n; i++) {

			System.out.print(nge[i] + " ");
		}

		sc.close();

	}

}
