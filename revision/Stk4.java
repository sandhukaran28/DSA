package revision;

import java.util.Arrays;
import java.util.Stack;

public class Stk4 {

	public static  void nge(int arr[], int n) {

		int nge[] = new int[n];

		Arrays.fill(nge, -1);

		Stack<Integer> st = new Stack<>();

		st.push(0);

		for (int i = 1; i < n; i++) {

			while (!st.isEmpty() && arr[st.peek()] < arr[i]) {

				nge[st.pop()] = arr[i];
			}

			st.push(i);
		}

		for (int c : arr) {
			System.out.print(c + " ");
		}
		System.out.println();
		for (int c : nge) {
			System.out.print(c + " ");
		}

	}
	
	public static void  nse(int arr[],int n) {
		
		int nse[] = new int[n];

		Arrays.fill(nse, -1);

		Stack<Integer> st = new Stack<>();

		st.push(0);

		for (int i = 1; i < n; i++) {

			while (!st.isEmpty() && arr[st.peek()] > arr[i]) {

				nse[st.pop()] = arr[i];
			}

			st.push(i);
		}

		for (int c : arr) {
			System.out.print(c + " ");
		}
		System.out.println();
		for (int c : nse) {
			System.out.print(c + " ");
		}
	}
	
	public static void pge(int arr[],int n) {
		
		int pge[] = new int[n];
		Arrays.fill(pge, -1);
		Stack<Integer> st = new Stack<>();

		st.push(0);

		for (int i = 1; i < n; i++) {
			
			while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
				
				st.pop();
			}
			
			if(!st.isEmpty()) {
				pge[i] = arr[st.peek()];
			}
			
			st.push(i);
		}
		
		for (int c : arr) {
			System.out.print(c + " ");
		}
		System.out.println();
		for (int c : pge) {
			System.out.print(c + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {7,1,2,1,3,5};
		
		
		pge(arr, 6);
	}

}
