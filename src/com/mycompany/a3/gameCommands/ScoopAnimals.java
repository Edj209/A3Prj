package com.mycompany.a3.gameCommands;

import java.util.Iterator;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.geom.Point2D;
import com.mycompany.a3.GameObject;
import com.mycompany.a3.GameWorld;
import com.mycompany.a3.Sound;
import com.mycompany.a3.gameObjects.Cats;
import com.mycompany.a3.gameObjects.Dogs;
import com.mycompany.a3.gameObjects.Nets;

public class ScoopAnimals extends Command {
	Sound ScoopSounds = new Sound("blip.wav");
	
	public ScoopAnimals(String command) {
		super(command);
		// TODO Auto-generated constructor stub
	}
	GameWorld gameWorldPass;
	public void setTarget (GameWorld g) {
        gameWorldPass = g;
    }

	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		scoop();
		
	}
	
	//scoops up all the animals in the net
    public void scoop() {
    	GameObject net;
    	GameObject object;
    	Iterator<GameObject> it = gameWorldPass.getGameWorldCollection().getIterator();
    	Iterator<GameObject> itCopy = it;
        Point2D netObjLocation = new Point2D(0, 0);

        //gets the net location
        while(itCopy.hasNext()){
        	net = itCopy.next();
        	if (net instanceof Nets) {
        		itCopy = gameWorldPass.getGameWorldCollection().getIterator();
        		while (itCopy.hasNext()) {
                    object = itCopy.next();

                    if (((Nets) net).collidesWith(object)) {
                        //if a cat is in the net delete it
                        if (object instanceof Cats) {
                            gameWorldPass.setCatsCaptured(gameWorldPass.getCatsCaptured()+1);
                            if(gameWorldPass.getCatsRemaining() > 0)	
                            	gameWorldPass.setCatsRemaining(gameWorldPass.getCatsRemaining()-1);
                            gameWorldPass.setTotalScore(gameWorldPass.getTotalScore()-10);
                            it = itCopy;
                            it.remove();
                            if(gameWorldPass.isSound())
                            ScoopSounds.play();
                            
                        }

                        else if (object instanceof Dogs) {
                            gameWorldPass.setDogsCaptured(gameWorldPass.getDogsCaptured()+1);
                            gameWorldPass.setDogsRemaining(gameWorldPass.getDogsRemaining()-1);
                            gameWorldPass.setTotalScore(gameWorldPass.getTotalScore() + 10 - ((Dogs) object).getScratches());
                            it = itCopy;
                            it.remove();
                            ScoopSounds.play();
                           
                        }
                        break;
                    }
                }
        	}
        }

//        it = gameWorldPass.getGameWorldCollection().getIterator();
//
//        while (it.hasNext()) {
//            object = it.next();
//
//            if (object.getObjLocation().equals(netObjLocation)) {
//                //if a cat is in the net delete it
//                if (object instanceof Cats) {
//                    gameWorldPass.setCatsCaptured(gameWorldPass.getCatsCaptured()+1);
//                    if(gameWorldPass.getCatsRemaining() > 0)	
//                    	gameWorldPass.setCatsRemaining(gameWorldPass.getCatsRemaining()-1);
//                    gameWorldPass.setTotalScore(gameWorldPass.getTotalScore()-10);
//                    it.remove();
//                }
//
//                else if (object instanceof Dogs) {
//                    gameWorldPass.setDogsCaptured(gameWorldPass.getDogsCaptured()+1);
//                    gameWorldPass.setDogsRemaining(gameWorldPass.getDogsRemaining()-1);
//                    gameWorldPass.setTotalScore(gameWorldPass.getTotalScore() + 10 - ((Dogs) object).getScratches());
//                    it.remove();
//                }
//            }
//        }
        gameWorldPass.notifyObservers();
        System.out.println("I made it here SCOOP Button");
    }
}
    
