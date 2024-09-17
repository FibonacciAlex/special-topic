import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class AssignmentTwoMain {

    public static void main(String[] args) throws Exception {

       String path1 = args[0];
       String path2 = args[1];

//        String currentPath = System.getProperty("user.dir");
//        System.out.println("Current Working Directory: " + currentPath);
//        String filePath = currentPath + "/A2/matrix1.txt"; // file path
//        String filePath = currentPath + "/matrix1.txt"; // file path

        Matrix matrix1 = createMatrixFromFile(path1, "Matrix 1");
        Matrix matrix2 = createMatrixFromFile(path2, "Matrix 2");

        Matrix resultMatrix = addMatrices(matrix1, matrix2);




    }


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
        Node node1;
        Node node2;
        boolean end = false;
        while(!end){

            int state = compare(node1, node2);

            if(node1 == null && node2 == null){
                end = true;
            }

        }


    }


    private static int compare(Node n1, Node n2){
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
                col = Integer.parseInt(strArys[0]);
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
