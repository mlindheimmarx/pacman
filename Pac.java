import java.util.Scanner;

public class Pac extends AnimatedObject {
    /* constructor */
    public Pac() {
        super(new int[][][] {{{0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                              {0, 0, 1, 1, 1, 1, 1, 1, 0, 0}},
                
                             {{0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                              {1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                              {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                              {1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                              {0, 0, 1, 1, 1, 1, 1, 1, 0, 0}},
                
                             {{0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                              {0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                              {0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                              {0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                              {0, 0, 1, 1, 1, 1, 1, 1, 0, 0}},
                
                             {{0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                              {1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
                              {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},
                
                             {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                              {1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                              {0, 0, 1, 1, 1, 1, 1, 1, 0, 0}}});
    }
    
    /* methods */
    public void nextFrame() {
        if (currentFrameNumber != 0) {
            currentFrameNumber = 0;
        }
        else {
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
	    			currentFrameNumber = 3;
	    		}
	    		else {
	    			currentFrameNumber = 2;
	    		}
	    	}
        }
        currentState = states[currentFrameNumber];
    }
    
    public int getStartX() {
    	return 0;
    }
    
    public int getStartY() {
    	return 0;
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

