import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearListener implements ActionListener
{
    private JButton[][] buttons;

    public ClearListener(JButton[][] buttons)
    {
        this.buttons = buttons;
    }

    public void actionPerformed(ActionEvent e)
    {
        for(int i = 0; i < buttons.length; i++)
        {
            for(int j = 0; j < buttons[i].length; j++)
            {
                buttons[i][j].setText("");
            }
        }
    }
}
