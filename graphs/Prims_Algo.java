package graphs;

public class Prims_Algo {
	
	public static int prims(int[][] arr) {
		
		boolean vis[] = new boolean[arr.length];
		
		vis[0] = true;
		int cost = 0;
		int n = arr.length;
		
		for(int k =1;k<n;k++) {
			
			int s = 0,e = 0;
			
			for(int i =0;i<n;i++) {
				
				if(vis[i]) {
					
					for(int j = 0;j<n;j++) {
						
						if(!vis[j]) {
							
							if(arr[i][j] < arr[s][e]) {
								
								s = i;
								e = j;
							}
						}
					}
				}
			}
			
			vis[e] = true;
			cost+= arr[s][e];
		}
		
		return cost;
	}
	

	public static void main(String[] args) {

		int[][] conn = { { 0, 3, 0, 2, 0, 0, 0, 0, 4 }, // 0 //9*9
				{ 3, 0, 0, 0, 0, 0, 0, 4, 0 }, // 1
				{ 0, 0, 0, 6, 0, 1, 0, 2, 0 }, // 2
				{ 2, 0, 6, 0, 1, 0, 0, 0, 0 }, // 3
				{ 0, 0, 0, 1, 0, 0, 0, 0, 8 }, // 4
				{ 0, 0, 1, 0, 0, 0, 8, 0, 0 }, // 5
				{ 0, 0, 0, 0, 0, 8, 0, 0, 0 }, // 6
				{ 0, 4, 2, 0, 0, 0, 0, 0, 0 }, // 7
				{ 4, 0, 0, 0, 8, 0, 0, 0, 0 } // 8
		};

		for (int i = 0; i < conn.length; i++) {

			for (int j = 0; j < conn.length; j++) {

				if (conn[i][j] == 0) {
						
					conn[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		System.out.println(prims(conn));

	}

}
