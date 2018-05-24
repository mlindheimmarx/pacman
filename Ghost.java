public class Ghost extends AnimatedObject {
    /* constructor */
    public Ghost() {
        super(new int[][][] {{{0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                              {1, 1, 0, 2, 1, 1, 0, 2, 1, 1},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                              {1, 0, 1, 0, 1, 1, 0, 1, 0, 1}},
                
                             {{0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                              {1, 1, 2, 0, 1, 1, 2, 0, 1, 1},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                              {1, 0, 1, 0, 1, 1, 0, 1, 0, 1}},
                
                             {{0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                              {1, 1, 3, 3, 1, 1, 3, 3, 1, 1},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                              {1, 0, 1, 0, 1, 1, 0, 1, 0, 1}},
                
                             {{0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                              {1, 1, 4, 4, 1, 1, 4, 4, 1, 1},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                              {1, 0, 1, 0, 1, 1, 0, 1, 0, 1}}});
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
    	currentState = states[currentFrameNumber];
    }
    
    public void nextLocation() {
    	
    } 
    
    public int getStartX() {
    	return 0;
    }
    
    public int getStartY() {
    	return 6;
    }
    
    public int[] getStartVelocity() {
    	return new int[] {1, 0};
    }
    
    public void getNewVelocity() {
    	if (velocity[0] == 1 && velocity[1] == 0)
    		velocity = new int[] {0, 1};
    	else if (velocity[0] == 0 && velocity[1] == 1)
    		velocity = new int[] {-1, 0};
    	else if (velocity[0] == -1 && velocity[1] == 0)
    		velocity = new int[] {0, -1};
    	else
    		velocity = new int[] {1, 0};
    }
}