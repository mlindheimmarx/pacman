import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;


public class PacGame {
    static ArrayList<AnimatedObject> animatedObjects;
    
    public static void main(String[] args) {
    	JFrame frame = new JFrame("GUI");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setLocationRelativeTo(null);
    	Window w = new Window(frame);
    	BufferedImage canvas = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
    	frame.add(new JLabel(new ImageIcon(canvas)));
    	frame.pack();
    	frame.setVisible(true);
    	frame.setResizable(false);
    	for (int i = 0; i < 600; i++)
    		for (int j = 0; j < 600; j++)
    			canvas.setRGB(i, j, Color.WHITE.getRGB());
    	frame.pack();
    	
        animatedObjects = new ArrayList<AnimatedObject>();
        Pac pac = new Pac();
        //Ghost blinky = new Ghost();
        animatedObjects.add(pac);
        //animatedObjects.add(blinky);
        while (true) {
            for (AnimatedObject object : animatedObjects) {
                object.getNewVelocity();
                object.nextFrame();
                try {
                	canvas.setRGB(0, 0, Color.GREEN.getRGB());
                	object.update();
               		canvas = object.blit(canvas);
                }
                catch (Exception e){
                	object.stop();
               		canvas = object.blit(canvas);
                }
            }
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            }
            catch(InterruptedException e) {
                System.out.println("Cannot sleep, aborting...");
                return;
            }
    		frame.pack();
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
