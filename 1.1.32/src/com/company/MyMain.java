package com.company;

import edu.princeton.cs.algs4.*;

public class MyMain {
    // javac -cp ../algs4.jar ./src/com/company/MyMain.java && java -cp ../algs4.jar:./src com.company.MyMain 20 10.0 90.0 < input1.1.32.txt

    public static void plotHistogram(double[] input) {
        for (int i = 0; i < input.length; i++) {
            double hw = (.5 / (double) input.length) / 2;
            double hh = input[i] * 0.01;
            double x = i / (double) input.length + hw * 2;
            double y = input[i] * 0.01 / 2;
            StdDraw.filledRectangle(x, y, hw, hh);
            StdOut.printf("%s %s %s %s\n", x, y, hw, hh);
        }
    }

    public static void main(String[] args) {
//        > input1.1.33.txt
//        for(int i = 0; i < 100; i++) {
//            StdOut.print(StdRandom.uniform()*100 + " ");
//        }

        double[] input = StdIn.readAllDoubles();

        int interval = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);
        double[] result = new double[input.length/interval];

        for (int i = 0; i < result.length; i++) {
            int count = 0;
            for (int j = 0; j < interval; j++) {
                if (input[i * interval + j] >= lo && input[i * interval + j] <= hi) count++;
            }
            result[i] = count;
        }

        plotHistogram(result);
    }
}

//javac -cp ../algs4.jar ./src/com/company/MyMain.java
//java -cp ../algs4.jar:./src com.company.MyMain < input1.txt
//javac -cp ../algs4.jar ./src/com/company/MyMain.java && java -cp ../algs4.jar:./src com.company.MyMain < input1.txt
