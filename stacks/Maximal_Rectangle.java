package stacks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Maximal_Rectangle {

	public static int maxArea(int arr[]) {

		int nse[] = new int[arr.length];
		int pse[] = new int[arr.length];

		Arrays.fill(pse, -1);
		Arrays.fill(nse, arr.length);

//		finding next smaller element

		Stack<Integer> st = new Stack<>();

		st.push(0);

		for (int i = 1; i < arr.length; i++) {

			while (!st.isEmpty() && arr[st.peek()] > arr[i]) {

				nse[st.pop()] = i;
			}

			st.push(i);
		}

//		finding previous smaller element
		st = new Stack<>();

		st.push(0);

		for (int i = 1; i < arr.length; i++) {

			while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {

				st.pop();
			}

			if (!st.isEmpty()) {

				pse[i] = st.peek();
			}

			st.push(i);
		}

		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			int curr = arr[i] * (nse[i] - pse[i] - 1);
			max = Math.max(curr, max);
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int r, c;
		r = sc.nextInt();
		c = sc.nextInt();

		int[][] arr = new int[r][c];

		for (int i = 0; i < r; i++) {

			for (int j = 0; j < c; j++) {

				arr[i][j] = sc.nextInt();
			}
		}

		if (arr.length == 0) {
			System.out.println(0);
			sc.close();
			return;
		}

		int hist[] = new int[c];
		int max = 0;
		for (int i = 0; i < r; i++) {

			for (int j = 0; j < c; j++) {

				if (arr[i][j] == 1) {

					hist[j]++;
				} else {
					hist[j] = 0;
				}
			}
			int curr = maxArea(hist);
			max = Math.max(curr, max);

		}

		System.out.println(max);
		sc.close();

	}

}
