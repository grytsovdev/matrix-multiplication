package multithread;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {

    private static final String MATRIX1 = "resources/matrix1.txt";
    private static final String MATRIX2 = "resources/matrix2.txt";
    private static final String MATRIX3 = "resources/matrix3.txt";

    public static int[][]readMatrixFromFile(File file) throws FileNotFoundException {
        int[][] matrix = new int[10][10];
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                for (int i = 0; i < matrix.length; i++) {
                    String[] line = sc.nextLine().trim().split(" ");
                    for (int j = 0; j < line.length; j++) {
                        matrix[i][j] = Integer.parseInt(line[j]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return matrix;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int[][] m1 = readMatrixFromFile(new File(MATRIX1));
        int[][] m2 = readMatrixFromFile(new File(MATRIX2));
        int[][] result = new int[m1.length][m2[0].length];
        long start = System.currentTimeMillis();
        ParallelThreadsCreator.multiply(m1, m2, result);
        long end = System.currentTimeMillis();
        MatrixMultiplication.printMatrix(result);





        System.out.println("\nTime taken in milli seconds: " + (end - start));

    }
}
