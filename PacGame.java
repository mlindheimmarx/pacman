import java.util.concurrent.TimeUnit;
import java.util.ArrayList;


public class PacGame {
    static ArrayList<AnimatedObject> animatedObjects;
    
    public static void main(String[] args) {
        animatedObjects = new ArrayList<AnimatedObject>();
        Pac pac = new Pac();
        animatedObjects.add(pac);
        String[] world = initWorld();
        String[] currentWorld = pac.blit(world, 0, 0);
        while (true) {
            for (AnimatedObject object : animatedObjects) {
                object.nextFrame();
                currentWorld = object.blit(world, 0, 0);
            }
            for (String worldString : currentWorld) {
                System.out.println(worldString);
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            }
            catch(InterruptedException e) {
                System.out.println("Cannot sleep, aborting...");
                return;
            }
        }
    }

    public static String[] initWorld() {
        String[] world = new String[45];

        char[][] charWorld = new char[45][45];
        for (int i = 0; i < charWorld.length; i++) {
            char[] charArray = charWorld[i];
            for (char character : charArray) {
                character = ' ';
            }
            world[i] = new String(charArray);
        }
        return world;
    }
}
