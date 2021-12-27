package graphs;

import java.util.Arrays;

public class Disjoint_Set_Union {
	
	int V;
	int[] parent;
	
	public Disjoint_Set_Union(int V) {
		
		this.V = V;
		parent = new int[V];
		Arrays.fill(parent, -1);
	}

	
	public int find(int u) {
		
		if(parent[u] == -1) {
			
			return u;
		}
		
		return find(parent[u]);
	}
	
	
	public void union(int u,int v) {
		
		int gfu = find(u);
		int gfv = find(v);
		
		if(gfu != gfv) {
			
			parent[gfu] = gfv;
		}
		
		
		
	}
	
	public boolean cycleDetection(int arr[][]) {
	
		for(int i = 0;i<arr.length;i++) {
			
			int u = arr[i][0];
			int v = arr[i][1];
			
			int gfu = find(u);
			int gfv = find(v);
			
			if(gfu == gfv) {
				
				return true;
			}
			else {
				
				union(gfu,gfv);
			}
		}
		
		return false;
		
	}
	
	public void display() {
		
	for(int e: parent) {
			
			System.out.print(e+" ");
		}
	}
	
	
	public static void main(String[] args) {
		
		Disjoint_Set_Union dsu = new Disjoint_Set_Union(5);
		
//		dsu.union(0, 1);
//		dsu.union(1, 4);
//		dsu.union(3, 0);
		
//		dsu.display();
		
		int arr[][] = { {0,1}, {1,2},{2,3},{3,4},{4,0}};
		
		System.out.println(dsu.cycleDetection(arr));
	}

}
