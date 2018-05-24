public abstract class AnimatedObject {
    /* fields */
    protected int x;
    protected int y;
    

    private char[/* y */][/* x */] world;

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
    public String[] blit(String[] world) {
   	    char[] charlist = new char[] {' ', 'X', '*', '.', '`'};
        this.world = new char[world.length][world[0].length()];
        for (int i = 0; i < world.length; i++) {
            String worldString = world[i];
            this.world[i] = worldString.toCharArray();
        }

        for (int i = y; i < y + currentState.length; i++) {
            for (int j = x; j < x + currentState[0].length; j++) {
            	int test = currentState[i - y][j - x];
            	this.world[i][j] = charlist[test];
            }
        }
        
        String[] blittedWorld = new String[world.length];
        for (int i = 0; i < world.length; i++) {
            blittedWorld[i] = new String(this.world[i]);
        }

        return blittedWorld;
    }
    
    public void update() {
    	x += velocity[0];
    	y += velocity[1];
    }
    
    public void reverseUpdate() {
    	x -= velocity[0];
    	y -= velocity[1];
    }
    
    public void stop() {
    	velocity = new int[] {0, 0};
    }
}
