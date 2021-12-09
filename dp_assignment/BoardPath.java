package dp_assignment;

import java.util.HashMap;
import java.util.Scanner;

public class BoardPath {
	
	public static int sol(int  i ,int n,int m,String str,HashMap<Integer,String> hs,HashMap<Integer,Integer> dp) {
		
		if(i == n) {
			System.out.print(str+" ");
			return 1;
		}
		
		if(hs.containsKey(i)) {
			
			str+=hs.get(i);
			System.out.print(str+" ");
			return dp.get(i);
		}
		
		int res = 0;
		for(int k=1;k<=m;k++) {
		
			if(i+k <=n) {
				
				res+=sol(i+k,n,m,str+Integer.toString(k),hs,dp);
			}
		}
		hs.put(i, str);
		dp.put(i, res);
		return res;
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n =sc.nextInt();
		int m = sc.nextInt();
		
		HashMap<Integer,String> hs = new HashMap<>();
		HashMap<Integer,Integer> dp = new HashMap<>();
		int res = sol(0,n,m,"",hs,dp);
		System.out.println();
		System.out.println(res);
		
		sc.close();
			
		
	}

}
