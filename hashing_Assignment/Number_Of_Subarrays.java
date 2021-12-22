package hashing_Assignment;

import java.util.Scanner;

public class Number_Of_Subarrays {
	
	public static int sol(int arr[],int t) {
		
		int n = arr.length;
		
		int cnt = 0;
		
		for(int i=0;i<n;i++) {
			
			int curr = 0;
			for(int j =i;j<n;j++) {
				
				curr+=arr[j];
				if(curr == t) {
					cnt++;
					
				}
				if(curr> t) {
					break;
				}
			}
		}
		
		return cnt;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int t = sc.nextInt();
		
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			
			arr[i] = sc.nextInt();
		}
		
		System.out.println(sol(arr,t));
		
		sc.close();

	}

}
