import java.util.Scanner;

public class Chess {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the type" +
                " of the first chessman");
        char first = scan.next().charAt(0);
        System.out.println("Please enter the number of row");
        int row1 = scan.nextInt();
        System.out.println("Please enter the number of column");
        int col1 = scan.nextInt();
        System.out.println("Please enter the type" +
                " of the second chessman");
        char second = scan.next().charAt(0);
        System.out.println("Please enter the number of row");
        int row2 = scan.nextInt();
        System.out.println("Please enter the number of column");
        int col2 = scan.nextInt();

        //This value will be true only if there is a rook on board, and he also threatens someone;
        boolean rookThreat = ((row1 == row2) || (col1 == col2)) && (first == 'r' || second == 'r');

        //This value will be true only if there is a knight on board, and he also threatens someone;
        boolean knightThreat = (row1 != row2 && col1 != col2) && (Math.abs(row1 - row2) + Math.abs(col1 - col2) == 3) && (first == 'k' || second == 'k');

        //This value will be true only if there is a bishop on board, and he also threatens someone;
        boolean bishopThreat = (Math.abs(row1 - row2) == Math.abs(col1 - col2)) && (first == 'b' || second == 'b');

        boolean illegalNote = false; //Check if something illegal happened;
        boolean noThreat = !(bishopThreat || knightThreat || rookThreat); //This value will be true only if there are no threats;


        if (first == second) { //Chessmen are the same
            System.out.println("Chessmen should be different from each other");
            illegalNote = true;
        }

        if ((row1 >= 1) && (row1 <= 8) && (row2 >= 1) && (row2 <= 8) && (col1 >= 1) && (col1 <= 8) && (col2 >= 1) && (col2 <= 8)) { //Position is legal;
            if ((row1 != row2) || (col1 != col2)) { //Position is not the same; The case where all the illegal stuff is already checked, so we can start checking for threats;

                if ((noThreat == true) && (illegalNote == false)) { //There are no threats
                    System.out.println("no threat");
                }

                if ((noThreat == false) && (rookThreat) && (illegalNote == false)) {//Rook threatens someone
                    if (first == 'k' || second == 'k') {
                        System.out.println("rook threats knight");
                    }
                    if (first == 'b' || second == 'b') {
                        System.out.println("rook threats bishop");
                    }
                }
                if ((noThreat == false) && (bishopThreat) && (illegalNote == false)) {//Bishop threatens someone
                    if (first == 'k' || second == 'k') {
                        System.out.println("bishop threats knight");
                    }
                    if (first == 'r' || second == 'r') {
                        System.out.println("bishop threats rook");
                    }
                }
                if (noThreat == false && (knightThreat) && (illegalNote == false)) {//Knight threatens someone
                    if (first == 'r' || second == 'r') {
                        System.out.println("knight threats rook");
                    }
                    if (first == 'b' || second == 'b') {
                        System.out.println("knight threats bishop");
                    }
                }

            } else {
                System.out.println("Chessmen positions should not be identical");
                illegalNote = true;
            }


        } else {
            System.out.println("Position is not legal");
            illegalNote = true;
        }

    }// end of method main
} //end of class Chess