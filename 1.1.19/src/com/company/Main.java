package com.company;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

class Fibonacci {
    public static int fibonacci(int n) {
        int[] buff = {0, 1, 1};
        if (n < 3) {return buff[n];}
        int current = 3;
        while (current <= n) {
            buff[0] = buff[1];
            buff[1] = buff[2];
            buff[2] = buff[0] + buff[1];
            current++;
        }
        return buff[2];
    }

    public static int fibonacciRecursive(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacciRecursive(n - 2) + fibonacciRecursive(n - 1);
    }
}

public class Main {

    public static void main(String[] args) {
        StdOut.println(Fibonacci.fibonacciRecursive(5));
        StdOut.println(Fibonacci.fibonacci(5));
    }

}
