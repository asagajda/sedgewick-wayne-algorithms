package com.company;

import edu.princeton.cs.algs4.*;

public class MyMain {
    /**
     * @param count - count of equally distributed points on circle
     * @param index - index of point to get angle for
     */
    public static double getAngleForPointOnCircle(int count, int index) {
        return (360.0 / (double) count) * (double) index;
    }

    /**
     * Returns X coordinate of point of given index from count points
     * to be plotted on circle (equally distributed)
     *
     * @param count - count of equally distributed points on circle
     * @param index - index of point on 1x1 circle
     */
    public static double getX(int count, int index) {
        return (Math.sin(
                        Math.toRadians(getAngleForPointOnCircle(count, index))
                ) + 1) / 2;
    }

    /**
     * Returns Y coordinate of point of given index from count points
     * to be plotted on circle (equally distributed)
     *
     * @param count - count of equally distributed points on circle
     * @param index - index of point on 1x1 circle
     */
    public static double getY(int count, int index) {
        return (Math.cos(
                Math.toRadians(getAngleForPointOnCircle(count, index))
        ) + 1) / 2;
    }

    /**
     * Plots point of given index from count points
     *
     * @param count - count of equally distributed points on circle
     * @param index - index of point to plot on 1x1 circle
     */
    public static void plotPoint(int count, int index) {
        StdDraw.point(
                getX(count, index),
                getY(count, index)
        );
    }

    /**
     * Plots line between points of index k and m
     * @param k - index of first point
     * @param m - index of first point
     * @param count - count of points on a circle
     */
    public static void plotConnection(int k, int m, int count) {
        StdDraw.line(
                getX(count, k),
                getY(count, k),
                getX(count, m),
                getY(count, m)
        );
    }

    /**
     * `probability` should be given as a percentage, such as
     * 10.0 (10.0%) or 25.5 (25.5%). As an example, if `probability`
     * is 60% (60.0), 100 calls to this function should return ~60
     * `true` values.
     * (Note that Math.random returns a value >= 0.0 and < 1.0.)
     */
    static boolean getRandomBoolean(float probability) {
        double randomValue = Math.random()*100;  //0.0 to 99.9
        return randomValue <= probability;
    }

    public static void main(String[] args) {
        int count = 40;

        StdDraw.setPenRadius(.03);
        for (int i = 0; i < count; i++) {
            plotPoint(count, i);
        }

        StdDraw.setPenRadius(.002);
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                boolean toss = getRandomBoolean(20f);
                if (toss) {
                    plotConnection(i, j, count);
                }
            }
        }

//        return (Math.cos(
//                Math.toRadians(getAngleForPointOnCircle(count, index))
//        ) + 1) / 2;

//        StdOut.println(Math.toRadians(getAngleForPointOnCircle(361,360)));
//        StdOut.println(getAngleForPointOnCircle(361,359));
//        StdOut.println(360./359);
    }
}

//javac -cp ../algs4.jar ./src/com/company/MyMain.java
//java -cp ../algs4.jar:./src com.company.MyMain < input1.txt

//javac -cp ../algs4.jar ./src/com/company/MyMain.java && java -cp ../algs4.jar:./src com.company.MyMain < input1.txt
