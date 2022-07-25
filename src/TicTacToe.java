import java.util.Scanner;
public class TicTacToe {

    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.println("Let's play Tic Tac Toe!");
        System.out.print("Player 1, what is your name? ");
        String p1 = input.nextLine();
        System.out.println("Player 1 is " + p1);
        System.out.print("Player 2, what is your name? ");
        String p2 = input.nextLine();
        System.out.println("Player 2 is " + p2);
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                board[i][j] = " ";
            }
        }
        boolean player1 = true;


        //make play again loop

        boolean gameEnded = false;




        String choice = " ";
        int row = 0;
        int col = 0;

        do  {
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    board[i][j] = " ";
                }
            }
             choice = " ";
             row = 0;
             col = 0;
            gameEnded = false;
            while (!gameEnded) {
                display();
                if (player1)
                    System.out.println(p1 + ", it's your turn! (X)");
                else
                    System.out.println(p2 + ", it's your turn! (O)");


                if (player1) {
                    choice = "X";
                } else {
                    choice = "O";
                }

                // col = 0;
                // row = 0;



                do  {
                    row = SafeInput.getRangedInt(input, "Enter a row number (1, 2, or 3): )", 1, 3);
                    row--;
                    col = SafeInput.getRangedInt(input, "Enter a column number (1, 2, or 3): )", 1, 3);
                    col--;
                    if (isValidMove(row, col)) {
                        board[row][col] = choice;
                        break;
                    }
                    System.out.println("Someone already moved there!");
                } while (1==1);

                if (isWin(p1)) {
                    System.out.println(p1 + " has won!");
                    gameEnded = true;
                } else if (isWin(p2)) {
                    System.out.println(p2 + " has won!");
                    gameEnded = true;
                } else {
                    if (isTie()) {
                        System.out.println("It's a tie!");
                        gameEnded = true;
                    } else {
                        player1 = !player1;
                    }
                }
            }


        } while (SafeInput.getYNConfirm(input, "Do you want to play again?"));
    }




















    private static void clearBoard(){
      return;

    }

    private static void display(){
        System.out.println("Board:");
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(int row, int col) {
        if (board[row][col].equals(" ")) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isWin(String player){
        if (isColWin(player)){
            display();
            return true;}
        if (isRowWin(player)){
            display();
            return true;}

        if (isDiagonalWin(player)){
           display();
        return true;}
        return false;
    }

    private static boolean isColWin(String player){
        for(int j = 0; j < COL; j++) {
            if(board[0][j].equals(board[1][j]) && board[1][j].equals(board[2][j]) && (board[0][j].equals("X") || board[0][j].equals("O"))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRowWin(String player){
        for(int j = 0; j < COL; j++) {
            if(board[j][0].equals(board[j][1]) && board[j][1].equals(board[j][2]) && (board[j][0].equals("X") || board[j][0].equals("O"))) {
                System.out.println("Row win");
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player){
        for(int j = 0; j < COL; j++) {
            if(board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && (board[j][j].equals("X") || board[j][j].equals("O"))) {
                System.out.println("Diagonal win");
                return true;
            }
            if(board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2]) && (board[2][0].equals("X") || board[j][j].equals("O"))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isTie(){
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j].equals(" ")){
                    return false;
                }
            }
        }
        return true;
    }
}




