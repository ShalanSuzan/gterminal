package ui;

import javax.swing.*;
import java.awt.*;

public class GFrame extends JFrame {

    public GFrame() {
        super("HomeAssignment");
        init();
    }

    private void init() {
        //Custom the frame
        setDefaultLookAndFeelDecorated(true);
        setMinimumSize(new Dimension(400, 400));
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        //Create panel and add the JComponents
        JPanel panel = new JPanel( new GridBagLayout());
        final JButton greenBtn = new JButton("Grön");
        panel.add(greenBtn, gridBagConstraints(0, 0, 5, 3, GridBagConstraints.WEST), 0);

        final JButton redBtn = new JButton("Röd");
        panel.add(redBtn, gridBagConstraints(1,0, 3, 10, GridBagConstraints.WEST), 1);
        panel.setAlignmentX(0);

        final String [] colors = {"Grön", "Röd"};
        JComboBox comboBox = new JComboBox(colors);
        comboBox.setSelectedItem(colors[0]);

        panel.add(comboBox, gridBagConstraints(0, 1,5, 10, GridBagConstraints.WEST), 2);
        CirclePanel circlePanel = new CirclePanel();
        panel.add(circlePanel, gridBagConstraints(1, 1,0, 0, GridBagConstraints.NORTHWEST));

        add(panel, gridBagConstraints(0, 0,0, 0, GridBagConstraints.NORTHWEST));
        pack();
        setVisible(true);
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
