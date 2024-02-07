import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileAddListener implements ActionListener
{
    private JButton[][] buttons;
    File theFile;
    private String type;

    public FileAddListener(JButton[][] buttons, File theFile, String type)
    {
        this.buttons = buttons;
        this.theFile = theFile;
        this.type = type;
    }

    public void actionPerformed(ActionEvent e)
    {
        if(type.equals("S"))
        {
            try
            {
                Scanner theReader = new Scanner(theFile);
                for (int i = 0; i < 5; i++)
                {
                    for (int j = 0; j < 5; j++)
                    {
                        if(theReader.hasNext())
                        {
                            String data = theReader.nextLine();
                            if(data.equals("1") || data.equals("2") || data.equals("3") || data.equals("4") || data.equals("5"))
                            {
                                buttons[i][j].setText(data);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "The file contains inappropriate values!");
                                System.exit(1);
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "The file doesn't contain enough values!");
                            System.exit(1);
                        }
                    }
                }
                theReader.close();
            }
            catch (FileNotFoundException err)
            {
                System.out.println("An error occurred: The file wasn't found");
                err.printStackTrace();
            }
        }
        else if(type.equals("K"))
        {
            try
            {
                Scanner theReader = new Scanner(theFile);
                for (int i = 0; i < 5; i++)
                {
                    for (int j = 0; j < 5; j++)
                    {
                        if(theReader.hasNext())
                        {
                            String data = theReader.nextLine();
                            if(data.equals("press"))
                            {
                                KakurasuButtons button = ((KakurasuButtons) buttons[i][j]);
                                button.setPressed(true);
                                button.setText("Pressed");
                                button.setBackground(Color.red);
                            }
                            else if(data.equals("do not press"))
                            {
                                KakurasuButtons button = ((KakurasuButtons) buttons[i][j]);
                                button.setPressed(false);
                                button.setText("");
                                button.setBackground(new Color(86, 125, 147));
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "The file contains inappropriate values!");
                                System.exit(1);
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "The file doesn't contain enough values!");
                            System.exit(1);
                        }
                    }
                }
                theReader.close();
            }
            catch (FileNotFoundException err)
            {
                System.out.println("An error occurred: The file wasn't found");
                err.printStackTrace();
            }
        }
        else if(type.equals("D"))
        {
            try
            {
                Scanner theReader = new Scanner(theFile);
                for (int i = 0; i < 4; i++)
                {
                    for (int j = 0; j < 4; j++)
                    {
                        if(theReader.hasNext())
                        {
                            String data = theReader.nextLine();
                            if((i == 1 && j == 1) || (i == 3 && j == 3))
                            {
                                DosunFuwariButtons button = ((DosunFuwariButtons) buttons[i][j]);
                                button.clearButton();
                            }
                            else if(data.equals("white"))
                            {
                                DosunFuwariButtons button = ((DosunFuwariButtons) buttons[i][j]);
                                button.whiteCircle();
                            }
                            else if(data.equals("black"))
                            {
                                DosunFuwariButtons button = ((DosunFuwariButtons) buttons[i][j]);
                                button.blackCircle();
                            }
                            else if(data.equals("clear"))
                            {
                                DosunFuwariButtons button = ((DosunFuwariButtons) buttons[i][j]);
                                button.clearButton();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "The file contains inappropriate values!");
                                System.exit(1);
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "The file doesn't contain enough values!");
                            System.exit(1);
                        }
                    }
                }
                theReader.close();
            }
            catch (FileNotFoundException err)
            {
                System.out.println("An error occurred: The file wasn't found");
                err.printStackTrace();
            }
        }
    }
}
