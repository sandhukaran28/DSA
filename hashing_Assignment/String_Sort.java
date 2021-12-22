package hashing_Assignment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class String_Sort {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String arr[] = new String[n];

		for (int i = 0; i < n; i++) {

			arr[i] = sc.next();
		}

		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				if (o1.contains(o2)) {

					if(o2.length() > o1.length()) {
						return 1;
					}
					return -1;
					
				} else {
					return o1.compareTo(o2);
				}
			}
		});

		for (int i = 0; i < n; i++) {

			System.out.println(arr[i]);
		}

		sc.close();

	}

}
