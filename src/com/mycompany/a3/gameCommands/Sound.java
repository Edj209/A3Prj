package com.mycompany.a3.gameCommands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game;
import com.mycompany.a3.GameWorld;

public class Sound extends Command{
	
	public Sound(String command) {
		super(command);
		// TODO Auto-generated constructor stub
	}
	GameWorld gameWorldPass;
	public void setTarget (GameWorld g) {
        gameWorldPass = g;
    }
	Game gamePass;
	public void setTarget (Game g) {
        gamePass = g;
    }
	
	

	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
		sound();
		
	}
	//expands the net
    public void sound(){
    	
    	
//    	gameWorldPass.setSound();
    	if (gamePass.getSoundCheckBox().isSelected() == true){
    		gamePass.getSoundCheckBox().setSelected(false);
    		gameWorldPass.setSound();
    		
    		gamePass.getBgSound().pause();
    		
    	}
    	else if (gamePass.getSoundCheckBox().isSelected() == false){
    		gamePass.getSoundCheckBox().setSelected(true);
    		gameWorldPass.setSound();
    		gamePass.getBgSound().play();
    	}
    	
    	gameWorldPass.notifyObservers();
        System.out.println("I MADE IT HERE sound BUTTON");
    }

}
