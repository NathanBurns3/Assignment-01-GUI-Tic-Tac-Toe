import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.Scanner;

public abstract class TicTacToeFrame extends JFrame implements ActionListener {
    JPanel mainPnl;
    JPanel boardPnl;
    JPanel quitPnl;

    TicTacToeButton[][] guiButtons = new TicTacToeButton[3][3];

    JButton topLeft = new JButton("");
    JButton topMiddle = new JButton("");
    JButton topRight = new JButton("");
    JButton middleLeft = new JButton("");
    JButton middleMiddle = new JButton("");
    JButton middleRight = new JButton("");
    JButton bottomLeft = new JButton("");
    JButton bottomMiddle = new JButton("");
    JButton bottomRight = new JButton("");
    JButton quitBtn;


    String letter = "";
    int count = 0;
    int XWins, OWins = 0;
    boolean win = false;

    static final int ROW = 3;
    static final int COL = 3;
    static String[][] board = new String[ROW][COL];

    public TicTacToeFrame() {
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        boardPnl = new JPanel();
        boardPnl.setLayout(new GridLayout(3, 3));

        boardPnl.add(topLeft);
        boardPnl.add(topMiddle);
        boardPnl.add(topRight);
        boardPnl.add(middleLeft);
        boardPnl.add(middleMiddle);
        boardPnl.add(middleRight);
        boardPnl.add(bottomLeft);
        boardPnl.add(bottomMiddle);
        boardPnl.add(bottomRight);

        topLeft.addActionListener(this);
        topMiddle.addActionListener(this);
        topRight.addActionListener(this);
        middleLeft.addActionListener(this);
        middleMiddle.addActionListener(this);
        middleRight.addActionListener(this);
        bottomLeft.addActionListener(this);
        bottomMiddle.addActionListener(this);
        bottomRight.addActionListener(this);


        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++) {
                guiButtons[row][col] = new TicTacToeButton(row, col);
                guiButtons[row][col].setText(" ");
                int finalCol2 = col;
                int finalRow2 = row;
                guiButtons[row][col].addActionListener((ActionEvent ae) -> {
                    System.out.println("row is " + finalRow2 + " col is " + finalCol2);
                });
            }

        mainPnl.add(boardPnl, BorderLayout.CENTER);
        add(mainPnl);

        quitPnl = new JPanel();
        quitBtn = new JButton("Quit the TTT Game!");
        quitBtn.addActionListener((ActionEvent ae) ->
        {
            System.exit(0);
        });

        quitPnl.add(quitBtn);
        mainPnl.add(quitPnl, BorderLayout.SOUTH);

        setVisible(true);
    }
}
