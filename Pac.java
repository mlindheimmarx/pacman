public class Pac extends AnimatedObject {
    /* constructor */
    public Pac() {
        super(new int[][][] {{{0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                              {0, 0, 1, 1, 1, 1, 1, 1, 0, 0}},
                
                             {{0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                              {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                              {0, 0, 1, 1, 1, 1, 1, 1, 0, 0}}});
    }
    
    /* methods */
    public void nextFrame() {
        if (currentFrameNumber != numFrames - 1) {
            currentFrameNumber++;
        }
        else {
            currentFrameNumber = 0;
        }
        currentState = states[currentFrameNumber];
    } 
}
