/**
 * Created by annezhao on 4/25/16.
 */
public class StaticScheduling {

    int numOfCores;
    int matrixSize;
    static int[][] A;
    static int[][] B;
    static int[][] C;

    public StaticScheduling(int cores, int size) {
        numOfCores = cores;
        matrixSize = size;
        A = MatrixGenerator.generate(size);
        B = MatrixGenerator.generate(size);
        C = new int[size][size];
    }

    public void displayA() {display(A);}

    public void displayB() {display(B);}

    public void displayC() {display(C);}

    private void display(int[][] matrix) {
        for (int i = 0 ; i < matrixSize ; i++ ) {
            for (int j = 0 ; j < matrixSize ; j++ )
                System.out.print(matrix[i][j]+"\t");

            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        StaticScheduling staticScheduling = new StaticScheduling(1, 3);

        Thread[] threads = new Thread[1];

        for (int i=0; i<threads.length; i++) {
            threads[i] = new Thread(new StaticThread(staticScheduling.A, staticScheduling.B, staticScheduling.C, 0, 3, staticScheduling.matrixSize));
        }

        for (Thread thread : threads) {
            thread.run();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Matrix A:");
        staticScheduling.displayA();
        System.out.println();

        System.out.println("Matrix B:");
        staticScheduling.displayB();
        System.out.println();

        System.out.println("Matrix C:");
        staticScheduling.displayC();
        System.out.println();

    }


}
