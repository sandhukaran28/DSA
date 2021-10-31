package queue;

public class DynamicQueue extends MyQueue {

	@Override
	public void enqueue(int item) throws Exception {

		if (this.isFull()) {

			int[] newData = new int[this.data.length * 2];

			for (int i = 0; i < data.length; i++) {

				int idx = (i + front) % data.length;

				newData[i] = this.data[idx];

			}
			front = 0;
			this.data = newData;

		}
		super.enqueue(item);
	}

}
