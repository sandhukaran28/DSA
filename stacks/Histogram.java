package stacks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Histogram {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n =sc.nextInt();
		
		long arr[]= new long[n];
		
		for(int i=0;i<n;i++) {
			
			arr[i] =sc.nextInt();
		}
		
		Stack<Integer> st = new Stack<>();
		
		long pse[] =new long[n];
		long nse[] =new long[n]; 
		
//		Next Smaller number
		Arrays.fill(nse, n);
		
		st.push(0);
		for(int i=1;i<n;i++) {
			
			while(!st.isEmpty() && arr[st.peek()] > arr[i] ) {
				
				nse[st.pop()] = i;
			}
			
			
			st.push(i);
		}
		
		
//		Previous Smaller number
		Arrays.fill(pse, -1);
		st= new Stack<>();
		
		st.push(0);
		
		for(int i=1;i<n;i++) {
			
			while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
				
				st.pop();
			}
			
			if(!st.isEmpty()) {
				pse[i]  = st.peek();
			}
			st.push(i);
		}
		
		long max =-1;
		for(int i=0;i<n;i++) {
			
			long curr = (nse[i] -pse[i]-1)*arr[i];
			
			if(curr>max) {
				max = curr;
			}
		}
		
		System.out.println(max);
		sc.close();

	}

}
