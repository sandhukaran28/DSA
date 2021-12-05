package dp_assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Climbing_Stairs {
	
	public static int sol(int r,int cache[]) {
		
		if (r == 0) {
			return 1;
		}

		if (r < 0) {
			return 0;
		}

		if (cache[r] != -1) {

			return cache[r];
		}

		int l = sol(r - 1, cache);
		int ri = sol(r - 2, cache);

		return cache[r] = l + ri;
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n =sc.nextInt();
		int cache[] = new int[n + 1];
		Arrays.fill(cache, -1);
		System.out.println(sol(n,cache));
		sc.close();
	}

}
