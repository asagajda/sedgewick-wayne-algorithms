package com.company;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MyMain {

    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int a = StdIn.readInt();
            int b = StdIn.readInt();
            StdOut.printf("%-15s\t%5d\t%5d\t%5.5f\n", name, a, b, (double)a/(double)b);
        }
    }
}

//javac -cp ../algs4.jar ./src/com/company/MyMain.java
//java -cp ../algs4.jar:./src com.company.MyMain < input1.txt
