import java.util.Arrays;

public class Recursion {
    public static int[] merge(int[] a1, int[] a2) {
        int[] a3 = new int[a1.length + a2.length];
        return merge(a1, a2, a3, 0, 0);
    }

    private static int[] merge(int[] a1, int[] a2, int[] a3, int i1, int i2) {
        if (a1.length == i1 && a2.length == i2) {
            return a3;
        } else if (a1.length == i1) {
            a3[i1 + i2] = a2[i2];
            i2 += 1;
        } else if (a2.length == i2) {
            a3[i1 + i2] = a1[i1];
            i1 += 1;
        } else {
            if (a1[i1] >= a2[i2]) {
                a3[i1 + i2] = a2[i2];
                i2 += 1;
            } else {
                a3[i1 + i2] = a1[i1];
                i1 += 1;
            }
        }
        return merge(a1, a2, a3, i1, i2);
    }


    public static boolean isSubString(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return false;
        }
        return isSubString(s1, s2, 0, s1.length());
    }

    private static boolean isSubString(String s1, String s2, int start, int end) {
        if (start >= end) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        return isSubString(s1.substring(start, end - 1), s2, start, end - 1) ||
                isSubString(s1.substring(start + 1, end), s2, start + 1, end);
    }


    public static int longestFlat(int[] arr) { //TODO:HOLY MOLY LETS GOOOOOOOOOOOOOOOOOO I DID IT!!!
        if (arr.length < 2) {
            return arr.length;
        }
        return longestFlat(arr, 1, arr[0], arr[0], 1);
    }

    private static int longestFlat(int[] arr, int i, int num1, int num2, int seq) {
        if (i >= arr.length) {
            return seq;
        }
        if (arr[i] == num1 || arr[i] == num2) {
            return longestFlat(arr, i + 1, num1, num2, seq + 1);
        } else if (num1 == num2 && (arr[i] == num1 + 1 || arr[i] == num1 - 1)) {
            return longestFlat(arr, i + 1, num1, arr[i], seq + 1);
        } else if (arr[i - 1] + 1 == arr[i] || arr[i - 1] - 1 == arr[i] || arr[i] == arr[i - 1]) {
            return Math.max(seq, longestFlat(arr, i + 1, arr[i - 1], arr[i], 2));
        }
        return Math.max(seq, longestFlat(arr, i + 1, arr[i], arr[i], 1));
    }


    public static int cheapRT(int[] stations, int step1, int step2, int limit) {
        return cheapRT(stations, step1, step2, limit, 0, 0, "");
    }

    private static int cheapRT(int[] stations, int step1, int step2, int limit, int i, int count, String path) {
        if (i == stations.length - 1) {
            count += stations[i];
            System.out.println(path + "  " + i + " = " + count);
            return count;
        }
        if (i > stations.length - 1 || i < 0) {
            return Integer.MAX_VALUE;
        }
        int l1 = cheapRT(stations, step1, step2, limit, i + step1, count + stations[i], path + "  " + i);
        int l2 = Integer.MAX_VALUE;
        if (limit > 0) {
            l2 = cheapRT(stations, step1, step2, limit - 1, i + step2, count + stations[i], path + "  " + i);
        }
        return Math.min(l1, l2);
    }


    public static void main(String[] args) {
        int[] a1 = {1, 2, 7};
        int[] a2 = {2, 4, 6};
        System.out.println(Arrays.toString(merge(a1, a2)));
        String s1 = "substring";
        String s2 = "string";
        System.out.println(isSubString(s1, s2));

        int[] longestFlat1 = {4, 5, 6, 5, 5, 5, 5, 5, 8, 8, 1, 2, 8, 5, 5, 5, 4, 3};
        System.out.println(longestFlat(longestFlat1));
        System.out.println("-------------------------");
        int[] longestFlat2 = {2, 3, 2, 4, 2, 3, 3, 2};
        System.out.println(longestFlat(longestFlat2));
        System.out.println("-------------------------");
        int[] longestFlat3 = {1, 2, 1, 4, 6, 5, 6, 5};
        System.out.println(longestFlat(longestFlat3));
        System.out.println("-------------------------");

        int[] cheapRT1 = {2, 4, 8, 3, 10, 1, 12, 3, 2};
        System.out.println(cheapRT(cheapRT1, 3, 2, 4));
    }
}
