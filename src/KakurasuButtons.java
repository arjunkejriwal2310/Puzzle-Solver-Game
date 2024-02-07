import javax.swing.*;

public class KakurasuButtons extends JButton
{
    private boolean isPressed;

    public KakurasuButtons()
    {
        isPressed = false;
    }

    public boolean getPressed()
    {
        return isPressed;
    }

    public void setPressed(boolean set)
    {
        isPressed = set;
    }
}
