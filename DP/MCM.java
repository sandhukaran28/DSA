package dp;

import java.util.Scanner;

public class MCM {
	
	public static int sol(int arr[],int l,int r) {
		
		if(l>=r) {
			return 0;
		}
		
		
		int res = Integer.MAX_VALUE;
		for(int i=l;i<r;i++) {
			
			int c1 = sol(arr,l,i);
			int c2 = sol(arr,i+1,r);
			
			int ans = c1 + c2 + arr[l-1]*arr[i]*arr[r];
			
			res = Math.min(res, ans);
		}
		
		return res;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr[]= new int[n];
		
		for(int i=0;i<n;i++) {
			
			arr[i] =sc.nextInt();
		}
		
		System.out.println(sol(arr,1,n-1));
		
		sc.close();
		

	}

}
