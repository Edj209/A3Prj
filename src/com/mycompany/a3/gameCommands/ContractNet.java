package com.mycompany.a3.gameCommands;

import java.util.Iterator;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameObject;
import com.mycompany.a3.GameWorld;
import com.mycompany.a3.gameObjects.Nets;

public class ContractNet extends Command {
	public ContractNet(String command) {
		super(command);
		// TODO Auto-generated constructor stub
	}
	GameWorld gameWorldPass;
	public void setTarget (GameWorld g) {
        gameWorldPass = g;
    }

	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		contract();
		
	}
	//expands the net
    public void contract(){
    	Iterator<GameObject> it = gameWorldPass.getGameWorldCollection().getIterator();
    	
        while(it.hasNext()) {
        	GameObject net = it.next();
        	
        	if (net instanceof Nets) {
                net.setSize(net.getSize()-5);
                if(net.getSize()<50)
                    net.setSize(50);
            }
        }
        System.out.println("I MADE IT HERE contract BUTTON");
    }

}
