package revision;

public class Q1 {
	
	public int front;
	public int size;
	public int[] data;
	
	public Q1() {
		
		front  = 0;
		size = 0;
		data=  new int[5];
	}
	
	public void enqueue(int n) throws Exception {
		
		if(size == data.length) {
			
			throw new Exception("Queue Full");
		}
		
		int idx = front + size;
		idx = (idx)% data.length;
		
		data[idx] = n;
		size++;
	}
	
	public int dequeue() throws Exception {
		
		if(size == 0) {
			throw new Exception("Queue Empty");
		}
		
		int temp = data[front];
		data[front] = 0;
		front++;
		front = (front)% data.length;
		size--;
		return temp;
		
	}

}
