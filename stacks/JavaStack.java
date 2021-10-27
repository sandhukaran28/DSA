package stacks;

public class JavaStack {

	public static void main(String[] args) throws Exception {

		DynamicStack st = new DynamicStack();

		for (int i = 0; i < 100; i++) {
			st.push(i);
		}

		st.display();

		System.out.println();
		System.out.println(st.peek());
	}
}
