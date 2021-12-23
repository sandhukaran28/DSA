package hashing_Assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Longest_SubString_Without_Repitition {

	public static int sol(String s) {

		int max = 0;
		int st = 0;

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {

			char ch = s.charAt(i);

			if (map.containsKey(ch)) {

				max = Math.max(i - st, max);
				st = map.get(ch) + 1;
				map.put(ch, i);
			} else {

				map.put(ch, i);
			}
		}

		return max;

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while (t-- > 0) {

			String s = sc.next();
			System.out.println(sol(s));

		}

		sc.close();

	}

}
