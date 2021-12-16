package dp;

import java.util.Arrays;
import java.util.Scanner;

public class Mixtures {
	
	public static int color(int arr[],int l,int r) {
		
		int sum =0;
		for(int i=l;i<=r;i++) {
			sum+=arr[i];
		}
		
		return sum;
	}
	
	public static long sol(int arr[],int l,int r,long[][] dp) {
		
		if(l>=r) {
			return 0;
		}
		if(dp[l][r] != -1) {
			return dp[l][r];
		}
		long res = Long.MAX_VALUE;
		for(int i=l;i<r;i++) {
			
			
			long c1 = sol(arr,l,i,dp);
			long c2 = sol(arr,i+1,r,dp);
			
			long outer = color(arr,i,l)* color(arr,l+1,r);
			
			long ans = c1+c2+outer;
			
			res = Math.min(res, ans);
			
		}
		
		return dp[l][r] =  res;
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		long dp[][]= new long[n+1][n+1];
		for(int i=0;i<=n;i++)
		{
			Arrays.fill(dp[i],-1);
		}
		for(int i=0;i<n;i++) {
			
			arr[i] = sc.nextInt();
		}
		
		System.out.println(sol(arr,0,n-1,dp));
		
		
		
		sc.close();

	}

}
