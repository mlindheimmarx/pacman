import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class MazeThickCornerDownRight extends StationaryObject {
    /* constructor */
    public MazeThickCornerDownRight(int x, int y) {
        super(new String[] {"000D",
        					"000D",
        					"00D0",
        					"DD00"}, x, y);
    }
}