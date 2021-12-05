package dp_assignment;

import java.util.Scanner;

public class Target_Sum {
	
	public static int sol(int arr[],int res[],int curr, int n ,int k) {
		
		
		if(curr == n) {
			
			int sum =0;
			for(int i=0;i<n;i++) {
				sum+=res[i];
			}
			if(sum == k) {
				return 1;
			}
			
			return 0;
		}
		
		res[curr] = arr[curr];
		int c1 = sol(arr,res,curr+1,n,k);
		res[curr] = -arr[curr];
		int c2 = sol(arr,res,curr+1,n,k);
		
		
		return c1+c2;
	}
	

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		int n =sc.nextInt();
		int k =sc.nextInt();
		
		int arr[] =new int[n];
		
		for(int i=0;i<n;i++) {
			
			arr[i]=sc.nextInt();
		}
		int res[] = new int[n];
		
		System.out.println(sol(arr,res,0,n,k));
		
		
		sc.close();

	}

}
