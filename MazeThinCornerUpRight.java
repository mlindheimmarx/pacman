import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class MazeThinCornerUpRight extends StationaryObject {
    /* constructor */
    public MazeThinCornerUpRight(int x, int y) {
        super(new String[] {"D0000",
        					"0DD00",
        					"000D0",
        					"000D0",
                            "D000D"}, x, y);
    }
}