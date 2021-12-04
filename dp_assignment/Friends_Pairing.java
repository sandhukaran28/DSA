package dp_assignment;

import java.util.Scanner;

public class Friends_Pairing {

	public static int sol(int i, int n) {
		
		if(i == n) {
			return 1;
		}
		if(i>n) {
			return 0;
		}
		
		int c1 = sol(i+1,n);
		System.out.println("i: "+i+" c1:"+c1);
		int c2 =(n-i)*sol(i+2,n);
		System.out.println("i: "+i+" c2:"+c2);
		
		return c1+c2;
	}
	
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		int test = sc.nextInt();
		while(test-->0) {
			
			int n =sc.nextInt();
			System.out.println(sol(1,n));
		}
		sc.close();
	}
}
