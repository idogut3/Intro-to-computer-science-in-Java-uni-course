import java.util.Scanner;

public class Knight {

    public static void main(String[] args) {

        //This program reads two integers which represent a knight's location on the chess board
        //and prints out all the possible moves the knight can make. If The Knights location is not on the board
        //The program will print out "input is illegal".

        Scanner scan = new Scanner(System.in);
        System.out.println("This program reads two integers which " +
                "represent the knight's location on the chess board: ");
        System.out.println("Please enter the number of row");
        int row = scan.nextInt();
        System.out.println("Please enter the number of column");
        int col = scan.nextInt();

        if ((row >= 1 && row <= 8) && (col >= 1 && col <= 8)) { //Verify if the location is legal.
            System.out.println("Moves:");

            if ((row-1>=1) && (col+2<=8)){
                System.out.println((row - 1) + " " + (col + 2));
            }

            if ((row+1<=8) && (col+2 <= 8)){
                System.out.println((row + 1) + " " + (col + 2));
            }

            if ((row - 2 >= 1) && (col + 1 <= 8)) {
                System.out.println((row - 2) + " " + (col + 1));
            }
            if ((row - 2 >= 1) && (col - 1 >= 1)) {
                System.out.println((row - 2) + " " + (col - 1));
            }
            if ((row - 1 >= 1) && (col - 2 >= 1)) {
                System.out.println((row - 1) + " " + (col - 2));
            }

            if ((row + 1 <= 8) && (col - 2 >= 1)){
                System.out.println((row+1) + " " + (col-2));
            }
            if ((row+2 <=8)&&(col-1>=1)){
                System.out.println((row+2)+" "+(col-1));
            }
            if ((row+2 <=8) && (col+1<=8)){
                System.out.println((row+2)+" "+ (col+1));
            }
        }

        else {
            System.out.println("input is illegal");
        }


    } // end of method main
} //end of class Knight

