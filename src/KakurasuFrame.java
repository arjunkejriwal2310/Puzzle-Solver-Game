import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class KakurasuFrame extends PuzzleFrame implements ActionListener
{
    private JFrame mainFrame;
    private KakurasuButtons[][] buttons;

    KakurasuRowChecker row1 = new KakurasuRowChecker(15, 0);
    KakurasuRowChecker row2 = new KakurasuRowChecker(10, 1);
    KakurasuRowChecker row3 = new KakurasuRowChecker(11, 2);
    KakurasuRowChecker row4 = new KakurasuRowChecker(2, 3);
    KakurasuRowChecker row5 = new KakurasuRowChecker(3, 4);

    KakurasuColumnChecker col1 = new KakurasuColumnChecker(1, 0);
    KakurasuColumnChecker col2 = new KakurasuColumnChecker(10, 1);
    KakurasuColumnChecker col3 = new KakurasuColumnChecker(8, 2);
    KakurasuColumnChecker col4 = new KakurasuColumnChecker(4, 3);
    KakurasuColumnChecker col5 = new KakurasuColumnChecker(6, 4);

    public void setUpFrame(JFrame frame)
    {
        this.mainFrame = frame;
        this.setTitle("Kakurasu Game");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container ct = this.getContentPane();
        ct.setLayout(new GridLayout(9, 0));

        JPanel panelHeader = new JPanel();
        panelHeader.setLayout(new FlowLayout());
        JLabel Heading = new JLabel("WELCOME TO KAKURASU!");
        Heading.setFont(new Font("Helvetica", Font.BOLD, 36));
        Heading.setForeground(new Color(245, 44, 50));
        Heading.setAlignmentX(0.5f);
        Heading.setAlignmentY(0.5f);
        panelHeader.add(Heading);
        panelHeader.setSize(this.getWidth(), 100);
        ct.add(panelHeader);

        JPanel[] centerPanels = new JPanel[7];

        for(int i = 0; i < 7; i++)
        {
            centerPanels[i] = new JPanel();
            centerPanels[i].setLayout(new GridLayout(0, 7));
        }

        JPanel[][] theGrid = new JPanel[7][7];

        for (int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                theGrid[i][j] = new JPanel();
                theGrid[i][j].setLayout(new FlowLayout());
                centerPanels[i].add(theGrid[i][j]);
            }
            ct.add(centerPanels[i]);
        }

        buttons = new KakurasuButtons[5][5];

        for(int i = 1; i < 6; i++)
        {
            for (int j = 1; j < 6; j++)
            {
                theGrid[i][j].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                theGrid[i][j].setLayout(new GridLayout(1,1));
                buttons[i-1][j-1] = new KakurasuButtons();
                buttons[i-1][j-1].setBackground(new Color(86, 125, 147));
                buttons[i-1][j-1].setEnabled(true);
                theGrid[i][j].add(buttons[i-1][j-1]);

                buttons[i-1][j-1].setFont(new Font("Helvetica", Font.PLAIN, 15));
                buttons[i-1][j-1].setForeground(new Color(0, 0, 0));
                buttons[i-1][j-1].addActionListener(new KakurasuListener(buttons[i-1][j-1]));
            }
        }

        for(int i = 1; i < 6; i++)
        {
            JLabel addLabel = new JLabel(i + "");
            addLabel.setFont(new Font("Helvetica", Font.PLAIN, 40));
            addLabel.setForeground(new Color(150, 150, 150));
            addLabel.setAlignmentX(0.5f);
            addLabel.setAlignmentY(0.5f);
            theGrid[0][i].add(addLabel);
        }

        for(int i = 1; i < 6; i++)
        {
            JLabel addLabel = new JLabel(i + "");
            addLabel.setFont(new Font("Helvetica", Font.PLAIN, 40));
            addLabel.setForeground(new Color(150, 150, 150));
            addLabel.setAlignmentX(0.5f);
            addLabel.setAlignmentY(0.5f);
            theGrid[i][0].add(addLabel);
        }

        for(int i = 1; i < 6; i++)
        {
            String add = "";

            if(i == 1)
            {
                add = "1";
            }
            else if(i == 2)
            {
                add = "10";
            }
            else if(i == 3)
            {
                add = "8";
            }
            else if(i == 4)
            {
                add = "4";
            }
            else if(i == 5)
            {
                add = "6";
            }

            JLabel addLabel = new JLabel(add);
            addLabel.setFont(new Font("Helvetica", Font.PLAIN, 40));
            addLabel.setForeground(new Color(0, 0, 0));
            addLabel.setAlignmentX(0.5f);
            addLabel.setAlignmentY(0.5f);
            theGrid[6][i].add(addLabel);
        }

        for(int i = 1; i < 6; i++)
        {
            String add = "";

            if(i == 1)
            {
                add = "15";
            }
            else if(i == 2)
            {
                add = "10";
            }
            else if(i == 3)
            {
                add = "11";
            }
            else if(i == 4)
            {
                add = "2";
            }
            else if(i == 5)
            {
                add = "3";
            }

            JLabel addLabel = new JLabel(add);
            addLabel.setFont(new Font("Helvetica", Font.PLAIN, 40));
            addLabel.setForeground(new Color(0, 0, 0));
            addLabel.setAlignmentX(0.5f);
            addLabel.setAlignmentY(0.5f);
            theGrid[i][6].add(addLabel);
        }

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        ct.add(bottomPanel);

        JButton instructions = new JButton("Instructions");
        instructions.setBounds(150, 45, 70, 60);
        instructions.setEnabled(true);
        instructions.setForeground(Color.red);
        bottomPanel.add(instructions);
        instructions.addActionListener(new ActionListener2(this, "K"));

        bottomPanel.add(Box.createHorizontalStrut(30));

        JButton checkPuzzle = new JButton("Check Answer");
        checkPuzzle.setBounds(150, 45, 70, 60);
        checkPuzzle.setEnabled(true);
        checkPuzzle.setForeground(Color.red);
        bottomPanel.add(checkPuzzle);
        checkPuzzle.addActionListener(this);

        bottomPanel.add(Box.createHorizontalStrut(30));

        JButton solvePuzzle = new JButton("Show Solution");
        solvePuzzle.setBounds(150, 45, 70, 60);
        solvePuzzle.setEnabled(true);
        solvePuzzle.setForeground(Color.red);
        bottomPanel.add(solvePuzzle);
        solvePuzzle.addActionListener(new SolveListener("K", mainFrame, this));

        bottomPanel.add(Box.createHorizontalStrut(30));

        JButton changePuzzle = new JButton("Different Puzzle");
        changePuzzle.setBounds(150, 45, 70, 60);
        changePuzzle.setEnabled(true);
        changePuzzle.setForeground(Color.red);
        bottomPanel.add(changePuzzle);
        changePuzzle.addActionListener(new ActionListener3(this, mainFrame));

        bottomPanel.add(Box.createHorizontalStrut(30));

        JButton fileRead = new JButton("Fill from File");
        fileRead.setBounds(150, 45, 70, 60);
        fileRead.setEnabled(true);
        fileRead.setForeground(Color.red);
        bottomPanel.add(fileRead);

        File theFile = new File("KakurasuAttempt1.dat");
        fileRead.addActionListener(new FileAddListener(buttons, theFile, "K"));
    }

    public void actionPerformed(ActionEvent e)
    {
        if(checkAnswer())
        {
            JOptionPane.showMessageDialog(null, "Correct! You have solved the puzzle!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Incorrect! Your answer is wrong! Try again!");
        }
    }

    public boolean checkAnswer()
    {
        int[] rowTotals = new int[5];

        for(int i = 0; i < 5; i++)
        {
            rowTotals[i] = 0;

            for (int j = 0; j < 5; j++)
            {
                if(buttons[i][j].getPressed())
                {
                    rowTotals[i] = rowTotals[i] + (j+1);
                }
            }
        }

        for(int i = 0; i < 5; i++)
        {
            if(i == 0)
            {
                if(rowTotals[i] != 15)
                {
                    return false;
                }
            }
            else if(i == 1)
            {
                if(rowTotals[i] != 10)
                {
                    return false;
                }
            }
            else if(i == 2)
            {
                if(rowTotals[i] != 11)
                {
                    return false;
                }
            }
            else if(i == 3)
            {
                if(rowTotals[i] != 2)
                {
                    return false;
                }
            }
            else if(i == 4)
            {
                if(rowTotals[i] != 3)
                {
                    return false;
                }
            }
        }

        int[] colTotals = new int[5];

        for(int i = 0; i < 5; i++)
        {
            colTotals[i] = 0;

            for (int j = 0; j < 5; j++)
            {
                if(buttons[j][i].getPressed())
                {
                    colTotals[i] = colTotals[i] + (j+1);
                }
            }
        }

        for(int i = 0; i < 5; i++)
        {
            if(i == 0)
            {
                if(colTotals[i] != 1)
                {
                    return false;
                }
            }
            else if(i == 1)
            {
                if(colTotals[i] != 10)
                {
                    return false;
                }
            }
            else if(i == 2)
            {
                if(colTotals[i] != 8)
                {
                    return false;
                }
            }
            else if(i == 3)
            {
                if(colTotals[i] != 4)
                {
                    return false;
                }
            }
            else if(i == 4)
            {
                if(colTotals[i] != 6)
                {
                    return false;
                }
            }
        }

        return true;
    }

    public JButton[][] getGrid()
    {
        return buttons;
    }

    public String[] getPossibles()
    {
        String[] possibles = {"pressed", "not pressed"};
        return possibles;
    }

    public boolean checkConstraints(String value, int row, int column)
    {
        boolean rowCheck = false;
        boolean colCheck = false;

        if(column == 4)
        {
            if (row == 0)
            {
                rowCheck = row1.constraintSatisfied(this.buttons);
            }
            else if (row == 1)
            {
                rowCheck = row2.constraintSatisfied(this.buttons);
            }
            else if (row == 2)
            {
                rowCheck = row3.constraintSatisfied(this.buttons);
            }
            else if (row == 3)
            {
                rowCheck = row4.constraintSatisfied(this.buttons);
            }
            else if (row == 4)
            {
                rowCheck = row5.constraintSatisfied(this.buttons);
            }
        }

        if(row == 4)
        {
            if (column == 0)
            {
                colCheck = col1.constraintSatisfied(this.buttons);
            }
            else if (column == 1)
            {
                colCheck = col2.constraintSatisfied(this.buttons);
            }
            else if (column == 2)
            {
                colCheck = col3.constraintSatisfied(this.buttons);
            }
            else if (column == 3)
            {
                colCheck = col4.constraintSatisfied(this.buttons);
            }
            else if (column == 4)
            {
                colCheck = col5.constraintSatisfied(this.buttons);
            }
        }

        if(row == 4 && column == 4)
        {
            if(rowCheck && colCheck)
            {
                return true;

            }
            else
            {
                return false;
            }
        }

        if(row == 4)
        {
            if(colCheck)
            {
                return true;

            }
            else
            {
                return false;
            }
        }

        if(column == 4)
        {
            if(rowCheck)
            {
                return true;

            }
            else
            {
                return false;
            }
        }

        return true;
    }

    public boolean isPreLabeled(JButton theButton)
    {
        return false;
    }

    public void setValue(JButton theButton, String value)
    {
        if(value.equals("pressed"))
        {
            KakurasuButtons button = ((KakurasuButtons) theButton);
            button.setPressed(true);
            button.setText("Pressed");
            button.setBackground(Color.red);
        }
        else
        {
            KakurasuButtons button = ((KakurasuButtons) theButton);
            button.setPressed(false);
            button.setText("");
            theButton.setBackground(new Color(86, 125, 147));
        }
    }

    public void clearButton2(JButton theButton)
    {
        KakurasuButtons button = ((KakurasuButtons) theButton);
        button.setPressed(false);
        button.setText("");
        theButton.setBackground(new Color(86, 125, 147));
    }
}
