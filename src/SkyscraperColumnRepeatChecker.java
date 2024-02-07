import javax.swing.*;

public class SkyscraperColumnRepeatChecker implements ConstraintsInterface
{
    int colNumber;

    public SkyscraperColumnRepeatChecker(int column)
    {
        colNumber = column;
    }

    public boolean constraintSatisfied(JButton[][] buttons)
    {
        String[] repeatChecker = new String[5];

        for(int i = 0; i < 5; i++)
        {
            repeatChecker[i] = "";

            repeatChecker[i] = buttons[i][colNumber].getText();

            for(int k = 0; k < i; k++)
            {
                if(repeatChecker[k].equals(buttons[i][colNumber].getText()))
                {
                    return false;
                }
            }
        }

        return true;
    }
}
