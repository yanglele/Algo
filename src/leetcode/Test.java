package leetcode;

import java.util.List;
import java.util.Stack;

public class Test {

	 Stack<Integer> stack1 = new Stack<Integer>();
	  Stack<Integer> stack2 = new Stack<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 
		  Test test=new Test();
	}
	
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    for(int i=0;i<stack1.size();i++)
    	stack2.push(stack1.pop());
    return (stack2.pop()).intValue();
    }

	 public int[] multiply(int[] A) {
	        int length=A.length;
	        int[] B=new int[length];
	        for(int i=0;i<length;i++)
	        	B[i]=1;
	        for(int i=0;i<length;i++){
	            for(int j=0;j<length;j++){
	                if(j == i)
	                    B[i]*=1;
	                else
	                    B[i]*=A[j];
	            }
	        }
	        return B;
	    }
}
