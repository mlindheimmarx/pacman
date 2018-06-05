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
        int frameNumber = 0;
    	JFrame frame = new JFrame("GUI");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setLocationRelativeTo(null);
    	Window w = new Window(frame);
    	BufferedImage canvas = new BufferedImage(672, 864, BufferedImage.TYPE_INT_ARGB);
    	frame.setVisible(true);
    	frame.setResizable(false);
    	
        boolean[][] space = availableSpace();
        animatedObjects = new ArrayList<AnimatedObject>();
        stationaryObjects = new ArrayList<StationaryObject>();
        
        stationaryObjects.add(new Dot(11, 35));
        stationaryObjects.add(new Dot(19, 35));
        stationaryObjects.add(new Dot(27, 35));
        stationaryObjects.add(new Dot(35, 35));
        stationaryObjects.add(new Dot(43, 35));
        stationaryObjects.add(new Dot(51, 35));
        stationaryObjects.add(new Dot(59, 35));
        stationaryObjects.add(new Dot(67, 35));
        stationaryObjects.add(new Dot(75, 35));
        stationaryObjects.add(new Dot(83, 35));
        stationaryObjects.add(new Dot(91, 35));
        stationaryObjects.add(new Dot(99, 35));
        stationaryObjects.add(new Dot(123, 35));
        stationaryObjects.add(new Dot(131, 35));
        stationaryObjects.add(new Dot(139, 35));
        stationaryObjects.add(new Dot(147, 35));
        stationaryObjects.add(new Dot(155, 35));
        stationaryObjects.add(new Dot(163, 35));
        stationaryObjects.add(new Dot(171, 35));
        stationaryObjects.add(new Dot(179, 35));
        stationaryObjects.add(new Dot(187, 35));
        stationaryObjects.add(new Dot(195, 35));
        stationaryObjects.add(new Dot(203, 35));
        stationaryObjects.add(new Dot(211, 35));

        stationaryObjects.add(new Dot(11, 67));
        stationaryObjects.add(new Dot(19, 67));
        stationaryObjects.add(new Dot(27, 67));
        stationaryObjects.add(new Dot(35, 67));
        stationaryObjects.add(new Dot(43, 67));
        stationaryObjects.add(new Dot(51, 67));
        stationaryObjects.add(new Dot(59, 67));
        stationaryObjects.add(new Dot(67, 67));
        stationaryObjects.add(new Dot(75, 67));
        stationaryObjects.add(new Dot(83, 67));
        stationaryObjects.add(new Dot(91, 67));
        stationaryObjects.add(new Dot(99, 67));
        stationaryObjects.add(new Dot(107, 67));
        stationaryObjects.add(new Dot(115, 67));
        stationaryObjects.add(new Dot(123, 67));
        stationaryObjects.add(new Dot(131, 67));
        stationaryObjects.add(new Dot(139, 67));
        stationaryObjects.add(new Dot(147, 67));
        stationaryObjects.add(new Dot(155, 67));
        stationaryObjects.add(new Dot(163, 67));
        stationaryObjects.add(new Dot(171, 67));
        stationaryObjects.add(new Dot(179, 67));
        stationaryObjects.add(new Dot(187, 67));
        stationaryObjects.add(new Dot(195, 67));
        stationaryObjects.add(new Dot(203, 67));
        stationaryObjects.add(new Dot(211, 67));

        stationaryObjects.add(new Dot(11, 91));
        stationaryObjects.add(new Dot(19, 91));
        stationaryObjects.add(new Dot(27, 91));
        stationaryObjects.add(new Dot(35, 91));
        stationaryObjects.add(new Dot(43, 91));
        stationaryObjects.add(new Dot(51, 91));
        stationaryObjects.add(new Dot(75, 91));
        stationaryObjects.add(new Dot(83, 91));
        stationaryObjects.add(new Dot(91, 91));
        stationaryObjects.add(new Dot(99, 91));
        stationaryObjects.add(new Dot(123, 91));
        stationaryObjects.add(new Dot(131, 91));
        stationaryObjects.add(new Dot(139, 91));
        stationaryObjects.add(new Dot(147, 91));
        stationaryObjects.add(new Dot(171, 91));
        stationaryObjects.add(new Dot(179, 91));
        stationaryObjects.add(new Dot(187, 91));
        stationaryObjects.add(new Dot(195, 91));
        stationaryObjects.add(new Dot(203, 91));
        stationaryObjects.add(new Dot(211, 91));
        
        stationaryObjects.add(new Dot(11, 187));
        stationaryObjects.add(new Dot(19, 187));
        stationaryObjects.add(new Dot(27, 187));
        stationaryObjects.add(new Dot(35, 187));
        stationaryObjects.add(new Dot(43, 187));
        stationaryObjects.add(new Dot(51, 187));
        stationaryObjects.add(new Dot(59, 187));
        stationaryObjects.add(new Dot(67, 187));
        stationaryObjects.add(new Dot(75, 187));
        stationaryObjects.add(new Dot(83, 187));
        stationaryObjects.add(new Dot(91, 187));
        stationaryObjects.add(new Dot(99, 187));
        stationaryObjects.add(new Dot(123, 187));
        stationaryObjects.add(new Dot(131, 187));
        stationaryObjects.add(new Dot(139, 187));
        stationaryObjects.add(new Dot(147, 187));
        stationaryObjects.add(new Dot(155, 187));
        stationaryObjects.add(new Dot(163, 187));
        stationaryObjects.add(new Dot(171, 187));
        stationaryObjects.add(new Dot(179, 187));
        stationaryObjects.add(new Dot(187, 187));
        stationaryObjects.add(new Dot(195, 187));
        stationaryObjects.add(new Dot(203, 187));
        stationaryObjects.add(new Dot(211, 187));
        
        stationaryObjects.add(new Dot(11, 211));
        stationaryObjects.add(new Dot(19, 211));
        stationaryObjects.add(new Dot(27, 211));
        stationaryObjects.add(new Dot(51, 211));
        stationaryObjects.add(new Dot(59, 211));
        stationaryObjects.add(new Dot(67, 211));
        stationaryObjects.add(new Dot(75, 211));
        stationaryObjects.add(new Dot(83, 211));
        stationaryObjects.add(new Dot(91, 211));
        stationaryObjects.add(new Dot(99, 211));
        stationaryObjects.add(new Dot(123, 211));
        stationaryObjects.add(new Dot(131, 211));
        stationaryObjects.add(new Dot(139, 211));
        stationaryObjects.add(new Dot(147, 211));
        stationaryObjects.add(new Dot(155, 211));
        stationaryObjects.add(new Dot(163, 211));
        stationaryObjects.add(new Dot(171, 211));
        stationaryObjects.add(new Dot(195, 211));
        stationaryObjects.add(new Dot(203, 211));
        stationaryObjects.add(new Dot(211, 211));

        stationaryObjects.add(new Dot(11, 235));
        stationaryObjects.add(new Dot(19, 235));
        stationaryObjects.add(new Dot(27, 235));
        stationaryObjects.add(new Dot(35, 235));
        stationaryObjects.add(new Dot(43, 235));
        stationaryObjects.add(new Dot(51, 235));
        stationaryObjects.add(new Dot(75, 235));
        stationaryObjects.add(new Dot(83, 235));
        stationaryObjects.add(new Dot(91, 235));
        stationaryObjects.add(new Dot(99, 235));
        stationaryObjects.add(new Dot(123, 235));
        stationaryObjects.add(new Dot(131, 235));
        stationaryObjects.add(new Dot(139, 235));
        stationaryObjects.add(new Dot(147, 235));
        stationaryObjects.add(new Dot(171, 235));
        stationaryObjects.add(new Dot(179, 235));
        stationaryObjects.add(new Dot(187, 235));
        stationaryObjects.add(new Dot(195, 235));
        stationaryObjects.add(new Dot(203, 235));
        stationaryObjects.add(new Dot(211, 235));

        stationaryObjects.add(new Dot(11, 259));
        stationaryObjects.add(new Dot(19, 259));
        stationaryObjects.add(new Dot(27, 259));
        stationaryObjects.add(new Dot(35, 259));
        stationaryObjects.add(new Dot(43, 259));
        stationaryObjects.add(new Dot(51, 259));
        stationaryObjects.add(new Dot(59, 259));
        stationaryObjects.add(new Dot(67, 259));
        stationaryObjects.add(new Dot(75, 259));
        stationaryObjects.add(new Dot(83, 259));
        stationaryObjects.add(new Dot(91, 259));
        stationaryObjects.add(new Dot(99, 259));
        stationaryObjects.add(new Dot(107, 259));
        stationaryObjects.add(new Dot(115, 259));
        stationaryObjects.add(new Dot(123, 259));
        stationaryObjects.add(new Dot(131, 259));
        stationaryObjects.add(new Dot(139, 259));
        stationaryObjects.add(new Dot(147, 259));
        stationaryObjects.add(new Dot(155, 259));
        stationaryObjects.add(new Dot(163, 259));
        stationaryObjects.add(new Dot(171, 259));
        stationaryObjects.add(new Dot(179, 259));
        stationaryObjects.add(new Dot(187, 259));
        stationaryObjects.add(new Dot(195, 259));
        stationaryObjects.add(new Dot(203, 259));
        stationaryObjects.add(new Dot(211, 259));

        stationaryObjects.add(new Dot(11, 43));
        stationaryObjects.add(new Dot(11, 51));
        stationaryObjects.add(new Dot(11, 59));
        stationaryObjects.add(new Dot(11, 75));
        stationaryObjects.add(new Dot(11, 83));
        stationaryObjects.add(new Dot(11, 195));
        stationaryObjects.add(new Dot(11, 203));
        stationaryObjects.add(new Dot(11, 243));
        stationaryObjects.add(new Dot(11, 251));

        stationaryObjects.add(new Dot(27, 219));
        stationaryObjects.add(new Dot(27, 227));

        stationaryObjects.add(new Dot(51, 43));
        stationaryObjects.add(new Dot(51, 51));
        stationaryObjects.add(new Dot(51, 59));
        stationaryObjects.add(new Dot(51, 75));
        stationaryObjects.add(new Dot(51, 83));
        stationaryObjects.add(new Dot(51, 99));
        stationaryObjects.add(new Dot(51, 107));
        stationaryObjects.add(new Dot(51, 115));
        stationaryObjects.add(new Dot(51, 123));
        stationaryObjects.add(new Dot(51, 131));
        stationaryObjects.add(new Dot(51, 139));
        stationaryObjects.add(new Dot(51, 147));
        stationaryObjects.add(new Dot(51, 155));
        stationaryObjects.add(new Dot(51, 163));
        stationaryObjects.add(new Dot(51, 171));
        stationaryObjects.add(new Dot(51, 179));
        stationaryObjects.add(new Dot(51, 195));
        stationaryObjects.add(new Dot(51, 203));
        stationaryObjects.add(new Dot(51, 219));
        stationaryObjects.add(new Dot(51, 227));

        stationaryObjects.add(new Dot(75, 75));
        stationaryObjects.add(new Dot(75, 83));
        stationaryObjects.add(new Dot(75, 219));
        stationaryObjects.add(new Dot(75, 227));

        stationaryObjects.add(new Dot(99, 43));
        stationaryObjects.add(new Dot(99, 51));
        stationaryObjects.add(new Dot(99, 59));
        stationaryObjects.add(new Dot(99, 195));
        stationaryObjects.add(new Dot(99, 203));
        stationaryObjects.add(new Dot(99, 243));
        stationaryObjects.add(new Dot(99, 251));

        stationaryObjects.add(new Dot(123, 43));
        stationaryObjects.add(new Dot(123, 51));
        stationaryObjects.add(new Dot(123, 59));
        stationaryObjects.add(new Dot(123, 195));
        stationaryObjects.add(new Dot(123, 203));
        stationaryObjects.add(new Dot(123, 243));
        stationaryObjects.add(new Dot(123, 251));

        stationaryObjects.add(new Dot(147, 75));
        stationaryObjects.add(new Dot(147, 83));
        stationaryObjects.add(new Dot(147, 219));
        stationaryObjects.add(new Dot(147, 227));

        stationaryObjects.add(new Dot(171, 43));
        stationaryObjects.add(new Dot(171, 51));
        stationaryObjects.add(new Dot(171, 59));
        stationaryObjects.add(new Dot(171, 75));
        stationaryObjects.add(new Dot(171, 83));
        stationaryObjects.add(new Dot(171, 99));
        stationaryObjects.add(new Dot(171, 107));
        stationaryObjects.add(new Dot(171, 115));
        stationaryObjects.add(new Dot(171, 123));
        stationaryObjects.add(new Dot(171, 131));
        stationaryObjects.add(new Dot(171, 139));
        stationaryObjects.add(new Dot(171, 147));
        stationaryObjects.add(new Dot(171, 155));
        stationaryObjects.add(new Dot(171, 163));
        stationaryObjects.add(new Dot(171, 171));
        stationaryObjects.add(new Dot(171, 179));
        stationaryObjects.add(new Dot(171, 195));
        stationaryObjects.add(new Dot(171, 203));
        stationaryObjects.add(new Dot(171, 219));
        stationaryObjects.add(new Dot(171, 227));

        stationaryObjects.add(new Dot(195, 219));
        stationaryObjects.add(new Dot(195, 227));

        stationaryObjects.add(new Dot(211, 43));
        stationaryObjects.add(new Dot(211, 51));
        stationaryObjects.add(new Dot(211, 59));
        stationaryObjects.add(new Dot(211, 75));
        stationaryObjects.add(new Dot(211, 83));
        stationaryObjects.add(new Dot(211, 195));
        stationaryObjects.add(new Dot(211, 203));
        stationaryObjects.add(new Dot(211, 243));
        stationaryObjects.add(new Dot(211, 251));

        final Pac pac = new Pac(space);

        animatedObjects.add(pac);

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
            if (frameNumber % 180 == 0) {
                boolean acceptable = false;
                int spawnx = 0;
                int spawny = 0;
                while (!acceptable) {
                    spawnx = (int) (Math.random() * space[0].length);
                    spawny = (int) (Math.random() * space.length);
                    if (space[spawny][spawnx] && Math.abs(spawnx - pac.getX()) > 15 && Math.abs(spawny - pac.getY()) > 15)
                        acceptable = true;
                }
                animatedObjects.add(new Ghost(Color.RED, spawny, spawnx + 24, space));
            }
    	    for (int i = 0; i < 224; i++)
    		    for (int j = 0; j < 288; j++)
    			    HelperClass.writeBigPixel(canvas, i, j, Color.BLACK.getRGB());
            makeMaze(canvas);
            for (StationaryObject object : stationaryObjects) {
                object.blit(canvas);
                if (object instanceof Dot) {
                    ((Dot) object).testRemove(pac.getX(), pac.getY(), pac);
                }
            }
            for (AnimatedObject object : animatedObjects) {
                if (object instanceof Ghost) {
                    ((Ghost) object).setPacLocation(pac.getX(), pac.getY());
                    if (Math.abs(((Ghost) object).getX() - pac.getX()) <= 6 && Math.abs(((Ghost) object).getY() - pac.getY()) <= 6) {
                        System.out.println(pac.score + "");
                        return;
                    }
                }
                object.getNewVelocity();
                try {
                    object.nextFrame();
                    object.update();
               		object.blit(canvas);
                }
                catch (Exception e){
                    object.antiUpdate();
                    object.stop();
               		object.blit(canvas);
                }
            }
            temp.setIcon(new ImageIcon(canvas));
            try {
                TimeUnit.MILLISECONDS.sleep(17);
            }
            catch(InterruptedException e) {
                System.out.println("Cannot sleep, aborting...");
                return;
            }
            frameNumber++;
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
    	wallElements.add(new MazeWallVertical(108, 46));
    	wallElements.add(new MazeThickCornerUpLeft(115, 27));
    	wallElements.add(new MazeWallVertical(115, 29));
    	wallElements.add(new MazeWallVertical(115, 39));
    	wallElements.add(new MazeWallVertical(115, 46));
    	wallElements.add(new MazeThickCornerDownLeft(108, 56));
    	wallElements.add(new MazeThickCornerDownRight(112, 56));
    	
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
    	wallElements.add(new MazeThinWallVerticalMedium(40, 128));
    	wallElements.add(new MazeThinWallVerticalMedium(40, 140));
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
    	wallElements.add(new MazeThinWallVerticalMedium(180, 128));
    	wallElements.add(new MazeThinWallVerticalMedium(180, 140));
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

        // Internals
        
    	wallElements.add(new MazeThickCornerUpLeft(180, 44));
    	wallElements.add(new MazeThickCornerDownLeft(180, 56));
    	wallElements.add(new MazeThickCornerUpRight(200, 44));
    	wallElements.add(new MazeThickCornerDownRight(200, 56));
    	wallElements.add(new MazeWallVertical(180, 47));
    	wallElements.add(new MazeWallVertical(203, 47));
    	wallElements.add(new MazeWallHorizontal(184, 44));
    	wallElements.add(new MazeWallHorizontal(190, 44));
    	wallElements.add(new MazeWallHorizontal(184, 59));
    	wallElements.add(new MazeWallHorizontal(190, 59));
        
    	wallElements.add(new MazeThickCornerUpLeft(20, 44));
    	wallElements.add(new MazeThickCornerDownLeft(20, 56));
    	wallElements.add(new MazeThickCornerUpRight(40, 44));
    	wallElements.add(new MazeThickCornerDownRight(40, 56));
    	wallElements.add(new MazeWallVertical(20, 47));
    	wallElements.add(new MazeWallVertical(43, 47));
    	wallElements.add(new MazeWallHorizontal(24, 44));
    	wallElements.add(new MazeWallHorizontal(30, 44));
    	wallElements.add(new MazeWallHorizontal(24, 59));
    	wallElements.add(new MazeWallHorizontal(30, 59));
        
    	wallElements.add(new MazeThickCornerUpLeft(20, 76));
    	wallElements.add(new MazeThickCornerDownLeft(20, 80));
    	wallElements.add(new MazeThickCornerUpRight(40, 76));
    	wallElements.add(new MazeThickCornerDownRight(40, 80));
    	wallElements.add(new MazeWallHorizontal(24, 76));
    	wallElements.add(new MazeWallHorizontal(30, 76));
    	wallElements.add(new MazeWallHorizontal(24, 83));
    	wallElements.add(new MazeWallHorizontal(30, 83));
        
    	wallElements.add(new MazeThickCornerUpLeft(180, 76));
    	wallElements.add(new MazeThickCornerDownLeft(180, 80));
    	wallElements.add(new MazeThickCornerUpRight(200, 76));
    	wallElements.add(new MazeThickCornerDownRight(200, 80));
    	wallElements.add(new MazeWallHorizontal(184, 76));
    	wallElements.add(new MazeWallHorizontal(190, 76));
    	wallElements.add(new MazeWallHorizontal(184, 83));
    	wallElements.add(new MazeWallHorizontal(190, 83));

    	wallElements.add(new MazeThickCornerUpLeft(60, 44));
    	wallElements.add(new MazeThickCornerDownLeft(60, 56));
    	wallElements.add(new MazeThickCornerUpRight(88, 44));
    	wallElements.add(new MazeThickCornerDownRight(88, 56));
    	wallElements.add(new MazeWallVertical(60, 47));
    	wallElements.add(new MazeWallVertical(91, 47));
    	wallElements.add(new MazeWallHorizontal(64, 44));
    	wallElements.add(new MazeWallHorizontal(74, 44));
    	wallElements.add(new MazeWallHorizontal(78, 44));
    	wallElements.add(new MazeWallHorizontal(64, 59));
    	wallElements.add(new MazeWallHorizontal(74, 59));
    	wallElements.add(new MazeWallHorizontal(78, 59));

    	wallElements.add(new MazeThickCornerUpLeft(132, 44));
    	wallElements.add(new MazeThickCornerDownLeft(132, 56));
    	wallElements.add(new MazeThickCornerUpRight(160, 44));
    	wallElements.add(new MazeThickCornerDownRight(160, 56));
    	wallElements.add(new MazeWallVertical(132, 47));
    	wallElements.add(new MazeWallVertical(163, 47));
    	wallElements.add(new MazeWallHorizontal(136, 44));
    	wallElements.add(new MazeWallHorizontal(146, 44));
    	wallElements.add(new MazeWallHorizontal(150, 44));
    	wallElements.add(new MazeWallHorizontal(136, 59));
    	wallElements.add(new MazeWallHorizontal(146, 59));
    	wallElements.add(new MazeWallHorizontal(150, 59));
    	
    	wallElements.add(new MazeThickCornerUpLeft(60, 196));
    	wallElements.add(new MazeThickCornerDownLeft(60, 200));
    	wallElements.add(new MazeThickCornerUpRight(88, 196));
    	wallElements.add(new MazeThickCornerDownRight(88, 200));
    	wallElements.add(new MazeWallHorizontal(64, 196));
    	wallElements.add(new MazeWallHorizontal(74, 196));
    	wallElements.add(new MazeWallHorizontal(78, 196));
    	wallElements.add(new MazeWallHorizontal(64, 203));
    	wallElements.add(new MazeWallHorizontal(74, 203));
    	wallElements.add(new MazeWallHorizontal(78, 203));
    	
    	wallElements.add(new MazeThickCornerUpLeft(132, 196));
    	wallElements.add(new MazeThickCornerDownLeft(132, 200));
    	wallElements.add(new MazeThickCornerUpRight(160, 196));
    	wallElements.add(new MazeThickCornerDownRight(160, 200));
    	wallElements.add(new MazeWallHorizontal(136, 196));
    	wallElements.add(new MazeWallHorizontal(146, 196));
    	wallElements.add(new MazeWallHorizontal(150, 196));
    	wallElements.add(new MazeWallHorizontal(136, 203));
    	wallElements.add(new MazeWallHorizontal(146, 203));
    	wallElements.add(new MazeWallHorizontal(150, 203));
    	
    	wallElements.add(new MazeThickCornerUpLeft(60, 148));
    	wallElements.add(new MazeThickCornerDownLeft(60, 176));
    	wallElements.add(new MazeThickCornerUpRight(64, 148));
    	wallElements.add(new MazeThickCornerDownRight(64, 176));
    	wallElements.add(new MazeWallVertical(60, 152));
    	wallElements.add(new MazeWallVertical(60, 162));
    	wallElements.add(new MazeWallVertical(60, 166));
    	wallElements.add(new MazeWallVertical(67, 152));
    	wallElements.add(new MazeWallVertical(67, 162));
    	wallElements.add(new MazeWallVertical(67, 166));
    	
    	wallElements.add(new MazeThickCornerUpLeft(156, 148));
    	wallElements.add(new MazeThickCornerDownLeft(156, 176));
    	wallElements.add(new MazeThickCornerUpRight(160, 148));
    	wallElements.add(new MazeThickCornerDownRight(160, 176));
    	wallElements.add(new MazeWallVertical(156, 152));
    	wallElements.add(new MazeWallVertical(156, 162));
    	wallElements.add(new MazeWallVertical(156, 166));
    	wallElements.add(new MazeWallVertical(163, 152));
    	wallElements.add(new MazeWallVertical(163, 162));
    	wallElements.add(new MazeWallVertical(163, 166));
    	
    	wallElements.add(new MazeThickCornerUpLeft(60, 76));
    	wallElements.add(new MazeThickCornerDownLeft(60, 128));
    	wallElements.add(new MazeThickCornerUpRight(64, 76));
    	wallElements.add(new MazeThickCornerDownRight(64, 128));
    	wallElements.add(new MazeThickCornerUpLeft(67, 107));
    	wallElements.add(new MazeThickCornerDownLeft(67, 97));
    	wallElements.add(new MazeThickCornerUpRight(88, 100));
    	wallElements.add(new MazeThickCornerDownRight(88, 104));
    	wallElements.add(new MazeWallVertical(60, 80));
    	wallElements.add(new MazeWallVertical(60, 90));
    	wallElements.add(new MazeWallVertical(60, 100));
    	wallElements.add(new MazeWallVertical(60, 110));
    	wallElements.add(new MazeWallVertical(60, 118));
    	wallElements.add(new MazeWallVertical(67, 80));
    	wallElements.add(new MazeWallVertical(67, 87));
    	wallElements.add(new MazeWallVertical(67, 111));
    	wallElements.add(new MazeWallVertical(67, 118));
    	wallElements.add(new MazeWallHorizontal(71, 100));
    	wallElements.add(new MazeWallHorizontal(78, 100));
    	wallElements.add(new MazeWallHorizontal(71, 107));
    	wallElements.add(new MazeWallHorizontal(78, 107));
    	
    	wallElements.add(new MazeThickCornerUpLeft(156, 76));
    	wallElements.add(new MazeThickCornerDownLeft(156, 128));
    	wallElements.add(new MazeThickCornerUpRight(160, 76));
    	wallElements.add(new MazeThickCornerDownRight(160, 128));
    	wallElements.add(new MazeThickCornerUpLeft(132, 100));
    	wallElements.add(new MazeThickCornerDownLeft(132, 104));
    	wallElements.add(new MazeThickCornerUpRight(153, 107));
    	wallElements.add(new MazeThickCornerDownRight(153, 97));
    	wallElements.add(new MazeWallVertical(163, 80));
    	wallElements.add(new MazeWallVertical(163, 90));
    	wallElements.add(new MazeWallVertical(163, 100));
    	wallElements.add(new MazeWallVertical(163, 110));
    	wallElements.add(new MazeWallVertical(163, 118));
    	wallElements.add(new MazeWallVertical(156, 80));
    	wallElements.add(new MazeWallVertical(156, 87));
    	wallElements.add(new MazeWallVertical(156, 111));
    	wallElements.add(new MazeWallVertical(156, 118));
    	wallElements.add(new MazeWallHorizontal(136, 100));
    	wallElements.add(new MazeWallHorizontal(143, 100));
    	wallElements.add(new MazeWallHorizontal(136, 107));
    	wallElements.add(new MazeWallHorizontal(143, 107));

    	wallElements.add(new MazeThickCornerUpLeft(84, 76));
    	wallElements.add(new MazeThickCornerDownLeft(84, 80));
    	wallElements.add(new MazeThickCornerUpRight(136, 76));
    	wallElements.add(new MazeThickCornerDownRight(136, 80));
    	wallElements.add(new MazeThickCornerUpLeft(115, 83));
    	wallElements.add(new MazeThickCornerDownLeft(108, 104));
    	wallElements.add(new MazeThickCornerUpRight(105, 83));
    	wallElements.add(new MazeThickCornerDownRight(112, 104));
    	wallElements.add(new MazeWallHorizontal(88, 76));
    	wallElements.add(new MazeWallHorizontal(98, 76));
    	wallElements.add(new MazeWallHorizontal(108, 76));
    	wallElements.add(new MazeWallHorizontal(118, 76));
    	wallElements.add(new MazeWallHorizontal(126, 76));
    	wallElements.add(new MazeWallHorizontal(88, 83));
    	wallElements.add(new MazeWallHorizontal(95, 83));
    	wallElements.add(new MazeWallHorizontal(119, 83));
    	wallElements.add(new MazeWallHorizontal(126, 83));
    	wallElements.add(new MazeWallVertical(108, 87));
    	wallElements.add(new MazeWallVertical(108, 94));
    	wallElements.add(new MazeWallVertical(115, 87));
    	wallElements.add(new MazeWallVertical(115, 94));
        
    	wallElements.add(new MazeThickCornerUpLeft(84, 172));
    	wallElements.add(new MazeThickCornerDownLeft(84, 176));
    	wallElements.add(new MazeThickCornerUpRight(136, 172));
    	wallElements.add(new MazeThickCornerDownRight(136, 176));
    	wallElements.add(new MazeThickCornerUpLeft(115, 179));
    	wallElements.add(new MazeThickCornerDownLeft(108, 200));
    	wallElements.add(new MazeThickCornerUpRight(105, 179));
    	wallElements.add(new MazeThickCornerDownRight(112, 200));
    	wallElements.add(new MazeWallHorizontal(88, 172));
    	wallElements.add(new MazeWallHorizontal(98, 172));
    	wallElements.add(new MazeWallHorizontal(108, 172));
    	wallElements.add(new MazeWallHorizontal(118, 172));
    	wallElements.add(new MazeWallHorizontal(126, 172));
    	wallElements.add(new MazeWallHorizontal(88, 179));
    	wallElements.add(new MazeWallHorizontal(95, 179));
    	wallElements.add(new MazeWallHorizontal(119, 179));
    	wallElements.add(new MazeWallHorizontal(126, 179));
    	wallElements.add(new MazeWallVertical(108, 183));
    	wallElements.add(new MazeWallVertical(108, 190));
    	wallElements.add(new MazeWallVertical(115, 183));
    	wallElements.add(new MazeWallVertical(115, 190));

    	wallElements.add(new MazeThickCornerUpLeft(84, 220));
    	wallElements.add(new MazeThickCornerDownLeft(84, 224));
    	wallElements.add(new MazeThickCornerUpRight(136, 220));
    	wallElements.add(new MazeThickCornerDownRight(136, 224));
    	wallElements.add(new MazeThickCornerUpLeft(115, 227));
    	wallElements.add(new MazeThickCornerDownLeft(108, 248));
    	wallElements.add(new MazeThickCornerUpRight(105, 227));
    	wallElements.add(new MazeThickCornerDownRight(112, 248));
    	wallElements.add(new MazeWallHorizontal(88, 220));
    	wallElements.add(new MazeWallHorizontal(98, 220));
    	wallElements.add(new MazeWallHorizontal(108, 220));
    	wallElements.add(new MazeWallHorizontal(118, 220));
    	wallElements.add(new MazeWallHorizontal(126, 220));
    	wallElements.add(new MazeWallHorizontal(88, 227));
    	wallElements.add(new MazeWallHorizontal(95, 227));
    	wallElements.add(new MazeWallHorizontal(119, 227));
    	wallElements.add(new MazeWallHorizontal(126, 227));
    	wallElements.add(new MazeWallVertical(108, 231));
    	wallElements.add(new MazeWallVertical(108, 238));
    	wallElements.add(new MazeWallVertical(115, 231));
    	wallElements.add(new MazeWallVertical(115, 238));

    	wallElements.add(new MazeThickCornerUpLeft(20, 196));
    	wallElements.add(new MazeThickCornerDownLeft(20, 200));
    	wallElements.add(new MazeThickCornerUpRight(40, 196));
    	wallElements.add(new MazeThickCornerDownRight(40, 224));
    	wallElements.add(new MazeThickCornerDownLeft(36, 224));
    	wallElements.add(new MazeThickCornerUpRight(33, 203));
    	wallElements.add(new MazeWallHorizontal(24, 196));
    	wallElements.add(new MazeWallHorizontal(30, 196));
    	wallElements.add(new MazeWallHorizontal(24, 203));
    	wallElements.add(new MazeWallVertical(36, 207));
    	wallElements.add(new MazeWallVertical(36, 214));
    	wallElements.add(new MazeWallVertical(43, 200));
    	wallElements.add(new MazeWallVertical(43, 210));
    	wallElements.add(new MazeWallVertical(43, 214));

    	wallElements.add(new MazeThickCornerUpLeft(180, 196));
    	wallElements.add(new MazeThickCornerDownLeft(180, 224));
    	wallElements.add(new MazeThickCornerUpRight(200, 196));
    	wallElements.add(new MazeThickCornerDownRight(200, 200));
    	wallElements.add(new MazeThickCornerUpLeft(187, 203));
    	wallElements.add(new MazeThickCornerDownRight(184, 224));
    	wallElements.add(new MazeWallHorizontal(184, 196));
    	wallElements.add(new MazeWallHorizontal(190, 196));
    	wallElements.add(new MazeWallHorizontal(191, 203));
    	wallElements.add(new MazeWallVertical(187, 207));
    	wallElements.add(new MazeWallVertical(187, 214));
    	wallElements.add(new MazeWallVertical(180, 200));
    	wallElements.add(new MazeWallVertical(180, 210));
    	wallElements.add(new MazeWallVertical(180, 214));

    	wallElements.add(new MazeThickCornerUpLeft(60, 220));
    	wallElements.add(new MazeThickCornerDownLeft(67, 241));
    	wallElements.add(new MazeThickCornerUpRight(64, 220));
    	wallElements.add(new MazeThickCornerDownRight(57, 241));
    	wallElements.add(new MazeThickCornerUpLeft(20, 244));
    	wallElements.add(new MazeThickCornerDownLeft(20, 248));
    	wallElements.add(new MazeThickCornerUpRight(88, 244));
    	wallElements.add(new MazeThickCornerDownRight(88, 248));
    	wallElements.add(new MazeWallHorizontal(24, 244));
    	wallElements.add(new MazeWallHorizontal(34, 244));
    	wallElements.add(new MazeWallHorizontal(44, 244));
    	wallElements.add(new MazeWallHorizontal(47, 244));
    	wallElements.add(new MazeWallHorizontal(71, 244));
    	wallElements.add(new MazeWallHorizontal(78, 244));
    	wallElements.add(new MazeWallHorizontal(24, 251));
    	wallElements.add(new MazeWallHorizontal(34, 251));
    	wallElements.add(new MazeWallHorizontal(44, 251));
    	wallElements.add(new MazeWallHorizontal(54, 251));
    	wallElements.add(new MazeWallHorizontal(64, 251));
    	wallElements.add(new MazeWallHorizontal(74, 251));
    	wallElements.add(new MazeWallHorizontal(78, 251));
    	wallElements.add(new MazeWallVertical(60, 224));
    	wallElements.add(new MazeWallVertical(60, 231));
    	wallElements.add(new MazeWallVertical(67, 224));
    	wallElements.add(new MazeWallVertical(67, 231));

    	wallElements.add(new MazeThickCornerUpLeft(156, 220));
    	wallElements.add(new MazeThickCornerDownLeft(163, 241));
    	wallElements.add(new MazeThickCornerUpRight(160, 220));
    	wallElements.add(new MazeThickCornerDownRight(153, 241));
    	wallElements.add(new MazeThickCornerUpLeft(132, 244));
    	wallElements.add(new MazeThickCornerDownLeft(132, 248));
    	wallElements.add(new MazeThickCornerUpRight(200, 244));
    	wallElements.add(new MazeThickCornerDownRight(200, 248));
    	wallElements.add(new MazeWallHorizontal(136, 244));
    	wallElements.add(new MazeWallHorizontal(143, 244));
    	wallElements.add(new MazeWallHorizontal(167, 244));
    	wallElements.add(new MazeWallHorizontal(177, 244));
    	wallElements.add(new MazeWallHorizontal(187, 244));
    	wallElements.add(new MazeWallHorizontal(190, 244));
    	wallElements.add(new MazeWallHorizontal(136, 251));
    	wallElements.add(new MazeWallHorizontal(146, 251));
    	wallElements.add(new MazeWallHorizontal(156, 251));
    	wallElements.add(new MazeWallHorizontal(166, 251));
    	wallElements.add(new MazeWallHorizontal(176, 251));
    	wallElements.add(new MazeWallHorizontal(186, 251));
    	wallElements.add(new MazeWallHorizontal(190, 251));
    	wallElements.add(new MazeWallVertical(156, 224));
    	wallElements.add(new MazeWallVertical(156, 231));
    	wallElements.add(new MazeWallVertical(163, 224));
    	wallElements.add(new MazeWallVertical(163, 231));

    	wallElements.add(new MazeJankFixer(84, 124));
    	wallElements.add(new MazeJankFixer(85, 124));
    	wallElements.add(new MazeJankFixer(86, 124));
    	wallElements.add(new MazeJankFixer(84, 125));
    	wallElements.add(new MazeJankFixer(84, 126));
    	wallElements.add(new MazeJankFixer(137, 124));
    	wallElements.add(new MazeJankFixer(138, 124));
    	wallElements.add(new MazeJankFixer(139, 124));
    	wallElements.add(new MazeJankFixer(139, 125));
    	wallElements.add(new MazeJankFixer(139, 126));
    	wallElements.add(new MazeJankFixer(84, 155));
    	wallElements.add(new MazeJankFixer(85, 155));
    	wallElements.add(new MazeJankFixer(86, 155));
    	wallElements.add(new MazeJankFixer(84, 154));
    	wallElements.add(new MazeJankFixer(84, 153));
    	wallElements.add(new MazeJankFixer(137, 155));
    	wallElements.add(new MazeJankFixer(138, 155));
    	wallElements.add(new MazeJankFixer(139, 155));
    	wallElements.add(new MazeJankFixer(139, 154));
    	wallElements.add(new MazeJankFixer(139, 153));
    	wallElements.add(new MazeJankFixer(120, 124));
    	wallElements.add(new MazeJankFixer(120, 125));
    	wallElements.add(new MazeJankFixer(120, 126));
    	wallElements.add(new MazeJankFixer(120, 127));
    	wallElements.add(new MazeJankFixer(103, 124));
    	wallElements.add(new MazeJankFixer(103, 125));
    	wallElements.add(new MazeJankFixer(103, 126));
    	wallElements.add(new MazeJankFixer(103, 127));
    	wallElements.add(new MazeGhostDoor(104, 125));
    	wallElements.add(new MazeThinWallHorizontal(87, 124));
    	wallElements.add(new MazeThinWallHorizontal(121, 124));
    	wallElements.add(new MazeThinWallVertical(84, 127));
    	wallElements.add(new MazeThinWallVertical(84, 137));
    	wallElements.add(new MazeThinWallHorizontal(87, 152));
    	wallElements.add(new MazeThinWallHorizontal(103, 152));
    	wallElements.add(new MazeThinWallHorizontal(119, 152));
    	wallElements.add(new MazeThinWallHorizontal(121, 152));
    	wallElements.add(new MazeThinWallVertical(136, 127));
    	wallElements.add(new MazeThinWallVertical(136, 137));

    	for (StationaryObject object : wallElements) {
                object.blit(canvas);
       	}
    }
    
    public static boolean[][] availableSpace() {
        boolean[][] space = new boolean[224][248];
        for (int i = 0; i < 224; i++)
            for (int j = 0; j < 248; j++)
                space[i][j] = false;
        space = HelperClass.fill(space, 4, 4, 95, 7);
        space = HelperClass.fill(space, 4, 8, 7, 63);
        space = HelperClass.fill(space, 44, 8, 47, 207);
        space = HelperClass.fill(space, 4, 36, 208, 39);
        space = HelperClass.fill(space, 4, 60, 43, 63);
        space = HelperClass.fill(space, 92, 8, 95, 35);
        space = HelperClass.fill(space, 68, 40, 71, 63);
        space = HelperClass.fill(space, 72, 60, 95, 63);
        space = HelperClass.fill(space, 92, 64, 95, 83);
        space = HelperClass.fill(space, 68, 84, 143, 87);
        space = HelperClass.fill(space, 68, 88, 71, 155);
        space = HelperClass.fill(space, 72, 132, 139, 135);
        space = HelperClass.fill(space, 140, 88, 143, 155);
        space = HelperClass.fill(space, 144, 108, 163, 111);
        space = HelperClass.fill(space, 48, 108, 67, 111);
        space = HelperClass.fill(space, 4, 156, 95, 159);
        space = HelperClass.fill(space, 4, 160, 7, 183);
        space = HelperClass.fill(space, 8, 180, 23, 183);
        space = HelperClass.fill(space, 20, 184, 23, 203);
        space = HelperClass.fill(space, 4, 204, 47, 207);
        space = HelperClass.fill(space, 4, 208, 7, 227);
        space = HelperClass.fill(space, 4, 228, 207, 231);
        space = HelperClass.fill(space, 48, 180, 163, 183);
        space = HelperClass.fill(space, 92, 156, 95, 179);
        space = HelperClass.fill(space, 68, 184, 71, 207);
        space = HelperClass.fill(space, 72, 204, 91, 207);
        space = HelperClass.fill(space, 92, 204, 95, 227);
        for (int i = 105; i < 212; i++)
            for (int j = 0; j < 248; j++)
                space[i][j] = space[211-i][j];
        return space;
    }
}
