public class Complexity {

    public static int maximalDrop(int[] a) {
        int max = -1;
        int maxNum = a[0];
        int minNum = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < minNum) {
                minNum = a[i];
                max = Math.max(max, maxNum - minNum);
            } else if (a[i] > maxNum) {
                maxNum = a[i];
                minNum = a[i];
            }
        }
        return max;
    }

    public static boolean equalParts(int[] a) {
        int sumAll = 0;
        for (int i = 0; i < a.length; i++) {
            sumAll += a[i];
        }
        int sumBefore = 0;
        for (int i = 0; i < a.length; i++) {
            sumBefore += a[i];
            sumAll -= a[i];
            if (sumAll == sumBefore) {
                return true;
            }
        }
        return false;
    }

    public static int findMax(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        if (arr[low] < arr[high]) {
            return high;
        }
        while (low <= high) {
            mid = (high + low) / 2;
            if (arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[low] < arr[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static int SI(int[] a) {
        int count = 0;
        int an = 1;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i + 1]) {
                an++;
            } else {
                count += (an * (an - 1)) / 2;
                an = 1;
            }
        }
        count += (an * (an - 1)) / 2;
        return count;
    }

    public static int SI2PointO(int[] a) {
        int count = 0;
        int streak = 1;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i + 1]) {
                count += streak;
                streak += 1;
            } else {
                streak = 1;
            }
        }
        return count;
    }

    public static boolean findX(int[] a, int x) {
        int high = a.length - 1;
        int low = 0;
        int mid;
        if (a.length == 1) {
            return false;
        }
        if (a[high] + a[high - 1] < x) {
            return false;
        }
        while (low <= high) {
            mid = (high + low) / 2;
            if (a[mid] + a[mid + 1] == x) {
                return true;
            } else if (a[mid] + a[mid + 1] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }


    public static boolean sum3(int[] arr, int num) {
        int j;
        int k = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            j = i + 1;
            while (j < k) {
                if (arr[i] + arr[j] + arr[k] == num) {
                    return true;
                }
                if (arr[i] + arr[j] + arr[k] < num) {
                    j += 1;
                } else {
                    k -= 1;
                }
            }
            k = arr.length - 1;
        }
        return false;
    }

    public static int smallestSub(int[] a, int k) {
        int smallest = a.length + 1;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        if (sum <= k) {
            return smallest;
        }
        int i = 0;
        int j = a.length - 1;
        while (i < j && sum > k) {
            smallest = j - i + 1;
            if (sum - a[i] >= sum - a[j]) {
                sum -= a[j];
                j--;
            } else {
                sum -= a[i];
                i++;
            }
        }
        return smallest;
    }

    public static void printClosest(int[] a, int[] b, int x) {
        int i = 0;
        int j = b.length - 1;
        int diff = Math.abs((a[i] + b[j]) - x);
        int minNum1 = a[i];
        int minNum2 = b[j];
        int minDiff = diff;
        if (diff == 0) {
            System.out.println(a[i] + " AND " + b[j]);
            return;
        }
        while (i < a.length && j >= 0) {
            diff = Math.abs((a[i] + b[j]) - x);
            if (diff < minDiff) {
                minNum1 = a[i];
                minNum2 = b[j];
                minDiff = diff;
            }
            if (minDiff == 0) {
                System.out.println(a[i] + " AND " + b[j]);
                return;
            }
            if (a[i] + b[j] - x < 0) {
                i += 1;
            } else {
                j -= 1;
            }
        }
        System.out.println(minNum1 + " AND " + minNum2);
    }

    public static void main(String[] args) {
        int[] maximalD1 = {5, 21, 3, 27, 12, 24, 7, 6, 4};
        System.out.println(maximalDrop(maximalD1));
        System.out.println("----------------------------");
        int[] maximalD2 = {5, 21, 3, 22, 12, 7, 26, 14};
        System.out.println(maximalDrop(maximalD2));
        int[] equalParts1 = {1,2,3,4};
        int[] equalParts2 = {1,4,3,2};
        int[] equalParts3 = {10,2,1,3,3,1};
        int[] equalParts4 = {0,-7,-3,10,0};
        System.out.println(equalParts(equalParts1));
        System.out.println("---------------------");
        System.out.println(equalParts(equalParts2));
        System.out.println("---------------------");
        System.out.println(equalParts(equalParts3));
        System.out.println("---------------------");
        System.out.println(equalParts(equalParts4));
        int[] findMax1 = {65,70,-5,3,48,49,52};
        int[] findMax2 = {1,2,4,6,9,10};
        int[] findMax3 = {10,11,18,111,-5,8,9};
        System.out.println(findMax(findMax3));
        int[] arrSI = {1,2,3,4,5,1,2,3,4};
        System.out.println(SI(arrSI));
        int[] findX1 = {1,2,5,3,6,10,9};
        int[] findX2 ={1,-2,2,-1,5,0,9};
        System.out.println(findX(findX1,2));
        System.out.println("-----------------------");
        System.out.println(findX(findX1,10));
        System.out.println("-----------------------");
        System.out.println(findX(findX2,0));

        int[] sum3First = {-2, 3, 5, 7, 12};
        System.out.println(sum3(sum3First, 19));

        int[] smallestSub1 = {1, 4, 13, 6, 0, 9};
        System.out.println(smallestSub(smallestSub1, 22));

        int[] printClosestA1 = {0, 4, 6, 11, 11};
        int[] printClosestB1 = {10, 20, 30, 40};
        printClosest(printClosestB1, printClosestA1, 70);

        int[] printClosestA2 = {1, 2, 4, 4};
        int[] printClosestB2 = {6, 6, 7, 8};
        printClosest(printClosestA2, printClosestB2, 6);
    }
}