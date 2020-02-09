package com.company;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MyMain {
    public static int indexOf(int[] arr, int n) {
        return indexOf(arr, n, 0, arr.length - 1, 0);
    }

    public static int indexOf(int[] arr, int key, int start, int end, int depth) {
//        for (int i = 0; i < depth; i++) {
//            StdOut.print("\t");
//        }
//        StdOut.println(start + " " + end);
        if (start > end) return -1;
        int midIndex = (end - start) / 2 + start;
        if (key == arr[midIndex]) return midIndex;
        if (key < arr[midIndex]) return indexOf(arr, key, start, midIndex - 1, depth + 1);
        if (key > arr[midIndex]) return indexOf(arr, key,  midIndex + 1, end, depth + 1);
        return -1;
    }

    public static void checkList(int[] arr, int[] keys, String operation) {
        for (int i = 0; i < keys.length; i++) {
            if (operation == "+") if (indexOf(arr, keys[i]) > -1) StdOut.print(keys[i] + ", ");
        }
        for (int i = 0; i < arr.length; i++) {
            if (operation == "-") if (indexOf(keys, arr[i]) == -1) StdOut.print(arr[i] + ", ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        int[] input = {1, 4, 6, 7, 8};
        StdOut.println(MyMain.indexOf(input, 1));
        StdOut.println(MyMain.indexOf(input, 4));
        StdOut.println(MyMain.indexOf(input, 6));
        StdOut.println(MyMain.indexOf(input, 7));
        StdOut.println(MyMain.indexOf(input, 8));
        StdOut.println(MyMain.indexOf(input, 0));
        StdOut.println(MyMain.indexOf(input, 10));

        int[] list = {4, 6, 9};
        MyMain.checkList(input, list, "+");
        MyMain.checkList(input, list, "-");
    }
}

//javac -cp ../algs4.jar ./src/com/company/MyMain.java
//java -cp ../algs4.jar:./src com.company.MyMain < input1.txt
