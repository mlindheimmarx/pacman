import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Melon extends StationaryObject {
    /* constructor */
    public Melon(int x, int y) {
        super(new String[] {"00700000000",
                            "00077777000",
                            "00000700000",
                            "00004340000",
                            "00444744400",
                            "04737444740",
                            "04474437440",
                            "43744474744",
                            "47443744374",
                            "43744474444",
                            "04473737440",
                            "04447444740",
                            "00474447400",
                            "00004470000"}, x, y);
    }
}
