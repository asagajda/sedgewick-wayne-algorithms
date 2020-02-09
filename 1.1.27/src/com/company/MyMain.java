package com.company;

import edu.princeton.cs.algs4.Count;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

class Counter {
    public int count = 0;
}

public class MyMain {
// https://www.youtube.com/watch?v=3D_Oj16EtD8
    public static double binomial(int n, int k, double p, int depth, Counter counter) {
//        StdOut.println(depth);
//        counter.count++;
//        StdOut.println(counter.count);
        if ((n == 0) && (k == 0)) return 1.0;
        if ((n < 0) || (k < 0)) return 0.0;
        return (1 - p)*binomial(n - 1, k, p, depth + 1, counter) + p*binomial(n - 1, k - 1, p, depth + 1, counter);
    }

    public static double[][] getStorageForImproved(int n, int k) {
        double[][] arr = new double[n+1][k+1];
        for(int i = 0; i < n + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                arr[i][j] = -1;
            }
        }
        return arr;
    }

    public static double binomialImproved(double[][] arr, int n, int k, double p) {
        if ((n == 0) && (k == 0)) return 1.0;
        if ((n < 0) || (k < 0)) return 0.0;
        if (arr[n][k] == -1) {
            arr[n][k] = (1 - p)*binomialImproved(arr, n - 1, k, p) + p*binomialImproved(arr, n - 1, k - 1, p);
        }
        return arr[n][k];
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
//        StdOut.println(binomial(100, 50, 0.25, 0, counter));
        StdOut.println(binomial(6, 2, 0.7, 0, counter));
        StdOut.println(binomialImproved(getStorageForImproved(6, 2), 6, 2, 0.7));

        StdOut.println(binomialImproved(getStorageForImproved(100, 50), 100, 50, 0.7));


    }
}

//javac -cp ../algs4.jar ./src/com/company/MyMain.java
//java -cp ../algs4.jar:./src com.company.MyMain < input1.txt
