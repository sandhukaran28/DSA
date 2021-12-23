package hashing_Assignment;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Duplicate_Values_I {
	
	public static boolean sol(int arr[],int n) {
		
	Set<Integer> hs = new HashSet<>();
	
	for(int i=0;i<n;i++) {
		
		if(hs.contains(arr[i])) {
			return true;
		}
		
		hs.add(arr[i]);
	}
	
	return false;
	}
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int arr[] =new int[n];
		
		for(int i=0;i<n;i++) {
			
			arr[i] = sc.nextInt();
		}
		
		System.out.println(sol(arr,n));
		
		sc.close();

	}

}
