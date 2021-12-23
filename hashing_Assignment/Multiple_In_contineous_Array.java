package hashing_Assignment;

import java.util.Scanner;

public class Multiple_In_contineous_Array {

	public static int sol(int arr[], int k) {
		
		int n =arr.length;
		
		for(int i=0;i<n;i++) {
			
			int sum = arr[i];
			for(int j =i+1;j<n;j++) {
				
				sum+=arr[j];
				if(sum%k == 0) {
					return 1;
				}
				
			}
		}
		return 0;

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String jsonArrayString = sc.next();
		String[] jsonArrayElements = jsonArrayString.substring(1, jsonArrayString.length() - 1).split(",");
		int[] arr = new int[jsonArrayElements.length];
		int i = 0;
		for (String j : jsonArrayElements) {
			arr[i] = Integer.parseInt(j);
			i++;
		}

		int k = sc.nextInt();
		int ans = sol(arr, k);
		
		if(ans == 1) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}

		sc.close();
	}

}
