import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class MazeThinCornerDownLeft extends StationaryObject {
    /* constructor */
    public MazeThinCornerDownLeft(int x, int y) {
        super(new String[] {"D000D",
        					"0D000",
        					"0D000",
        					"00DD0",
                            "0000D"}, x, y);
    }
}