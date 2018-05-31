import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class MazeGhostDoor extends StationaryObject {
    /* constructor */
    public MazeGhostDoor(int x, int y) {
        super(new String[] {"EEEEEEEEEEEEEEEE",
                            "EEEEEEEEEEEEEEEE"}, x, y);
    }
}
