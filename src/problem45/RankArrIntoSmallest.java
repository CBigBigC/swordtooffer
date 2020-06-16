package problem45;

import java.util.Collections;

public class RankArrIntoSmallest {
    public static void main(String[] args) {
        int[] n = {35, 256, 5, 3, 1};
        smallest(n);
    }

    private static void smallest(int[] n) {
        String[] m = new String[n.length];
        for (int i = 0; i < n.length; i++) {
            m[i] = String.valueOf(n[i]);
        }
        quickSort(m, 0, m.length - 1);
        for (String temp : m) {
            System.out.print(temp);
        }
    }

    private static void quickSort(String[] m, int left, int right) {
        if(left >= right) return;
        int begin = left, end = right;
        while (begin < end) {
            if (biggerThan(m[begin], m[end])) {
                String temp = m[begin];
                m[begin] = m[end];
                m[end] = temp;
                begin++;
                while (!biggerThan(m[begin], m[end]) && begin < end) {
                        begin ++;
                }
                if(begin >= end) break;
                temp = m[begin];
                m[begin] = m[end];
                m[end] = temp;
                end --;
            } else {
                end--;
            }
        }
        quickSort(m, left, begin - 1);
        quickSort(m, begin + 1, right);
    }

    private static boolean biggerThan(String a, String b) {
        char[] first = a.toCharArray();
        char[] second = b.toCharArray();
        int i = 0;
        while (true) {
            if (i >= first.length && i >= second.length) {
                return false;
            } else if (i >= first.length && i < second.length) {
                return !(second[0] > second[i]);
            } else if (i < first.length && i >= second.length) {
                return !(first[0] > first[i]);
            } else {
                if (first[i] == second[i]) {
                    i++;
                } else {
                    return first[i] > second[i];
                }
            }
        }
    }
}
