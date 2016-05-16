package com.mycompany.a3.gameCommands;

import java.util.Iterator;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game;
import com.mycompany.a3.GameObject;
import com.mycompany.a3.GameWorld;
import com.mycompany.a3.gameObjects.Dogs;
import com.mycompany.a3.gameObjects.Nets;

public class Heal extends Command{
	public Heal(String command) {
		super(command);
		// TODO Auto-generated constructor stub
	}
	Game gamePass;
	public void setTarget (Game g) {
        gamePass = g;
    }
	GameWorld gameWorldPass;
	public void setTarget (GameWorld gw) {
        gameWorldPass = gw;
    }

	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		heal();
		
	}
	//toggles pause play
	public void heal() {
		if(gameWorldPass.isPause()){
			Iterator<GameObject> it = ((GameWorld)gameWorldPass).getGameWorldCollection().getIterator();
			while(it.hasNext()){
				GameObject item = it.next();
				if (item instanceof Dogs && ((Dogs) item).isSelected()){
					((Dogs)item).setScratches(0);
					((Dogs)item).setSpeed(5);
				}
			}
		}
		
        System.out.println("I MADE IT HERE heal BUTTON");
	}
}
