public abstract class AnimatedObject {
    /* fields */
    private int x;
    private int y;

    private char[/* y */][/* x */] world;

    private int numFrames;
    private int[/* state */][/* y */][/* x */] states;

    private int currentFrameNumber;
    private int[/* y */][/* x */] currentState;
    
    /* constructor */
    public AnimatedObject(int[][][] states) {
        this.states = states;
        numFrames = states.length;
        currentState = states[0];
    }

    /* abstract methods */
    abstract public void nextFrame();
    
    abstract public void nextLocation();

    /* methods */
    public String[] blit(String[] world) {
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
}
