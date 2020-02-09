package com.company;
import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class Main {

    public static void main(String[] args) {
        int size = 100;
        Integer[] array = new Integer[size];
        for(int i = 0; i < array.length; i++) {
            array[i] = StdRandom.uniform(3) + 1;
        }
//        for(int i = 0; i < array.length; i++) {
//            StdOut.print(array[i] + ", ");
//        }
//        StdOut.println();

        Stopwatch timer = new Stopwatch();
        DutchFlagSort.sort(array, new Integer[]{1,2,3});
        StdOut.println(timer.elapsedTime());

        for(int i = 0; i < array.length; i++) {
            StdOut.print(array[i] + ", ");
        }
        StdOut.println();

    }
}


class DutchFlagSort {
    public static void sort(java.lang.Comparable[] array, java.lang.Comparable[] possibleElements) {
        Shell.sort(possibleElements);
        int left = 0;
        int right = array.length - 1;
        int current = 0;
        while(current <= right) {
            if(array[current].compareTo(possibleElements[1]) > 0) {
                if (array[right].compareTo(possibleElements[1]) < 0) {
                    swap(array, current, right);
                    swap(array, current, left);
                    while(array[right].compareTo(possibleElements[1]) > 0) {
                        right--;
                    }
                    while(array[left].compareTo(possibleElements[1]) < 0) {
                        left++;
                        current++;
                    }
                } else {
                    swap(array, current, right);
                    while(array[right].compareTo(possibleElements[1]) > 0) {
                        right--;
                    }
                }
                continue;
            }
            if(array[current].compareTo(possibleElements[1]) == 0) {
                current++;
                continue;
            }
            if(array[current].compareTo(possibleElements[1]) < 0) {
                swap(array, current, left);
                while(array[left].compareTo(possibleElements[1]) < 0) {
                    left++;
                    current++;
                }
                continue;
            }
        }
    }

    private static void swap(Comparable[] array, int k, int m) {
        Comparable temp = array[k];
        array[k] = array[m];
        array[m] = temp;
    }
}

