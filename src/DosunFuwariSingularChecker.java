import javax.swing.*;

public class DosunFuwariSingularChecker implements ConstraintsInterface
{
    private int[] rowCoordinates;
    private int[] columnCoordinates;

    public DosunFuwariSingularChecker(int[] rowCoordinates, int[] columnCoordinates)
    {
        this.rowCoordinates = rowCoordinates;
        this.columnCoordinates = columnCoordinates;
    }

    public boolean constraintSatisfied(JButton[][] buttons)
    {
        int white = 0;
        int black = 0;

        for(int i = 0; i < rowCoordinates.length; i++)
        {
            if(((DosunFuwariButtons)buttons[rowCoordinates[i]][columnCoordinates[i]]).getType().equals("white"))
            {
                white++;
            }
            else if(((DosunFuwariButtons)buttons[rowCoordinates[i]][columnCoordinates[i]]).getType().equals("black"))
            {
                black++;
            }
        }

        if(!((white == 1) && (black == 1)))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
