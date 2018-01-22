package ui;

import lombok.Getter;

import java.awt.*;

public enum GColor {

    BLUE (new Color(153, 179, 255)),
    GREEN (new Color(127,255,0)),
    RED (new Color(220,20,60));

    @Getter private Color color;

    GColor(Color color) {
        this.color = color;
    }
}
