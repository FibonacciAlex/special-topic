import java.util.LinkedList;

public class Matrix {

    private String title;

    private int rows;
    private int cols;

    private LinkedList<Node> data;

    public Matrix(String title, int rows, int cols, LinkedList<Node> data) {
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

    public LinkedList<Node> getData() {
        return data;
    }

    public String getDataStr(){

        if(data.isEmpty()){
            return "";
        }
        StringBuilder str = new StringBuilder();
        Node pre = data.getFirst();
        while (pre != null){
            str.append(pre.value).append(" ");
            pre = pre.next;
        }
        return str.toString();
    }


    public String printMatrix(){
        StringBuilder str = new StringBuilder();
        Node node = data.getFirst();
        for (int i = 0; i <rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (node != null && (i == node.row && j == node.column)){
                    str.append(node.value).append(" ");
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
        return  title +" " +getDataStr()+"\n"+ printMatrix();
    }
}
