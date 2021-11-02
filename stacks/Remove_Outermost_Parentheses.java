package stacks;

import java.util.Scanner;
import java.util.Stack;

public class Remove_Outermost_Parentheses {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in); 
		
		String s = sc.nextLine();
		String res ="";
		
		Stack<Character> st =new Stack<>();
		
		int cnt = 0;
		
		for(int i=0;i<s.length();i++) {
			
			if(s.charAt(i) == '(') {
				st.push('(');
			}
			else {
				
				if(st.size() == 1 && cnt == 0) {
					st.pop();
				}
				else  {
					while(st.size() != 1) {
						
						cnt++;
						res+='(';
						st.pop();
					}
					
					if(cnt!= 0) {
						res+=')';
						cnt--;
					}
				}
			}
		}
		System.out.println(res);
		sc.close();

	}

}
