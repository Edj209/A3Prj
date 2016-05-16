package com.mycompany.a3.gameCommands;

import java.util.Iterator;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.geom.Point2D;
import com.mycompany.a3.GameObject;
import com.mycompany.a3.GameWorld;
import com.mycompany.a3.gameObjects.Dogs;
import com.mycompany.a3.gameObjects.Nets;

public class MoveToDog extends Command {
	public MoveToDog(String command) {
		super(command);
		// TODO Auto-generated constructor stub
	}
	GameWorld gameWorldPass;
	public void setTarget (GameWorld g) {
        gameWorldPass = g;
    }

	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		netToRandomDog();
		
	}
	//expands the net
	public void netToRandomDog() {
		Iterator<GameObject> it = gameWorldPass.getGameWorldCollection().getIterator();
    	
        while(it.hasNext()) {
        	GameObject dogLocation = it.next();
        	if (dogLocation instanceof Dogs) {
                Point2D objLocation = dogLocation.getObjLocation();
                it = gameWorldPass.getGameWorldCollection().getIterator();
            	while(it.hasNext()) {
                	GameObject net = it.next();
                	if (net instanceof Nets) {
                		((Nets) net).jumpToRandomDog(objLocation);
                	}
            	}
                
        	}
        
        }
        System.out.println("I MADE IT HERE JUMP TO DOG BUTTON");
	}

}
