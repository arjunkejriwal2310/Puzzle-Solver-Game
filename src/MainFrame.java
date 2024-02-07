import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainFrame extends JFrame
{

    public void setUpFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        this.setContentPane(mainPanel);
        mainPanel.setLayout(new GridLayout(3, 0));
        Border orangeLine = BorderFactory.createLineBorder(Color.orange, 2);
        mainPanel.setBorder(orangeLine);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JLabel Heading = new JLabel("WELCOME TO THE OCEAN OF PUZZLES!");
        Heading.setFont(new Font("Helvetica", Font.PLAIN, 18));
        Heading.setForeground(new Color(0, 255, 255));
        panel1.setBackground(Color.black);
        Heading.setAlignmentX(0.5f);
        Heading.setAlignmentY(0.5f);
        panel1.add(Heading);
        mainPanel.add(panel1);

        panel1.add(Box.createVerticalStrut(70));

        JLabel SubHeading = new JLabel("Which puzzle do you wish to try?");
        SubHeading.setFont(new Font("Helvetica", Font.PLAIN, 16));
        SubHeading.setForeground(new Color(150, 82, 245));
        Heading.setAlignmentX(0.5f);
        panel1.add(SubHeading);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel2.setBackground(Color.black);

        JButton game1 = new JButton("Kakurasu");
        game1.setBounds(25, 25, 10, 5);
        game1.setForeground(Color.red);
        panel2.add(game1);
        game1.addActionListener(new ActionListener1(this, "K"));

        panel2.add(Box.createHorizontalStrut(30));

        JButton game2 = new JButton("Skyscraper");
        game2.setBounds(25, 25, 10, 5);
        game2.setForeground(new Color(5, 134, 196));
        panel2.add(game2);
        game2.addActionListener(new ActionListener1(this, "S"));

        panel2.add(Box.createHorizontalStrut(30));

        JButton game3 = new JButton("Dosun-Fuwari");
        game3.setBounds(25, 25, 10, 5);
        game3.setForeground(new Color(46, 196, 11));
        panel2.add(game3);
        game3.addActionListener(new ActionListener1(this, "D"));

        mainPanel.add(panel2);

        DesignPanel panel3 = new DesignPanel();
        panel3.setBackground(Color.BLACK);
        mainPanel.add(panel3);
    }
}
