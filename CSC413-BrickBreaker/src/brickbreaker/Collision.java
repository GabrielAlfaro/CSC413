/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainbowreef2;

/**
 *
 * @author Gabriel
 */
import java.util.ArrayList;
import java.awt.Rectangle;

public class Collision {

    GameEvent ge1, ge2;
    private ArrayList<Brick> totalBricks = new ArrayList<>();

    private boolean isCleared = false;

    public Collision(GameEvent ge1, GameEvent ge2) {
        this.ge1 = ge1;
        this.ge2 = ge2;

    }

    //getter and setter for brickList to remove bricks
    public ArrayList getBricks() {
        return totalBricks;
    }

    public void setBrickList(ArrayList a) {
        this.totalBricks = a;
    }

    public void setCleared(boolean b) {
        this.isCleared = b;
    }

    public void paddleVSball(Paddle p, Ball b) {
        //passing in paddle object and ball object
        //when the player hits the ball
        Rectangle p_box = new Rectangle(p.getX(), p.getY(), p.getWidth(), p.getHeight());
        //   System.out.println("X: "+p.getX()+"Y: "+p.getY()+"W: "+p.getWidth()+"H: "+p.getHeight());
        Rectangle b_box = new Rectangle(b.getX(), b.getY(), b.getWidth(), b.getHeight());

        if (p_box.intersects(b_box)) {
            //collision
            //if ball is going +y and -x
            if (b.getVY() > 0 || b.getVY() < 0) {
                b.setVY(b.getVY() * -1);
            }
            if (b.getY() < p.getY()) {//if the ball is inside the paddle
                b.setVX(b.getVX() * -1);
                b.setVX(b.getVX() * -1);
            }
        }
    }

    public void ballVSbrick(Ball bb, Brick br) {
        //passed in is a Brick from brick list
        Rectangle bb_box = new Rectangle(bb.getX(), bb.getY(), bb.getWidth(), bb.getHeight());
        Rectangle br_box = new Rectangle(br.getX(), br.getY(), br.getWidth(), br.getHeight());

        if (bb_box.intersects(br_box)) {
            //collision
            if (bb.getVX() < 0 && bb.getVY() < 0) {//-x,-y
                bb.setVY(bb.getVY() * -1);
                //remove brick
                //totalBricks.get(i)
            }//Inconsistent with collision
            else if (bb.getVX() > 0 && (bb.getVY() > 0)) {//+x,+y
                bb.setVY(bb.getVY() * -1);
            }//works
            else if (bb.getVX() < 0 && (bb.getVY() > 0)) {//-x,+y
                bb.setVY(bb.getVY() * -1);
            }//also inconsistent with collision
            else if(bb.getVX()>0 && bb.getVY()<0){//+x,-y
                bb.setVY(bb.getVY()*-1);
            }
        }
        if (totalBricks.isEmpty()) {
            this.setCleared(true);
        }
        //when the ball hits a brick
        //remove the brick
        //update velocity of ball

    }

}
