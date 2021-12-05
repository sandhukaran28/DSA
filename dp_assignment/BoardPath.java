package dp_assignment;

import java.util.Scanner;

public class BoardPath {
	
	public static int sol(int  i ,int n,int m,String str) {
		
		if(i == n) {
			System.out.print(str+" ");
			return 1;
		}
		
		int res = 0;
		for(int k=1;k<=m;k++) {
		
			if(i+k <=n) {
				
				res+=sol(i+k,n,m,str+Integer.toString(k));
			}
		}
		
		return res;
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n =sc.nextInt();
		int m = sc.nextInt();
		int res = sol(0,n,m,"");
		System.out.println();
		System.out.println(res);
		
		sc.close();
			
		
	}

}
