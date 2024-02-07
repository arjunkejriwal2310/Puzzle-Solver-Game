import javax.swing.*;

public class SkyscraperColumnChecker implements ConstraintsInterface
{
    int colNumber;
    int upColValue;
    int downColValue;

    public SkyscraperColumnChecker(int upColValue, int downColValue, int colNumber)
    {
        this.upColValue = upColValue;
        this.downColValue = downColValue;
        this.colNumber = colNumber;
    }

    public boolean constraintSatisfied(JButton[][] buttons)
    {
        int[] values = new int[5];
        int upColumnCount = 1;

        for(int i = 0; i < 5; i++)
        {
            values[i] = Integer.parseInt(buttons[i][colNumber].getText());
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
                upColumnCount++;
            }

            j++;
        }

        if(upColumnCount != upColValue)
        {
            return false;
        }

        int downColumnCount = 1;

        int i = 3;
        while(i >= 0)
        {
            boolean checker = true;

            for(int k = i+1; k < 5; k++)
            {
                if(values[i] < values[k])
                {
                    checker = false;
                }
            }

            if(checker)
            {
                downColumnCount++;
            }

            i--;
        }

        if(downColumnCount != downColValue)
        {
            return false;
        }

        return true;
    }
}
