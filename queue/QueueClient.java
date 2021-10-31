package queue;

public class QueueClient {

	public static void main(String[] args) throws Exception {

		DynamicQueue queue = new DynamicQueue();

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.enqueue(100);
		queue.enqueue(100);
		queue.display();
		System.out.println(queue.isFull());
		queue.enqueue(300);
		queue.display();
		System.out.println(queue.isFull());

	}

}
