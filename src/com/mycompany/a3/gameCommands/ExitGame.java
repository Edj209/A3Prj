package com.mycompany.a3.gameCommands;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class ExitGame extends Command{
	public ExitGame(String command) {
		super(command);
		// TODO Auto-generated constructor stub
	}
	GameWorld gameWorldPass;
	public void setTarget (GameWorld g) {
        gameWorldPass = g;
    }

	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		quit();
		
	}
	//expands the net
    public void quit(){
    	Button yesButton = new Button("yes");
    	yesButton.getAllStyles().setAlignment(Component.CENTER);
    	yesButton.setVisible(false);
    	
    	Button noButton = new Button("no");
    	
    	Yes yes = new Yes("yes");
    	No no = new No("no");
    	
    	noButton.setCommand(no);
    	
    	Dialog.setCommandsAsButtons(true);
    	Dialog.show("Are you sure you want to quit?",yesButton,yes,no);
    	
    	
    	
        System.out.println("I MADE IT HERE quit BUTTON");
    }
    
    private class Yes extends Command{

		public Yes(String command) {
			super(command);
			// TODO Auto-generated constructor stub
		}
		
		public void actionPerformed(ActionEvent evt) {
			// TODO Auto-generated method stub
			System.out.println("Thanks for playing!");
			System.exit(0);
		}
    	
    }
    
    private class No extends Command {

		public No(String command) {
			super(command);
			// TODO Auto-generated constructor stub
		}
		
		public void actionPerformed(ActionEvent evt) {
			// TODO Auto-generated method stub
		
			
		}
    	
    }

}
