public class Complexity2 {
    public static int meetingPoint(int[] a, int[] b) {
        int low = 0;
        int high = Math.min(a.length - 1, b.length - 1);
        int mid;
        int index = Integer.MAX_VALUE;
        while (low <= high) {
            mid = (high + low) / 2;
            if (a[mid] == b[mid]) {
                index = mid;
                high -= 1;
            }
            if (a[mid] < b[mid]) {
                high = mid - 1;
            }
            if (a[mid] > b[mid]) {
                low = mid + 1;
            }
        }
        return index;
    }

    public static int count(int[] a, int x) {
        int count = 0;
        int low = 0;
        int high = a.length - 1;
        int mid;
        while (low <= high) {
            mid = (high + low) / 2;
            if (a[mid] < x) {
                low = mid - 1;
            }
            if (a[mid] > x) {
                high = mid - 1;
            } else {
                count += 1;
                high += 1;
            }
        }
        return count;
    }


    public static void main(String[] args) {
//        int[] a = {19,19,16,15,15,15,15,13,5};
//        int[] b = {0,12,13,14,14,15,15,19,25,30,35};
//        System.out.println(meetingPoint(a,b));
//        System.out.println("---------------------------");
//        int[] arr = {-5, -5, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 67, 67, 99};
//        System.out.println(count(arr, -5));

    }
}
