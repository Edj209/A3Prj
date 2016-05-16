package com.mycompany.a3.gameCommands;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.geom.Point2D;
import com.mycompany.a3.GameObject;
import com.mycompany.a3.GameWorld;
import com.mycompany.a3.gameObjects.Cats;
import com.mycompany.a3.gameObjects.ICollider;
import com.mycompany.a3.gameObjects.Kitten;

public class ProduceKitten extends Command {
	private static ProduceKitten produceKitten = new ProduceKitten("Kitten");
	
	public static ProduceKitten getInstance(){
		return produceKitten;
	}
	
	private ProduceKitten(String command) {
		super(command);
		// TODO Auto-generated constructor stub
	}
	GameWorld gameWorldPass;
	public void setTarget (GameWorld g) {
        gameWorldPass = g;
    }

	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		catCollision2(null);
		
	}
	//expands the net
	public void catCollision(ICollider otherObject) {
				if(((Cats)otherObject).isMature() == false)
					return;
		
        		if(otherObject instanceof Cats){
                    Point2D objLocation = new Point2D((float) ((Cats)otherObject).getObjLocation().getX()+30, (float) ((Cats)otherObject).getObjLocation().getY()+30);
                    Kitten kitty = new Kitten();
                    kitty.setSize(randInt(20, 50));
                    kitty.setObjLocation(objLocation);
                    kitty.initialColor();
                    kitty.setMature(false);
                    
                    gameWorldPass.getGameWorldCollection().add(kitty);
//                  GameObjects.add(kitty);
                    gameWorldPass.setCatsRemaining(gameWorldPass.getCatsRemaining()+1);
                    
                 }
        	
            
        
        gameWorldPass.notifyObservers();
        System.out.println("I MADE IT HERE CAT COLLISION");
    }
	//backup of catCollision method code
	public void catCollision2(ICollider otherObject) {
			Iterator<GameObject> it = gameWorldPass.getGameWorldCollection().getIterator();
			
	        Set<Cats> uniqueCats = new HashSet<Cats>();
	        
	        while(it.hasNext()){
	        	GameObject cat = it.next();
	        	if(cat instanceof Cats){
	                Cats uniqueCat = (Cats) cat;
	                uniqueCats.add(uniqueCat);
	            }
	        }
	        	
	        int uniqueItemCounter = uniqueCats.size();
	        
	        if(uniqueItemCounter >= 2){
	        	it = gameWorldPass.getGameWorldCollection().getIterator();
	        	
	        	while(it.hasNext()){
	        		GameObject cat = it.next();
	        		if(cat instanceof Cats){
	                    Point2D objLocation = new Point2D((float) cat.getObjLocation().getX()+30, (float) cat.getObjLocation().getY()+30);
	                    Cats kitty = new Cats();
	                    kitty.setSize(randInt(20, 50));
	                    kitty.setObjLocation(objLocation);
	                    kitty.initialColor();
	                    
	                    gameWorldPass.getGameWorldCollection().add(kitty);
//	                  GameObjects.add(kitty);
	                    gameWorldPass.setCatsRemaining(gameWorldPass.getCatsRemaining()+1);
	                    break;
	                 }
	        	}
	            
	        }
	        gameWorldPass.notifyObservers();
	        System.out.println("I MADE IT HERE CAT COLLISION");
	    }
	
	public static int randInt(int min, int max) {
        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
