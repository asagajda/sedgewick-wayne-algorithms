package com.company;

import edu.princeton.cs.algs4.*;

class ShuffleTest {
    public static int[] initArray(int m) {
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            result[i] = i;
        }
        return result;
    }

    public static void testShuffle(int m, int n) {
        int[][] counts = new int[m][m];

        for (int trial = 0; trial < n; trial++) {
            int[] arr = initArray(m);
            // do shuffle
//            /*
            for (int i = 0; i < m; i++) {
//                if (i == arr.length - 1) continue;
//                int positionToSwap = i + StdRandom.uniform(0, m - i);
//                1.1.37
                int positionToSwap = StdRandom.uniform(0, m);
                int temp = arr[i];
                arr[i] = arr[positionToSwap];
                arr[positionToSwap] = temp;
            }
//            */
//            StdRandom.shuffle(arr);

            for (int i = 0; i < arr.length; i++) {
                counts[arr[i]][i]++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                StdOut.print(counts[i][j] + "\t");
            }
            StdOut.println();
        }
    }
}

public class MyMain {

    public static void main(String[] args) {
        StdOut.println("Enter array size:");
        int m = StdIn.readInt();
        StdOut.println("Enter shuffles count:");
        int n = StdIn.readInt();

        ShuffleTest.testShuffle(m, n);
    }
}


//javac -cp ../algs4.jar ./src/com/company/MyMain.java
//java -cp ../algs4.jar:./src com.company.MyMain < input1.txt
//javac -cp ../algs4.jar ./src/com/company/MyMain.java && java -cp ../algs4.jar:./src com.company.MyMain < input1.txt
