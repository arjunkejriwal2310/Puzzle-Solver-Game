import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonToMenuListener implements ActionListener
{
    private JFrame theFrame;
    private SkyscaperButtons theButton;
    private DosunFuwariButtons theButton2;
    private String type;
    JPopupMenu menu;

    public ButtonToMenuListener(JFrame frame, JButton button, String type)
    {
        theFrame = frame;
        menu = new JPopupMenu("Menu");
        this.type = type;

        if(type.equals("S"))
        {
            theButton = (SkyscaperButtons)button;
            JMenuItem one = new JMenuItem("1");
            JMenuItem two = new JMenuItem("2");
            JMenuItem three = new JMenuItem("3");
            JMenuItem four = new JMenuItem("4");
            JMenuItem five = new JMenuItem("5");
            menu.add(one);
            menu.add(two);
            menu.add(three);
            menu.add(four);
            menu.add(five);
            one.addActionListener(new MenuItemListener(theFrame, theButton, "1", "S"));
            two.addActionListener(new MenuItemListener(theFrame, theButton, "2", "S"));
            three.addActionListener(new MenuItemListener(theFrame, theButton, "3", "S"));
            four.addActionListener(new MenuItemListener(theFrame, theButton, "4", "S"));
            five.addActionListener(new MenuItemListener(theFrame, theButton, "5", "S"));
        }
        else if (type.equals("D"))
        {
            theButton2 = (DosunFuwariButtons)button;
            JMenuItem clear = new JMenuItem("Clear");
            JMenuItem white = new JMenuItem("White Circle");
            JMenuItem black = new JMenuItem("Black Circle");
            menu.add(clear);
            menu.add(white);
            menu.add(black);
            clear.addActionListener(new MenuItemListener(theFrame, theButton2, "clear", "D"));
            white.addActionListener(new MenuItemListener(theFrame, theButton2, "white", "D"));
            black.addActionListener(new MenuItemListener(theFrame, theButton2, "black", "D"));
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        if(type.equals("S"))
        {
            menu.show(theButton, theButton.getWidth() / 2, theButton.getHeight() / 2);
        }
        else if(type.equals("D"))
        {
            menu.show(theButton2, theButton2.getWidth() / 2, theButton2.getHeight() / 2);
        }
    }
}
