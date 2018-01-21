package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CirclePanel extends JPanel {

    CirclePanel(){
        setPreferredSize(new Dimension(33, 33));
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        //Draw eclipse edges
        Ellipse2D ellipse2D = new Ellipse2D.Double();
        ellipse2D.setFrame(10, 5, 20, 20);
        g2.draw(ellipse2D);

        //Fill upp the eclipse with blue white gradient paint
        GradientPaint blueWhite = new GradientPaint(13,7, Color.white,12, 13, new Color(153, 179, 255));
        g2.setPaint(blueWhite);
        g2.fillOval(10, 5, 20, 20);
    }
}
