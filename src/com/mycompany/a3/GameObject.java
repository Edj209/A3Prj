package com.mycompany.a3;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

/**
 * Created by Edgar on 2/23/2016.
 */
public abstract class GameObject {

    Random randomNum = new Random();

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ColorUtil getColor() {
        return color;
    }

    public void setColor(ColorUtil color) {
        this.color = color;
    }

    

    private Point2D objLocation;
    public Point2D getObjLocation() {
		return objLocation;
	}

	public void setObjLocation(Point2D objLocation) {
		this.objLocation = objLocation;
	}



	private ColorUtil color = new ColorUtil();
    public abstract void changeColor();
    private int size;

    //set the color of each object
    public void initialColor() {
        int randomR = this.randomNum.nextInt(255);
        int randomG = this.randomNum.nextInt(255);
        int randomB = this.randomNum.nextInt(255);

        color.rgb(randomR, randomG, randomB);
    }

    public String toString(){
        return "location=" + this.objLocation + " color=" + this.color;
    }





}
