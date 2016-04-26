/**
 * Created by Ilona on 4/25/2016.
 */
public class DynamicThread implements Runnable {
    int[][] A;
    int[][] B;
    int[][] C;
    static int row;
    int size;

    public DynamicThread(int[][] A, int[][] B, int[][] C, int size) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.size = size;
    }

    @Override
    public void run() {
        int i = 0;
        while (row < size) {
            for (int j=0; j<size; j++) {
                for (int k=0; k<size; k++) {
                    C[i][j] = C[i][j] + (A[i][k]*B[k][j]);
                }
            }
        }
    }
}
