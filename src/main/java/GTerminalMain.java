import org.apache.log4j.BasicConfigurator;
import ui.GFrame;

import javax.swing.*;

import static lombok.Lombok.checkNotNull;

public class GTerminalMain {

    public static void main(String [] args){
        BasicConfigurator.configure();
        Runnable starter = () -> checkNotNull(new GFrame(),
                "Unexpected error been occurred. Unable to start gTerminal application.");
        SwingUtilities.invokeLater(starter);
    }
}
