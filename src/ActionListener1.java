import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListener1 implements ActionListener
{
    JFrame frameToClose;
    String type;

    public ActionListener1(JFrame frame, String type)
    {
        frameToClose = frame;
        this.type = type;
    }

    public void actionPerformed(ActionEvent e)
    {
        frameToClose.setVisible(false);

        if (type.equals("K"))
        {
            KakurasuFrame frame = new KakurasuFrame();
            frame.setUpFrame(frameToClose);
            frame.pack();
            frame.setVisible(true);
            frame.setSize(700,800);
            frame.repaint();
        }
        else if (type.equals("S"))
        {
            SkyscaperFrame frame = new SkyscaperFrame();
            frame.setUpFrame(frameToClose);
            frame.pack();
            frame.setVisible(true);
            frame.setSize(700,800);
            frame.repaint();
        }
        else if (type.equals("D"))
        {
            DosunFuwariFrame frame = new DosunFuwariFrame();
            frame.setUpFrame(frameToClose);
            frame.pack();
            frame.setVisible(true);
            frame.setSize(400,600);
            frame.repaint();
        }
    }

}
