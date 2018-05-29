import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Cherries extends StationaryObject {
    /* constructor */
    public Cherries(int x, int y) {
        super(new String[] {"000000000022",
                            "000000002222",
                            "000000220200",
                            "000002000200",
                            "011120002000",
                            "111211020000",
                            "111110121100",
                            "131101121110",
                            "113101111110",
                            "011101311110",
                            "000001131110",
                            "000000111100"}, x, y);
    }
}
