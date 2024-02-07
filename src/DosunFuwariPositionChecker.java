import javax.swing.*;

public class DosunFuwariPositionChecker implements ConstraintsInterface
{
    private int[] rowCoordinates;
    private int[] columnCoordinates;

    public DosunFuwariPositionChecker(int[] rowCoordinates, int[] columnCoordinates)
    {
        this.rowCoordinates = rowCoordinates;
        this.columnCoordinates = columnCoordinates;
    }

    public boolean constraintSatisfied(JButton[][] buttons)
    {
        int min = 5;
        int max = -1;

        for(int i = 0; i < rowCoordinates.length; i++)
        {
            if(rowCoordinates[i] < min)
            {
                min = rowCoordinates[i];
            }

            if(rowCoordinates[i] > max)
            {
                max = rowCoordinates[i];
            }
        }


        for(int i = 0; i < rowCoordinates.length; i++)
        {
            if(((DosunFuwariButtons)buttons[rowCoordinates[i]][columnCoordinates[i]]).getType().equals("white"))
            {
                if(rowCoordinates[i] != min)
                {
                    return false;
                }
            }
            else if(((DosunFuwariButtons)buttons[rowCoordinates[i]][columnCoordinates[i]]).getType().equals("black"))
            {
                if(rowCoordinates[i] != max)
                {
                    return false;
                }
            }
        }

        return true;
    }
}
