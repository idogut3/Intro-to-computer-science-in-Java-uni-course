/**
 * @author Ido Gutman
 * @authorID 329200216
 * @description <p>
 * Maman 14
 * </p>
 */

/**
 * Q1 segment A:
 * 1) FALSE;
 * 2) FALSE;
 * 3) TRUE;
 * 4) FALSE;
 * 5) TRUE;
 * 6) TRUE;
 */

public class Ex14 {


    /**
     * @param m   - The given array;
     * @param val - The value that we need to find;
     * @Method : "findValWhat";
     * @description <p>
     * For a given array that has returned the value true from the function "what", and a given value,
     * This method returns a boolean that represents if the value is located somewhere in the array;
     * --------------------------------------------------
     * Time complexity : O(n);
     * There is a while loop that is not nested;
     * Space complexity : O(1);
     * Uses only 2 data types that it doesn't receive;
     * -------------------------------------------------
     * </p>
     * @returns - A boolean that represents if the value is located somewhere in the array;
     */
    public static boolean findValWhat(int[][] m, int val) {
        int x = 0;
        int y = 0;

        while (y <= m.length - 1) { //array border
            if (m[y][x] == val) { //Found the value;
                return true;
            } else if (x == m.length - 1 || m[y][x] > m[y][x + 1]) {
                y += 1;
                x = 0;
            } else {
                x += 1;
            }
        }
        return false;
    }

    /**
     * @param m   - The given array;
     * @param val - The value that we need to find;
     * @Method : "findValTest";
     * @description <p>
     * For a given array that has returned the value true from the function "test", and a given value,
     * This method returns a boolean that represents if the value is located somewhere in the array;
     * --------------------------------------------------
     * Time complexity : O(n);
     * There is a while loop that is not nested;
     * Space complexity : O(1);
     * Uses only 2 data types that is doesn't receive;
     * -------------------------------------------------
     * </p>
     * @returns - A boolean that represents if the value is located somewhere in the array;
     */
    public static boolean findValTest(int[][] m, int val) {
        int x = 0;
        int y = 0;

        while (y <= m.length - 1) { //array border
            if (m[y][x] == val) { //found the value
                return true;
            } else if (x == m.length - 1) { // We have reached the end of the array;
                y += 1; // We enter a new array;
                x = 0; // We reset the x position so that we can start checking from the start;
            } else {
                x += 1;
            }
        }
        return false;
    }

    /**
     * @param a - The given array;
     * @Method : "strictlyIncreasing";
     * @description <p>
     * For a given array, returns the number of sub-arrays that are arranged in ascending order - strictlyIncreasing;
     * --------------------------------------------------
     * Time complexity : O(n);
     * There is a for loop that is not nested;
     * Space complexity : O(1);
     * Uses only 2 data types that is doesn't receive;
     * -------------------------------------------------
     * </p>
     * @returns - Returns the number of sub-arrays that are arranged in ascending order;
     */
    public static int strictlyIncreasing(int[] a) {
        int count = 0; // Number of ascending sub arrays in the array;
        int streak = 1; // How long is the current continuous ascending order;

        for (int i = 0; i < a.length - 1; i++) { // The array border;
            if (a[i] < a[i + 1]) { // The series keeps ascending;
                count += streak;
                streak += 1;
            } else { // The series stopped ascending; resets the current continuous ascending order to 1;
                streak = 1;
            }
        }
        return count;
    }

    /**
     * @param arr - The given array;
     * @Method : "longestFlatSequence";
     * @description <p>
     * For a given array, returns the maximum flat sequence length inside of the array;
     *  --------------------------------------------------
     *  Time complexity : O(n);
     *  This method uses a recursive method that repeats itself n times therefore, O(n);
     *  Space complexity : O(n);
     *   This method uses a recursive method that repeats itself n times and each time creates temporary variables, therefor O(n);
     *  -------------------------------------------------
     * </p>
     * @returns - Returns the maximum flat sequence length inside the given array;
     */
    public static int longestFlatSequence(int[] arr) {//returns the maximum flat sequence length in the given array
        return longestFlatSequence(arr, 0, 1, 1);
    }
    /**
     * @param arr - The given array;
     * @param index - The current index;
     * @param currentSeq - The current length of the flat sequence inside the array;
     * @param maxSeqLength - The maximum length of a flat sequence inside the array;
     * @Method : private "longestFlatSequence";
     * @description <p>
     * For a given array, returns the maximum flat sequence length;
     * --------------------------------------------------
     *  Time complexity : O(n);
     *  This method is  a recursive method that repeats itself n times therefore, O(n);
     *  Space complexity : O(n);
     *   This method is a recursive method that repeats itself n times and each time creates temporary variables, therefor O(n);
     * -------------------------------------------------
     * </p>
     * @returns - Returns the maximum flat sequence length inside the given array;
     */

    private static int longestFlatSequence(int[] arr, int index, int currentSeq, int maxSeqLength) {
        if (index == arr.length - 1)//The stopping point for the recursion - returns the maximum flat sequence length in the array
            return maxSeqLength;
        if (currentSeq == 1) {//On a condition that the current flat sequence length in the position is 1
            if (arr[index + 1] == arr[index] + 1 || arr[index + 1] == arr[index] || arr[index + 1] == arr[index] - 1) {
                return longestFlatSequence(arr, index + 1, currentSeq + 1, Math.max(currentSeq + 1, maxSeqLength));
            }
            return longestFlatSequence(arr, index + 1, currentSeq, Math.max(currentSeq, maxSeqLength));
        }
        if (arr[index + 1] == arr[index - 1] || arr[index + 1] == arr[index]){//to see if the flat sequence continues
            return longestFlatSequence(arr,index+1,currentSeq+1,Math.max(currentSeq+1,maxSeqLength));
        }
        if(arr[index+1]-arr[index]==1||arr[index+1]-arr[index]==-1){
            if(arr[index+1]-arr[index-1]==2||arr[index+1]-arr[index-1]==-2){//the condition for the flat sequence to not continue
                return longestFlatSequence(arr,index+1,2,Math.max(2,maxSeqLength));
            }
            //The flat sequence continues
            return longestFlatSequence(arr,index+1,currentSeq+1,Math.max(currentSeq+1,maxSeqLength));
        }
        return longestFlatSequence(arr,index+1,1,Math.max(currentSeq,maxSeqLength));
    }

    /**
     * @param a - an integer;
     * @param b - an integer;
     * @Method : "max";

     *  --------------------------------------------------
     *  Time complexity : O(1);
     *  Repeats itself only once;
     *  Space complexity : O(1);
     *  Does not create any variables;
     *  -------------------------------------------------
     * @returns - Returns the bigger integer (a or b);
     */
    private static int max(int a, int b) {
        return (a >= b) ? a : b;
    }

    /**
     * @param mat - The given matrix;
     * @Method : public "findMaximum";
     * @description <p>
     * For a given 2D array, with only the values 1,0,-1; returns the highest amount of points for every possible path you could create in the array;
     * A path is defined by:
     * Its starting point - at mat[0][0];
     * It passes only at places at the array where the value is 0 or 1;
     * If the path is on an even index of the array the path can continue moving only to the right cell of the same line or enter a new array below it;
     * If the path is on an odd index of the array the path can continue moving only to the left cell of the same line or enter a new array below it;
     * Example-    {
     * {0,0,0} - even index - 0;
     * {0,0,0} - odd index - 1;
     * {0,0,0} - even index - 2;
     * }
     * The path gains 1 point for each element in the array that she passes through that is equal to 1;
     * --------------------------------------------------
     * Time complexity : O(n);
     * This method uses a recursive method that repeats itself n times therefor, O(n);
     * Space complexity : O(n);
     *  This method uses a recursive method that repeats itself n times and each time creates temporary variables, therefor O(n);
     * -------------------------------------------------
     * </p>
     * @returns - Returns the maximum amount of points that can be gained by crossing a path;
     */
    public static int findMaximum(int[][] mat) {
        if (mat[0][0] == -1) { // if the starting point equals -1 then there are no paths- returns -1;
            return -1;
        }
        return findMaximum(mat, 0, 0, 0, 0); // The recursion call;
    }

    /**
     * @param mat            - The given matrix;
     * @param currPathPoints - The current path points;
     * @param maxPathPoints  - The maximum amount of path points so far;
     * @param xIndex         - The x index of my current position in the path;
     * @param yIndex         - The y index of my current position in the path - which array am I in;
     * --------------------------------------------------
     * Time complexity : O(n);
     * This method  is a recursive method that repeats itself n times therefor, O(n);
     * Space complexity : O(n);
     *  This method is a recursive method that repeats itself n times and each time creates temporary variables, therefor O(n);
     * -------------------------------------------------
     * @Method : private "findMaximum";
     * @returns - Returns the maximum amount of points that can be gained by crossing a path;
     */
    private static int findMaximum(int[][] mat, int currPathPoints, int maxPathPoints, int xIndex, int yIndex) {
        int maxHeight = mat.length; // How many arrays there are in the array of arrays - The height border;
        int maxWidth = mat[0].length; //How long is each array inside the big array - The width border;

        if (mat[yIndex][xIndex] == 1) { //If the path crossed an array element that stores 1 in it - gains a point;
            currPathPoints += 1;
        }
        if (mat[0][0] == -1) { //The stopping condition for thr recursion - starting point equals -1;
            return max(currPathPoints, maxPathPoints); // Returns the maximum amount of points out of the current path points and the maximum path points until this path;
        }
        if (yIndex % 2 == 0) { // Current position is on an even number;
            if (xIndex + 1 < maxWidth && mat[yIndex][xIndex + 1] != -1) { // If on an even number checks to see if it can continue its path to the right cell;
                return findMaximum(mat, currPathPoints, max(currPathPoints, maxPathPoints), xIndex + 1, yIndex);
            } else if (yIndex + 1 < maxHeight && mat[yIndex + 1][xIndex] != -1) { // If it can't continue to the right cell checks if it can continue the path to the next array;
                return findMaximum(mat, currPathPoints, max(currPathPoints, maxPathPoints), xIndex, yIndex + 1);
            } else { // The path has reached a dead end - calls to the recursion in order to start the new brand path;
                mat[yIndex][xIndex] = -1; // Declares its positioning is the end of the path so new paths won't go there again;
                return findMaximum(mat, 0, max(currPathPoints, maxPathPoints), 0, 0);
            }
        } else { // Current position is on an odd number;
            if (xIndex - 1 >= 0 && mat[yIndex][xIndex - 1] != -1) { // If on an odd number checks to see if it can continue its path to the left cell;
                return findMaximum(mat, currPathPoints, max(currPathPoints, maxPathPoints), xIndex - 1, yIndex);
            } else if (yIndex + 1 < maxHeight && mat[yIndex + 1][xIndex] != -1) { // If it can't continue to the left cell checks if it can continue the path to the next array;
                return findMaximum(mat, currPathPoints, max(currPathPoints, maxPathPoints), xIndex, yIndex + 1);
            } else { // The path has reached a dead end - calls to the recursion in order to start the new brand path;
                mat[yIndex][xIndex] = -1;// Declares its positioning is the end of the path so new paths won't go there again;
                return findMaximum(mat, 0, max(currPathPoints, maxPathPoints), 0, 0);
            }
        }
    }


}