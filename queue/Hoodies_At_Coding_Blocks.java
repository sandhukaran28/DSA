package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Hoodies_At_Coding_Blocks {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList<Queue<Integer>> courses = new ArrayList<>();

		for (int i = 0; i <= 4; i++) {

			courses.add(new LinkedList<>());
		}

		ArrayList<Integer> order = new ArrayList<>();
		int qu = sc.nextInt();

		while (qu-- > 0) {

			char type = sc.next().charAt(0);
			if (type == 'E') {

				int course = sc.nextInt();
				int roll = sc.nextInt();
				courses.get(course).add(roll);

				if (!order.contains(course)) {
					order.add(course);
				}

			} else {

				int course = order.get(0);

				int roll = courses.get(course).remove();

				System.out.println(course + " " + roll);

				if (courses.get(course).isEmpty()) {
					order.remove(0);
				}
			}
		}
		sc.close();
	}

}
