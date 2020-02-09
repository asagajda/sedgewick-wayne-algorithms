package com.company;

import edu.princeton.cs.algs4.StdOut;

import static java.lang.Math.*;

class EggDrop {
    private final int floors;
    private final int eggs;
    private final int pivotal;

    public EggDrop(int eggs, int floors, int pivotal) {
        this.eggs = eggs;
        this.floors = floors;
        this.pivotal = pivotal;
    }

    public int[] findInterval(int from, int to, int eggs) {
        int[] result = new int[2];
        if (eggs == 2) {
            result[0] = to-1;
            result[1] = to;
        }
        // square roots for triangle number formula <= floors count
        int floorToStart = (int) ceil(max((-1 + sqrt(1 + 8 * (to - from))) / 2, (-1 - sqrt(1 + 8 * (to - from))) / 2));
        for (int floor = floorToStart; floor < to; floor += floorToStart--) {
            if (drop(floor)) {
                eggs--;
                if (eggs >= 2) {
                    StdOut.println("[" + (floor - floorToStart + 1) + "," + floor + "]");
                    return findInterval(floor - floorToStart + 1, floor, eggs);
                } else {
                    result[0] = floor - floorToStart;
                    result[1] = floor;
                }
                break;
            }
        }

        StdOut.println("[" + result[0] + "," + result[1] + "]");
        return result;
    }

    private boolean drop(int i) {
        if (i >= this.pivotal) {
            StdOut.println("broken");
            return true;
        }
        else {
            StdOut.println("survived");
            return false;
        }
    }

    public Integer find() {
        int []interval = findInterval(1, this.floors, this.eggs);
        for (int i = interval[0]; i <= interval[1]; i++) {
            if (drop(i)) return i;
        }
        return null;
    }
}

public class Main {

    public static void main(String[] args) {
        EggDrop test = new EggDrop(3, 100, 10);
        StdOut.println(test.find());
    }
}

// ttps://truongtx.me/2018/05/06/solutions-to-egg-drop-problem
