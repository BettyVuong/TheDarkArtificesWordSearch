/**
 * Betty Vuong 
 * ICS4U
 * 23/06/22
 * Class acts like a stack. The Stack can push, pop, empty, check if stack is empty or full, calculate stack size. Stack stores int
 * values that indicate a certain search set in main and WordSearch class. Stacks store the int values correlating to the word search
 * set by a specific order in main. 
 */
public class Stack {
	private int top;
	private int[] data;

		// constructor method
		public Stack() {
		top = 0;
		data = new int[3];

		}

		// overloaded constructor method
		public Stack(int n) {
		top = 0;
		data = new int[n];
		}
		
		// tells if stack is empty or not
		// post: returns boolean, if stack is empty, return true, is stack is not empty, return false
		public boolean isEmpty() { // empties stack
			return top == 0; 
		}
		
		// pushes an element on top of stack
		public void push (int n) {
			if (!isFull()) { //if there is still space to push elements into the stack
				data[top] = n;
				top++;
			} else {
				System.out.println("Full"); // if there is no space to push elements into the stack, indicates user
			}
			
		}
		
		// returns the element on the top of the stack, but does not remove it
		// post: return int top element value
		public int top() {
			if (!isEmpty()) { // if stack is not empty, return (view and use) the top element value but does not remove the value from the stack
				return data[top-1];
			}
			
			return 0; // if stack is empty
		}
		
		//calculates how many items are in the stack
		public int size() {
			return top; 
		}
		
		// removes top element from stack
		// post: return int element value
		public int pop() {
			if(!isEmpty()) { // if stack is not empty, remove element and returns the top element of the stack
				top--;
				return data[top];
				} 
			return 0; // if stack is empty
		}
		
		// makes stack empty
		public void makeEmpty() {
			top = 0;
		}
		
		// tells if stack is full or not
		// post: returns boolean, if stack is full, return true, is stack is not full, return false
		public boolean isFull() {
			return top == data.length;
		}

}
