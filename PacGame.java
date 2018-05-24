import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Scanner;


public class PacGame {
    static ArrayList<AnimatedObject> animatedObjects;
    
    public static void main(String[] args) {
        animatedObjects = new ArrayList<AnimatedObject>();
        Pac pac = new Pac();
        Ghost blinky = new Ghost();
        animatedObjects.add(pac);
        animatedObjects.add(blinky);
        while (true) {
        	Scanner keyboard = new Scanner(System.in);
    		keyboard.useDelimiter("");
    		String input = keyboard.next();
    		if (input.equals("q")) {
    			return;
    		}
    		else {
    			pac.getNewVelocity(input.toCharArray()[0]);
    		}
        	String[] world = initWorld();
            for (AnimatedObject object : animatedObjects) {
                object.getNewVelocity();
                object.nextFrame();
                object.update();
                try {
               		world = object.blit(world);
                }
                catch (Exception e){
                	object.reverseUpdate();
                	object.stop();
               		world = object.blit(world);
                }
            }
            for (String worldString : world) {
                System.out.println(worldString);
            }
            try {
                TimeUnit.MILLISECONDS.sleep(250);
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
