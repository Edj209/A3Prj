package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.Border;

import java.util.Observable;
import java.util.Observer;

public class ScoreView extends Container implements Observer{
	private final GameWorld gameWorldPass;
	Label totalScore, dogsCaptured, catsCaptured, dogsRemaining, catsRemaining, sound;
	
	
	public ScoreView (GameWorld g){
		
		gameWorldPass = g;
		//set container type
		this.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
		
		//labels for name
		 totalScore = new Label("Total Score: " + gameWorldPass.getTotalScore());
		 dogsCaptured = new Label("Dogs Captured: " + gameWorldPass.getDogsCaptured());
		 catsCaptured = new Label("Cats Captured: "+ gameWorldPass.getCatsCaptured());
		 dogsRemaining = new Label("Dogs Remaining: " + gameWorldPass.getDogsRemaining());
		 catsRemaining = new Label("Cats Remaining: " + gameWorldPass.getCatsRemaining());
		 sound = new Label("Sound: " + (gameWorldPass.isSound() ? "On" : "Off"));
		
		//labels for score; these are updated
		
		//add labels to container
		this.add(totalScore);
		this.add(dogsCaptured);
		this.add(catsCaptured);
		this.add(dogsRemaining);
		this.add(catsRemaining);
		this.add(sound);
		
	}
    
    public void update(Observable o, Object arg) {
    	
    	totalScore.setText("Total Score: " + gameWorldPass.getTotalScore());
		 dogsCaptured.setText("Dogs Captured: " + gameWorldPass.getDogsCaptured());
		 catsCaptured.setText("Cats Captured: "+ gameWorldPass.getCatsCaptured()); 
		 dogsRemaining.setText("Dogs Remaining: " + gameWorldPass.getDogsRemaining()); 
		 catsRemaining.setText("Cats Remaining: " + gameWorldPass.getCatsRemaining()); 
		 
		 if(!gameWorldPass.isSound())
			 sound.setText("Sound: " + "off"); 
		 else
			 sound.setText("Sound: " + "on"); 
    	
    	
    }
}
