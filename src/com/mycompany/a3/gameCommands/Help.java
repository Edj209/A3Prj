package com.mycompany.a3.gameCommands;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class Help extends Command{
	public Help(String command) {
		super(command);
		// TODO Auto-generated constructor stub
	}
	GameWorld gameWorldPass;
	public void setTarget (GameWorld g) {
        gameWorldPass = g;
    }

	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		help();
		
	}
	//expands the net
    public void help(){
    	Button okButton = new Button("ok");
    	Ok ok = new Ok("ok");
    	okButton.getAllStyles().setAlignment(Component.CENTER);
    	okButton.setVisible(false);
    	
    	
    	Dialog.setCommandsAsButtons(true);
    	Dialog.show(null, "Instructions for game: \n e : expand the net \n c : contract the net \n s : scoop animals \n r : move right \n l : move left \n u : move up \n d : move the net down \n o : move the net to a dog \n a : move the net to a cat \n k : produce a kitten \n f : a cat and dog fight \n t : clock ticks \n x : exit game", "ok", null);
    	
        System.out.println("I MADE IT HERE help BUTTON");
    }
    
    private class Ok extends Command {

		public Ok(String command) {
			super(command);
			// TODO Auto-generated constructor stub
		}

		
		
		public void actionPerformed(ActionEvent evt) {
			// TODO Auto-generated method stub
		
			
		}
    	
    }

}
