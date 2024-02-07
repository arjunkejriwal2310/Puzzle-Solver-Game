import javax.swing.*;

public class KakurasuRowChecker implements ConstraintsInterface
{
    private int rowSum;
    private int rowNumber;

    public KakurasuRowChecker(int rowSum, int rowNumber)
    {
        this.rowSum = rowSum;
        this.rowNumber = rowNumber;
    }

    public boolean constraintSatisfied(JButton[][] buttons)
    {
        int sumOfRow = 0;

        for(int i = 0; i < 5; i++)
        {
            if(((KakurasuButtons)buttons[rowNumber][i]).getPressed())
            {
                sumOfRow = sumOfRow + (i+1);
            }
        }

        if(sumOfRow == rowSum)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
