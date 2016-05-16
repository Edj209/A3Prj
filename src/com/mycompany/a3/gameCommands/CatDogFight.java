package com.mycompany.a3.gameCommands;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameObject;
import com.mycompany.a3.GameWorld;
import com.mycompany.a3.gameObjects.Cats;
import com.mycompany.a3.gameObjects.Dogs;

public class CatDogFight extends Command {
	public CatDogFight(String command) {
		super(command);
		// TODO Auto-generated constructor stub
	}
	GameWorld gameWorldPass;
	public void setTarget (GameWorld g) {
        gameWorldPass = g;
    }

	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		catDogFight();
		
	}
	//expands the net
    public void catDogFight(){
    	Iterator<GameObject> it = gameWorldPass.getGameWorldCollection().getIterator();
    	Set<Cats> uniqueCats = new HashSet<Cats>();
    	
        while(it.hasNext()) {
        	GameObject cat = it.next();
        	if(cat instanceof Cats){
                Cats uniqueCat = (Cats) cat;
                uniqueCats.add(uniqueCat);
            }
        }
        int uniqueItemCounter = uniqueCats.size();
        if(uniqueItemCounter > 0) {
        	it = gameWorldPass.getGameWorldCollection().getIterator();
        	while(it.hasNext()){
        		GameObject dog = it.next();
        		
                if (dog instanceof Dogs) {
                    ((Dogs) dog).scratched();
                    dog.changeColor();
                    break;
                }
            }
        }
        gameWorldPass.notifyObservers();
        System.out.println("I MADE IT HERE CAT DOG FIGHT BUTTON");
    }

}
