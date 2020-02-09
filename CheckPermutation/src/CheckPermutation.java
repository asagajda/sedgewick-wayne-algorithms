/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 *
 * Permutation. Given two integer arrays of size nn, design a subquadratic algorithm to determine
 * whether one is a permutation of the other. That is, do they contain exactly the same entries but,
 * possibly, in a different order.
 **************************************************************************** */
import edu.princeton.cs.algs4.StdOut;

public class CheckPermutation<Comparable> {
    java.lang.Comparable[] a;
    java.lang.Comparable[] b;
    CheckPermutation(java.lang.Comparable[] a, java.lang.Comparable[] b) {
        this.a = a;
        this.b = b;
    }

    public boolean aIsPermutationOfB() {
        ShellSort.sort(this.a);
        ShellSort.sort(this.b);
        for (int i = 0; i < a.length; i++) {
            if (a[i].compareTo(b[i]) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] testArrA = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        Integer[] testArrB = new Integer[]{1, 2, 3, 5, 8, 6, 7, 8, 9, 0};

        CheckPermutation test = new CheckPermutation<Integer>(testArrA, testArrB);
        StdOut.println(test.aIsPermutationOfB());
    }
}

class ShellSort {
    private static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void sort(Comparable[] arr) {
        int h = 0;
        while (h < arr.length/3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for (int i = h; i < arr.length; i++) {
                for (int j = i; (j - h >= 0) && (arr[j].compareTo(arr[j-h]) < 0); j -= h ) {
                    swap(arr, j, j-h);
                }
            }
            h = h/3;
        }
    }
}
