import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Alexander Zhao
 */
public class AssignmentTwoMain {

    public static void main(String[] args) throws Exception {

        String currentPath = System.getProperty("user.dir");
        System.out.println("Current Working Directory: " + currentPath);

        String filePath1 = currentPath + "/A2/matrix1.txt"; // matrix 1 file relative path
        String filePath2 = currentPath + "/A2/matrix2.txt"; // matrix 2 file relative path

        Matrix matrix1 = createMatrixFromFile(filePath1, "Matrix 1");
        printMatrix(matrix1);
        Matrix matrix2 = createMatrixFromFile(filePath2, "Matrix 2");
        printMatrix(matrix2);
        Matrix resultMatrix = addMatrices(matrix1, matrix2);
        printMatrix(resultMatrix);
    }

    public static void printMatrix(Matrix matrix) {
        System.out.println(matrix);
    }


    /**
     * Merge two matrices and return a new one
     * @param m1 first matrix
     * @param m2 second matrix
     * @return a new matrix will be return
     */
    private static Matrix addMatrices(Matrix m1, Matrix m2){
        if(m1 == null || m2 == null){
            System.out.println("The matrix should not be null");
            return null;
        }

        if(m1.getCols() != m2.getCols() || m1.getRows() != m2.getRows()){
            System.out.println("The matrices should be the same size");
            return null;
        }

        int row = m1.getRows();
        int col = m1.getCols();
        Node node1=null;
        Node pre = null;
        Node node2=null;
        if(!m1.getData().isEmpty()){
            node1 = m1.getData().getFirst();
        }
        if(!m2.getData().isEmpty()){
            node2 = m2.getData().getFirst();
        }

        LinkedList<Node> mergeNodes = new LinkedList<>();


        boolean end = false;
        while(!end) {
            int state = compare(node1, node2);
            Node newNode = null;
            switch (state) {
                case -1:
                    // n1 ahead of n2, use n1
                    if(node1 != null){
                        newNode = new Node(node1.row, node1.column, node1.value);
                        mergeNodes.add(newNode);
                        node1 = node1.next;
                    }
                    break;
                case 0:
                    // n1 same position of n2, combine them
                    if(node1 != null && node2 != null){
                        int value = node1.value + node2.value;
                        newNode = new Node(node1.row, node1.column, value);
                        mergeNodes.add(newNode);
                        //move the pointer to the next one
                        node1 = node1.next;
                        node2 = node2.next;
                    }
                    break;
                case 1:
                    //n2 ahead of n1, use n2
                    if(node2 != null){
                        newNode = new Node(node2.row, node2.column, node2.value);
                        mergeNodes.add(newNode);
                        node2 = node2.next;
                    }
                    break;
                default:
                    break;
            }

            if (node1 == null && node2 == null) {
                end = true;
            }

            if(pre != null){// not the first node
                pre.next = newNode;
            }
            pre = newNode;

        }
        return new Matrix("Matrix Result", row, col, mergeNodes);
    }


    /**
     * -1= n1 ahead of n2    0= n1 same position of n2   1 = n2 ahead of n1
     * @param n1 first node
     * @param n2 second node
     * @return -1, 0, or 1
     */
    private static int compare(Node n1, Node n2){
        if(n1 == null && n2 == null){
            return 0;
        }
        if(n1 == null){
            //n1 already to the end, use n2
            return 1;
        }
        if(n2 == null){
            //n2 already to the end, use n1
            return -1;
        }
        //compare row first
        if(n1.row < n2.row){
            return -1;
        }else if(n1.row > n2.row){
            return 1;
        }
        //same row, compare column
        if(n1.column < n2.column){
            return -1;
        }else if(n1.column > n2.column){
            return 1;
        }
        return 0;
    }

    private static Matrix createMatrixFromFile(String path, String title) throws Exception{
        int row = 0, col = 0;
        LinkedList<Node> data = new LinkedList<>();
        List<String> lines;
        Node pre = null;
        try {
            lines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            System.out.println("Find target file from path:" + path);
            throw e;
        }

        for (int i = 0; i < lines.size(); i++) {
            String[] strArys = lines.get(i).split(" ");
            if(i == 0){
                //first line should be the size of matrix
                row = Integer.parseInt(strArys[0]);
                col = Integer.parseInt(strArys[1]);
                continue;
            }

            //cols
            for (int j = 0; j < strArys.length; j++) {
                int v = Integer.parseInt(strArys[j]);
                if(v == 0){
                    //skip 0 value
                    continue;
                }
                Node n = new Node(i - 1, j, v);
                data.add(n);
                if(pre != null){
                    pre.setNext(n);
                }
                pre = n;
            }
        }

        return new Matrix(title, row, col, data);

    }

}
