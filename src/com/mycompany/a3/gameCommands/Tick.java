package com.mycompany.a3.gameCommands;

import java.util.Iterator;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameObject;
import com.mycompany.a3.GameWorld;
import com.mycompany.a3.gameObjects.IMoving;

public class Tick extends Command{
	public Tick(String command) {
		super(command);
		// TODO Auto-generated constructor stub
	}
	static GameWorld gameWorldPass;
	public void setTarget (GameWorld g) {
        gameWorldPass = g;
    }

	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
		
	}
	//expands the net
    public static void tick(int millisec){
    	Iterator<GameObject> it = gameWorldPass.getGameWorldCollection().getIterator();
    	
        while(it.hasNext()) {
        	GameObject gameObject = it.next();
        	if(gameObject instanceof IMoving) {
                ((IMoving) gameObject).move(millisec);
            }
        }
        if (gameWorldPass.getDogsRemaining() <= 0) {
            System.out.println("Game Over, all dogs captured.");
            System.exit(0);
        }
        gameWorldPass.notifyObservers();
        System.out.println("I MADE IT HERE tick BUTTON");
    }
    
	

}
