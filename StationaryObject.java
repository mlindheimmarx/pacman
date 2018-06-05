import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class StationaryObject {
    /* fields */
    protected int x;
    protected int y;

    private boolean stopRendering;

    private BufferedImage world;

    protected int[/* y */][/* x */] sprite;
    
    /* constructor */
    public StationaryObject(String[] stringSprite, int x, int y) {
    	int[][] sprite = new int[stringSprite.length][stringSprite[0].length()];
        for (int i = 0; i < stringSprite.length; i++) {
            char[] charString = stringSprite[i].toCharArray();
            int[] temp = new int[charString.length];
            for (int j = 0; j < stringSprite[0].length(); j++) {
                if (Character.isDigit(charString[j]))
                    temp[j] = Character.getNumericValue(charString[j]);
                else if (charString[j] == 'A')
                    temp[j] = 10;
                else if (charString[j] == 'B')
                    temp[j] = 11;
                else if (charString[j] == 'C')
                    temp[j] = 12;
                else if (charString[j] == 'D')
                    temp[j] = 13;
                else
                    temp[j] = 14;
            }
            sprite[i] = temp;
        }
        this.sprite = sprite;
        this.x = x;
        this.y = y;
        stopRendering = false;
    }

    /* methods */
    public void blit(BufferedImage world) {
        if (!stopRendering) {
            Color[] colorList = new Color[] {Color.decode("#FF0000"), Color.decode("#DE9751"), Color.decode("#E0DDFF"), Color.decode("#00FF00"), Color.decode("#DF9851"), Color.decode("#FFB951"), Color.decode("#47B9AE"), Color.decode("#2121FF"), Color.decode("#FFFF00"), Color.decode("#47b8ff"), Color.decode("#47B9FF"), Color.decode("#FAB9B0"), Color.decode("#2121DE"), Color.decode("#FCB5FF")};

            for (int i = y; i < y + sprite.length; i++) {
                for (int j = x; j < x + sprite[0].length; j++) {
                    int test = sprite[i - y][j - x];
                    if (test != 0)
                        HelperClass.writeBigPixel(world, j, i, colorList[test - 1].getRGB());
                }
            }
        }
    }

    public void remove() {
        stopRendering = true;
    }
}
