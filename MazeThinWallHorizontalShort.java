import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class MazeThinWallHorizontalShort extends StationaryObject {
    /* constructor */
    public MazeThinWallHorizontalShort(int x, int y) {
        super(new String[] {"DDDDDD",
        					"000000",
        					"000000",
                            "DDDDDD"}, x, y);
    }
}
