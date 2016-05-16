package com.mycompany.a3.gameObjects;


import com.codename1.ui.util.UITimer;
import com.mycompany.a3.GameObject;

public class Kitten extends Cats implements ICollider{
	
	private boolean mature;
	public boolean isMature() {
		return mature;
	}
	public void setMature(boolean mature) {
		this.mature = mature;
	}
	public Kitten(){
		mature = false;
	}
	
	@Override
	public void handleCollision(ICollider otherObject) {
		
	}
	

}
