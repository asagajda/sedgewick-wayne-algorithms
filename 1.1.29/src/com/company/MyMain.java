package com.company;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

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

    public static int[] sortAndRemoveDups(int[] keys) {
        Arrays.sort(keys);
        int[] noDups = new int[keys.length];
        int noDupsIndex = 0;
        for (int i = 0; i < keys.length; i++) {
            if (i == keys.length - 1 || keys[i] != keys[i+1]) {
                noDups[noDupsIndex] = keys[i];
                noDupsIndex++;
            }
        }
        if (keys.length == noDupsIndex) return noDups;
        int[] noDupsShrinked = new int[noDupsIndex];
        for (int i = 0; i < noDupsShrinked.length; i++) {
            noDupsShrinked[i] = noDups[i];
        }
        return noDupsShrinked;
    }

    public static void checkList(int[] arr, int[] unsortedKeys, String operation) {
        int[] keys = sortAndRemoveDups(unsortedKeys);
        for (int i = 0; i < keys.length; i++) {
            if (operation == "+") if (indexOf(arr, keys[i]) > -1) StdOut.print(keys[i] + ", ");
        }
        for (int i = 0; i < arr.length; i++) {
            if (operation == "-") if (indexOf(keys, arr[i]) == -1) StdOut.print(arr[i] + ", ");
        }
        StdOut.println();
    }

    public static int rank(int[] arr, int key) {
        // arr supposed to be sorted
        int count = 0;
        int index = 0;
        while (arr[index] < key) {
            count++;
            index++;
        }
        return count;
    }

    public static int count(int[] arr, int key) {
        // arr supposed to be sorted
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) count++;
        }
        return count;
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

        int[] unsortedListWithDups = {4, 6, 9, 6, 8, 2, 4};
        int[] sortedWithoutDups = MyMain.sortAndRemoveDups(unsortedListWithDups);
        for (int i = 0; i < sortedWithoutDups.length; i++) {
            StdOut.print(sortedWithoutDups[i]);
            StdOut.print(" ");
        }

        StdOut.println();
        StdOut.println();
        int[] sortedListWithDups = {4, 6, 9, 16, 18, 18, 24};
        StdOut.println(rank(sortedListWithDups, 18));
        StdOut.println(rank(sortedListWithDups, 9));
        StdOut.println(count(sortedListWithDups, 18));
        StdOut.println(count(sortedListWithDups, 9));
        StdOut.println();
        for (int i = rank(sortedListWithDups, 18);
             i <= rank(sortedListWithDups, 18) + count(sortedListWithDups, 18) - 1;
             i++) {
            StdOut.println(sortedListWithDups[i]);
        }
    }
}

//javac -cp ../algs4.jar ./src/com/company/MyMain.java
//java -cp ../algs4.jar:./src com.company.MyMain < input1.txt
