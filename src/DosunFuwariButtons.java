import javax.swing.*;
import java.awt.*;

public class DosunFuwariButtons extends JButton
{
    private String type = "";
    private JFrame theFrame;
    int row;
    int column;


    public DosunFuwariButtons(JFrame frame, int r, int c)
    {
        theFrame = frame;
        row = r;
        column = c;
    }

    public int getRow()
    {
        return row;
    }

    public int getColumn()
    {
        return column;
    }

    public void whiteCircle()
    {
        type = "white";
        theFrame.repaint();
    }

    public void blackCircle()
    {
        type = "black";
        theFrame.repaint();
    }

    public void clearButton()
    {
        type = "";
        theFrame.repaint();
    }

    public String getType()
    {
        return type;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        if(type.equals("black"))
        {
            g.setColor(Color.black);
            g.fillOval(14, 17, 65, 65);
        }
        else if (type.equals("white"))
        {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.white);
            g2d.fillOval(14, 17, 65, 65);
            g2d.setColor(Color.black);
            g2d.setStroke(new BasicStroke(2.0f));
            g2d.drawOval(14, 17, 65, 65);
        }
    }
}
