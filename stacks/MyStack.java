package stacks;

public class MyStack {
	
	int[] arr;
	int tos;
	
	public MyStack() {
		arr= new int[5];
		tos= -1;
	}
	
	public MyStack(int size) {
		arr = new int[size];
		tos=-1;
	}
	
	public int size() {
		return tos+1;
	}
	
	
	public int peek() {
		return this.arr[tos];
	}
	
	public void push(int item) throws Exception {
		
		
		if(this.isFull()) {
			 throw new Exception("Stack Already full");
		}
		
		
		arr[++tos] = item; 
	}
	
	public boolean isEmpty() {
		if(this.size()>0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean isFull() {
		if(this.size() != arr.length) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	
	public int  pop() throws Exception{
		
		if(this.isEmpty()) {
			 throw new Exception("Nothing to Pop");
		}
		
		int temp = arr[tos];
		arr[tos] = 0;
		tos--;
		return temp;
	}
	
	public void display() {
		
		for(int i=tos;i>=0;i--) {
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
	}

}
