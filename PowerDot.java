import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class PowerDot extends AnimatedObject {
    int startx;
    int starty;
    /* constructor */
    public PowerDot(int x, int y) {
        super(new String[][] {{"00999900",
                               "09999990",
                               "99999999",
                               "99999999",
                               "99999999",
                               "99999999",
                               "09999990",
                               "00999900"},

                              {"00000000",
                               "00000000",
                               "00000000",
                               "00000000",
                               "00000000",
                               "00000000",
                               "00000000",
                               "00000000"}});
        this.x = x;
        this.y = y;
        centerx = 3;
        centery = 3;
    }
    
    /* methods */
    public void nextFrame() {
        if (currentFrameNumber != 0) {
            currentFrameNumber = 0;
        }
        else {
            currentFrameNumber = 1;
        }
        currentState = states[currentFrameNumber];
    }
    
    public int getStartX() {
    	return startx;
    }
    
    public int getStartY() {
    	return starty;
    }
    
    public int[] getStartVelocity() {
    	return new int[] {0, 0};
    }
    
    public void getNewVelocity() {
    	
    }
}
