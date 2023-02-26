public class TestOpenU {

    //Ido Gutman - id: 329200216

    public static int kAlmostSearch(int[] a, int num) {
        int low = 0;
        int mid;
        int high = a.length - 1;

        while (low <= high) {
            mid = (high + low) / 2;
            if (num == a[mid]) {
                return mid;
            }
            if (a[mid] == 0) {
                if (a[high] == num) {
                    return high;
                } else {
                    high -= 1;
                }
            } else {
                if (a[mid] < num) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,4};
        System.out.println(kAlmostSearch(a, 3));
        System.out.println(kAlmostSearch(a, 4));
        System.out.println(kAlmostSearch(a, 5));
    }

}
