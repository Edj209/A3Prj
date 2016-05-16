package com.mycompany.a3.gameObjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import com.mycompany.a3.GameObject;

import java.util.Random;

/**
 * Created by Edgar on 2/23/2016.
 */
public class Dogs extends Animals implements IDrawable, ICollider, ISelectable{
    ColorUtil color = new ColorUtil();
    Random randomNum = new Random();
    boolean inCollision = false;
    boolean selected = false;
    
    
    public void setInCollision(boolean inCollision) {
		this.inCollision = inCollision;
	}


	//color 
    public int chooseColor() {
    	if(this.scratches == 1)
    		return color.GREEN;
    	if(this.scratches == 2)
    		return color.BLUE;
    	if(this.scratches == 3)
    		return color.LTGRAY;
    	if(this.scratches == 4)
    		return color.MAGENTA;
    	if(this.scratches == 5)
    		return color.WHITE;
    	return color.BLACK;
    }
    //end of color
    

    public int getScratches() {
        return scratches;
    }

    public void setScratches(int scratches) {
        this.scratches = scratches;
    }

    private int scratches;
    private int speed;


    public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public Dogs() {
        speed = 5;
        scratches = 0;
        direction = randomNum.nextInt(360);
    }

    //color of dog may change
    @Override
    public void changeColor() {
        int R = 255;
        int G = 255;
        int B = 255;

        color.rgb(R, G, B);
    }

    
    public void move(int m) {
//        direction = direction + randInt(-1, 1);
        int theta = 90 - direction;
        Math.toRadians((double)theta);
        //update new location
        Point2D newLocation = new Point2D(0, 0);
        newLocation.setX(getObjLocation().getX() + ((double) Math.cos(theta)) * speed);
        newLocation.setY(getObjLocation().getY() + ((double) Math.sin(theta)) * speed);
        
        if (newLocation.getX() > 1000 || newLocation.getY() > 610 || newLocation.getX() < 0 || newLocation.getY() < 0){
        	direction = direction + 180;
        	
        }
        
        this.setObjLocation((com.codename1.ui.geom.Point2D) newLocation);
        
//        Point2D newLocation;
//        newLocation.setLocation(getObjLocation().x + ((float) Math.cos(theta) * speed, getObjLocation().y + ((float) Math.sin(theta) * speed);
//        newLocation.y = getObjLocation().y + ((float) Math.sin(theta) * speed);
//        setObjLocation(newLocation);

    }

    public void scratched () {
        scratches++;
        speed--;
        if (scratches > 5)
            scratches = 5;
        if (speed < 0)
            speed = 0;

    }
    public static int randInt(int min, int max) {
        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    //print for map
    public String toString(){
        System.out.print("Dog: ");
        String parentDesc = super.toString();
        String myDesc = " direction=" + this.direction + " speed=" + this.speed + " size=" + this.getSize() + " scratches= " + this.scratches;
        return parentDesc + myDesc;
    }

    public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(chooseColor());
		if(!isSelected())
		g.fillArc((int)this.getObjLocation().getX()+pCmpRelPrnt.getX(), (int)this.getObjLocation().getY()+pCmpRelPrnt.getY(), this.getSize(), this.getSize(), 0, 360);
		else {
			g.drawArc((int)this.getObjLocation().getX()+pCmpRelPrnt.getX(), (int)this.getObjLocation().getY()+pCmpRelPrnt.getY(), this.getSize(), this.getSize(), 0, 360);
		}
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
		}
		return result;	
	}

	public void handleCollision(ICollider otherObject) {
		// TODO Auto-generated method stub
		
	}


	public void setSelected(boolean yesNo) {
		selected = yesNo;
		
	}


	public boolean isSelected() {
		return selected;
	}


	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		int px = pPtrRelPrnt.getX(); // pointer location relative to
		int py = pPtrRelPrnt.getY(); // parent’s origin
		int xLoc = (int) (pCmpRelPrnt.getX()+ this.getObjLocation().getX());// shape location relative
		int yLoc = (int) (pCmpRelPrnt.getY()+ this.getObjLocation().getY());// to parent’s origin
		if ( (px >= xLoc) && (px <= xLoc+this.getSize())
		&& (py >= yLoc) && (py <= yLoc+this.getSize()) )
		return true; else return false;
	}
}
