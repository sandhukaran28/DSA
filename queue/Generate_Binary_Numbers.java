package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Generate_Binary_Numbers {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Queue<String> q = new LinkedList<>();

		String num = "1";
		q.add(num);

		int n = sc.nextInt();

		while (n-- > 0) {

			String n1 = q.poll();

			System.out.print(n1 + " ");

			q.add(n1 + '0');

			q.add(n1 + '1');
		}

		sc.close();

	}

}
