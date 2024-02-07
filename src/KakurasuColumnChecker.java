import javax.swing.*;

public class KakurasuColumnChecker implements ConstraintsInterface
{
    private int colSum;
    private int colNumber;
    private int currentColValue;

    public KakurasuColumnChecker(int colSum, int colNumber)
    {
        this.colSum = colSum;
        this.colNumber = colNumber;
        currentColValue = 0;
    }

    public boolean constraintSatisfied(JButton[][] buttons)
    {
        int sumOfCol = 0;

        for(int i = 0; i < 5; i++)
        {
            if(((KakurasuButtons)buttons[i][colNumber]).getPressed())
            {
                sumOfCol = sumOfCol + (i+1);
            }
        }

        if(sumOfCol == colSum)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
