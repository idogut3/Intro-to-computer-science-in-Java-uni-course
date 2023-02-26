public class PathsAndMats {

    public static int longestPath(int[][] mat, int x, int y) {
        if (mat[x][y] == 0) {
            return Integer.MIN_VALUE;
        }
        return longestPath(mat, x, y, 0, 0);
    }

    private static int longestPath(int[][] mat, int x, int y, int i, int j) {
        if (i >= mat.length || i < 0 || j >= mat.length || j < 0 || mat[x][y] != 1) {
            return Integer.MIN_VALUE;
        }
        if (i == x && j == y) {
            return 1;
        }
        mat[x][y] = 2;
        int max1 = Math.max(longestPath(mat, x, y, i + 1, j), longestPath(mat, x, y, i - 1, j));
        int max2 = Math.max(longestPath(mat, x, y, i, j + 1), longestPath(mat, x, y, i, j - 1));
        int absMax = Math.max(max1, max2);
        mat[x][y] = 1;
        if (absMax < 0) {
            return Integer.MIN_VALUE;
        } else {
            return absMax + 1;
        }
    }

    public static int howManyPaths(int[][] mat) {
        return howManyPaths(mat, 0, 0);
    }

    private static int howManyPaths(int[][] mat, int i, int j) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] <= 0) {
            return 0;
        }
        if (i == mat.length - 1 || j == mat.length - 1) {
            return 1;
        }
        int k = mat[i][j];
        mat[i][j] = -1;
        int r1 = howManyPaths(mat, i, j + k);
        int r2 = howManyPaths(mat, i, j - k);
        int r3 = howManyPaths(mat, i - k, j);
        int r4 = howManyPaths(mat, i + k, j);
        mat[i][j] = k;
        return r1 + r2 + r3 + r4;
    }



    /***
     * @Method heaviestPath
     * 
     * @description:
     * <p>
     *     This is an exercise I got from Nir calfon from his ~intro to c course I chose to do it in Java though because I hate c :);
     * <p/>
     */

    public int heaviestPath(int[][] mat, int height, int width) { //height == mat.length, width == mat[0].length;
        if (height == 0 && width == 0) {
            return mat[0][0];
        }
        return heaviestPath(mat, height, width, 0, 0, mat[0][0]);
    }

    private int heaviestPath(int[][] mat, int height, int width, int x, int y, int sum) { //height == mat.length, width == mat[0].length;
        int down, up;

        if (width == x - 1 && height == y - 1) { //Reached the end;
            return sum + mat[y - 1][x - 1];
        }
        if (width == x - 1) { //Can't go right anymore;
            if (mat[y][x] <= mat[y + 1][x]) {
                return heaviestPath(mat, height, width, x, y + 1, sum + mat[y][x]);
            } else { //Didn't reach the end and can't move;
                return -1;
            }
        }
        if (height == x - 1) { //Can't go down anymore;
            if (mat[y][x] <= mat[y][x + 1]) {
                return heaviestPath(mat, height, width, x + 1, y, sum + mat[y][x]);
            } else { //Didn't reach the end and can't move;
                return -1;
            }
        }
        down = heaviestPath(mat, height, width, x, y + 1, sum + mat[y][x]);
        up = heaviestPath(mat, height, width, x + 1, y, sum + mat[y][x]);
        if (up >= down) {
            return up;
        } else {
            return down;
        }
    }


    public static void main(String[] args) {
        int[][] mat = {
                {1, 3, 1, 6}
                , {2, 8, 1, 2},
                {6, 2, 7, 5},
                {2, 4, 1, 3}
        };
        System.out.println(howManyPaths(mat));
        int[][] mat1 = {
                {1, 1, 1, 1, 1, 1, 1}
                , {1, 1, 0, 1, 0, 0, 1},
                {1, 1, 1, 1, 0, 1, 1},
        };
        System.out.println(longestPath(mat1, 2, 1));


    }
}
