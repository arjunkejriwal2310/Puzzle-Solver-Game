import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItemListener implements ActionListener
{
    private JFrame theFrame;
    private SkyscaperButtons theButton;
    private DosunFuwariButtons theButton2;
    private String value;
    private String type;

    public MenuItemListener (JFrame frame, JButton theButton, String value, String type)
    {
        theFrame = frame;
        this.value = value;
        this.type = type;

        if(type.equals("S"))
        {
            this.theButton = (SkyscaperButtons)theButton;
        }
        else if(type.equals("D"))
        {
            this.theButton2 = (DosunFuwariButtons)theButton;
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        if(type.equals("S"))
        {
            theButton.setText(value);
        }
        else if(type.equals("D"))
        {
            String action = e.getActionCommand();
            if(action.equals("White Circle"))
            {
                theButton2.whiteCircle();
            }
            else if(action.equals("Black Circle"))
            {
                theButton2.blackCircle();
            }
            else if(action.equals("Clear"))
            {
                theButton2.clearButton();
            }
        }
    }
}
