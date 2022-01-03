package heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {

	List<Integer> nodes;

	public Heap() {

		nodes = new ArrayList<>();
		nodes.add(Integer.MIN_VALUE);

	}

	public void add(int val) {

		nodes.add(val);
		int ci = nodes.size() - 1;
		int parenti = ci / 2;

		while (ci > 1 && nodes.get(parenti) > nodes.get(ci)) {

			this.swap(parenti, ci);
			ci = parenti;
			parenti = ci / 2;
		}
		System.out.println(nodes);

	}

	public void swap(int i, int j) {
		int temp = nodes.get(i);
		nodes.set(i, nodes.get(j));
		nodes.set(j, temp);

	}

	public void remove() {
		this.swap(1, nodes.size() - 1);
		nodes.remove(nodes.size() - 1);

		downHeapify(1);

	}

	public void downHeapify(int ci) {

		int cl = ci * 2;
		int cr = ci * 2 + 1;

		if (cl >= nodes.size() && cr >= nodes.size()) {

			return;
		}

		if (cl >= nodes.size() && nodes.get(ci) > nodes.get(cr)) {

			this.swap(ci, cr);
			return;

		}
		if (cr >= nodes.size() && nodes.get(ci) > nodes.get(cl)) {

			this.swap(ci, cl);
			return;

		}

		int min = ci;

		if (min > cl) {
			min = cl;
		}
		if (min > cr) {

			min = cr;
		}

		if (ci != min) {

			this.swap(ci, min);
			downHeapify(min);

		}

	}

	public boolean isEmpty() {

		return this.nodes.size() == 1;
	}

	public int get() {

		return nodes.get(1);
	}

	public static void main(String[] args) {

		Heap h = new Heap();

		h.add(1);
		h.add(2);
		h.add(3);
		h.remove();
		System.out.println(h.get());
		System.out.println(h.isEmpty());
		System.out.println(h.nodes);

	}

}
