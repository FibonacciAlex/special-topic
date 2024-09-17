package Week7;

import java.util.LinkedList;

public class Graph {

	// Number of vertices in the graph
	private int vertices;
	// Array of linked lists to store adjacency list for each vertex
	private LinkedList<Integer>[] adjacencyList;

	// Constructor
	public Graph(int vertices) {
		this.vertices = vertices;
		adjacencyList = new LinkedList[vertices];

		// Initialize adjacency lists for all vertices
		for (int i = 0; i < vertices; i++) {
			adjacencyList[i] = new LinkedList<>();
		}
	}

	// Method to add an edge into the graph
	public void addEdge(int source, int destination) {
		// Since it's an undirected graph, add an edge from source to destination
		adjacencyList[source].add(destination);

		// For undirected graph, also add an edge from destination to source
		adjacencyList[destination].add(source);
	}

	// Method to display the adjacency list of the graph
	public void printGraph() {
		for (int i = 0; i < vertices; i++) {
			System.out.print("Vertex " + i + ": ");
			for (Integer edge : adjacencyList[i]) {
				System.out.print(" -> " + edge);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// Create a graph with 5 vertices
		Graph graph = new Graph(5);

		// Add edges
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		// Print the adjacency list representation of the graph
		graph.printGraph();
	}
}