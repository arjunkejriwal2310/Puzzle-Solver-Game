import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class DosunFuwariFrame extends PuzzleFrame implements ActionListener
{
    public JFrame mainFrame;
    DosunFuwariButtons[][] buttons;

    int[] rowCoordinates1 = {0, 0};
    int[] colCoordinates1 = {0, 1};
    int[] rowCoordinates2 = {1, 2, 3};
    int[] colCoordinates2 = {0, 0, 0};
    int[] rowCoordinates3 = {2, 3, 3};
    int[] colCoordinates3 = {1, 1, 2};
    int[] rowCoordinates4 = {0, 0, 1, 2};
    int[] colCoordinates4 = {2, 3, 2, 2};
    int[] rowCoordinates5 = {1, 2};
    int[] colCoordinates5 = {3, 3};

    DosunFuwariSingularChecker area1 = new DosunFuwariSingularChecker(rowCoordinates1, colCoordinates1);
    DosunFuwariSingularChecker area2 = new DosunFuwariSingularChecker(rowCoordinates2, colCoordinates2);
    DosunFuwariSingularChecker area3 = new DosunFuwariSingularChecker(rowCoordinates3, colCoordinates3);
    DosunFuwariSingularChecker area4 = new DosunFuwariSingularChecker(rowCoordinates4, colCoordinates4);
    DosunFuwariSingularChecker area5 = new DosunFuwariSingularChecker(rowCoordinates5, colCoordinates5);

    DosunFuwariPositionChecker area01 = new DosunFuwariPositionChecker(rowCoordinates1, colCoordinates1);
    DosunFuwariPositionChecker area02 = new DosunFuwariPositionChecker(rowCoordinates2, colCoordinates2);
    DosunFuwariPositionChecker area03 = new DosunFuwariPositionChecker(rowCoordinates3, colCoordinates3);
    DosunFuwariPositionChecker area04 = new DosunFuwariPositionChecker(rowCoordinates4, colCoordinates4);
    DosunFuwariPositionChecker area05 = new DosunFuwariPositionChecker(rowCoordinates5, colCoordinates5);

    public void setUpFrame(JFrame frame)
    {
        this.mainFrame = frame;
        this.setTitle("Dosun-Fuwari Game");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container ct = this.getContentPane();
        ct.setLayout(new GridLayout(6, 0));

        JPanel panelHeader = new JPanel();
        panelHeader.setLayout(new FlowLayout());
        JLabel Heading = new JLabel("WELCOME TO DOSUN-FUWARI!");
        Heading.setFont(new Font("Helvetica", Font.BOLD, 20));
        Heading.setForeground(new Color(46, 196, 11));
        Heading.setAlignmentX(0.5f);
        Heading.setAlignmentY(0.5f);
        panelHeader.add(Heading);
        panelHeader.setSize(this.getWidth(), 100);
        ct.add(panelHeader);

        JPanel[] centerPanels = new JPanel[4];

        for(int i = 0; i < 4; i++)
        {
            centerPanels[i] = new JPanel();
            centerPanels[i].setLayout(new GridLayout(0, 4));
        }

        JPanel[][] theGrid = new JPanel[4][4];

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                theGrid[i][j] = new JPanel();
                theGrid[i][j].setLayout(new GridLayout(1, 1));
                centerPanels[i].add(theGrid[i][j]);
            }
            ct.add(centerPanels[i]);
        }

        buttons = new DosunFuwariButtons[4][4];

        for(int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                buttons[i][j] = new DosunFuwariButtons(this, i, j);
                buttons[i][j].setBackground(Color.white);
                buttons[i][j].setEnabled(true);
                theGrid[i][j].add(buttons[i][j]);

                buttons[i][j].addActionListener(new ButtonToMenuListener(this, buttons[i][j], "D"));
            }
        }

        buttons[1][1].setBackground(Color.black);
        buttons[1][1].setEnabled(false);
        buttons[3][3].setBackground(Color.black);
        buttons[3][3].setEnabled(false);

        buttons[0][0].setBorder(BorderFactory.createMatteBorder(7, 7, 4, 1, Color.black));
        buttons[0][1].setBorder(BorderFactory.createMatteBorder(7, 1, 4, 4, Color.black));
        buttons[0][2].setBorder(BorderFactory.createMatteBorder(7, 4, 1, 1, Color.black));
        buttons[0][3].setBorder(BorderFactory.createMatteBorder(7, 1, 4, 7, Color.black));
        buttons[1][0].setBorder(BorderFactory.createMatteBorder(4, 7, 1, 4, Color.black));
        buttons[1][2].setBorder(BorderFactory.createMatteBorder(1, 4, 1, 4, Color.black));
        buttons[1][3].setBorder(BorderFactory.createMatteBorder(4, 4, 1, 7, Color.black));
        buttons[2][0].setBorder(BorderFactory.createMatteBorder(1, 7, 1, 4, Color.black));
        buttons[2][1].setBorder(BorderFactory.createMatteBorder(4, 4, 1, 4, Color.black));
        buttons[2][2].setBorder(BorderFactory.createMatteBorder(1, 4, 4, 4, Color.black));
        buttons[2][3].setBorder(BorderFactory.createMatteBorder(1, 4, 7, 7, Color.black));
        buttons[3][0].setBorder(BorderFactory.createMatteBorder(1, 7, 7, 4, Color.black));
        buttons[3][1].setBorder(BorderFactory.createMatteBorder(1, 4, 7, 1, Color.black));
        buttons[3][2].setBorder(BorderFactory.createMatteBorder(4, 1, 7, 4, Color.black));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        ct.add(bottomPanel);

        JButton instructions = new JButton("Instructions");
        instructions.setBounds(150, 45, 70, 60);
        instructions.setEnabled(true);
        instructions.setForeground(new Color(46, 196, 11));
        bottomPanel.add(instructions);
        instructions.addActionListener(new ActionListener2(this, "D"));

        bottomPanel.add(Box.createHorizontalStrut(30));

        JButton checkPuzzle = new JButton("Check Answer");
        checkPuzzle.setBounds(150, 45, 70, 60);
        checkPuzzle.setEnabled(true);
        checkPuzzle.setForeground(new Color(46, 196, 11));
        bottomPanel.add(checkPuzzle);
        checkPuzzle.addActionListener(this);

        bottomPanel.add(Box.createHorizontalStrut(30));

        JButton solvePuzzle = new JButton("Show Solution");
        solvePuzzle.setBounds(150, 45, 70, 60);
        solvePuzzle.setEnabled(true);
        solvePuzzle.setForeground(new Color(46, 196, 11));
        bottomPanel.add(solvePuzzle);
        solvePuzzle.addActionListener(new SolveListener("D", mainFrame, this));

        bottomPanel.add(Box.createHorizontalStrut(30));

        JButton changePuzzle = new JButton("Different Puzzle");
        changePuzzle.setBounds(150, 45, 70, 60);
        changePuzzle.setEnabled(true);
        changePuzzle.setForeground(new Color(46, 196, 11));
        bottomPanel.add(changePuzzle);
        changePuzzle.addActionListener(new ActionListener3(this, mainFrame));

        bottomPanel.add(Box.createHorizontalStrut(30));

        JButton fileRead = new JButton("Fill from File");
        fileRead.setBounds(150, 45, 70, 60);
        fileRead.setEnabled(true);
        fileRead.setForeground(new Color(46, 196, 11));
        bottomPanel.add(fileRead);

        File theFile = new File("DosunFuwariAttempt1.dat");
        fileRead.addActionListener(new FileAddListener(buttons, theFile, "D"));
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
        DosunFuwariButtons[][] areas = {{buttons[0][0], buttons[0][1]}, {buttons[1][0], buttons[2][0], buttons[3][0]},
                                        {buttons[2][1], buttons[3][1], buttons[3][2]}, {buttons[0][2], buttons[0][3], buttons[1][2], buttons[2][2]},
                                        {buttons[1][3], buttons[2][3]}};

        DosunFuwariButtons black1 = buttons[1][1];
        DosunFuwariButtons black2 = buttons[3][3];

        int[] numberWhite = {0, 0, 0, 0, 0};
        int[] numberBlack = {0, 0, 0, 0, 0};

        for(int i = 0; i < areas.length; i++)
        {
            for(int j = 0; j < areas[i].length; j++)
            {
                if (areas[i][j].getType().equals("white"))
                {
                    numberWhite[i]++;
                }
                else if (areas[i][j].getType().equals("black"))
                {
                    numberBlack[i]++;
                }
            }

            if(!((numberWhite[i] == 1) && (numberBlack[i] == 1)))
            {
                return false;
            }
        }

        int[] min = {5, 5, 5, 5, 5};
        int[] max = {-1, -1, -1, -1, -1};

        for(int i = 0; i < areas.length; i++)
        {
            for(int j = 0; j < areas[i].length; j++)
            {
                if(areas[i][j].getRow() < min[i])
                {
                    min[i] = areas[i][j].getRow();
                }

                if(areas[i][j].getRow() > max[i])
                {
                    max[i] = areas[i][j].getRow();
                }
            }

            boolean correctWhite = false;
            boolean correctBlack = false;

            for(int j = 0; j < areas[i].length; j++)
            {
                if(areas[i][j].getRow() == min[i])
                {
                    if(areas[i][j].getType().equals("white"))
                    {
                        correctWhite = true;
                    }
                }
                else if ((areas[i][j].getRow() - 1 == black1.getRow() && areas[i][j].getColumn() == black1.getColumn()) || (areas[i][j].getRow() - 1 == black2.getRow() && areas[i][j].getColumn() == black2.getColumn()))
                {
                    if(areas[i][j].getType().equals("white"))
                    {
                        correctWhite = true;
                    }
                }

                if(areas[i][j].getRow() == max[i])
                {
                    if(areas[i][j].getType().equals("black"))
                    {
                        correctBlack = true;
                    }
                }
                else if ((areas[i][j].getRow() + 1 == black1.getRow() && areas[i][j].getColumn() == black1.getColumn()) || (areas[i][j].getRow() + 1 == black2.getRow() && areas[i][j].getColumn() == black2.getColumn()))
                {
                    if(areas[i][j].getType().equals("black"))
                    {
                        correctBlack = true;
                    }
                }
            }

            if(!(correctWhite && correctBlack))
            {
                return false;
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
        String[] possibles = {"white", "black", "clear"};
        return possibles;
    }

    public boolean checkConstraints(String value, int row, int column)
    {
        boolean singularCheck = false;
        boolean positionCheck = false;

        if(row == 0 && column == 1)
        {
            singularCheck = area1.constraintSatisfied(this.buttons);

            if(singularCheck)
            {
                positionCheck = area01.constraintSatisfied(this.buttons);
            }
            else
            {
                return false;
            }

            if(positionCheck)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(row == 3 && column == 0)
        {
            singularCheck = area2.constraintSatisfied(this.buttons);

            if(singularCheck)
            {
                positionCheck = area02.constraintSatisfied(this.buttons);
            }
            else
            {
                return false;
            }

            if(positionCheck)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(row == 3 && column == 2)
        {
            singularCheck = area3.constraintSatisfied(this.buttons);

            if(singularCheck)
            {
                positionCheck = area03.constraintSatisfied(this.buttons);
            }
            else
            {
                return false;
            }

            if(positionCheck)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(row == 2 && column == 2)
        {
            singularCheck = area4.constraintSatisfied(this.buttons);

            if(singularCheck)
            {
                positionCheck = area04.constraintSatisfied(this.buttons);
            }
            else
            {
                return false;
            }

            if(positionCheck)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(row == 2 && column == 3)
        {
            singularCheck = area5.constraintSatisfied(this.buttons);

            if(singularCheck)
            {
                positionCheck = area05.constraintSatisfied(this.buttons);
            }
            else
            {
                return false;
            }

            if(positionCheck)
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
        if(theButton == buttons[1][1])
        {
            return true;
        }
        else if(theButton == buttons[3][3])
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void setValue(JButton theButton, String value)
    {
        DosunFuwariButtons button = ((DosunFuwariButtons)theButton);

        if(value.equals("white"))
        {
            button.whiteCircle();
        }
        else if(value.equals("black"))
        {
            button.blackCircle();
        }
        else if(value.equals("clear"))
        {
            button.clearButton();
        }
    }

    public void clearButton2(JButton theButton)
    {
        DosunFuwariButtons button = ((DosunFuwariButtons)theButton);
        button.clearButton();
    }
}
