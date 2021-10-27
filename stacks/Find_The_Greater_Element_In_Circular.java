package stacks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Find_The_Greater_Element_In_Circular {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Stack<Integer> pge = new Stack<>();
		Stack<Integer> nge = new Stack<>();

		int n = sc.nextInt();
		int arr[] = new int[n];
		int gre[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.fill(gre, -1);

//		Next Greater Element
		nge.push(0);
		for (int i = 1; i < n; i++) {

			while (!nge.isEmpty() && arr[nge.peek()] < arr[i]) {

				gre[nge.peek()] = arr[i];
				nge.pop();
			}

			nge.push(i);

		}

//		Previous Greater Element

		pge.push(0);

		for (int i = 1; i < n; i++) {

			while (!pge.isEmpty() && arr[pge.peek()] <= arr[i]) {

				pge.pop();
			}

			if (!pge.isEmpty()) {

				if (gre[i] == -1) {

					gre[i] = arr[pge.peek()];
				}
			}

			pge.push(i);
		}

		for (int ele : gre) {
			System.out.print(ele + " ");
		}

		sc.close();
	}

}
