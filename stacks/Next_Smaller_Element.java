package stacks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Next_Smaller_Element {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {

			arr[i] = sc.nextInt();
		}
		
		int nse[] = new int[n];
		
		Arrays.fill(nse,-1);
		
		Stack<Integer> st = new Stack<>();
		
		st.push(0);
		
		for(int i=1;i<n;i++) {
			
			while(!st.isEmpty() && arr[i] < arr[st.peek()]) {
				
				nse[st.pop()] = arr[i] ;
				
			}
			
			st.push(i);
			
			
		}
		
		for(int i=0;i<n;i++) {
			
			System.out.print(nse[i]+" ");
		}
		
		
		sc.close();

	}

}
