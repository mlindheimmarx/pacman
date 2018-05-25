import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public abstract class AnimatedObject {
    /* fields */
    protected int x;
    protected int y;
    

    private BufferedImage world;

    protected int numFrames;
    protected int[/* state */][/* y */][/* x */] states;

    protected int currentFrameNumber;
    protected int[/* y */][/* x */] currentState;
    
    protected int[] velocity;
    
    /* constructor */
    public AnimatedObject(int[][][] states) {
    	this.states = states;
        numFrames = states.length;
        currentState = states[0];
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
    public BufferedImage blit(BufferedImage world) {
   	    Color[] colorList = new Color[] {Color.WHITE, Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE};
		this.world = world;

        for (int i = y; i < y + currentState.length; i++) {
            for (int j = x; j < x + currentState[0].length; j++) {
            	int test = currentState[i - y][j - x];
            	this.world.setRGB(i, j, colorList[test].getRGB());
            }
        }

        return this.world;
    }
    
    public void update() {
    	x += velocity[0];
    	y += velocity[1];
    }
    
    public void stop() {
    	velocity = new int[] {0, 0};
    }
}
