package stacks;

import java.util.Scanner;
import java.util.Stack;

public class Score_Of_Paretheses {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s =sc.nextLine();
		
		Stack<Integer> st =new Stack<>();
		
		st.push(0);  // Current Score
		
		for(int i=0;i<s.length();i++) {
			
			if(s.charAt(i) == '(') {
				st.push(0);
			}
			else {
				
				int x = st.pop();
				int y = st.pop();
				
				int score = y +  Math.max(x*2, 1);
				st.push(score);
			}
		}
		
		System.out.println(st.pop());
			
		sc.close();
	}

}
