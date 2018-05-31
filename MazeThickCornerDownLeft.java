import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class MazeThickCornerDownLeft extends StationaryObject {
    /* constructor */
    public MazeThickCornerDownLeft(int x, int y) {
        super(new String[] {"D000",
        					"D000",
        					"0D00",
        					"00DD"}, x, y);
    }
}