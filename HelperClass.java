import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public final class HelperClass {
    public static void writeBigPixel(BufferedImage canvas, int x, int y, int color) {
        for (int i = x * 3; i < (x + 1) * 3; i++)
            for (int j = y * 3; j < (y + 1) * 3; j++)
                canvas.setRGB(i, j, color);
    }
}
