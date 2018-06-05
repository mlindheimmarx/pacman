import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Dot extends StationaryObject {
    /* constructor */
    public Dot(int x, int y) {
        super(new String[] {"CC",
                            "CC"}, x, y);
    }

    /* methods */
    public void testRemove(int pacx, int pacy, Pac pac) {
        if (x - pacx <= 12 && x - pacx >= 0 && y - pacy <= 12 && y - pacy >= 0)
            remove(pac);
    }
}
