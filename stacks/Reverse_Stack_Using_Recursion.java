package stacks;

import java.util.Scanner;
import java.util.Stack;

public class Reverse_Stack_Using_Recursion {

	public static void reverse(Stack<Integer> st) {

		if (st.isEmpty()) {
			return;
		}
		
		int ele = st.pop();
		reverse(st);

		insert(ele,st);
		

	}
	
	public static void insert(int n,Stack<Integer> st) {
		
		if(st.isEmpty()) {
			st.push(n);
		}
		else {
			int ele = st.pop();
			insert(n,st);
			st.push(ele);
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Stack<Integer> st = new Stack<>();

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			st.push(sc.nextInt());
		}
		reverse(st);

		while (!st.isEmpty()) {

			System.out.println(st.pop());
		}

		sc.close();
	}

}
