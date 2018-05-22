public class AnimatedObject {

    private char[/* y */][/* x */] world;

    private int numFrames;
    private int[/* state */][/* y */][/* x */] states;

    private int currentFrameNumber;
    private int[/* y */][/* x */] currentState;
    
    public AnimatedObject(int[][][] states) {
        this.states = states;
        numFrames = states.length;
        currentState = states[0];
    }

    public void nextFrame() {
        if (currentFrameNumber != numFrames - 1) {
            currentFrameNumber++;
        }
        else {
            currentFrameNumber = 0;
        }
        currentState = states[currentFrameNumber];
    }

    public String[] blit(String[] world, int x, int y) {
        this.world = new char[world.length][world[0].length()];
        for (int i = 0; i < world.length; i++) {
            String worldString = world[i];
            this.world[i] = worldString.toCharArray();
        }

        for (int i = y; i < y + currentState.length; i++) {
            for (int j = x; j < x + currentState[0].length; j++) {
                this.world[i][j] = currentState[i - y][j - x] == 1 ? 'X' : ' ';
            }
        }
        
        String[] blittedWorld = new String[world.length];
        for (int i = 0; i < world.length; i++) {
            blittedWorld[i] = new String(this.world[i]);
        }

        return blittedWorld;
    }

    public void setStates(int[][][] states) {
        this.states = states;
    }

    public void setNumFrames(int numFrames) {
        this.numFrames = numFrames;
    }
}
