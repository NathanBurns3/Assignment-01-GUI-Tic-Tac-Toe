import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Scanner;

public class TicTacToeFrameMethods extends TicTacToeFrame{

    public TicTacToeFrameMethods() {
        boolean finished = false;
        boolean playing = true;
        Scanner in = new Scanner(System.in);
        String player = "X";
        int moveCnt = 0;
        int row = -1;
        int col = -1;
        final int MOVES_FOR_WIN = 5;
        final int MOVES_FOR_TIE = 7;
        do // program loop
        {
            //begin a game
            player = "X";
            playing = true;
            moveCnt = 0;
            clearBoard();
            do  // game loop
            {
                // get the move
                do {

                    display();
                    System.out.println("Enter move for " + player);
                    JOptionPane.showMessageDialog(null, "Enter move for " + player);
                    row = SafeInput.getRangedInt(in, "Enter row ", 1, 3);
                    col = SafeInput.getRangedInt(in, "Enter col ", 1, 3);
                    row--;
                    col--;
                } while (!isValidMove(row, col));
                board[row][col] = player;
                guiButtons[row][col].setText(player);
                moveCnt++;

                if (moveCnt >= MOVES_FOR_WIN) {
                    if (isWin(player)) {
                        display();
                        System.out.println("Player " + player + " wins!");
                        playing = false;
                    }
                }
                if (moveCnt >= MOVES_FOR_TIE) {
                    if (isTie()) {
                        display();
                        System.out.println("It's a Tie!");
                        playing = false;
                    }
                }
                if (player.equals("X")) {
                    player = "O";
                } else {
                    player = "X";
                }

            } while (playing);

            finished = SafeInput.getYNConfirm(in, "Done Playing? ");
        } while (!finished);
    }

    @Override
    public void actionPerformed(ActionEvent z) {
        count++;
        if (count == 1 || count == 3 || count == 5 || count == 7 || count == 9) {
            letter = "X";
        } else if (count == 2 || count == 4 || count == 6 || count == 8 || count == 10) {
            letter = "O";
        }
        //Displaying an X or O on the buttons
        if (z.getSource() == topLeft) {
            topLeft.setText(letter);
            topLeft.setEnabled(false);
            CheckForWin();
        } else if (z.getSource() == topMiddle) {
            topMiddle.setText(letter);
            topMiddle.setEnabled(false);
            CheckForWin();
        } else if (z.getSource() == topRight) {
            topRight.setText(letter);
            topRight.setEnabled(false);
            CheckForWin();
        } else if (z.getSource() == middleLeft) {
            middleLeft.setText(letter);
            middleLeft.setEnabled(false);
            CheckForWin();
        } else if (z.getSource() == middleMiddle) {
            middleMiddle.setText(letter);
            middleMiddle.setEnabled(false);
            CheckForWin();
        } else if (z.getSource() == middleRight) {
            middleRight.setText(letter);
            middleRight.setEnabled(false);
            CheckForWin();
        } else if (z.getSource() == bottomLeft) {
            bottomLeft.setText(letter);
            bottomLeft.setEnabled(false);
            CheckForWin();
        } else if (z.getSource() == bottomMiddle) {
            bottomMiddle.setText(letter);
            bottomMiddle.setEnabled(false);
            CheckForWin();
        } else if (z.getSource() == bottomRight) {
            bottomRight.setText(letter);
            bottomRight.setEnabled(false);
            CheckForWin();
        }
    }

    public void CheckForWin()
    {
        //looking who wins horizontally
        if (topLeft.getText() == topMiddle.getText() && topMiddle.getText() == topRight.getText() && topLeft.getText() != "")
        {
            win = true;
            Win();
        }
        else if (middleLeft.getText() == middleMiddle.getText() && middleMiddle.getText() == middleRight.getText() && middleLeft.getText() != "")
        {
            win = true;
            Win();
        }
        else if (bottomLeft.getText() == bottomMiddle.getText() && bottomMiddle.getText() == bottomRight.getText() && bottomLeft.getText() != "")
        {
            win = true;
            Win();
        }
        //looking for who wins vertically
        else if (topLeft.getText() == middleLeft.getText() && middleLeft.getText() == bottomLeft.getText() && topLeft.getText() != "")
        {
            win = true;
            Win();
        }
        else if (topMiddle.getText() == middleMiddle.getText() && middleMiddle.getText() == bottomMiddle.getText() && topMiddle.getText() != "")
        {
            win = true;
            Win();
        }
        else if (topRight.getText() == middleRight.getText() && middleRight.getText() == bottomRight.getText() && topRight.getText() != "")
        {
            win = true;
            Win();
        }
        //looking for who wins diagonally
        else if (topLeft.getText() == middleMiddle.getText() && middleMiddle.getText() == bottomRight.getText() && topLeft.getText() != "")
        {
            win = true;
            Win();
        }
        else if (topRight.getText() == middleMiddle.getText() && middleMiddle.getText() == bottomLeft.getText() && topRight.getText() != "")
        {
            win = true;
            Win();
        }
        else
        {
            win = false;
            Win();
        }
    }

    public void Win()
    {
        if (win == true)
        {
            int input = JOptionPane.showConfirmDialog(null, "Player " + letter + " Won!\n" + "Play again?");
            if(input == JOptionPane.YES_OPTION){
                reset();
            }else if (input == JOptionPane.NO_OPTION){
                System.exit(0);
            }else {
                //label.setText("None selected");
            }

            if(letter.equalsIgnoreCase("X"))
            {
                XWins++;
            }
            else
            {
                OWins++;
            }
        }
        else if (count == 9 && win == false)
        {
            JOptionPane.showMessageDialog(null, "It's a Tie!");
        }
    }

    public void reset()
    {
        topLeft.setText("");
        topLeft.setEnabled(true);
        topMiddle.setText("");
        topMiddle.setEnabled(true);
        topRight.setText("");
        topRight.setEnabled(true);
        middleLeft.setText("");
        middleLeft.setEnabled(true);
        middleMiddle.setText("");
        middleMiddle.setEnabled(true);
        middleRight.setText("");
        middleRight.setEnabled(true);
        bottomLeft.setText("");
        bottomLeft.setEnabled(true);
        bottomMiddle.setText("");
        bottomMiddle.setEnabled(true);
        bottomRight.setText("");
        bottomRight.setEnabled(true);
        win = false;
        count = 0;
    }

    private static void clearBoard()
    {
        // sets all the board elements to a space
        for(int row=0; row < ROW; row++)
        {
            for(int col=0; col < COL; col++)
            {
                board[row][col] = " ";
            }
        }
    }
    private static void display()
    {
        // shows the Tic Tac Toe game
        for(int row=0; row < ROW; row++)
        {
            System.out.print("| ");
            for(int col=0; col < COL; col++)
            {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }

    }
    private static boolean isValidMove(int row, int col)
    {
        boolean retVal = false;
        if(board[row][col].equals(" "))
            retVal = true;

        return retVal;

    }
    private static boolean isWin(String player)
    {
        if(isColWin(player) || isRowWin(player) || isDiagnalWin(player))
        {
            return true;
        }

        return false;
    }
    private static boolean isColWin(String player)
    {
        // checks for a col win for specified player
        for(int col=0; col < COL; col++)
        {
            if(board[0][col].equals(player) &&
                    board[1][col].equals(player) &&
                    board[2][col].equals(player))
            {
                return true;
            }
        }
        return false; // no col win
    }
    private static boolean isRowWin(String player)
    {
        // checks for a row win for the specified player
        for(int row=0; row < ROW; row++)
        {
            if(board[row][0].equals(player) &&
                    board[row][1].equals(player) &&
                    board[row][2].equals(player))
            {
                return true;
            }
        }
        return false; // no row win
    }
    private static boolean isDiagnalWin(String player)
    {
        // checks for a diagonal win for the specified player

        if(board[0][0].equals(player) &&
                board[1][1].equals(player) &&
                board[2][2].equals(player) )
        {
            return true;
        }
        if(board[0][2].equals(player) &&
                board[1][1].equals(player) &&
                board[2][0].equals(player) )
        {
            return true;
        }
        return false;
    }

    // checks for a tie before board is filled.
    // check for the win first to be efficient
    private static boolean isTie()
    {
        boolean xFlag = false;
        boolean oFlag = false;
        // Check all 8 win vectors for an X and O so
        // no win is possible
        // Check for row ties
        for(int row=0; row < ROW; row++)
        {
            if(board[row][0].equals("X") ||
                    board[row][1].equals("X") ||
                    board[row][2].equals("X"))
            {
                xFlag = true; // there is an X in this row
            }
            if(board[row][0].equals("O") ||
                    board[row][1].equals("O") ||
                    board[row][2].equals("O"))
            {
                oFlag = true; // there is an O in this row
            }

            if(! (xFlag && oFlag) )
            {
                return false; // No tie can still have a row win
            }

            xFlag = oFlag = false;

        }
        // Now scan the columns
        for(int col=0; col < COL; col++)
        {
            if(board[0][col].equals("X") ||
                    board[1][col].equals("X") ||
                    board[2][col].equals("X"))
            {
                xFlag = true; // there is an X in this col
            }
            if(board[0][col].equals("O") ||
                    board[1][col].equals("O") ||
                    board[2][col].equals("O"))
            {
                oFlag = true; // there is an O in this col
            }

            if(! (xFlag && oFlag) )
            {
                return false; // No tie can still have a col win
            }
        }
        // Now check for the diagonals
        xFlag = oFlag = false;

        if(board[0][0].equals("X") ||
                board[1][1].equals("X") ||
                board[2][2].equals("X") )
        {
            xFlag = true;
        }
        if(board[0][0].equals("O") ||
                board[1][1].equals("O") ||
                board[2][2].equals("O") )
        {
            oFlag = true;
        }
        if(! (xFlag && oFlag) )
        {
            return false; // No tie can still have a diag win
        }
        xFlag = oFlag = false;

        if(board[0][2].equals("X") ||
                board[1][1].equals("X") ||
                board[2][0].equals("X") )
        {
            xFlag =  true;
        }
        if(board[0][2].equals("O") ||
                board[1][1].equals("O") ||
                board[2][0].equals("O") )
        {
            oFlag =  true;
        }
        if(! (xFlag && oFlag) )
        {
            return false; // No tie can still have a diag win
        }

        // Checked every vector so I know I have a tie
        return true;
    }
}
