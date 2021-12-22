package hashing_Assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Group_Anagrams {
	
	 public static List<List<String>> sol(String[] arr) {
	        
	        
	        List<List<String>>  ans = new ArrayList<>();
	        
	        Map<String,List<String>> map = new HashMap<>();
	        
	        for(int i=0;i<arr.length;i++){
	            
	            int ch[] = new int[26];
	            
	            String curr = arr[i];
	            
	            for(int j = 0;j<curr.length();j++){
	                
	                char c = curr.charAt(j);
	                
	                ch[c - 'a']++;
	            }
	           String key  = Arrays.toString(ch);
	            List<String> ls = map.getOrDefault(key,new ArrayList<>());
	            
	            ls.add(curr);
	            map.put(key,ls);
	        }
	        
	        ans.addAll(map.values());
	        return ans;
	    }

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String arr[] =new String[n];
		
		for(int i=0;i<n;i++) {
			
			arr[i] = sc.next();
		}
		
		List<List<String>> ls =  sol(arr);
		
		for(int i=0;i<ls.size();i++) {
			
			List<String> curr = ls.get(i);
			
			for(int j= 0;j<curr.size();j++) {
				
				System.out.print(curr.get(j)+" ");
			}
			System.out.println();
		}
		
		
		sc.close();

	}

}
