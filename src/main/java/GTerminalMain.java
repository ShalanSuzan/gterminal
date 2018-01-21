import ui.GFrame;

import javax.swing.*;

public class GTerminalMain {

    public static void main(String [] args){
        Runnable starter = new Runnable()
        {
            public void run(){
                new GFrame();
            }
        };

        SwingUtilities.invokeLater(starter);
    }
}
