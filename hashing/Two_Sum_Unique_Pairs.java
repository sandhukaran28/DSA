package hashing;

public class Two_Sum_Unique_Pairs {
	
	public static void sol(int arr[],int t) {
		
		int n = arr.length;
		int l = 0;
		int r = n-1;
		
		while(l < r) {
			
			int sum = arr[l] + arr[r];
			
			if(sum ==  t) {
				
				System.out.println(arr[l]+" "+ arr[r]);
				l++;
				r--;
				while(arr[l] == arr[l-1]) {
					l++;
				}
			}
			else if(sum > t) {
				
				r--;
			}
			else {
				l++;
			}
			
		}
	}

	public static void main(String[] args) {
		
		int arr[] = {1,1,2,3,4,4,5,6};
		sol(arr,6);
	}

}
