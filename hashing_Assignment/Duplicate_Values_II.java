package hashing_Assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Duplicate_Values_II {
	
	public static boolean sol(int arr[],int n,int t) {
		
		HashMap<Integer,List<Integer>> map = new HashMap<>();
		
		for(int i=0;i<n;i++) {
			
			if(map.containsKey(arr[i])) {
				
				List<Integer> ls = map.get(arr[i]);
				
				for(int j=0;j<ls.size();j++) {
					
					int curr= ls.get(j);
					
					if(Math.abs(curr - i) <= t) {
						
						return true;
					}
				}
				ls.add(i);
				map.put(arr[i], ls);
			}
			else {
				
				List<Integer> ls = new ArrayList<>();
				
				ls.add(i);
				map.put(arr[i], ls);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			
			arr[i] = sc.nextInt();
		}
		
		int t = sc.nextInt();
		
		System.out.println(sol(arr,n,t));
		
		
		
		sc.close();

	}

}
