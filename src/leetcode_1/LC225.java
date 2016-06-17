package leetcode_1;

import java.util.ArrayDeque;
import java.util.Queue;

public class LC225 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Queue<Integer> queue1=new ArrayDeque<>();
	Queue<Integer> queue=new ArrayDeque<>();
	// Push element x onto stack.
    public void push(int x) {
        if(queue.isEmpty())
        	queue.add(x);
        else{
        	queue1.add(x);
        	while(!queue.isEmpty())
        		queue1.add(queue.poll());
        	
        	while( !queue1.isEmpty())
        		queue.add(queue1.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
    	queue.poll();
    }

    // Get the top element.
    public int top() {
    	return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(queue.isEmpty())
        	return true;
        else 
        	return false;
    }
}
