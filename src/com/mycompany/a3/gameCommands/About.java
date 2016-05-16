package com.mycompany.a3.gameCommands;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class About extends Command {

	public About(String command) {
		super(command);
		// TODO Auto-generated constructor stub
	}
	GameWorld gameWorldPass;
	public void setTarget (GameWorld g) {
        gameWorldPass = g;
    }

	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		about();
		
	}
	//expands the net
    public void about(){
    	Button okButton = new Button("ok");
    	Ok ok = new Ok("ok");
    	okButton.getAllStyles().setAlignment(Component.CENTER);
    	okButton.setVisible(false);
    	
    	
    	Dialog.setCommandsAsButtons(true);
    	Dialog.show(null, "Author: Edgar Jimenez \n Course: 133 \n Version: 1.03", "ok", null);
//    	Dialog.show("Author: Edgar Jimenez \n Course: 133 \n Version: 1.03", okButton, ok);
    	
        System.out.println("I MADE IT HERE about BUTTON");
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
