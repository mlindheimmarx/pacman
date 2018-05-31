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

        final Pac pac = new Pac();
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
            makeMaze(canvas);
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
    
    public static void makeMaze(BufferedImage canvas) {
    	ArrayList<StationaryObject> wallElements = new ArrayList<StationaryObject>();
  
    	// Top
    	
    	wallElements.add(new MazeThinCornerUpLeft(0, 24));
    	wallElements.add(new MazeThinWallHorizontal(5, 24));
    	wallElements.add(new MazeThinWallHorizontal(21, 24));
    	wallElements.add(new MazeThinWallHorizontal(37, 24));
    	wallElements.add(new MazeThinWallHorizontal(53, 24));
    	wallElements.add(new MazeThinWallHorizontal(69, 24));
    	wallElements.add(new MazeThinWallHorizontal(85, 24));
    	wallElements.add(new MazeThinWallHorizontalShort(101, 24));
    	
    	wallElements.add(new MazeWallHorizontal(107, 24));
    	wallElements.add(new MazeThickCornerUpRight(105, 27));
    	wallElements.add(new MazeWallVertical(108, 29));
    	wallElements.add(new MazeWallVertical(108, 39));
    	wallElements.add(new MazeWallVertical(108, 44));
    	wallElements.add(new MazeThickCornerUpLeft(115, 27));
    	wallElements.add(new MazeWallVertical(115, 29));
    	wallElements.add(new MazeWallVertical(115, 39));
    	wallElements.add(new MazeWallVertical(115, 44));
    	wallElements.add(new MazeThickCornerDownLeft(108, 54));
    	wallElements.add(new MazeThickCornerDownRight(112, 54));
    	
    	wallElements.add(new MazeThinCornerUpRight(219, 24));
    	wallElements.add(new MazeThinWallHorizontal(203, 24));
    	wallElements.add(new MazeThinWallHorizontal(187, 24));
    	wallElements.add(new MazeThinWallHorizontal(171, 24));
    	wallElements.add(new MazeThinWallHorizontal(155, 24));
    	wallElements.add(new MazeThinWallHorizontal(139, 24));
    	wallElements.add(new MazeThinWallHorizontal(123, 24));
    	wallElements.add(new MazeThinWallHorizontalShort(117, 24));
    	
    	// Left Side
    	
    	wallElements.add(new MazeThinWallVertical(0, 29));
    	wallElements.add(new MazeThinWallVertical(0, 45));
    	wallElements.add(new MazeThinWallVertical(0, 61));
    	wallElements.add(new MazeThinWallVertical(0, 77));
    	wallElements.add(new MazeThinWallVerticalShort(0, 93));
    	wallElements.add(new MazeThinCornerDownLeft(0, 99));
    	wallElements.add(new MazeThinWallHorizontal(5, 100));
    	wallElements.add(new MazeThinWallHorizontal(21, 100));
    	wallElements.add(new MazeThinWallHorizontal(24, 100));
    	wallElements.add(new MazeThickCornerUpRight(40, 100));
    	wallElements.add(new MazeThinWallVerticalMedium(40, 104));
    	wallElements.add(new MazeThinWallVerticalMedium(40, 116));
    	wallElements.add(new MazeThickCornerDownRight(40, 128));
    	wallElements.add(new MazeThinWallHorizontal(0, 128));
    	wallElements.add(new MazeThinWallHorizontal(16, 128));
    	wallElements.add(new MazeThinWallHorizontal(24, 128));
    	
    	wallElements.add(new MazeThinWallHorizontal(0, 148));
    	wallElements.add(new MazeThinWallHorizontal(16, 148));
    	wallElements.add(new MazeThinWallHorizontal(24, 148));
    	wallElements.add(new MazeThickCornerUpRight(40, 148));
    	wallElements.add(new MazeThinWallVerticalMedium(40, 152));
    	wallElements.add(new MazeThinWallVerticalMedium(40, 164));
    	wallElements.add(new MazeThickCornerDownRight(40, 176));
    	wallElements.add(new MazeThinCornerUpLeft(0, 176));
    	wallElements.add(new MazeThinWallHorizontal(5, 176));
    	wallElements.add(new MazeThinWallHorizontal(21, 176));
    	wallElements.add(new MazeThinWallHorizontal(24, 176));
    	
    	wallElements.add(new MazeThinWallVertical(0, 181));
    	wallElements.add(new MazeThinWallVertical(0, 197));
    	wallElements.add(new MazeThinWallVerticalShort(0, 213));
    	wallElements.add(new MazeWallVertical(0, 219));
    	wallElements.add(new MazeThickCornerDownLeft(3, 217));
    	
    	wallElements.add(new MazeWallHorizontal(6, 220));
    	wallElements.add(new MazeThickCornerUpRight(16, 220));
    	wallElements.add(new MazeThickCornerDownRight(16, 224));
    	wallElements.add(new MazeWallHorizontal(6, 227));
    	
    	wallElements.add(new MazeThickCornerUpLeft(3, 227));
    	wallElements.add(new MazeThinWallVertical(0, 229));
    	wallElements.add(new MazeThinWallVertical(0, 245));
    	wallElements.add(new MazeThinWallVerticalShort(0, 261));
    	wallElements.add(new MazeThinCornerDownLeft(0, 267));
    	
    	// Bottom
    	
    	wallElements.add(new MazeThinWallHorizontal(5, 268));
    	wallElements.add(new MazeThinWallHorizontal(21, 268));
    	wallElements.add(new MazeThinWallHorizontal(37, 268));
    	wallElements.add(new MazeThinWallHorizontal(53, 268));
    	wallElements.add(new MazeThinWallHorizontal(69, 268));
    	wallElements.add(new MazeThinWallHorizontal(85, 268));
    	wallElements.add(new MazeThinWallHorizontal(101, 268));
    	wallElements.add(new MazeThinWallHorizontal(117, 268));
    	wallElements.add(new MazeThinWallHorizontal(133, 268));
    	wallElements.add(new MazeThinWallHorizontal(149, 268));
    	wallElements.add(new MazeThinWallHorizontal(165, 268));
    	wallElements.add(new MazeThinWallHorizontal(181, 268));
    	wallElements.add(new MazeThinWallHorizontal(197, 268));
    	wallElements.add(new MazeThinWallHorizontalShort(213, 268));
    	
    	// Right Side
    	
    	wallElements.add(new MazeThinWallVertical(220, 29));
    	wallElements.add(new MazeThinWallVertical(220, 45));
    	wallElements.add(new MazeThinWallVertical(220, 61));
    	wallElements.add(new MazeThinWallVertical(220, 77));
    	wallElements.add(new MazeThinWallVerticalShort(220, 93));
    	wallElements.add(new MazeThinCornerDownRight(219, 99));
    	wallElements.add(new MazeThinWallHorizontal(203, 100));
    	wallElements.add(new MazeThinWallHorizontal(200, 100));
    	wallElements.add(new MazeThinWallHorizontal(184, 100));
    	wallElements.add(new MazeThickCornerUpLeft(180, 100));
    	wallElements.add(new MazeThinWallVerticalMedium(180, 104));
    	wallElements.add(new MazeThinWallVerticalMedium(180, 116));
    	wallElements.add(new MazeThickCornerDownLeft(180, 128));
    	wallElements.add(new MazeThinWallHorizontal(208, 128));
    	wallElements.add(new MazeThinWallHorizontal(200, 128));
    	wallElements.add(new MazeThinWallHorizontal(184, 128));
    	    	
    	wallElements.add(new MazeThinWallHorizontal(208, 148));
    	wallElements.add(new MazeThinWallHorizontal(200, 148));
    	wallElements.add(new MazeThinWallHorizontal(184, 148));
    	wallElements.add(new MazeThickCornerUpLeft(180, 148));
    	wallElements.add(new MazeThinWallVerticalMedium(180, 152));
    	wallElements.add(new MazeThinWallVerticalMedium(180, 164));
    	wallElements.add(new MazeThickCornerDownLeft(180, 176));
    	wallElements.add(new MazeThinCornerUpRight(219, 176));
    	wallElements.add(new MazeThinWallHorizontal(203, 176));
    	wallElements.add(new MazeThinWallHorizontal(200, 176));
    	wallElements.add(new MazeThinWallHorizontal(184, 176));
    	
    	wallElements.add(new MazeThinWallVertical(220, 181));
    	wallElements.add(new MazeThinWallVertical(220, 197));
    	wallElements.add(new MazeThinWallVerticalShort(220, 213));
    	wallElements.add(new MazeWallVertical(223, 219));
    	wallElements.add(new MazeThickCornerDownRight(217, 217));
    	
    	wallElements.add(new MazeWallHorizontal(208, 220));
    	wallElements.add(new MazeThickCornerUpLeft(204, 220));
    	wallElements.add(new MazeThickCornerDownLeft(204, 224));
    	wallElements.add(new MazeWallHorizontal(208, 227));
    	
    	wallElements.add(new MazeThickCornerUpRight(217, 227));
    	wallElements.add(new MazeThinWallVertical(220, 229));
    	wallElements.add(new MazeThinWallVertical(220, 245));
    	wallElements.add(new MazeThinWallVerticalShort(220, 261));
    	wallElements.add(new MazeThinCornerDownRight(219, 267));
    	
    	for (StationaryObject object : wallElements) {
                object.blit(canvas);
       	}
    }
}
