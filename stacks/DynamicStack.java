package stacks;

public class DynamicStack extends MyStack {
	
	public void push(int item) throws Exception {
		
		if(isFull()) {
			
			int[] newArray = new int[arr.length *2];
			
			for(int i=0;i<=tos;i++) {
				
				newArray[i] = arr[i];
			}
			
			arr= newArray;
			
		}
		
		super.push(item);
		
		
	}
	
	
	

}
