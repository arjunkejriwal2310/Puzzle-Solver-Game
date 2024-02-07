import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SkyscaperFrame extends PuzzleFrame implements ActionListener
{
    public JFrame mainFrame;
    private SkyscaperButtons[][] buttons;

    SkyscraperRowRepeatChecker row1 = new SkyscraperRowRepeatChecker(0);
    SkyscraperRowRepeatChecker row2 = new SkyscraperRowRepeatChecker(1);
    SkyscraperRowRepeatChecker row3 = new SkyscraperRowRepeatChecker(2);
    SkyscraperRowRepeatChecker row4 = new SkyscraperRowRepeatChecker(3);
    SkyscraperRowRepeatChecker row5 = new SkyscraperRowRepeatChecker(4);

    SkyscraperColumnRepeatChecker col1 = new SkyscraperColumnRepeatChecker(0);
    SkyscraperColumnRepeatChecker col2 = new SkyscraperColumnRepeatChecker(1);
    SkyscraperColumnRepeatChecker col3 = new SkyscraperColumnRepeatChecker(2);
    SkyscraperColumnRepeatChecker col4 = new SkyscraperColumnRepeatChecker(3);
    SkyscraperColumnRepeatChecker col5 = new SkyscraperColumnRepeatChecker(4);

    SkyscraperRowChecker row01 = new SkyscraperRowChecker(3, 3, 0);
    SkyscraperRowChecker row02 = new SkyscraperRowChecker(2, 4, 1);
    SkyscraperRowChecker row03 = new SkyscraperRowChecker(3, 1, 2);
    SkyscraperRowChecker row04 = new SkyscraperRowChecker(2, 2, 3);
    SkyscraperRowChecker row05 = new SkyscraperRowChecker(1, 2, 4);

    SkyscraperColumnChecker col01 = new SkyscraperColumnChecker(4, 1, 0);
    SkyscraperColumnChecker col02 = new SkyscraperColumnChecker(2, 4, 1);
    SkyscraperColumnChecker col03 = new SkyscraperColumnChecker(1, 3, 2);
    SkyscraperColumnChecker col04 = new SkyscraperColumnChecker(2, 2, 3);
    SkyscraperColumnChecker col05 = new SkyscraperColumnChecker(3, 2, 4);

    public void setUpFrame(JFrame frame)
    {
        this.mainFrame = frame;
        this.setTitle("Skyscraper Game");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container ct = this.getContentPane();
        ct.setLayout(new GridLayout(9, 0));

        JPanel panelHeader = new JPanel();
        panelHeader.setLayout(new FlowLayout());
        JLabel Heading = new JLabel("WELCOME TO SKYSCRAPER!");
        Heading.setFont(new Font("Helvetica", Font.BOLD, 36));
        Heading.setForeground(new Color(5, 134, 196));
        Heading.setAlignmentX(0.5f);
        Heading.setAlignmentY(0.5f);
        panelHeader.add(Heading);
        panelHeader.setSize(this.getWidth(), 100);
        ct.add(panelHeader);

        JPanel[] centerPanels = new JPanel[7];

        try
        {
            File setUpFile = new File("SkyscaperSetUp.dat");
            Scanner scanner = new Scanner(setUpFile);

            int gridLength = Integer.parseInt(scanner.nextLine());

            for(int i = 0; i < gridLength + 2; i++)
            {
                centerPanels[i] = new JPanel();
                centerPanels[i].setLayout(new GridLayout(0, 7));
            }

            JPanel[][] theGrid = new JPanel[gridLength + 2][gridLength + 2];

            for (int i = 0; i < gridLength + 2; i++)
            {
                for (int j = 0; j < gridLength + 2; j++)
                {
                    theGrid[i][j] = new JPanel();
                    theGrid[i][j].setLayout(new FlowLayout());
                    centerPanels[i].add(theGrid[i][j]);
                }
                ct.add(centerPanels[i]);
            }

            buttons = new SkyscaperButtons[gridLength][gridLength];

            for(int i = 1; i < gridLength + 1; i++)
            {
                for (int j = 1; j < gridLength + 1; j++)
                {
                    theGrid[i][j].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    theGrid[i][j].setLayout(new GridLayout(1,1));
                    buttons[i-1][j-1] = new SkyscaperButtons();
                    buttons[i-1][j-1].setBackground(new Color(120, 120, 120));
                    buttons[i-1][j-1].setEnabled(true);
                    theGrid[i][j].add(buttons[i-1][j-1]);

                    buttons[i-1][j-1].setFont(new Font("Helvetica", Font.PLAIN, 40));
                    buttons[i-1][j-1].setForeground(new Color(0, 0, 0));
                    buttons[i-1][j-1].addActionListener(new ButtonToMenuListener(this, buttons[i-1][j-1], "S"));
                }
            }

            for(int i = 1; i < gridLength + 1; i++)
            {
                String add = "";

                if(scanner.hasNext())
                {
                    add = scanner.nextLine();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "The file doesn't contain enough values!");
                    System.exit(1);
                }

                JLabel addLabel = new JLabel(add);
                addLabel.setFont(new Font("Helvetica", Font.PLAIN, 40));
                addLabel.setForeground(new Color(0, 0, 0));
                addLabel.setAlignmentX(0.5f);
                addLabel.setAlignmentY(0.5f);
                theGrid[0][i].add(addLabel);
                theGrid[0][i].setBackground(new Color(63, 193, 231));
            }

            for(int i = 1; i < gridLength + 1; i++)
            {
                String add = "";

                if(scanner.hasNext())
                {
                    add = scanner.nextLine();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "The file doesn't contain enough values!");
                    System.exit(1);
                }

                JLabel addLabel = new JLabel(add);
                addLabel.setFont(new Font("Helvetica", Font.PLAIN, 40));
                addLabel.setForeground(new Color(0, 0, 0));
                addLabel.setAlignmentX(0.5f);
                addLabel.setAlignmentY(0.5f);
                theGrid[i][0].add(addLabel);
                theGrid[i][0].setBackground(new Color(63, 193, 231));
            }

            for(int i = 1; i < gridLength + 1; i++)
            {
                String add = "";

                if(scanner.hasNext())
                {
                    add = scanner.nextLine();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "The file doesn't contain enough values!");
                    System.exit(1);
                }

                JLabel addLabel = new JLabel(add);
                addLabel.setFont(new Font("Helvetica", Font.PLAIN, 40));
                addLabel.setForeground(new Color(0, 0, 0));
                addLabel.setAlignmentX(0.5f);
                addLabel.setAlignmentY(0.5f);
                theGrid[6][i].add(addLabel);
            }

            for(int i = 1; i < gridLength + 1; i++)
            {
                String add = "";

                if(scanner.hasNext())
                {
                    add = scanner.nextLine();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "The file doesn't contain enough values!");
                    System.exit(1);
                }

                JLabel addLabel = new JLabel(add);
                addLabel.setFont(new Font("Helvetica", Font.PLAIN, 40));
                addLabel.setForeground(new Color(0, 0, 0));
                addLabel.setAlignmentX(0.5f);
                addLabel.setAlignmentY(0.5f);
                theGrid[i][6].add(addLabel);
            }

            scanner.close();
        }
        catch (FileNotFoundException err)
        {
            System.out.println("An error occurred: The file wasn't found");
            err.printStackTrace();
        }


        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        ct.add(bottomPanel);

        JButton instructions = new JButton("Instructions");
        instructions.setBounds(150, 45, 70, 60);
        instructions.setEnabled(true);
        instructions.setForeground(new Color(5, 134, 196));
        bottomPanel.add(instructions);
        instructions.addActionListener(new ActionListener2(this, "S"));

        bottomPanel.add(Box.createHorizontalStrut(20));

        JButton checkPuzzle = new JButton("Check Answer");
        checkPuzzle.setBounds(150, 45, 70, 60);
        checkPuzzle.setEnabled(true);
        checkPuzzle.setForeground(new Color(5, 134, 196));
        bottomPanel.add(checkPuzzle);
        checkPuzzle.addActionListener(this);

        bottomPanel.add(Box.createHorizontalStrut(20));

        JButton solvePuzzle = new JButton("Show Solution");
        solvePuzzle.setBounds(150, 45, 70, 60);
        solvePuzzle.setEnabled(true);
        solvePuzzle.setForeground(new Color(5, 134, 196));
        bottomPanel.add(solvePuzzle);
        solvePuzzle.addActionListener(new SolveListener("S", mainFrame, this));

        bottomPanel.add(Box.createHorizontalStrut(20));

        JButton clearPuzzle = new JButton("Start Over");
        clearPuzzle.setBounds(150, 45, 70, 60);
        clearPuzzle.setEnabled(true);
        clearPuzzle.setForeground(new Color(5, 134, 196));
        bottomPanel.add(clearPuzzle);
        clearPuzzle.addActionListener(new ClearListener(buttons));

        bottomPanel.add(Box.createHorizontalStrut(20));

        JButton changePuzzle = new JButton("Different Puzzle");
        changePuzzle.setBounds(150, 45, 70, 60);
        changePuzzle.setEnabled(true);
        changePuzzle.setForeground(new Color(5, 134, 196));
        bottomPanel.add(changePuzzle);
        changePuzzle.addActionListener(new ActionListener3(this, mainFrame));

        bottomPanel.add(Box.createHorizontalStrut(20));

        JButton fileRead = new JButton("Fill from File");
        fileRead.setBounds(150, 45, 70, 60);
        fileRead.setEnabled(true);
        fileRead.setForeground(new Color(5, 134, 196));
        bottomPanel.add(fileRead);

        File theFile = new File("SkyscaperAttempt1.dat");
        fileRead.addActionListener(new FileAddListener(buttons, theFile, "S"));
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
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(!(buttons[i][j].getText().equals("1")||buttons[i][j].getText().equals("2")||buttons[i][j].getText().equals("3")||buttons[i][j].getText().equals("4")||buttons[i][j].getText().equals("5")))
                {
                    return false;
                }
            }
        }

        String[] repeatChecker = new String[5];

        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                repeatChecker[j] = "";
            }

            for(int j = 0; j < 5; j++)
            {
                repeatChecker[j] = buttons[i][j].getText();

                for(int k = 0; k < j; k++)
                {
                    if(repeatChecker[k].equals(buttons[i][j].getText()))
                    {
                        return false;
                    }
                }
            }
        }

        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                repeatChecker[j] = "";
            }

            for(int j = 0; j < 5; j++)
            {
                repeatChecker[j] = buttons[j][i].getText();

                for(int k = 0; k < j; k++)
                {
                    if(repeatChecker[k].equals(buttons[j][i].getText()))
                    {
                        return false;
                    }
                }
            }
        }

        int[][] values = new int[5][5];
        int[] leftRowCount = new int[5];

        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                values[i][j] = Integer.parseInt(buttons[i][j].getText());
            }
        }

        for(int i = 0; i < 5; i++)
        {
            leftRowCount[i] = 1;

            int j = 1;
            while(j < 5)
            {
                boolean checker = true;

                for(int k = 0; k < j; k++)
                {
                    if(values[i][j] < values[i][k])
                    {
                        checker = false;
                    }
                }

                if(checker)
                {
                    leftRowCount[i]++;
                }

                j++;
            }
        }

        if(leftRowCount[0] != 3)
        {
            return false;
        }
        if(leftRowCount[1] != 2)
        {
            return false;
        }
        if(leftRowCount[2] != 3)
        {
            return false;
        }
        if(leftRowCount[3] != 2)
        {
            return false;
        }
        if(leftRowCount[4] != 1)
        {
            return false;
        }

        int[] rightRowCount = new int[5];

        for(int i = 0; i < 5; i++)
        {
            rightRowCount[i] = 1;

            int j = 3;
            while(j >= 0)
            {
                boolean checker = true;

                for(int k = j+1; k < 5; k++)
                {
                    if(values[i][j] < values[i][k])
                    {
                        checker = false;
                    }
                }

                if(checker)
                {
                    rightRowCount[i]++;
                }

                j--;
            }
        }

        if(rightRowCount[0] != 3)
        {
            return false;
        }
        if(rightRowCount[1] != 4)
        {
            return false;
        }
        if(rightRowCount[2] != 1)
        {
            return false;
        }
        if(rightRowCount[3] != 2)
        {
            return false;
        }
        if(rightRowCount[4] != 2)
        {
            return false;
        }

        int[] upColumnCount = new int[5];

        for(int i = 0; i < 5; i++)
        {
            upColumnCount[i] = 1;

            int j = 1;
            while(j < 5)
            {
                boolean checker = true;

                for(int k = 0; k < j; k++)
                {
                    if(values[j][i] < values[k][i])
                    {
                        checker = false;
                    }
                }

                if(checker)
                {
                    upColumnCount[i]++;
                }

                j++;
            }
        }

        if(upColumnCount[0] != 4)
        {
            return false;
        }
        if(upColumnCount[1] != 2)
        {
            return false;
        }
        if(upColumnCount[2] != 1)
        {
            return false;
        }
        if(upColumnCount[3] != 2)
        {
            return false;
        }
        if(upColumnCount[4] != 3)
        {
            return false;
        }

        int[] downColumnCount = new int[5];

        for(int i = 0; i < 5; i++)
        {
            downColumnCount[i] = 1;

            int j = 3;
            while(j >= 0)
            {
                boolean checker = true;

                for(int k = j+1; k < 5; k++)
                {
                    if(values[j][i] < values[k][i])
                    {
                        checker = false;
                    }
                }

                if(checker)
                {
                    downColumnCount[i]++;
                }

                j--;
            }
        }

        if(downColumnCount[0] != 1)
        {
            return false;
        }
        if(downColumnCount[1] != 4)
        {
            return false;
        }
        if(downColumnCount[2] != 3)
        {
            return false;
        }
        if(downColumnCount[3] != 2)
        {
            return false;
        }
        if(downColumnCount[4] != 2)
        {
            return false;
        }

        return true;
    }

    public JButton[][] getGrid()
    {
        return buttons;
    }

    public String[] getPossibles()
    {
        String[] possibles = {"1", "2", "3", "4", "5"};
        return possibles;
    }

    public boolean checkConstraints(String value, int row, int column)
    {
        boolean rowRepeatCheck = false;
        boolean colRepeatCheck = false;
        boolean rowCheck = false;
        boolean colCheck = false;

        if(column == 4)
        {
            if (row == 0)
            {
                rowRepeatCheck = row1.constraintSatisfied(this.buttons);

                if(rowRepeatCheck)
                {
                    rowCheck = row01.constraintSatisfied(this.buttons);
                }
            }
            else if (row == 1)
            {
                rowRepeatCheck = row2.constraintSatisfied(this.buttons);

                if(rowRepeatCheck)
                {
                    rowCheck = row02.constraintSatisfied(this.buttons);
                }
            }
            else if (row == 2)
            {
                rowRepeatCheck = row3.constraintSatisfied(this.buttons);

                if(rowRepeatCheck)
                {
                    rowCheck = row03.constraintSatisfied(this.buttons);
                }
            }
            else if (row == 3)
            {
                rowRepeatCheck = row4.constraintSatisfied(this.buttons);

                if(rowRepeatCheck)
                {
                    rowCheck = row04.constraintSatisfied(this.buttons);
                }
            }
            else if (row == 4)
            {
                rowRepeatCheck = row5.constraintSatisfied(this.buttons);

                if(rowRepeatCheck)
                {
                    rowCheck = row05.constraintSatisfied(this.buttons);
                }
            }
        }

        if(row == 4)
        {
            if (column == 0)
            {
                colRepeatCheck = col1.constraintSatisfied(this.buttons);

                if(colRepeatCheck)
                {
                    colCheck = col01.constraintSatisfied(this.buttons);
                }
            }
            else if (column == 1)
            {
                colRepeatCheck = col2.constraintSatisfied(this.buttons);

                if(colRepeatCheck)
                {
                    colCheck = col02.constraintSatisfied(this.buttons);
                }
            }
            else if (column == 2)
            {
                colRepeatCheck = col3.constraintSatisfied(this.buttons);

                if(colRepeatCheck)
                {
                    colCheck = col03.constraintSatisfied(this.buttons);
                }
            }
            else if (column == 3)
            {
                colRepeatCheck = col4.constraintSatisfied(this.buttons);

                if(colRepeatCheck)
                {
                    colCheck = col04.constraintSatisfied(this.buttons);
                }
            }
            else if (column == 4)
            {
                colRepeatCheck = col5.constraintSatisfied(this.buttons);

                if(colRepeatCheck)
                {
                    colCheck = col05.constraintSatisfied(this.buttons);
                }
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
        SkyscaperButtons button = ((SkyscaperButtons)theButton);

        if(value.equals("1"))
        {
            button.setText(value);
        }
        else if(value.equals("2"))
        {
            button.setText(value);
        }
        else if(value.equals("3"))
        {
            button.setText(value);
        }
        else if(value.equals("4"))
        {
            button.setText(value);
        }
        else if(value.equals("5"))
        {
            button.setText(value);
        }
    }

    public void clearButton2(JButton theButton)
    {
        theButton.setText("");
    }
}
