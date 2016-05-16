package com.mycompany.a3.gameCommands;

import java.util.Iterator;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.geom.Point2D;
import com.mycompany.a3.GameObject;
import com.mycompany.a3.GameWorld;
import com.mycompany.a3.gameObjects.Cats;
import com.mycompany.a3.gameObjects.Nets;

public class MoveToCat extends Command {
	public MoveToCat(String command) {
		super(command);
		// TODO Auto-generated constructor stub
	}
	GameWorld gameWorldPass;
	public void setTarget (GameWorld g) {
        gameWorldPass = g;
    }

	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		netToRandomCat();
		
	}
	//expands the net
	public void netToRandomCat() {
		Iterator<GameObject> it = gameWorldPass.getGameWorldCollection().getIterator();
    	
        while(it.hasNext()) {
        	GameObject catLocation = it.next();
        	if (catLocation instanceof Cats) {
                Point2D objLocation = catLocation.getObjLocation();
                it = gameWorldPass.getGameWorldCollection().getIterator();
            	while(it.hasNext()) {
                	GameObject net = it.next();
                	if (net instanceof Nets) {
                		((Nets) net).jumpToRandomCat(objLocation);
                	}
            	}
                
        	}
        
        }
        System.out.println("I MADE IT HERE JUMP TO cat BUTTON");
	}
}
