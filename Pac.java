import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Pac extends AnimatedObject {
    /* fields */
    private boolean closing;
    /* constructor */
    public Pac(boolean[][] space) {
        super(new String[][] {{"0000111110000",
                               "0011111111100",
                               "0111111111110",
                               "0111111111110",
                               "1111111111111",
                               "1111111111111",
                               "1111111111111",
                               "1111111111111",
                               "1111111111111",
                               "0111111111110",
                               "0111111111110",
                               "0011111111100",
                               "0000111110000"},
                 
                              {"0000111110000",
                               "0011111111100",
                               "0111111111110",
                               "0111111111110",
                               "1111111111000",
                               "1111111000000",
                               "1111000000000",
                               "1111111000000",
                               "1111111111000",
                               "0111111111110",
                               "0111111111110",
                               "0011111111100",
                               "0000111110000"},
                 
                              {"0000111110000",
                               "0011111111100",
                               "0111111111110",
                               "0111111111110",
                               "1111110111111",
                               "1111110111111",
                               "1111110111111",
                               "1111100011111",
                               "1111100011111",
                               "0111100011110",
                               "0111000001110",
                               "0011000001100",
                               "0000000000000"},
                 
                              {"0000111110000",
                               "0011111111100",
                               "0111111111110",
                               "0111111111110",
                               "0001111111111",
                               "0000001111111",
                               "0000000001111",
                               "0000001111111",
                               "0001111111111",
                               "0111111111110",
                               "0111111111110",
                               "0011111111100",
                               "0000111110000"},
                 
                              {"0000000000000",
                               "0011000001100",
                               "0111000001110",
                               "0111100011110",
                               "1111100011111",
                               "1111100011111",
                               "1111110111111",
                               "1111110111111",
                               "1111110111111",
                               "0111111111110",
                               "0111111111110",
                               "0011111111100",
                               "0000111110000"},

                              {"0000111110000",
                               "0011111110000",
                               "0111111100000",
                               "0111111000000",
                               "1111110000000",
                               "1111100000000",
                               "1111000000000",
                               "1111100000000",
                               "1111110000000",
                               "0111111000000",
                               "0111111100000",
                               "0011111110000",
                               "0000111110000"},

                              {"0000111110000",
                               "0011111111100",
                               "0111111111110",
                               "0111111111110",
                               "1111110111111",
                               "1111100011111",
                               "1111000001111",
                               "1110000000111",
                               "1100000000011",
                               "0000000000000",
                               "0000000000000",
                               "0000000000000",
                               "0000000000000"},
                               
                              {"0000111110000",
                               "0000111111100",
                               "0000011111110",
                               "0000001111110",
                               "0000000111111",
                               "0000000011111",
                               "0000000001111",
                               "0000000011111",
                               "0000000111111",
                               "0000001111110",
                               "0000011111110",
                               "0000111111100",
                               "0000111110000"},

                              {"0000000000000",
                               "0000000000000",
                               "0000000000000",
                               "0000000000000",
                               "1100000000011",
                               "1110000000111",
                               "1111000001111",
                               "1111100011111",
                               "1111110111111",
                               "0111111111110",
                               "0111111111110",
                               "0011111111100",
                               "0000111110000"}}, space);
        closing = false;
        centerx = 6;
        centery = 6;
    }
    
    /* methods */
    public void nextFrame() {
        if (currentFrameNumber != 0 && closing == true) {
            currentFrameNumber = 0;
        }
        else if (currentFrameNumber == 0) {
            closing = false;
	        if (velocity[0] > velocity[1]) {
	    		if (velocity[0] == 1) {
	    			currentFrameNumber = 1;
	    		}
	    		else {
	    			currentFrameNumber = 4;
	    		}
	    	}
	    	if (velocity[1] > velocity[0]) {
	    		if (velocity[1] == 1) {
	    			currentFrameNumber = 2;
	    		}
	    		else {
	    			currentFrameNumber = 3;
	    		}
	    	}
        }
        else if (currentFrameNumber > 4) {
            closing = true;
	        if (velocity[0] > velocity[1]) {
	    		if (velocity[0] == 1) {
	    			currentFrameNumber = 1;
	    		}
	    		else {
	    			currentFrameNumber = 4;
	    		}
	    	}
	    	if (velocity[1] > velocity[0]) {
	    		if (velocity[1] == 1) {
	    			currentFrameNumber = 2;
	    		}
	    		else {
	    			currentFrameNumber = 3;
	    		}
	    	}
        }
        else {
	        if (velocity[0] > velocity[1]) {
	    		if (velocity[0] == 1) {
	    			currentFrameNumber = 5;
	    		}
	    		else {
	    			currentFrameNumber = 8;
	    		}
	    	}
	    	if (velocity[1] > velocity[0]) {
	    		if (velocity[1] == 1) {
	    			currentFrameNumber = 6;
	    		}
	    		else {
	    			currentFrameNumber = 7;
	    		}
	    	}
        }
        currentState = states[currentFrameNumber];
    }
    
    public int getStartX() {
    	return 4;
    }
    
    public int getStartY() {
    	return 28;
    }
    
    public int[] getStartVelocity() {
    	return new int[] {1, 0};
    }
    
    public void getNewVelocity() {
    	
    }

    public void getNewVelocity(char characterInput) {
    	if (characterInput == 'w')
    		velocity = new int[] {0, -1};
    	if (characterInput == 'a')
    		velocity = new int[] {-1, 0};
    	if (characterInput == 's')
    		velocity = new int[] {0, 1};
    	if (characterInput == 'd')
    		velocity = new int[] {1, 0};
    }
}
