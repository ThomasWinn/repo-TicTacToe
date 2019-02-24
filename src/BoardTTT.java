import java.util.Scanner;

public class BoardTTT {

    public static void main(String[] args) {


    Scanner s = new Scanner(System.in);
    String[] board = new String[9];
    String turn = "X";
    String winner = null;

    System.out.println("Welcome to Tic Tac Toe.");
    System.out.println("-----------------------");

    printStartBoard(board);

    System.out.println("pick which number you'd like to put X into.");

    while(winner == null) {

        int userChoice = s.nextInt();

        if(userChoice > 9 || userChoice < 0) {
            //not acceptable
            System.out.println("The number you chose is not listed, please input a new number.");
            continue;
        } else {
            // IF PICKED BOARD COORDINATE ISNT TAKEN
            if (board[userChoice - 1].equals(String.valueOf(userChoice))) {

                // Update Board
                updateBoard(turn, board, userChoice);

                // Switching turns
                if(turn.equals("X")) {
                    turn = "O";
                }
                else {
                    turn = "X";
                }

                winner = Winner(board);

                if(winner == null) {

                    if (turn.equals("X")) {
                        System.out.println("pick which number you'd like to put X into.");
                    } else {
                        System.out.println("pick which number you'd like to put O into.");
                    }
                }

            }
            // ELSE IF YOU PICKED AN OCCUPIED SPACE
            else {
                System.out.println("Slot already taken, pick a new one.");
                continue;
            }
        }
    }

    if(winner.equals("draw")) {
        System.out.println("The game is a draw.");
    }
    else {
        System.out.println("Congrats " + winner + " won.");
    }
    }

    // {0,1,2,   3,4,5,   6,7,8}
    // {1,2,3,   4,5,6,   7,8,9}
    public static void updateBoard(String turn, String[] board, int userChoice) {
        for(int j = 0; j < board.length; j++) {
            if(j % 3 == 0) {
                System.out.println("\n");
            }

            if (board[userChoice - 1].equals(String.valueOf(userChoice))) {
                board[userChoice - 1] = turn;
                System.out.print(board[j] + "\t");
                continue;
            }

            System.out.print(board[j] + "\t");
        }
        System.out.println();
    }

    public static String Winner(String[] board) {

        int count = 0;

        //8 winning cases
        for(int i = 0; i < 8; i ++) {
            String combination = "";
            switch(i) {
                case 0:
                    combination = board[0] + board[4] + board[8];
                    break;
                case 1:
                    combination = board[2] + board[4] + board[6];
                    break;
                case 2:
                    combination = board[0] + board[1] + board[2];
                    break;
                case 3:
                    combination = board[3] + board[4] + board[5];
                    break;
                case 4:
                    combination = board[6] + board[7] + board[8];
                    break;
                case 5:
                    combination = board[0] + board[3] + board[6];
                    break;
                case 6:
                    combination = board[1] + board[4] + board[7];
                    break;
                case 7:
                    combination = board[2] + board[5] + board[8];
                    break;
            }
            if(combination.equals("XXX")) {
                return "X";
            }
            else if(combination.equals("OOO")) {
                return "O";
            }
        }
        // draw condition
        for(int a = 0; a < board.length; a++) {
            if(board[a].equals("X") || board[a].equals("O")) {
                count++;
            }
        }
        if(count == 9) {
            return "draw";
        }
        return null;
    }


    public static void printStartBoard(String[] board) {
        for(int i = 0; i < board.length; i++) {
            board[i] = String.valueOf(i + 1);
            if(i % 3 == 0) {
                System.out.println("\n");
            }
            System.out.print(board[i] + "\t");
        }
        System.out.println();
    }
}