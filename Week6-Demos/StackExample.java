
import java.util.Stack;

public class StackExample {
	public static void main(String[] args) {
		// Create a stack
		Stack<Integer> stack = new Stack<>();

		// Push elements onto the stack
		stack.push(10);
		stack.push(20);
		stack.push(30);

		// Print the top element of the stack
		System.out.println("Top element:" + stack.peek());

		// Pop elements from the stack
		int poppedElement = stack.pop();
		System.out.println("Popped element:" + poppedElement);

		// Check if the stack is empty
		System.out.println("Is stack empty?" + stack.isEmpty());

		// Get the size of the stack
		System.out.println("Stack size:" + stack.size());

		// Iterate over the stack
		System.out.println("Stack elements:");
		for (Integer element : stack) {
			System.out.println(element);
		}
	}
}
