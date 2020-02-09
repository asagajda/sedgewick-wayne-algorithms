package com.company;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MyMain {
    public static int gcd(int a, int b) {
        int remainder = a % b;
        StdOut.println(a + " " + b);
        if (remainder != 0)  {
            return gcd(b, a % b);
        }
        return b;
    }

    public static void main(String[] args) {
        StdOut.println(gcd(105, 24));
    }
}

// 1.1.25

//105  24  9  6
//        ___  __  _  _
//
//        24   9  6  3 <-
//
//
//        105 = (  24             * 4 + 9)
//        105 = (( 9    * 2 + 6)   * 4 + 9)
//        105 = (((6 * 1) + 3)  * 2 + 6)   * 4 + 9)
//
//
//        105 = (((6*1)+3)  *2 + 6)   * 4 + 9)
//
//        we can divide a = 6*1 by 3 =>
//        we can divide b = a+3 by 3 =>
//        we can divide c = b*2 by 3 =>
//        we can divide d = c+6 by 3 =>
//        we can divide e = d*4 by 3 =>
//        we can divide f = d+9 by 3, and
//        f=105
//        d=24

//javac -cp ../algs4.jar ./src/com/company/MyMain.java
//java -cp ../algs4.jar:./src com.company.MyMain < input1.txt
