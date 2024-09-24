/**
 * The definition of node
 */
public class Node {
    int row;
    int column;
    int value;

    /**
     * pointer to the next node
     */
    Node next;


    public Node(int row, int column, int value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }



}
