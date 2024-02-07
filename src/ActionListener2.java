import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListener2 implements ActionListener
{
    JFrame frameToClose;
    String type;

    public ActionListener2(JFrame frame, String type)
    {
        frameToClose = frame;
        this.type = type;
    }

    public void actionPerformed(ActionEvent e)
    {
        frameToClose.setVisible(false);

        if(type.equals("K"))
        {
            KakurasuInstructions frame = new KakurasuInstructions();
            frame.setUpFrame(frameToClose);
            frame.pack();
            frame.setVisible(true);
            frame.setSize(600, 600);
            frame.repaint();
        }
        else if (type.equals("S"))
        {
            SkyscaperInstructions frame = new SkyscaperInstructions();
            frame.setUpFrame(frameToClose);
            frame.pack();
            frame.setVisible(true);
            frame.setSize(600, 600);
            frame.repaint();
        }
        else if (type.equals("D"))
        {
            DosunFuwariInstructions frame = new DosunFuwariInstructions();
            frame.setUpFrame(frameToClose);
            frame.pack();
            frame.setVisible(true);
            frame.setSize(600, 600);
            frame.repaint();
        }
    }
}
