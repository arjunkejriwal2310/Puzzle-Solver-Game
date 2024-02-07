import javax.swing.*;
import java.awt.*;

public class DosunFuwariInstructions extends JFrame
{
    public JFrame previousFrame;

    public void setUpFrame(JFrame frame)
    {
        this.previousFrame = frame;
        this.setTitle("Instructions for Dosun-Fuwari Game");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container ct = this.getContentPane();
        ct.setLayout(new GridLayout(4, 0));

        ct.add(Box.createVerticalStrut(10));

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());
        JLabel text1 = new JLabel("Instructions for Dosun-Fuwari");
        text1.setFont(new Font("Helvetica", Font.BOLD, 24));
        text1.setForeground(new Color(46, 196, 11));
        text1.setAlignmentX(0.5f);
        text1.setAlignmentY(0.5f);
        top.add(text1);
        ct.add(top);


        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout());

        JLabel text2 = new JLabel("Place balloons (white circles) and iron balls (black circles) according to the following rules: ");
        bottom.add(text2);
        bottom.add(Box.createVerticalStrut(5));

        JLabel text3 = new JLabel("• Place one balloon and one iron ball in each of the areas surrounded by bold lines.");
        bottom.add(text3);
        bottom.add(Box.createVerticalStrut(5));

        JLabel text35 = new JLabel("• Balloons are light and float, so they must be placed in one of the cells at the top, ");
        bottom.add(text35);
        bottom.add(Box.createVerticalStrut(5));

        JLabel text4 = new JLabel("or in a cell right under a black cell (filled-in cell) or under other balloons.");
        bottom.add(text4);
        bottom.add(Box.createVerticalStrut(5));

        JLabel text5 = new JLabel("• Iron balls are heavy and sink, so they must be placed in one of the cells at the");
        bottom.add(text5);
        bottom.add(Box.createVerticalStrut(5));

        JLabel text6 = new JLabel("bottom, or in a cell right over a black cell or over other iron balls.");
        bottom.add(text6);
        bottom.add(Box.createVerticalStrut(5));

        ct.add(bottom);


        JPanel bottommost = new JPanel();
        bottommost.setLayout(new FlowLayout());

        JButton back = new JButton("Back");
        back.setForeground(new Color(46, 196, 11));
        back.setAlignmentX(0.5f);
        back.setAlignmentY(0.5f);

        ct.add(bottommost);
        bottom.add(Box.createVerticalStrut(20));
        bottommost.add(back);

        back.addActionListener(new ActionListener3(this, previousFrame));
    }
}
