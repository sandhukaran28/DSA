package stacks;

import java.util.Scanner;
import java.util.Stack;

public class Reverse_Stack_Using_Recursion {

	public static void reverse(Stack<Integer> st) {

		if (st.isEmpty()) {
			return;
		}
		reverse(st);
		int ele = st.pop();

		st.push(ele);

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Stack<Integer> st = new Stack<>();

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			st.push(sc.nextInt());
		}

		while (!st.isEmpty()) {

			System.out.print(st.pop() + " ");
		}

		sc.close();
	}

}
