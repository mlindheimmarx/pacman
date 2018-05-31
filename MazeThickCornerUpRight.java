import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class MazeThickCornerUpRight extends StationaryObject {
    /* constructor */
    public MazeThickCornerUpRight(int x, int y) {
        super(new String[] {"DD00",
        					"00D0",
        					"000D",
        					"000D"}, x, y);
    }
}