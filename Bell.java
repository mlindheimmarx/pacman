import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Bell extends StationaryObject {
    /* constructor */
    public Bell(int x, int y) {
        super(new String[] {"000009900000",
                            "000990099000",
                            "009999999900",
                            "009909999900",
                            "009099999900",
                            "099099999990",
                            "099099999990",
                            "099999999990",
                            "990999999999",
                            "990999999999",
                            "999999999999",
                            "9AAAAA33AAA9",
                            "0AAAAA33AAA0"}, x, y);
    }
}
