package com.company;

import edu.princeton.cs.algs4.*;

class Matrix {
    public static double dot(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException();
        }
        double result = 0;
        for (int i = 0; i < x.length; i++) {
            result += x[i]*y[i];
        }
        return result;
    }
    public static double[][] mult(double[][] a, double[][] b) {
        if (a[0].length != b.length) {
            throw new IllegalArgumentException();
        }
        double[][] result = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                double[] col = new double[b.length];
                for (int k = 0; k < b.length; k++) {
                    col[k] = b[k][j];
                }
                result[i][j] = dot(a[i], col);
            }
        }
        return result;
    }
    public static double[][] transpose(double[][] a) {
        double[][] result = new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[j][i] = a[i][j];
            }
        }
        return result;
    }

    public static double[] mult(double[][] a, double[] cv) {
        double[][] colMatrix = colVectorToMatrix(cv);
        double[][] product = mult(a, colMatrix);
        return colMatrixToVector(product);
    }

    public static double[] mult(double[] rv, double[][] a) {
        double[][] rowMatrix = rowVectorToMatrix(rv);
        double[][] product = mult(rowMatrix, a);
        return rowMatrixToVector(product);
    }

    private static double[][] colVectorToMatrix(double[] b) {
        double[][] colB = new double[b.length][1];
        for (int i = 0; i < b.length; i++) {
            double[] temp = new double[1];
            temp[0] = b[i];
            colB[i] = temp;
        }
        return colB;
    }

    private static double[][] rowVectorToMatrix(double[] b) {
        double[][] rowB = transpose(colVectorToMatrix(b));
        return rowB;
    }

    private static double[] colMatrixToVector(double[][] m) {
        double[] result = new double[m.length];
        for (int i = 0; i < m.length; i++) {
           result[i] = m[i][0];
        }
        return result;
    }

    private static double[] rowMatrixToVector(double[][] m) {
        double[] result = new double[m[0].length];
        for (int i = 0; i < m[0].length; i++) {
            result[i] = m[0][i];
        }
        return result;
    }
}

public class MyMain {

    public static void main(String[] args) {

        // column vector
        StdOut.println("Enter column vector size");
        int cvSize = StdIn.readInt();
        double[] cv = new double[cvSize];
        StdOut.println("Enter column vector");
        for (int i = 0; i < cvSize; i++) {
            cv[i] = StdIn.readDouble();
        }
        StdOut.println("Column vector is: ");
        for (int i = 0; i < cvSize; i++) {
            StdOut.print(cv[i] + " ");
        }
        StdOut.println();
        StdOut.println();


        // row vector
        StdOut.println("Enter row vector size");
        int rvSize = StdIn.readInt();
        double[] rv = new double[rvSize];
        StdOut.println("Enter row vector");
        for (int i = 0; i < rvSize; i++) {
            rv[i] = StdIn.readDouble();
        }
        StdOut.println("Row vector is: ");
        for (int i = 0; i < rvSize; i++) {
            StdOut.print(rv[i] + " ");
        }
        StdOut.println();
        StdOut.println();


        // a matrix
        StdOut.println("Enter matrix a size: (rows, space, columns)");
        int aRowsSize = StdIn.readInt();
        int aColsSize = StdIn.readInt();
        double[][] a = new double[aRowsSize][aColsSize];
        StdOut.println("Enter a matrix");
        for (int i = 0; i < aRowsSize; i++) {
            for (int j = 0; j < aColsSize; j++) {
                a[i][j] = StdIn.readDouble();
            }
        }
        StdOut.println("a matrix is: ");
        for (int i = 0; i < aRowsSize; i++) {
            for (int j = 0; j < aColsSize; j++) {
                StdOut.print(a[i][j] + " ");
            }
            StdOut.println();
        }
        StdOut.println();
        StdOut.println();


        // b matrix
        StdOut.println("Enter matrix b size: (rows, space, columns)");
        int bRowsSize = StdIn.readInt();
        int bColsSize = StdIn.readInt();
        double[][] b = new double[bRowsSize][bColsSize];
        StdOut.println("Enter a matrix");
        for (int i = 0; i < bRowsSize; i++) {
            for (int j = 0; j < bColsSize; j++) {
                b[i][j] = StdIn.readDouble();
            }
        }
        StdOut.println("b matrix is: ");
        for (int i = 0; i < bRowsSize; i++) {
            for (int j = 0; j < bColsSize; j++) {
                StdOut.print(b[i][j] + " ");
            }
            StdOut.println();
        }
        StdOut.println();
        StdOut.println();


        // vectors dot product
        double dp = Matrix.dot(cv, cv);
        StdOut.println(dp);
        StdOut.println();


        // multiply two matrices
        double[][] r1 = Matrix.mult(a, b);
        for(int i = 0; i < r1.length; i++) {
            for (int j = 0; j < r1[0].length; j++) {
                StdOut.println(r1[i][j]);
            }
            StdOut.println();
        }
        StdOut.println();
        StdOut.println();


        // transpose matrix
        double[][] transposed = Matrix.transpose(a);
        for(int i = 0; i < transposed.length; i++) {
            for (int j = 0; j < transposed[0].length; j++) {
                StdOut.print(transposed[i][j] + " ");
            }
            StdOut.println();
        }
        StdOut.println();
        StdOut.println();


        // multiply matrix and column vector
        double[] r2 = Matrix.mult(a, cv);
        for(int i = 0; i < r2.length; i++) {
            StdOut.println(r2[i]);
        }
        StdOut.println();
        StdOut.println();


        // multiply row vector and matrix
        double[] r3 = Matrix.mult(rv, a);
        for(int i = 0; i < r3.length; i++) {
            StdOut.print(r3[i] + " ");
        }
        StdOut.println();
        StdOut.println();
    }
}

//javac -cp ../algs4.jar ./src/com/company/MyMain.java
//java -cp ../algs4.jar:./src com.company.MyMain < input1.txt
//javac -cp ../algs4.jar ./src/com/company/MyMain.java && java -cp ../algs4.jar:./src com.company.MyMain < input1.txt
