public class Recursion2 {

    public static int makeSum(int[] lengths, int k, int num) { //Todo:Working but check if can print what adds up to k mid process
        return makeSum(lengths, k, num, 0);
    }

    private static int makeSum(int[] lengths, int k, int num, int x) {
        if (k == 0) {
            return 1;
        }
        if (num == 0 || x > lengths.length - 1 || k < 0) {
            return 0;
        }
        return makeSum(lengths, k - lengths[x], num - 1, x) +
                makeSum(lengths, k, num, x + 1);
    }

    public static void printAllSum(int[] a, int sum) {
        printAllSum(a, sum, 0, "");
    }

    private static void printAllSum(int[] a, int sum, int i, String msg) {
        if (i >= a.length) {
            if (sum == 0) {
                System.out.println(msg);
            }
        } else {
            printAllSum(a, sum - a[i], i + 1, msg + "1");
            printAllSum(a, sum, i + 1, msg + "0");
        }
    }


    public static int longOrdNum(String s) {
        return longOrdNum(s, 0, '0', 0);
    }

    private static int longOrdNum(String s, int x, char prev, int count) {
        if (x == s.length()) {
            return count;
        }
        if (prev < s.charAt(x) && s.charAt(x) <= '9') {
            return longOrdNum(s, x + 1, s.charAt(x), count + 1);
        }
        if ('0' <= s.charAt(x) && s.charAt(x) <= '9') {
            return Math.max(longOrdNum(s, x + 1, '0', 1), count);
        }
        return Math.max(count, longOrdNum(s, x + 1, '0', 0));
    }

    public static int count(int sum) {
        return count(sum, 1);
    }

    private static int count(int sum, int x) {
        if (sum == 0) {
            return 1;
        }
        if (sum < 0) {
            return 0;
        }
        if (x > sum) {
            return 0;
        }
        return count(sum - x, x + 1) + count(sum, x + 1);
    }

    public static int ways(int k, int n) {
        if (n == 0 && k == 0) {
            return 1;
        }
        if (k == 0) {
            return 0;
        }
        return ways(k - 1, n + 1) + ways(k - 1, n - 1);
    }

    public static boolean split3(int[] arr) {
        return split3(arr, 0, 0, 0, 0);
    }

    private static boolean split3(int[] arr, int i, int sum1, int sum2, int sum3) {
        if (i == arr.length) {
            if (sum1 == sum2 && sum2 == sum3) {
                return true;
            }
            return false;
        }
        return split3(arr, i + 1, sum1 + arr[i], sum2, sum3) || split3(arr, i + 1, sum1, sum2 + arr[i], sum3) || split3(arr, i + 1, sum1, sum2, sum3 + arr[i]);
    }


    public static void main(String[] args) {
        int[] lengthsMakeSum = new int[]{2, 5, 10, 20, 50};
        System.out.println(makeSum(lengthsMakeSum, 40, 4));
        int[] arrPrintAllS = new int[]{1, 1, 3, 7};
        printAllSum(arrPrintAllS, 8);
        System.out.println(longOrdNum("x1y2z3456778"));

        System.out.println(ways(4,2));
        System.out.println(ways(4,3));

        int[] split3First = {8,4,7,1,2,3,5};
        int[] split3Second = {4,7,1,2,3,5};
        System.out.println(split3(split3Second));
    }
}
