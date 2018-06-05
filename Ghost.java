import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Ghost extends AnimatedObject {
    /* fields */
    private int startX;
    private int startY;
    private int pacx;
    private int pacy;
    private int numFrames;
    private boolean evenFrame;
    
    /* constructor */
        public Ghost(Color c, int x, int y, boolean[][] availableSpace) {
        super(new String[][] {{"00000888800000",
                               "00088888888000",
                               "00888888888800",
                               "08887788887780",
                               "08877778877770",
                               "08877668877660",
                               "88877668877668",
                               "88887788887788",
                               "88888888888888",
                               "88888888888888",
                               "88888888888888",
                               "88880888808888",
                               "08800088000880"},

                              {"00000888800000",
                               "00088888888000",
                               "00888888888800",
                               "08888888888880",
                               "08778888778880",
                               "07777887777880",
                               "86677886677888",
                               "86677886677888",
                               "88778888778888",
                               "88888888888888",
                               "88888888888888",
                               "88880888808888",
                               "08800088000880"},

                              {"00000888800000",
                               "00088888888000",
                               "00888888888800",
                               "08888888888880",
                               "08877888877880",
                               "08777788777780",
                               "88777788777788",
                               "88766788766788",
                               "88866888866888",
                               "88888888888888",
                               "88888888888888",
                               "88880888808888",
                               "08800088000880"},

                              {"00000888800000",
                               "00066888866000",
                               "00766788766700",
                               "08777788777780",
                               "08777788777780",
                               "08877888877880",
                               "88888888888888",
                               "88888888888888",
                               "88888888888888",
                               "88888888888888",
                               "88888888888888",
                               "88880888808888",
                               "08800088000880"},
                               
                              {"00000888800000",
                               "00088888888000",
                               "00888888888800",
                               "08887788887780",
                               "08877778877770",
                               "08877668877660",
                               "88877668877668",
                               "88887788887788",
                               "88888888888888",
                               "88888888888888",
                               "88888888888888",
                               "88088800888088",
                               "80008800880008"},

                              {"00000888800000",
                               "00088888888000",
                               "00888888888800",
                               "08888888888880",
                               "08778888778880",
                               "07777887777880",
                               "86677886677888",
                               "86677886677888",
                               "88778888778888",
                               "88888888888888",
                               "88888888888888",
                               "88088800888088",
                               "80008800880008"},

                              {"00000888800000",
                               "00088888888000",
                               "00888888888800",
                               "08888888888880",
                               "08877888877880",
                               "08777788777780",
                               "88777788777788",
                               "88766788766788",
                               "88866888866888",
                               "88888888888888",
                               "88888888888888",
                               "88088800888088",
                               "80008800880008"},

                              {"00000888800000",
                               "00066888866000",
                               "00766788766700",
                               "08777788777780",
                               "08777788777780",
                               "08877888877880",
                               "88888888888888",
                               "88888888888888",
                               "88888888888888",
                               "88888888888888",
                               "88888888888888",
                               "88088800888088",
                               "80008800880008"}}, availableSpace);
        evenFrame = false;
        ghostColor = c;
        this.x = x;
        this.y = y;
        centerx = 6;
        centery = 6;
        numFrames = 0;
    }
    
    /* methods */
    public void nextFrame() {
    	if (velocity[0] > velocity[1]) {
    		if (velocity[0] == 1) {
    			currentFrameNumber = 0;
    		}
    		else {
    			currentFrameNumber = 3;
    		}
    	}
    	if (velocity[1] > velocity[0]) {
    		if (velocity[1] == 1) {
    			currentFrameNumber = 2;
    		}
    		else {
    			currentFrameNumber = 1;
    		}
    	}
        if (evenFrame) {
            currentFrameNumber += 4;
        }
        evenFrame = !evenFrame;
    	currentState = states[currentFrameNumber];
    }
    
    public void nextLocation() {
    	x += velocity[0];
        y += velocity[1];
    } 

    public int getStartX() {
    	return startX;
    }
    
    public int getStartY() {
    	return startY;
    }
    
    public int getX() {
    	return x;
    }
    
    public int getY() {
    	return y;
    }
    
    public int[] getStartVelocity() {
    	return new int[] {1, 0};
    }
    
    public void getNewVelocity() {
        if (numFrames == 0) {
            int testVar = (int) (4 * Math.random());
            numFrames = (int) (30 * Math.random()) + 1;
            if (testVar == 0)
                velocity = new int[] {1, 0};
            if (testVar == 1)
                velocity = new int[] {-1, 0};
            if (testVar == 2)
                velocity = new int[] {0, 1};
            if (testVar == 3)
                velocity = new int[] {0, -1};
        }
        numFrames--;
    }

    public void setPacLocation(int pacx, int pacy) {
        this.pacx = pacx;
        this.pacy = pacy;
    }
}

