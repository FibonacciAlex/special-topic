
// using user-defined LinkedList

public class SinglyLinkedList {

	// defining the head of a singly linked list
	public Node head = null;

	// Method to add a node to the end of the LinkedList
	public Node addNodeToEnd(int row, int col,int data) {
		Node newNode = new Node(row, col, data);

		if (head == null) { // If the list is empty
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) { // Traverse to the last node
				current = current.next;
			}
			current.next = newNode;
		}
		return newNode;
	}

}
