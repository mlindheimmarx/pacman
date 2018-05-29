import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Key extends StationaryObject {
    /* constructor */
    public Key(int x, int y) {
        super(new String[] {"00BBB00",
                            "BB000BB",
                            "BBBBBBB",
                            "BBBBBBB",
                            "BBBBBBB",
                            "0030300",
                            "0030330",
                            "0030300",
                            "0030000",
                            "0030300",
                            "0030330",
                            "0030300",
                            "0003000"}, x, y);
    }
}
