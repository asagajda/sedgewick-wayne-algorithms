package com.company;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

class LogFac {
    static double logFacVal(int n) {
        return Math.log(fac(n));
    }

    static int fac(int n) {
        if (n == 1) return 1;
        return fac(n-1)*n;
    }
}

public class Main {

    public static void main(String[] args) {
        StdOut.println(LogFac.fac(4));
    }

}
