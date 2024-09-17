public class Node {
    int row;
    int column;
    int value;

    /**
     * if reach to the end, this value should be null
     */
    Node next;


    public Node(int row, int column, int value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }


    public void setNext(Node next) {
        this.next = next;
    }
}
