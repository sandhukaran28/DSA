package stacks;

import java.util.Scanner;
import java.util.Stack;

public class Celebrity_Problem {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int arr[][] = new int[n][n];

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		Stack<Integer> st =new Stack<>();
		for(int i=0;i<n;i++) {
			
			st.push(i);
		}
		
		while(st.size() != 1) {
			
			int p1 = st.pop();
			int p2 =st.pop();
			
			if(arr[p1][p2] == 1) {
				st.push(p2);
			}
			else {
				st.push(p1);
			}
		}
		
		int p = st.peek();
		
		for(int i=0;i<n;i++) {
			
			if(arr[p][i] == 1) {
				
				System.out.println("No Celebrity");
				return;
			}
		}
		
		for(int i=0;i<n;i++) {
			
			if(arr[i][p] == 0 && i!=p) {
				
				System.out.println("No Celebrity");
				return;
			}
		}
		
		System.out.println(p);
		sc.close();
	}

}
