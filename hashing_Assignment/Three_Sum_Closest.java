package hashing_Assignment;

import java.util.Scanner;

public class Three_Sum_Closest {
	
	
	public static int sol(int arr[],int t) {
		
		int n = arr.length;
		int min = 0;
		for(int i=0;i<n-2;i++) {
			
			int l = i+1;
			int r = n-1;
		
			while(l<r) {
				
				int sum = arr[i] + arr[l]+ arr[r];
				
				if(Math.abs(t - sum) < Math.abs(t - min)) {
					
					min = sum;
				
				}
				
				if(sum < t) {
					l++;
				}
				else {
					
					r--;
				}
			}
		}
		
		return min;
		
	}

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int t=  sc.nextInt();
		
		int arr[] =new int[n];
		
		for(int i=0;i<n;i++) {
			
			arr[i] = sc.nextInt();
		}
		
		System.out.println(sol(arr,t));
		
		
		sc.close();

	}

}
