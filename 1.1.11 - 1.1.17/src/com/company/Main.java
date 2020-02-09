package com.company;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

class MatrixPrinter {
    public static void printMatrix(boolean[][] input) {
        int rows = input.length;
        int cols = input[0].length;
        StdOut.print("\t");
        for (int c = 0; c < cols; c++) {
            StdOut.print(c + "\t");
        }
        StdOut.print("\n");

        for (int i = 0; i < rows; i++) {
            StdOut.print(i + "\t");
            for (int j = 0; j < cols; j++) {
                if (input[i][j]) StdOut.print("*\t"); else StdOut.print(" \t");
            }
            StdOut.print("\n");
        }
    }

    public static boolean[][] transpond(boolean[][] input) {
        boolean[][] output = new boolean[input[0].length][input.length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                output[j][i] = input[i][j];
            }

        }
        return output;
    }
}

public class Main {

    public static int lg(int n) {
        int result = 0;
        for (int i = 1; 1<<i < n; i++) {
            StdOut.println(i*i);
            result = i;
        }
        return result;
    }

    public static int[] histogram(int[] a, int m) {
        int[] output = new int[m+1];
        for (int i = 0; i < a.length; i++) {
            output[a[i]]++;
        }
        return output;
    }

    public static String exR1(int n) {
        if (n <= 0) return "";
        StdOut.println(n);
        return exR1(n-3) + n + exR1(n-2) + n;
    }

    public static void main(String[] args) {

        StdOut.println(exR1(6));


    }

}
