import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class MazeThinWallHorizontal extends StationaryObject {
    /* constructor */
    public MazeThinWallHorizontal(int x, int y) {
        super(new String[] {"DDDDDDDDDDDDDDDD",
        					"0000000000000000",
        					"0000000000000000",
                            "DDDDDDDDDDDDDDDD"}, x, y);
    }
}
