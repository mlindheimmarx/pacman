import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public final class HelperClass {
    public static void writeBigPixel(BufferedImage canvas, int x, int y, int color) {
        for (int i = x * 3; i < (x + 1) * 3; i++)
            for (int j = y * 3; j < (y + 1) * 3; j++)
                canvas.setRGB(i, j, color);
    }
    public static int getBigPixelColor(BufferedImage canvas, int x, int y) {
        return canvas.getRGB(x * 3, y * 3);
    }
    public static boolean[][] fill(boolean[][] space, int x, int y, int endx, int endy) {
        for (int i = x; i <= endx; i++) {
            for (int j = y; j <= endy; j++) {
                space[i][j] = true;
            }
        }
        return space;
    }
}
