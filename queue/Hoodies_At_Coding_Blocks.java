package queue;

import java.util.LinkedList;
import java.util.Scanner;

public class Hoodies_At_Coding_Blocks {

	static class Student {

		public int course, roll;

		Student(int course, int roll) {
			this.course = course;
			this.roll = roll;
		}
	}

	public static int find(LinkedList<Student> l, int course, int i) {

		if (l.size() == 0) {

			return -1;
		}

		Student curr = l.removeLast();
		if (curr.course == course) {
			return i;
		}

		return find(l, course, i + 1);

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		LinkedList<Student> q = new LinkedList<>();

		int qu = sc.nextInt();

		while (qu-- > 0) {

			char type = sc.next().charAt(0);
			if (type == 'E') {

				int course = sc.nextInt();
				int roll = sc.nextInt();
				Student stu = new Student(course, roll);
				@SuppressWarnings("unchecked")
				int res = find((LinkedList<Student>) q.clone(), course, 0);
				if (res == -1) {

					q.addLast(stu);
				} else {

					q.add(q.size() - res, stu);
				}

			} else {
				Student stu = q.poll();
				System.out.println(stu.course + " " + stu.roll);
			}

		}
	}

}
