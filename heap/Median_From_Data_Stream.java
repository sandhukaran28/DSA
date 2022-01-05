package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Median_From_Data_Stream {

	class MedianFinder {

		PriorityQueue<Integer> max;
		PriorityQueue<Integer> min;

		public MedianFinder() {

			min = new PriorityQueue<>();
			max = new PriorityQueue<>(Collections.reverseOrder());
		}

		public void addNum(int num) {

			if (max.isEmpty() || num <= max.peek()) {

				max.add(num);
			} else {
				min.add(num);
			}

			balance();
		}

		public double findMedian() {

			if (max.size() == min.size()) {

				return ((double) max.peek() + min.peek()) / 2;
			} else {

				return max.peek();
			}

		}

		public void balance() {

			if (max.size() > min.size() + 1) {
				min.add(max.poll());
			} else if (min.size() > max.size()) {

				max.add(min.poll());
			}
		}
	}

}
