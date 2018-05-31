import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class MazeThinCornerDownRight extends StationaryObject {
    /* constructor */
    public MazeThinCornerDownRight(int x, int y) {
        super(new String[] {"D000D",
        					"000D0",
        					"000D0",
        					"0DD00",
                            "D0000"}, x, y);
    }
}