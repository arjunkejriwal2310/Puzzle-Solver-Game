import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListener3 implements ActionListener
{
    JFrame frameToClose;
    JFrame frameToOpen;

    public ActionListener3(JFrame frame1, JFrame frame2)
    {
        frameToClose = frame1;
        frameToOpen = frame2;
    }

    public void actionPerformed(ActionEvent e)
    {
        frameToClose.setVisible(false);
        frameToOpen.setVisible(true);
    }
}
