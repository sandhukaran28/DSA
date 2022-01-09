package revision;

import java.util.Stack;
//https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1#
public class Stk3 {
	
	 public static int[] calculateSpan(int arr[], int n)
	    {
	        
	        int res[] =new int[n];
	        
	        res[0] = 1;
	        
	        Stack<Integer> st = new Stack<>();
	        st.push(0);
	        
	        for(int i=1;i<n;i++){
	            
	            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
	                
	                st.pop();
	            }
	            
	            if(st.isEmpty()){
	                
	                res[i] = i+1;
	            }
	            else{
	                
	                res[i] = i - st.peek();
	            }
	            
	            st.push(i);
	        }
	        
	        return res;
	        
	    }

}
