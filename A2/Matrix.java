

public class Matrix {

    private final String title;

    private final int rows;
    private final int cols;

    private final SinglyLinkedList data;

    public Matrix(String title, int rows, int cols, SinglyLinkedList data) {
        this.title = title;
        this.rows = rows;
        this.cols = cols;
        this.data = data;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public SinglyLinkedList getData() {
        return data;
    }

    public String getDataStr(){

        if(data.head == null){
            return "";
        }
        StringBuilder str = new StringBuilder();
        Node pre = data.head;
        while (pre != null && pre.value != 0){
            str.append(pre.value).append(" ");
            pre = pre.next;
        }
        return str.toString();
    }


    public String printMatrix(){
        StringBuilder str = new StringBuilder();
        Node node = data.head;
        for (int i = 0; i <rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (node != null && (i == node.row && j == node.column)){
                    str.append(node.value).append(" ");
                    node = node.next;
                } else {
                    str.append("0 ");
                }
            }
            str.append("\n");
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return  title +": " +getDataStr()+"\n"+ printMatrix();
    }
}
