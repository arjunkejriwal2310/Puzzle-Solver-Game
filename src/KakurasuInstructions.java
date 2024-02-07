import javax.swing.*;
import java.awt.*;

public class KakurasuInstructions extends JFrame
{
    public JFrame previousFrame;

    public void setUpFrame(JFrame frame)
    {
        this.previousFrame = frame;
        this.setTitle("Instructions for Kakurasu Game");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container ct = this.getContentPane();
        ct.setLayout(new GridLayout(5, 0));

        ct.add(Box.createVerticalStrut(10));

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());
        JLabel text1 = new JLabel("Instructions for Kakurasu");
        text1.setFont(new Font("Helvetica", Font.BOLD, 24));
        text1.setForeground(Color.red);
        text1.setAlignmentX(0.5f);
        text1.setAlignmentY(0.5f);
        top.add(text1);
        ct.add(top);


        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout());

        JLabel text2 = new JLabel("• Squares are either marked or not marked.");
        bottom.add(text2);
        bottom.add(Box.createVerticalStrut(5));

        JLabel text3 = new JLabel("• The clues are on the right and across the bottom and are the totals");
        bottom.add(text3);
        bottom.add(Box.createVerticalStrut(5));

        JLabel text35 = new JLabel("for the respective rows and columns.");
        bottom.add(text35);
        bottom.add(Box.createVerticalStrut(5));

        JLabel text4 = new JLabel("• The numbers across the top and on the left are the values for each of the squares");
        bottom.add(text4);
        bottom.add(Box.createVerticalStrut(5));

        JLabel text5 = new JLabel("• Marking a square will add that square's value to both the row's total and the column's\n" +
                "total. ");
        bottom.add(text5);
        bottom.add(Box.createVerticalStrut(5));

        ct.add(bottom);



        JPanel bottommost = new JPanel();
        bottommost.setLayout(new FlowLayout());

        JButton back = new JButton("Back");
        back.setForeground(Color.red);
        back.setAlignmentX(0.5f);
        back.setAlignmentY(0.5f);

        ct.add(bottommost);
        bottom.add(Box.createVerticalStrut(20));
        bottommost.add(back);

        back.addActionListener(new ActionListener3(this, previousFrame));
    }
}
