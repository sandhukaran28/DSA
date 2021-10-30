package stacks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Asteroid_Collision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {

			arr[i] = sc.nextInt();
		}

		Stack<Integer> st = new Stack<>();

		st.push(arr[0]);

		for (int i = 1; i < n; i++) {

			if (!st.isEmpty()) {

				int pre = st.peek();
				int curr = arr[i];

				if (pre > 0 && curr > 0 || pre < 0 && curr < 0 || pre < 0 && curr > 0) {

					st.push(curr);

				} else {
					
					st.push(curr);

					while (!st.isEmpty()&& st.size()>=2) {
						
					  curr = st.pop();
					  pre = st.pop();

						if (pre > 0 && curr > 0 || pre < 0 && curr < 0 || pre < 0 && curr > 0) {
							
							st.push(pre);
							st.push(curr);
							break;

						}
						else {
							
							if(Math.abs(curr) > Math.abs(pre)) {
								
								st.push(curr);
								
							}
							else if(Math.abs(curr) < Math.abs(pre)) {
								
								st.push(pre);
							}
						}

					}
				}

			} else {
				st.push(arr[i]);
			}

		}

		int res[] = new int[st.size()];

		for (int i = st.size() - 1; i >= 0; i--) {

			res[i] = st.pop();
		}

		System.out.println(Arrays.toString(res));
		sc.close();
	}

}
