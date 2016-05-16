package com.mycompany.a3.gameObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import com.mycompany.a3.GameObject;
import com.mycompany.a3.GameWorld;
import com.mycompany.a3.Sound;
import com.mycompany.a3.gameCommands.ProduceKitten;


/**
 * Created by Edgar on 2/23/2016.
 */
public class Cats extends Animals implements IDrawable, ICollider {
	Sound catCollision = new Sound("cat_meow_x.wav");
	Sound catDogFight = new Sound("cat_growl.wav");
	private boolean mature = true;
	public boolean isMature() {
		return mature;
	}

	public void setMature(boolean mature) {
		this.mature = mature;
	}

	ProduceKitten kittenMaker = ProduceKitten.getInstance();
	ArrayList<GameObject> collidedWith = new ArrayList<GameObject>();
	
	GameWorld gameWorldPass;
	public void setTarget (GameWorld g) {
        gameWorldPass = g;
    }
	
    Random randomNum = new Random();
    private int theta;
    private int thetaX;
    private int thetaY;


    public Cats() {
        speed = 2;
        direction = randomNum.nextInt(360);
    }

    //empty
    @Override
    public void changeColor() {
    }

    
    public void move(int m) {
//        direction = direction + randInt(-1, 1);
        int theta = 90 - direction;
        Math.toRadians((double)theta);
        //update new location
        Point2D newLocation = new Point2D(0, 0);
        newLocation.setX((getObjLocation().getX() + ((double) Math.cos(theta)) * speed));
        newLocation.setY((getObjLocation().getY() + ((double) Math.sin(theta)) * speed));
        
        if (newLocation.getX() > 1000 || newLocation.getY() > 610 || newLocation.getX() < 0 || newLocation.getY() < 0){
        	direction = direction + 180;
        	
        }
        
        this.setObjLocation((com.codename1.ui.geom.Point2D) newLocation);
        
//        Point2D newLocation;
//        newLocation.setLocation(getObjLocation().x + ((float) Math.cos(theta) * speed, getObjLocation().y + ((float) Math.sin(theta) * speed);
//        newLocation.y = getObjLocation().y + ((float) Math.sin(theta) * speed);
//        setObjLocation(newLocation);

    }
    
    public static int randInt(int min, int max) {
        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public String toString(){
        System.out.print("Cat: ");
        String parentDesc = super.toString();
        String myDesc = " direction=" + this.direction + " speed=" + this.speed + " size=" + this.getSize();
        return parentDesc + myDesc;
    }

	public void draw(Graphics g, Point pCmpRelPrnt) {
		int[] xPoints = {(int) this.getObjLocation().getX()+pCmpRelPrnt.getX(),
				(int) this.getObjLocation().getX()+this.getSize()+pCmpRelPrnt.getX(),
				(int) this.getObjLocation().getX()+(this.getSize()/2)+pCmpRelPrnt.getX()};
		int[] yPoints = {(int) this.getObjLocation().getY()+pCmpRelPrnt.getY(),
				(int) this.getObjLocation().getY()+pCmpRelPrnt.getY(),
				(int) this.getObjLocation().getY()+this.getSize()+pCmpRelPrnt.getY()};
		g.setColor(this.getColor().YELLOW);
		g.fillPolygon(xPoints, yPoints, 3);
	}

	public boolean collidesWith(GameObject otherObject) {
		boolean result = false;
		int thisX = (int) this.getObjLocation().getX();
		int thisY = (int) this.getObjLocation().getY();
		int otherX =  (int) otherObject.getObjLocation().getX();
		int otherY = (int) otherObject.getObjLocation().getY();
		
		if(this.getObjLocation().getX() < otherObject.getObjLocation().getX() + otherObject.getSize() &&
				this.getObjLocation().getX() + this.getSize() > otherObject.getObjLocation().getX() &&
				this.getObjLocation().getY() < otherObject.getObjLocation().getY() + otherObject.getSize() &&
				this.getSize() + this.getObjLocation().getY() > otherObject.getObjLocation().getY()) {
			result = true;
			return result;
		}
		
		return result;	
	}

	public void handleCollision(ICollider otherObject) {
		// may have to set a flag to prevent multiple collisions
		if (collidedWith.contains(otherObject)){
			return;
		}
		else if (otherObject instanceof Dogs) {
				 
				 ((Dogs) otherObject).scratched();
				 ((Dogs) otherObject).changeColor();
				 collidedWith.add((GameObject) otherObject);
				 
				 
				 catDogFight.play();
			 }
		else if (otherObject instanceof Cats) {
			kittenMaker.catCollision(otherObject);
			collidedWith.add((GameObject) otherObject);
			
	
			catCollision.play();
			
		}
		
		
		
	}
}
