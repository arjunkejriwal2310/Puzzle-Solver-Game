import javax.swing.*;

public class SkyscraperRowRepeatChecker implements ConstraintsInterface
{
    int rowNumber;

    public SkyscraperRowRepeatChecker(int row)
    {
        rowNumber = row;
    }

    public boolean constraintSatisfied(JButton[][] buttons)
    {
        String[] repeatChecker = new String[5];

        for(int i = 0; i < 5; i++)
        {
            repeatChecker[i] = "";

            repeatChecker[i] = buttons[rowNumber][i].getText();

            for(int k = 0; k < i; k++)
            {
                if(repeatChecker[k].equals(buttons[rowNumber][i].getText()))
                {
                    return false;
                }
            }
        }

        return true;
    }
}
