import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Strawberry extends StationaryObject {
    /* constructor */
    public Strawberry(int x, int y) {
        super(new String[] {"00000300000",
                            "00444344400",
                            "01144444110",
                            "11111411131",
                            "13111113111",
                            "11131311111",
                            "11111111311",
                            "01311311110",
                            "01111111110",
                            "00113113000",
                            "00011111000",
                            "00000100000"}, x, y);
    }
}
