//YOU WILL NEED TO RUN THIS CLASS TO PLAY THE PUZZLE GAME!

//Name: Arjun Kejriwal
//Class: 2024

import java.awt.*;

public class MainFrameRun
{
    public static void main (String[] args)
    {
        try
        {
            javax.swing.UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
        }
        catch(Exception e) {}

        MainFrame frame = new MainFrame();
        frame.setUpFrame();

        frame.pack();
        frame.setVisible(true);
        frame.setSize(500,400);
        frame.setTitle("COSC-112 Final Project");
        frame.repaint();
    }
}
