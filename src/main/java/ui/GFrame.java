package ui;

import lombok.extern.log4j.Log4j;

import javax.swing.*;
import java.awt.*;

/**
 * GFrame class is responsible to create the swing components of the main window.
 */
@Log4j
public class GFrame extends JFrame {
    private JPanel panel;
    private GPanel circlePanel;
    private JButton greenBtn, redBtn;
    private JComboBox <String> comboBox;

    public GFrame() {
        super("HomeAssignment");
        init();
        initComponents();
    }

    private void init() {
        //Custom the frame
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(350, 250));
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
    }

    private void initComponents() {
        //init swing components
        circlePanel = new GPanel();
        panel = new JPanel( new GridBagLayout());
        greenBtn = new JButton("Grön");
        redBtn = new JButton("Röd");
        String [] colors = {"Grön", "Röd"};
        comboBox = new JComboBox<>();
        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(colors));
        comboBox.setSelectedItem(colors[0]);


        //give name to the swing components
        greenBtn.setName("MyGreen");
        redBtn.setName("MyRed");
        comboBox.setName("MyCombo");

        //add action listeners
        greenBtn.addActionListener(event -> {
            log.debug(String.format("The %s button is been selected.", greenBtn.getName()));
            changeColorTo(GColor.GREEN);
        });

        redBtn.addActionListener(actionEvent -> {
            log.debug(String.format("The %s button is been selected.", redBtn.getName()));
            changeColorTo(GColor.RED);
        });

        comboBox.addActionListener(actionEvent -> alterColor(comboBox.getSelectedItem() != null ? (String)comboBox.getSelectedItem() : "error"));

        //attach the components to the panel
        panel.add(greenBtn, gridBagConstraints(0, 0, 5, 3, GridBagConstraints.WEST), 0);
        panel.add(redBtn, gridBagConstraints(1,0, 3, 10, GridBagConstraints.WEST), 1);
        panel.add(comboBox, gridBagConstraints(0, 1,5, 10, GridBagConstraints.WEST), 2);
        panel.add(circlePanel, gridBagConstraints(1, 1,0, 0, GridBagConstraints.NORTHWEST));

        //attach the panel to the frame
        add(panel, gridBagConstraints(0, 0,0, 0, GridBagConstraints.NORTHWEST));
        pack();
        setVisible(true);
    }

    private void alterColor(String colorsStr) {
        switch (colorsStr){
            case "Grön":
                changeColorTo(GColor.GREEN);
                break;
            case "Röd":
                changeColorTo(GColor.RED);
                break;
            default:
                log.warn(String.format("Undefined color. Found %s.", colorsStr));
                changeColorTo(GColor.BLUE);
                break;
        }
        log.debug(String.format("%s color is selected via %s comboBox.", colorsStr, comboBox.getName()));
    }

    private void changeColorTo(GColor color) {
        circlePanel.setGColor(color);
        circlePanel.repaint();
    }

    private GridBagConstraints gridBagConstraints(int xPos, int yPos, int left, int right, int anchor) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = xPos;
        constraints.gridy = yPos;
        constraints.anchor = anchor;
        constraints.insets = new Insets(3, left, 3, right);
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        return constraints;
    }
}
