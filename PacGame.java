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
}
