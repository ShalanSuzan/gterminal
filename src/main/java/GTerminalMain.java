import lombok.extern.log4j.Log4j;
import org.apache.log4j.BasicConfigurator;
import ui.GFrame;

import javax.swing.*;

import static lombok.Lombok.checkNotNull;

@Log4j
public class GTerminalMain {

    public static void main(String [] args){
        BasicConfigurator.configure();
        Runnable starter = () -> checkNotNull(new GFrame(),
                "Unexpected error been occurred. Unable to start gTerminal application.");
        SwingUtilities.invokeLater(starter);
    }
}
