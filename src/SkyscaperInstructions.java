import javax.swing.*;
import java.awt.*;

public class SkyscaperInstructions extends JFrame
{
    public JFrame previousFrame;

    public void setUpFrame(JFrame frame)
    {
        this.previousFrame = frame;
        this.setTitle("Instructions for Skyscaper Game");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container ct = this.getContentPane();
        ct.setLayout(new GridLayout(3, 0));

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());
        JLabel text1 = new JLabel("Instructions for Skyscaper");
        text1.setFont(new Font("Helvetica", Font.BOLD, 24));
        text1.setForeground(new Color(5, 134, 196));
        text1.setAlignmentX(0.5f);
        text1.setAlignmentY(0.5f);
        top.add(text1);
        ct.add(top);


        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout());

        JLabel text2 = new JLabel("• In a skyscraper puzzle, you have to fill each square with an integer from");
        bottom.add(text2);
        bottom.add(Box.createVerticalStrut(5));

        JLabel text3 = new JLabel("1 to N where N is the size of the puzzle (the size of the grid).");
        bottom.add(text3);
        bottom.add(Box.createVerticalStrut(5));

        JLabel text35 = new JLabel("• Each and every square has to contain a number.");
        bottom.add(text35);
        bottom.add(Box.createVerticalStrut(5));

        JLabel text4 = new JLabel("• Every row and column contains the numbers 1 to N.");
        bottom.add(text4);
        bottom.add(Box.createVerticalStrut(5));

        JLabel text5 = new JLabel("No number may appear twice in any row or column.");
        bottom.add(text5);
        bottom.add(Box.createVerticalStrut(5));

        JLabel text6 = new JLabel("• The clues around the grid tell you how many skyscrapers you can see.");
        bottom.add(text6);
        bottom.add(Box.createVerticalStrut(5));

        JLabel text7 = new JLabel("They indicate the number of buildings which you would see from that direction.");
        bottom.add(text7);
        bottom.add(Box.createVerticalStrut(5));

        JLabel text8 = new JLabel("• You can't see a shorter skyscraper behind a taller one.");
        bottom.add(text8);
        bottom.add(Box.createVerticalStrut(5));

        ct.add(bottom);

        JPanel bottommost = new JPanel();
        bottommost.setLayout(new FlowLayout());

        JButton back = new JButton("Back");
        back.setForeground(new Color(5, 134, 196));
        back.setAlignmentX(0.5f);
        back.setAlignmentY(0.5f);

        ct.add(bottommost);
        bottom.add(Box.createVerticalStrut(20));
        bottommost.add(back);

        back.addActionListener(new ActionListener3(this, previousFrame));
    }
}
