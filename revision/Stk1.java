package revision;

public class Stk1 {
	
	int data[];
	int tos;
	
	public Stk1() {
		
		data = new int[5];
		tos = -1;
	}
	
	public void push(int n) {
		
		data[tos++]  = n;
		
	}
	
	public int  delete() {
		
		int temp = data[tos];
		data[tos] = 0;
		tos--;
		return temp;
		
	}

}
