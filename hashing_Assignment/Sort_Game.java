package hashing_Assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Sort_Game {
	
	public static class Person{
		
		String name;
		int sal;
		
		public Person(String name,int sal) {
			
			this.name = name;
			this.sal = sal;
		}
	}

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int t = sc.nextInt();
		int n = sc.nextInt();
		
		List<Person> ls = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			
			String name = sc.next();
			int sal = sc.nextInt();
			
			if(sal >= t) {
				
				ls.add(new Person(name,sal));
			}
		}
		
		Collections.sort(ls, new Comparator<Person>() {
			
			@Override
			public int compare(Person o1, Person o2) {
				
				if(o1.sal != o2.sal) {
					
					return o2.sal - o1.sal;
				}
				else {
					return o1.name.compareTo(o2.name);
				}
			}
		});
		
		for(int i=0;i<ls.size();i++) {
			
			Person curr = ls.get(i);
			System.out.println(curr.name +" "+ curr.sal);
		}
		sc.close();

	}

}
