import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class MazeThinCornerUpLeft extends StationaryObject {
    /* constructor */
    public MazeThinCornerUpLeft(int x, int y) {
        super(new String[] {"0000D",
        					"00DD0",
        					"0D000",
        					"0D000",
                            "D000D"}, x, y);
    }
}