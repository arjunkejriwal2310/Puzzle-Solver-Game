import javax.swing.*;

public class SkyscraperRowChecker implements ConstraintsInterface
{
    int rowNumber;
    int leftRowValue;
    int rightRowValue;

    public SkyscraperRowChecker(int leftRowValue, int rightRowValue, int rowNumber)
    {
        this.leftRowValue = leftRowValue;
        this.rightRowValue = rightRowValue;
        this.rowNumber = rowNumber;
    }

    public boolean constraintSatisfied(JButton[][] buttons)
    {
        int[] values = new int[5];
        int leftRowCount = 1;

        for(int i = 0; i < 5; i++)
        {
            values[i] = Integer.parseInt(buttons[rowNumber][i].getText());
        }

        int j = 1;

        while(j < 5)
        {
            boolean checker = true;

            for(int k = 0; k < j; k++)
            {
                if(values[j] < values[k])
                {
                    checker = false;
                }
            }

            if(checker)
            {
                leftRowCount++;
            }

            j++;
        }

        if(leftRowCount != leftRowValue)
        {
            return false;
        }

        int rightRowCount = 1;

        int i = 3;

        while(i >= 0)
        {
            boolean checker = true;

            for (int k = i + 1; k < 5; k++)
            {
                if (values[i] < values[k])
                {
                    checker = false;
                }
            }

            if (checker)
            {
                rightRowCount++;
            }

            i--;
        }

        if(rightRowCount != rightRowValue)
        {
            return false;
        }

        return true;
    }
}
