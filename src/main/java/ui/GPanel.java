package ui;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * GPanel is responsible to draw and update the gColor of
 * the graphical shape (in this case sphere).
 */
@Log4j
public class GPanel extends JPanel {
    @Setter public GColor gColor = GColor.BLUE;

    GPanel(){
        setPreferredSize(new Dimension(33, 33));
    }

    @Override
    public void paint(Graphics g){
        paintComponent(g);
        log.debug(String.format("Repaint the graph. The current color is %s.", gColor.name()));
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;

        //Draw eclipse edges
        Ellipse2D ellipse2D = new Ellipse2D.Double();
        ellipse2D.setFrame(10, 5, 20, 20);
        g2.draw(ellipse2D);

        //Fill upp the eclipse with blue white gradient paint
        GradientPaint blueWhite = new GradientPaint(13,7, Color.white,12, 13, gColor.getColor());
        g2.setPaint(blueWhite);
        g2.fillOval(10, 5, 20, 20);
    }
}
