import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;

public class PacGame {
    static ArrayList<AnimatedObject> animatedObjects;
    static ArrayList<StationaryObject> stationaryObjects;
    
    public static void main(String[] args) {
    	JFrame frame = new JFrame("GUI");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setLocationRelativeTo(null);
    	Window w = new Window(frame);
    	BufferedImage canvas = new BufferedImage(672, 864, BufferedImage.TYPE_INT_ARGB);
    	frame.setVisible(true);
    	frame.setResizable(false);
    	
        animatedObjects = new ArrayList<AnimatedObject>();
        stationaryObjects = new ArrayList<StationaryObject>();

        Pac pac = new Pac();
        Ghost clyde = new Ghost(Color.decode("#F8BB55"), 100, 125);
        Ghost inky = new Ghost(Color.decode("#00FFFF"), 100, 150);
        Ghost pinky = new Ghost(Color.decode("#FCB5FF"), 100, 175);
        Ghost blinky = new Ghost(Color.decode("#FF0000"), 100, 200);
        PowerDot powerdot = new PowerDot();

        Cherries cherries = new Cherries(100, 225);
        Strawberry strawberry = new Strawberry(100, 250);
        Orange orange = new Orange(100, 275);
        Apple apple = new Apple(125, 225);
        Melon melon = new Melon(125, 250);
        Galaga galaga = new Galaga(125, 275);
        Bell bell = new Bell(150, 225);
        Key key = new Key(150, 250);
        Dot dot = new Dot(150, 275);

        animatedObjects.add(pac);
        animatedObjects.add(clyde);
        animatedObjects.add(inky);
        animatedObjects.add(pinky);
        animatedObjects.add(blinky);
        animatedObjects.add(powerdot);
        
        stationaryObjects.add(cherries);
        stationaryObjects.add(strawberry);
        stationaryObjects.add(orange);
        stationaryObjects.add(apple);
        stationaryObjects.add(melon);
        stationaryObjects.add(galaga);
        stationaryObjects.add(bell);
        stationaryObjects.add(key);
        stationaryObjects.add(dot);

        JLabel temp = new JLabel(new ImageIcon(canvas));
        frame.add(temp);
        frame.pack();
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                pac.getNewVelocity(e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        while (true) {
    	    for (int i = 0; i < 224; i++)
    		    for (int j = 0; j < 288; j++)
    			    HelperClass.writeBigPixel(canvas, i, j, Color.BLACK.getRGB());
            for (StationaryObject object : stationaryObjects) {
                object.blit(canvas);
            }
            for (AnimatedObject object : animatedObjects) {
                object.getNewVelocity();
                object.nextFrame();
                object.update();
                try {
               		object.blit(canvas);
                }
                catch (Exception e){
                	object.stop();
               		object.blit(canvas);
                }
            }
            temp.setIcon(new ImageIcon(canvas));
            try {
                TimeUnit.MILLISECONDS.sleep(100);
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
