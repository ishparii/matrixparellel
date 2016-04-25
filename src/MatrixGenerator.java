import java.util.Random;

/**
 * Created by annezhao on 4/25/16.
 */

public class MatrixGenerator {
    int[][] matrix;
    Random r = new Random();

    public MatrixGenerator(int n) {
        for(int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                matrix[i][j] = r.nextInt(100);
            }
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

}
