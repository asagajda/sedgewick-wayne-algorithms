package com.company;

import edu.princeton.cs.algs4.Count;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

class Counter {
    public int count = 0;
}

public class MyMain {
    public static int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        int remainder = a % b;
        if (remainder != 0)  {
            return gcd(b, a % b);
        }
        return b;
    }

    public static boolean[][] relativelyPrimeMatrix(int size) {
        boolean[][] matrix = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (gcd(i, j) > 1) {
                    matrix[i][j] = true;
                } else {
                    matrix[i][j] = false;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int size = 50;
        boolean[][] m = relativelyPrimeMatrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (m[i][j]) {
                    StdOut.print(" * ");
                } else {
                    StdOut.print("   ");
                }
            }
            StdOut.print("\n");
        }
    }
}

//javac -cp ../algs4.jar ./src/com/company/MyMain.java
//java -cp ../algs4.jar:./src com.company.MyMain < input1.txt
