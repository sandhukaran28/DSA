package queue;

public class MyQueue {

	int data[];
	int front;
	int size;

	public MyQueue() {

		data = new int[5];
		this.front = 0;
		this.size = 0;
	}

	public MyQueue(int cap) {

		data = new int[cap];
		this.front = 0;
		this.size = 0;
	}

	public void enqueue(int item) throws Exception {

		if (size == this.data.length) {
			throw new Exception("Queue is full");
		}

		int idx = front + size;
		idx = idx % data.length;
		this.data[idx] = item;
		size++;

	}

	public boolean isEmpty() {

		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() {

		if (size == data.length) {
			return true;
		} else {
			return false;
		}
	}

	public int dequeue() throws Exception {

		if (size == 0) {
			throw new Exception("Queue Empty");
		}

		int temp = data[front];
		data[front] = 0;
		size--;
		front++;
		front = front % data.length;

		return temp;
	}

	public void display() {

		for (int i = 0; i < data.length; i++) {

			int idx = (i + front) % data.length;

			System.out.print(data[idx] + " ");
		}
		System.out.println();
	}

}
