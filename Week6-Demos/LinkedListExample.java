
import java.util.LinkedList;

// using java.util.LinkedList

public class LinkedListExample {

	public static void main(String[] args) {
		// Create a LinkedList to store integers
		LinkedList<Integer> linkedList1 = new LinkedList<>();

		// Add elements to the end of LinkedList
		linkedList1.add(10);
		linkedList1.add(20);
		linkedList1.add(30);
		linkedList1.add(40);
		linkedList1.add(50);
		linkedList1.add(2,60); //Adding an element at the specific position  
		
		// Print the LinkedList
		System.out.println("LinkedList:" + linkedList1);
		
		linkedList1.addFirst(70); // Add element to the front of LinkedList
		linkedList1.addLast(80); // Add element to the end of LinkedList
		
		// Print the LinkedList
		System.out.println("LinkedList after addFirst and addLast:" + linkedList1);

		// Remove the first element from the LinkedList
		linkedList1.removeFirst();
		System.out.println("LinkedList after removing first element:" + linkedList1);
		
		// Remove specific element from LinkedList
		linkedList1.remove(2);
		System.out.println("LinkedList after removing Index 2:" + linkedList1);
		
		// Remove the last element from the LinkedList
		linkedList1.removeLast();
		System.out.println("LinkedList after removing last element:" + linkedList1);

		// Check if an element exists in the LinkedList
		boolean containsElement = linkedList1.contains(30);
		System.out.println("LinkedList contains element 30?" + containsElement);

		// Get the first and last elements of the LinkedList
		int firstElement = linkedList1.getFirst();
		int lastElement = linkedList1.getLast();
		System.out.println("First element:" + firstElement);
		System.out.println("Last element:" + lastElement);

		// Clear the LinkedList
		linkedList1.clear();
		System.out.println("LinkedList after clearing:" + linkedList1);

	}

}
