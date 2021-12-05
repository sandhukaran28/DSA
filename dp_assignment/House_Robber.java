package dp_assignment;

import java.util.Arrays;
import java.util.Scanner;

public class House_Robber {
	
	public static int max(int[] nums, int curr, int[] cache) {

		if (curr >= nums.length) {

			return 0;
		}
		if (cache[curr + 1] != -1) {

			return cache[curr + 1];
		}

		int l = max(nums, curr + 2, cache) + nums[curr];

		int r = max(nums, curr + 1, cache);

		return cache[curr + 1] = Math.max(l, r);
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int test =sc.nextInt();
		
		while(test -->0) {
		
			int n =sc.nextInt();
			
			int arr[] =new int[n];
			
			for(int i=0;i<n;i++) {
				arr[i] =sc.nextInt();
			}
			int cache[] = new int[n + 1];
			Arrays.fill(cache, -1);
			
			System.out.println(max(arr,0,cache));
			
			
		}
		
		
		sc.close();

	}

}
