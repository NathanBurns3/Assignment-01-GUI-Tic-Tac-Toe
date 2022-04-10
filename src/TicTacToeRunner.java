import javax.swing.*;
import java.util.Scanner;

public class TicTacToeRunner {

    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];

    public static void main(String[] args)
    {
       JFrame frame = new TicTacToeFrameMethods();
       frame.setVisible(true);
    }
}
