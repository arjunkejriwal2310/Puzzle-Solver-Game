import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolveListener implements ActionListener
{
    private String type;
    private JFrame mainFrame;
    private JFrame frameToClose;

    public SolveListener(String type, JFrame frame, JFrame frameToClose)
    {
        this.type = type;
        mainFrame = frame;
        this.frameToClose = frameToClose;
    }

    public void actionPerformed(ActionEvent e)
    {
        if (type.equals("D"))
        {
            PuzzleFrame theGame = new DosunFuwariFrame();
            DosunFuwariFrame frame = (DosunFuwariFrame) theGame;
            frame.setUpFrame(mainFrame);
            frame.pack();
            frame.setSize(400, 600);
            frame.repaint();


            JButton[][] theGrid = theGame.getGrid();
            String[] possibleValues = theGame.getPossibles();

            boolean result = theGame.label(theGrid, possibleValues, 0, 0);

            if (result)
            {
                frameToClose.setVisible(false);
                frame.setVisible(true);
                JOptionPane.showMessageDialog(null, "Here is the computer-generated solution!");
            }
            else
            {
                frame.setVisible(false);
                JOptionPane.showMessageDialog(null, "No solution is possible!");
            }
        }
        else if (type.equals("S"))
        {
            PuzzleFrame theGame = new SkyscaperFrame();
            SkyscaperFrame frame = (SkyscaperFrame) theGame;
            frame.setUpFrame(mainFrame);
            frame.pack();
            frame.setSize(700, 800);
            frame.repaint();


            JButton[][] theGrid = theGame.getGrid();
            String[] possibleValues = theGame.getPossibles();

            boolean result = theGame.label(theGrid, possibleValues, 0, 0);

            if (result)
            {
                frameToClose.setVisible(false);
                frame.setVisible(true);
                JOptionPane.showMessageDialog(null, "Here is the computer-generated solution!");
            }
            else
            {
                frame.setVisible(false);
                JOptionPane.showMessageDialog(null, "No solution is possible!");
            }
        }
        else if (type.equals("K"))
        {
            PuzzleFrame theGame = new KakurasuFrame();
            KakurasuFrame frame = (KakurasuFrame) theGame;
            frame.setUpFrame(mainFrame);
            frame.pack();
            frame.setSize(700, 800);
            frame.repaint();


            JButton[][] theGrid = theGame.getGrid();
            String[] possibleValues = theGame.getPossibles();

            boolean result = theGame.label(theGrid, possibleValues, 0, 0);

            if (result)
            {
                frameToClose.setVisible(false);
                frame.setVisible(true);
                JOptionPane.showMessageDialog(null, "Here is the computer-generated solution!");
            }
            else
            {
                frame.setVisible(false);
                JOptionPane.showMessageDialog(null, "No solution is possible!");
            }
        }
    }
}
