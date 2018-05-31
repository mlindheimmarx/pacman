import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class MazeThinWallHorizontalMedium extends StationaryObject {
    /* constructor */
    public MazeThinWallHorizontalMedium(int x, int y) {
        super(new String[] {"DDDDDDDDDDD",
        					"00000000000",
        					"00000000000",
                            "DDDDDDDDDDD"}, x, y);
    }
}
