import javax.swing.*;

public abstract class PuzzleFrame extends JFrame
{
    public abstract void setUpFrame(JFrame frame);

    public abstract JButton[][] getGrid();

    public abstract String[] getPossibles();

    public abstract boolean checkConstraints(String value, int row, int column);

    public abstract boolean checkAnswer();

    public abstract boolean isPreLabeled(JButton theButton);

    public abstract void setValue(JButton theButton, String value);

    public abstract void clearButton2(JButton theButton);

    public boolean label (JButton[][] theGrid, String[] possibleValues, int row, int column)
    {
        if(row == theGrid.length)
        {
            return this.checkAnswer();
        }

        if(isPreLabeled(theGrid[row][column]))
        {
            column = column + 1;

            if(column == theGrid[row].length)
            {
                column = 0;
                row = row + 1;
                if(row == theGrid.length)
                {
                    return this.checkAnswer();
                }
            }
        }

        for(String value : possibleValues)
        {
            this.setValue(theGrid[row][column],value);
            boolean check = this.checkConstraints(value, row, column);

            if(check)
            {
                int newColumn = column + 1;
                int newRow = row;

                if(newColumn == theGrid[row].length)
                {
                    newColumn = 0;
                    newRow = row + 1;
                }

                if(label(theGrid, possibleValues, newRow, newColumn))
                {
                    return true;
                }
            }
        }

        this.clearButton2(theGrid[row][column]);
        return false;
    }
}
