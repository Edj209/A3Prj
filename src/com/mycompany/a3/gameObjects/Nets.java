package com.mycompany.a3.gameObjects;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import com.mycompany.a3.GameObject;

/**
 * Created by Edgar on 2/23/2016.
 */
public class Nets extends Catchers implements IDrawable, ICollider{


    public Nets () {
        setSize(100);
    }

   
    public void left() {
        Point2D objLocation = new Point2D((float)this.getObjLocation().getX()-5, (float) this.getObjLocation().getY());
        this.setObjLocation(objLocation);
    }

    
    public void right() {
        Point2D objLocation = new Point2D((float)this.getObjLocation().getX()+5, (float) this.getObjLocation().getY());
        this.setObjLocation(objLocation);
    }

    
    public void up() {
        Point2D objLocation = new Point2D((float)this.getObjLocation().getX(), (float) this.getObjLocation().getY()+5);
        this.setObjLocation(objLocation);
    }

    
    public void down() {
        Point2D objLocation = new Point2D((float)this.getObjLocation().getX(), (float) this.getObjLocation().getY()-5);
        this.setObjLocation(objLocation);
    }

    
    public void jumpToRandomDog(Point2D dogObjLocation) {
        this.setObjLocation(dogObjLocation);
    }

    
    public void jumpToRandomCat(Point2D catObjLocation) {
        this.setObjLocation(catObjLocation);
    }

    @Override
    public void changeColor() {

    }

    public String toString(){
        System.out.print("Net: ");
        String parentDesc = super.toString();
        String myDesc = " size=" + this.getSize();
        return parentDesc + myDesc;
    }


	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		g.setColor(this.getColor().CYAN);
		g.drawRect((int)this.getObjLocation().getX()+pCmpRelPrnt.getX(),
				(int)this.getObjLocation().getY()+pCmpRelPrnt.getY(), this.getSize(), this.getSize());
		
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
		
	}
}
