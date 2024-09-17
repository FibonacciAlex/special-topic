package Week7;

import java.util.LinkedList;
import java.util.Queue;

//Class representing a Node in the binary tree
class Node {
	int value;
	Node left, right;

	// Constructor to create a new node
	public Node(int value) {
		this.value = value;
		left = right = null;
	}
}

//BinaryTree class with basic operations and ability to manually add children
public class BinaryTree {
	Node root;

	// Constructor for the BinaryTree
	public BinaryTree() {
		root = null;
	}

	// Add left child to a given node
	public void addLeftChild(Node parent, int value) {
		if (parent == null) {
			System.out.println("Parent node cannot be null");
			return;
		}

		parent.left = new Node(value);
	}

	// Add right child to a given node
	public void addRightChild(Node parent, int value) {
		if (parent == null) {
			System.out.println("Parent node cannot be null");
			return;
		}

		parent.right = new Node(value);
	}

	// Inorder traversal: left-root-right
	public void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left); // recursion
		System.out.print(node.value + " ");
		inorder(node.right); // recursion
	}

	// Preorder traversal: root-left-right
	public void preorder(Node node) {
		if (node == null)
			return;
		System.out.print(node.value + " ");
		preorder(node.left);
		preorder(node.right);
	}

	// Postorder traversal: left-right-root
	public void postorder(Node node) {
		if (node == null)
			return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.value + " ");
	}
	
	// Breadth-first traversal (level-order)
    public void breadthFirstTraversal() {
        if (root == null) {
            return;
        }

        // Create a queue for level-order traversal
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // Remove the current node from the front of the queue
            Node currentNode = queue.poll();
            System.out.print(currentNode.value + " ");

            // Add the left child to the queue if it exists
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            // Add the right child to the queue if it exists
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

	// Main method to test the BinaryTree class
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		// Manually creating the tree structure
		tree.root = new Node(1); // Root node

		// Adding children manually
		tree.addLeftChild(tree.root, 2);
		tree.addRightChild(tree.root, 3);

		tree.addLeftChild(tree.root.left, 4);
		tree.addRightChild(tree.root.left, 5);

		tree.addLeftChild(tree.root.right, 6);
		tree.addRightChild(tree.root.right, 7);

		// Traversal outputs
		System.out.print("Inorder traversal: ");
		tree.inorder(tree.root); // Output: 4 2 5 1 6 3 7
		System.out.println();

		System.out.print("Preorder traversal: ");
		tree.preorder(tree.root); // Output: 1 2 4 5 3 6 7
		System.out.println();

		System.out.print("Postorder traversal: ");
		tree.postorder(tree.root); // Output: 4 5 2 6 7 3 1
		System.out.println();
		
		// Perform breadth-first traversal (level-order traversal)
        System.out.print("Breadth-first traversal (Level-order): ");
        tree.breadthFirstTraversal();  // Output: 1 2 3 4 5 6 7
        System.out.println();
	}
}
