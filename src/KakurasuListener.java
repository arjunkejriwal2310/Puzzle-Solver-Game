import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KakurasuListener implements ActionListener
{
    KakurasuButtons theButton;

    public KakurasuListener(KakurasuButtons theButton)
    {
        this.theButton = theButton;
    }

    public void actionPerformed(ActionEvent e)
    {
        if(!theButton.getPressed())
        {
            theButton.setPressed(true);
            theButton.setText("Pressed");
            theButton.setBackground(Color.red);
        }
        else
        {
            theButton.setPressed(false);
            theButton.setText("");
            theButton.setBackground(new Color(86, 125, 147));
        }
    }
}
