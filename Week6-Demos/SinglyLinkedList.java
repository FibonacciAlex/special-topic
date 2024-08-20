
// using user-defined LinkedList

public class SinglyLinkedList {

	// defining a node in singly linked list
	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	// defining the head of a singly linked list
	public Node head = null;

	// Method to add a node to the beginning of the LinkedList
	public void addNodeToFirst(int data) {
		Node newNode = new Node(data);
		newNode.next = head; // New node points to the current head
		head = newNode; // New node becomes the new head
	}

	// Method to add a node to the end of the LinkedList
	public void addNodeToEnd(int data) {
		Node newNode = new Node(data);

		if (head == null) { // If the list is empty
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) { // Traverse to the last node
				current = current.next;
			}
			current.next = newNode;
		}
	}

	// Method to insert a node after a specific key
	public void insertAfterKey(int key, int data) {
		Node current = head;

		// Traverse the list to find the key
		while (current != null && current.data != key) {
			current = current.next;
		}

		if (current != null) { // If key is found
			Node newNode = new Node(data);
			newNode.next = current.next; // New node points to the next node of current
			current.next = newNode; // Current node points to the new node
		} else {
			System.out.println("Key " + key + " not found in the list.");
		}
	}

	// Method to insert a node at the Nth position
	public void insertNth(int index, int data) {
		if (index < 0) {
			System.out.println("Invalid index.");
			return;
		}

		Node newNode = new Node(data);

		if (index == 0) { // Insert at the beginning
			newNode.next = head;
			head = newNode;
			return;
		}

		// traverse the linked list to position N-1
		Node current = head;
		for (int i = 0; current != null && i < index - 1; i++) {
			current = current.next;
		}

		if (current == null) {
			System.out.println("Index " + index + " is out of bounds.");
			return;
		}

		// insert the newNode after current (position N-1)
		newNode.next = current.next;
		current.next = newNode; // newNode at Nth position
	}

	// Method to remove a node with a specific key
	public void removeByKey(int key) {
		if (head == null) {
			System.out.println("The list is empty.");
			return;
		}

		// If the head node itself holds the key to be deleted
		if (head.data == key) {
			head = head.next;
			return;
		}

		Node current = head;
		Node previous = null;

		// Search for the key to be deleted
		while (current != null && current.data != key) {
			previous = current;
			current = current.next;
		}

		if (current == null) { // If key is not found
			System.out.println("Key " + key + " not found.");
			return;
		}

		// Unlink the node from the linked list
		previous.next = current.next;
	}

	// Method to remove the Nth element from the LinkedList
	public void removeNth(int index) {
		if (head == null) {
			System.out.println("The list is empty.");
			return;
		}

		if (index < 0) {
			System.out.println("Invalid index.");
			return;
		}

		if (index == 0) { // Remove the head node
			head = head.next;
			return;
		}

		Node current = head;
		Node previous = null;

		for (int i = 0; current != null && i < index; i++) {
			previous = current;
			current = current.next;
		}

		if (current == null) {
			System.out.println("Index " + index + " is out of bounds.");
			return;
		}

		// Unlink the node from the linked list
		previous.next = current.next;
	}

	// Method to display the elements of the LinkedList
	public void displayList() {
		if (head == null) {
			System.out.println("The list is empty.");
			return;
		}

		Node current = head;
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println("null");
	}

	public static void main(String[] args)

	{
		// creating a new list
		SinglyLinkedList list = new SinglyLinkedList();

		// Adding nodes to the end of the list
		list.addNodeToEnd(10);
		list.addNodeToEnd(20);
		list.addNodeToEnd(30);
		list.addNodeToEnd(40);
		
		// Display the list
		list.displayList(); // Output: 10 -> 20 -> 30 -> 40 -> null
		
		// Adding nodes to the front of the list
		list.addNodeToFirst(50);

		// Display the list
		list.displayList(); // Output: 50 -> 10 -> 20 -> 30 -> 40 -> null

		// Insert after a specific key
		list.insertAfterKey(20, 25);
		list.displayList(); // Output: 50 -> 10 -> 20 -> 25 -> 30 -> 40 -> null

		// Insert at the 3rd position (index 2)
		list.insertNth(2, 15);
		list.displayList(); // Output: 50 -> 10 -> 15 -> 20 -> 25 -> 30 -> 40 -> null

		// Remove the node with key 25
		list.removeByKey(25);
		list.displayList(); // Output: 50 -> 10 -> 15 -> 20 -> 30 -> 40 -> null

		// Remove the 2nd node (index 1)
		list.removeNth(1);
		list.displayList(); // Output: 50 -> 15 -> 20 -> 30 -> 40 -> null

	}

}
