package multithread;// Java program to multiply two square matrices.

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.Timer;

public class MatrixMultiplication {

    private static final String MATRIX1 = "resources/matrix1.txt";
    private static final String MATRIX2 = "resources/matrix2.txt";
    private static final String MATRIX3 = "resources/matrix3.txt";


    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length != matrix2.length) return null;

        int[][] resultMatrix = new int[matrix1.length][matrix2[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return resultMatrix;
    }

    public static int[][] generateRandomMatrix(int row, int col) {
        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void writeMatrix(int[][] matrix, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (int[] row : matrix) {
            bufferedWriter.write(Arrays.toString(row).replaceFirst("\\W+","").replaceAll("]","").replaceAll(", ", " "));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }


    public static void main(String[] args) throws IOException {


        int n, m, k;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter n,m,k: ");

//        n = scanner.nextInt();
//        m = scanner.nextInt();
//        k = scanner.nextInt();

        int[][] matrix1 = generateRandomMatrix(10, 10);
        System.out.println(Arrays.deepToString(matrix1));
        int[][] matrix2 = generateRandomMatrix(10, 10);

        System.out.println("Matrix 1:");
        //printMatrix(matrix1);
        writeMatrix(matrix1, MATRIX1);

        System.out.println("Matrix 2:");
        //printMatrix(matrix2);
        writeMatrix(matrix2, MATRIX2);
        long startTime = System.currentTimeMillis();
        int[][] resultMatrix = multiply(matrix1, matrix2);
        long elapsedTime = System.currentTimeMillis();
        if (resultMatrix != null) {
            System.out.println("Resultant matrix is: ");
        //    printMatrix(resultMatrix);
            writeMatrix(resultMatrix, MATRIX3);
        } else {
            System.out.println("Matrix multiplication is not possible");
        }
        System.out.println("Execution time is:" + (elapsedTime-startTime));
    }
}



