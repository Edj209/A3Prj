package com.mycompany.a3.gameCommands;

import java.util.Iterator;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.geom.Point2D;
import com.mycompany.a3.GameObject;
import com.mycompany.a3.GameWorld;
import com.mycompany.a3.gameObjects.Nets;

public class MoveLeft extends Command {
	public MoveLeft(String command) {
		super(command);
		// TODO Auto-generated constructor stub
	}
	GameWorld gameWorldPass;
	public void setTarget (GameWorld g) {
        gameWorldPass = g;
    }

	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		left();
		
	}
	//expands the net
    public void left(){
    	Iterator<GameObject> it = gameWorldPass.getGameWorldCollection().getIterator();
    	
        while(it.hasNext()) {
        	GameObject net = it.next();
        	
            if (net instanceof Nets) {
            	Point2D objLocation = new Point2D((float)net.getObjLocation().getX()-5, (float) net.getObjLocation().getY());
                net.setObjLocation(objLocation);
            }
        }
        gameWorldPass.notifyObservers();
        System.out.println("I MADE IT HERE left BUTTON");
    }

}
