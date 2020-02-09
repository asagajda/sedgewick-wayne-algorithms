package com.company;

import edu.princeton.cs.algs4.*;

public class MyMain {

    public static boolean arraysEqualThirdAfterComma(double[] empiricalProbabilities, double[] probabilities) {
        for (int k = 0; k < empiricalProbabilities.length; k++) {
//            StdOut.print("assert ");
//            StdOut.print(String.format("< %.03f >", empiricalProbabilities[k]) + " " + String.format("< %.03f >", probabilities[k]));
            if (!(
                    String.format("%.03f", empiricalProbabilities[k]).equals(String.format("%.03f", probabilities[k]))
            )) {
//                StdOut.println("false");
                return false;
            }
        }
        return true;
    }

    public static double[] calculateProbabilities(int[] frequencies, int number) {
        double [] result = new double[frequencies.length];
        for (int i = 2; i < frequencies.length; i++) {
            result[i] = (double) frequencies[i] / number;
        }
        return result;
    }

    public static void main(String[] args) {
        int size = 6;
        double[] probabilities = new double[size*2 + 1];
        int[] frequencies = new int[size*2 + 1];
        double[] empiricalProbabilities = new double[size*2 + 1];
        int[] empiricalFrequencies = new int[size*2 + 1];

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                frequencies[i+j]++;
            }
        }

        probabilities = calculateProbabilities(frequencies, 36);

        // StdOut

        for (int i = 2; i < frequencies.length; i++) {
            StdOut.print(probabilities[i] + " ");
        }
        StdOut.println();

        for (int i = 2; i < frequencies.length; i++) {
            StdOut.print(frequencies[i] + " ");
        }
        StdOut.println();

        // Empirical trials

        int i = 0;
        while (!arraysEqualThirdAfterComma(empiricalProbabilities, probabilities)) {
            empiricalFrequencies = new int[size*2 + 1];
            for (int t = 0; t < i; t++) {
                int diceOne = StdRandom.uniform(1, 7);
                int diceTwo = StdRandom.uniform(1, 7);
                empiricalFrequencies[diceOne + diceTwo]++;
            }

            empiricalProbabilities = calculateProbabilities(empiricalFrequencies, i);

            StdOut.println(i);
            for (int m = 2; m < frequencies.length; m++) {
                StdOut.print(empiricalFrequencies[m] + " ");
            }
            StdOut.println();
            for (int m = 2; m < frequencies.length; m++) {
                StdOut.print(empiricalProbabilities[m] + " ");
            }
            StdOut.println();

            i++;
        }
        StdOut.println(i);
        StdOut.println(arraysEqualThirdAfterComma(empiricalProbabilities, probabilities));

    }
}


//javac -cp ../algs4.jar ./src/com/company/MyMain.java
//java -cp ../algs4.jar:./src com.company.MyMain < input1.txt
//javac -cp ../algs4.jar ./src/com/company/MyMain.java && java -cp ../algs4.jar:./src com.company.MyMain < input1.txt
