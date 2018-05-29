import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Apple extends StationaryObject {
    /* constructor */
    public Apple(int x, int y) {
        super(new String[] {"000000200000",
                            "011102011100",
                            "111112111110",
                            "111111111111",
                            "111111111111",
                            "111111111111",
                            "111111111311",
                            "111111111311",
                            "011111113110",
                            "011111111110",
                            "001111111100",
                            "000110111000"}, x, y);
    }
}
