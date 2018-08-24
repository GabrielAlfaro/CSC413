
package rainbowreef2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.util.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import javax.swing.JApplet;
import java.awt.image.*;
import javax.swing.*;

/**
 *
 * @author Gabriel
 */
public class RainbowReef2 extends JApplet implements Runnable {

    private Thread thread;

    Graphics2D g2;
    private BufferedImage paddleImg, ballImg, enemy, firstEnemy;
    private BufferedImage background, border, quit;
    private BufferedImage start, startScreen, endScreen;
    private BufferedImage[] bricks = new BufferedImage[11];

    GameEvent ge1, ge2;

    static Random rand = new Random();

    private BufferedImage pbimg;
    Collision CD;
    Paddle paddleObj;
    Ball ballObj;

    public int lives;

    boolean boardCleared, secondBoardCleared;

    public static int ScreenW = 640;
    public static int ScreenH = 480;
    //create an arrayList of bricks

    private ArrayList<Brick> brickObj = new ArrayList<>();

    private BufferedImageLoader loader;

    
    public static void main(String[] args) {
        RainbowReef2 rr = new RainbowReef2();
        rr.init();
        //intialize values, images and create objects objects
        JFrame f = new JFrame("Super Rainbow Reef");
        // f.addWindowListener(new WindowAdapter(){      
        // });
        f.getContentPane().add("Center", rr);
        f.pack();
        f.setSize(new Dimension(ScreenW, ScreenH));
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rr.start();
        //draw game

    }

    @Override
    public void run() {
        Thread me = Thread.currentThread();
        while (thread == me) {
            repaint();
            try {
                thread.sleep(25);
            } catch (InterruptedException e) {
                break;
            }

        }
    }

    @Override
    public void start() {
        System.out.println();
        thread = new Thread(this);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
    }

    @Override
    public void init() {
        setFocusable(true);
        setBackground(Color.white);
        BufferedImageLoader loader = new BufferedImageLoader();

        paddleImg = loader.loadImage("/res/Shell.png");
        ballImg = loader.loadImage("/res/Pop.png");
        enemy = loader.loadImage("/res/Bigleg_small.png");
        firstEnemy = loader.loadImage("/res/Bigleg.png");
        background = loader.loadImage("/res/background1.jpg");
        border = loader.loadImage("/res/wall.jpg");
        quit = loader.loadImage("/res/Quit.jpg");
        start = loader.loadImage("/res/StartButton.jpg");
        startScreen = loader.loadImage("/res/TitleScr.jpg");
        endScreen = loader.loadImage("/res/TitleScr.jpg");
        bricks[0] = loader.loadImage("/res/Block1.jpg");
        bricks[1] = loader.loadImage("/res/Block2.jpg");
        bricks[2] = loader.loadImage("/res/Block3.jpg");
        bricks[3] = loader.loadImage("/res/Block4.jpg");
        bricks[4] = loader.loadImage("/res/Block5.jpg");
        bricks[5] = loader.loadImage("/res/Block6.jpg");
        bricks[6] = loader.loadImage("/res/Block7.jpg");
        bricks[7] = loader.loadImage("/res/BlockDouble.jpg");
        bricks[8] = loader.loadImage("/res/BlockSolid.jpg");
        bricks[9] = loader.loadImage("/res/BlockSplit.jpg");
        bricks[10] = loader.loadImage("/res/BlockLife.jpg");
        //pass images to the objects
        paddleObj = new Paddle(paddleImg, 320, 410);
        ballObj = new Ball(ballImg, 270, 240);

        //treat enemy like bricks 
        PaddleControl pc1 = new PaddleControl(paddleObj, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
        ge1 = new GameEvent();
        ge2 = new GameEvent();

        ge1.addObserver(paddleObj);
        ge2.addObserver(ballObj);
        // ge3.addObserver(enemy1);
        addKeyListener(pc1);

        brickObj = new ArrayList<Brick>();
        //create an arraylist of bricks to hold and remove when collision happens

        //brick takes in an image
        //an x, a y and a type, brickType
        brickObj.add(new Brick(firstEnemy, ScreenW / 2 - 40, 0, 2));

        for (int i = 0; i <= 14; i++) {
            brickObj.add(new Brick(bricks[rand.nextInt(8) + 0], 40 * i, 100, 0));
        }//using random number generator to get different bricks          
        for (int j = 0; j <= 14; j++) {
            brickObj.add(new Brick(bricks[rand.nextInt(8) + 0], 40 * j, 140, 0));
        }//excluding power ups from first level
        //adding two rows of bricks for first level        
    }

    public void drawGame() {
        //1st level
        this.lives = 3;
        boardCleared = false;
        secondBoardCleared = false;

        String content = "Player Score: " + paddleObj.getScore();
        Font stringFont = new Font("SansSerif", Font.PLAIN, 30);
        g2.setColor(Color.white);
        if ((this.boardCleared)) {
            //go to second level 
            levelTwo();
            System.out.println("Go to second level");

        } else if (this.secondBoardCleared) {
            //if second level, bricks in that level are cleared
            //you win the game
            stringFont = new Font("SansSerif", Font.PLAIN, 30);
            drawEndScreen();
            g2.drawString("You WIN!", 220, 150);
        } else {
            //board1 isnt cleared and neither is board2            
            //check collision

            CD = new Collision(ge1, ge2);
            //Dynamic binding  
            CD.paddleVSball(paddleObj, ballObj);
            //check paddle and ball collision
            drawBackground();
            CD.ballVSbrick(ballObj, brickObj.get(0));
            //check collision with the enemy object

            paddleObj.render(g2, this);
            //render=draw
            ballObj.render(g2, this);
            brickObj.get(0).render(g2);
            //render the enemy brick
            //since the enemy is the first object in array
            //set for loop to start at 1

            for (int z = 1; z <= brickObj.size() - 1; z++) {
                brickObj.get(z).render(g2);
            }//rendering the brickObjects array list
            for (int q = 1; q < brickObj.size() - 1; q++) {
                CD.ballVSbrick(ballObj, brickObj.get(q));
            }//rendering the second row
            //render then update
            //passing in observable and object
            paddleObj.update(ge1, g2);
            ballObj.update(ge2, g2);
            //update the two constant objects
            //Did not implement the multiple balls powerups
            //Would just use another array list that adds 
            //ball objects when ball collides with brick types

            if (brickObj.isEmpty()) {
                //go to second level
                //create indicator to go to second level
                this.boardCleared = true;
            }
        }
    }

    public void levelTwo() {

        paddleObj = new Paddle(paddleImg, 320, 410);
        ballObj = new Ball(ballImg, 270, 240);

        //treat enemy like bricks 
        PaddleControl pc1 = new PaddleControl(paddleObj, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
        ge1 = new GameEvent();
        ge2 = new GameEvent();

        ge1.addObserver(paddleObj);
        ge2.addObserver(ballObj);
        // ge3.addObserver(enemy1);
        addKeyListener(pc1);

        CD.paddleVSball(paddleObj, ballObj);

        brickObj.add(new Brick(enemy, 0, 0, 2));

        brickObj.add(new Brick(enemy, ScreenW - 40, 0, 2));

        brickObj.add(new Brick(enemy, ScreenW / 2 - 20, 0, 2));

        for (int i = 0; i <= 15; i++) {
            brickObj.add(new Brick(bricks[rand.nextInt(10) + 0], 40 * i, 100, 0));
        }//add in random power ups to second level
        //did not implement the power ups
        for (int j = 0; j <= 15; j++) {
            brickObj.add(new Brick(bricks[rand.nextInt(8) + 0], 40 * j, 120, 1));
        }
        for (int k = 0; k <= 15; k++) {
            brickObj.add(new Brick(bricks[rand.nextInt(8) + 0], 40 * k, 120, 1));
        }//make second level have more rows and blocks       

        paddleObj.update(ge1, g2);
        ballObj.update(ge2, g2);

        for (int i = 1; i <= brickObj.size() - 1; i++) {
            brickObj.get(i).render(g2);
        }//rendering the brickObjects array list
        for (int j = 1; j <= brickObj.size() - 1; j++) {
            brickObj.get(j).render(g2);
        }
        for (int k = 1; k < brickObj.size() - 1; k++) {
            CD.ballVSbrick(ballObj, brickObj.get(k));
        }
        if (brickObj.isEmpty()) {
            this.secondBoardCleared = true;
            //return second game is true, Game Over
        }

    }

    public void drawBackground() {
        g2.drawImage(background, 0, 0, this);
        //simple draw background function
    }

    public void drawEndScreen() {
        //when the game is over, print End Screen with Message saying player won
        int endScrW = endScreen.getWidth(this);
        int endScrH = endScreen.getHeight(this);
        g2.drawImage(endScreen, endScrW, endScrH, null);
    }

    @Override
    public void paint(Graphics g) {
        //draws the images
        if (pbimg == null) {
            Dimension windowSize = getSize();
            pbimg = (BufferedImage) createImage(windowSize.width, windowSize.height);
            g2 = pbimg.createGraphics();
        }
        drawGame();
        //levelTwo();
        g.drawImage(pbimg, 0, 0, this);
    }

}
