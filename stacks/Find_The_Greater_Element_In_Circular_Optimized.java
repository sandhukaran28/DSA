package stacks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Find_The_Greater_Element_In_Circular_Optimized {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Stack<Integer> nge = new Stack<>();

		int n = sc.nextInt();
		int arr[] = new int[n];
		int gre[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.fill(gre, -1);

		for (int i = n * 2 - 1; i >= 0; i--) {

			while (!nge.isEmpty() && arr[nge.peek()] <= arr[i % n]) {

				nge.pop();
			}

			if (i < n) {

				if (!nge.isEmpty()) {
					gre[i] = arr[nge.peek()];
				}
			}

			nge.push(i % n);
		}

		for (int ele : gre) {
			System.out.print(ele + " ");
		}

		sc.close();
	}
}
