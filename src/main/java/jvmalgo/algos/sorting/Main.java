package jvmalgo.algos.sorting;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(xorAllNums(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(xorAllNums(new int[]{2, 1, 3}, new int[]{10, 2, 5, 0}));
    }


    public static int xorAllNums(int[] nums1, int[] nums2) {
        var ints1 = new int[33];
        for (var i : nums1) {
            int ix = 0;
            while (i > 0) {
                if (i % 2 == 1) {
                    ints1[ix] += nums2.length;

                }
                i /= 2;
                ix++;
            }
        }

        for (var i : nums2) {
            int ix = 0;
            while (i > 0) {
                if (i % 2 == 1) {
                    ints1[ix] += nums1.length;

                }
                i /= 2;
                ix++;
            }
        }

        int m = 1;
        int res = 0;
        for (int i = 0; i < ints1.length; i++) {
            if (ints1[i] % 2 == 1) {
                res += m;
            }
            m *=2;
        }
        return res;
    }

    Integer[] ints;
    int fill = 0;

    public Main(int n) {
        ints = new Integer[n + 2];
    }

    public void upload(int video) {
        ints[video] = 0;
        while (ints[fill + 1] != null) fill++;
    }

    public int longest() {
        return fill;
    }

    public boolean equalFrequency(String word) {
        if (word.length() == 0) return false;
        if (word.length() == 1) return true;

        int[] counts = new int['z' + 1];

        for (int i = 0; i < word.length(); i++) {
            counts[word.charAt(i)]++;
        }

        int low = 1000;
        int high = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0 && counts[i] < low) {
                low = counts[i];
            }
            if (counts[i] > high) {
                high = counts[i];
            }
        }

        var lows = counts.clone();
        var higs = counts.clone();
        for (int i = 0; i < counts.length; i++) {
            if (lows[i] == low) {
                lows[i]--;
                i = 1000;
            }
        }
        int f = 0;
        boolean s = true;
        for (int i : lows) {
            if (i == 0) continue;
            if (f == 0) {
                f = i;
            } else {
                if (i != f) {
                    s = false;
                }
            }
        }
        if (s) return true;

        for (int i = 0; i < counts.length; i++) {
            if (higs[i] == high) {
                higs[i]--;
                i = 1000;
            }
        }
        f = 0;
        for (int i : higs) {
            if (i == 0) continue;
            if (f == 0) {
                f = i;
            } else {
                if (i != f) {
                    return false;
                }
            }
        }
        return true;
    }
}
