import javax.swing.*;
import java.awt.*;

public class DesignPanel extends JPanel
{
    private Color[] cs = {Color.blue, Color.green, Color.red, Color.yellow};

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        int x = 0;
        int y = 0;
        int size = 45;
        int number = 15;

        for (int i=0; i<number; i++)
        {
            g.setColor(cs[i%4]);

            x = 190 + size + (int) (size*Math.sin((i)*Math.PI*2.0/number));
            y = size + (int) (size*Math.cos((i)*Math.PI*2.0/number));

            g.fillOval(x,y,10,10);
        }

        g.setColor(Color.CYAN);
        g.fillRoundRect(53, 20, 80, 80, 5, 5);
        g.setColor(Color.CYAN);
        g.fillRoundRect(347, 20, 80, 80, 5, 5);
    }
}
