package leetcode;

import java.util.Stack;

public class LC232 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//push时，先将stack2中数据全部pop到stack1中，然后将外部push值push进stack1，然后将stack1中值全部push进stack2
	Stack<Integer> stack1=new Stack<Integer>();
	Stack<Integer> stack2=new Stack<Integer>();
	// Push element x to the back of queue.
    public void push(int x) {
    	while(!(stack2.empty()))
    		stack1.push(stack2.pop());
    	stack1.push(x);
    	while(!(stack1.empty()))
    		stack2.push(stack1.pop());    
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack2.pop();
    }

    // Get the front element.
    public int peek() {
    	return stack2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        
    	return stack2.empty();
    }
}
