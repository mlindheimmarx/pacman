import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public abstract class AnimatedObject {
    /* fields */
    protected int x;
    protected int y;

    protected int centerx;
    protected int centery;

    protected int prevx;
    protected int prevy;

    protected Color ghostColor;
    

    private BufferedImage world;

    protected int numFrames;
    protected int[/* frame */][/* y */][/* x */] states;

    protected int currentFrameNumber;
    protected int[/* y */][/* x */] currentState;
    
    protected int[] velocity;

    protected boolean[][] availableSpace;
    
    /* constructors */
    public AnimatedObject(String[][] states) {
    	int[][][] intStates = new int[states.length][states[0].length][states[0][0].length()];
        for (int i = 0; i < states.length; i++) {
            for (int j = 0; j < states[0].length; j++) {
                char[] charString = states[i][j].toCharArray();
                int[] temp = new int[charString.length];
                for (int k = 0; k < charString.length; k++) {
                    temp[k] = Character.getNumericValue(charString[k]);
                }
                intStates[i][j] = temp;
            }
        }
        this.states = intStates;
        numFrames = states.length;
        currentState = this.states[0];
        x = getStartX();
        y = getStartY();
        velocity = getStartVelocity();
    }

    public AnimatedObject(String[][] states, boolean[][] availableSpace) {
    	int[][][] intStates = new int[states.length][states[0].length][states[0][0].length()];
        for (int i = 0; i < states.length; i++) {
            for (int j = 0; j < states[0].length; j++) {
                char[] charString = states[i][j].toCharArray();
                int[] temp = new int[charString.length];
                for (int k = 0; k < charString.length; k++) {
                    temp[k] = Character.getNumericValue(charString[k]);
                }
                intStates[i][j] = temp;
            }
        }
        this.states = intStates;
        this.availableSpace = availableSpace;
        numFrames = states.length;
        currentState = this.states[0];
        x = getStartX();
        y = getStartY();
        velocity = getStartVelocity();
    }

    /* abstract methods */
    abstract public void nextFrame();
    
    abstract public int getStartX();
    
    abstract public int getStartY();
    
    abstract public int[] getStartVelocity();
    
    abstract public void getNewVelocity();

    /* methods */
    public void blit(BufferedImage world) {
   	    Color[] colorList = new Color[] {Color.decode("#FFFF00"), Color.decode("#FF0000"), Color.BLUE, Color.GREEN, Color.ORANGE, Color.decode("#2121FF"), Color.decode("#E0DDFF"), ghostColor, Color.decode("#FAB9B0")};

        for (int i = y; i < y + currentState.length; i++) {
            for (int j = x; j < x + currentState[0].length; j++) {
            	int test = currentState[i - y][j - x];
                if (test != 0) {
                    HelperClass.writeBigPixel(world, j, i, colorList[test - 1].getRGB());
                }
                else {
                    HelperClass.writeBigPixel(world, j, i, HelperClass.getBigPixelColor(world, j, i));
                }
            }
        }
    }
    
    public void update() {
        prevx = x;
        prevy = y;
    	x += velocity[0];
    	y += velocity[1];
        if (!availableSpace[x][y - 24]) {
            antiUpdate();
            stop();
        }
    }

    public void antiUpdate() {
        x = prevx;
        y = prevy;
    }
    
    public void stop() {
    	velocity = new int[] {0, 0};
    }
}
