import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class MazeThickCornerUpLeft extends StationaryObject {
    /* constructor */
    public MazeThickCornerUpLeft(int x, int y) {
        super(new String[] {"00DD",
        					"0D00",
        					"D000",
        					"D000"}, x, y);
    }
}