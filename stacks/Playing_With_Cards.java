package stacks;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Playing_With_Cards {

	public static int MAX = 1300000;;

	public static ArrayList<Integer> primes = new ArrayList<>();

	public static void sieveOfEratosthenes() {

		int n = MAX;
		boolean prime[] = new boolean[n + 1];
		for (int i = 0; i <= n; i++)
			prime[i] = true;

		for (int p = 2; p * p <= n; p++) {
			if (prime[p] == true) {
				for (int i = p * p; i <= n; i += p)
					prime[i] = false;
			}
		}

		for (int i = 2; i <= n; i++) {
			if (prime[i] == true)
				primes.add(i);
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		primes.add(-1);
		sieveOfEratosthenes();

		int n, q;
		n = sc.nextInt();
		q = sc.nextInt();
		
		Stack<Integer> a = new Stack<>();
		Stack<Integer> b = new Stack<>();
		Stack<Integer> ai = new Stack<>();
		
		for(int i=0;i<n;i++) {
			
			a.push(sc.nextInt());
		}
		
		for(int i=1;i<=q;i++) {
			
			
			
			while(!a.isEmpty()) {
				
				int num = a.pop();
				if(num%(primes.get(i)) == 0) {
					b.push(num);
				}
				else {
					ai.push(num);
				}
			}
			
			while(!b.isEmpty()) {
				System.out.println(b.pop());
			}
			
			a = ai; 
			ai =new Stack<>();
		}
		
		while(!a.isEmpty()) {
			System.out.println(a.pop());
		}
		
		

		sc.close();
	}

}
