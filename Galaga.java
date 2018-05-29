import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Galaga extends StationaryObject {
    /* constructor */
    public Galaga(int x, int y) {
        super(new String[] {"00000100000",
                            "80001110008",
                            "80011111008",
                            "89119191198",
                            "89999199998",
                            "88999999988",
                            "08890909880",
                            "00880908800",
                            "00080908000",
                            "00000900000",
                            "00000900000"}, x, y);
    }
}
