package com.mycompany.a3.gameCommands;

import java.util.Iterator;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.geom.Point2D;
import com.codename1.ui.plaf.Style;
import com.mycompany.a3.Game;
import com.mycompany.a3.GameObject;
import com.mycompany.a3.GameWorld;
import com.mycompany.a3.gameObjects.Cats;
import com.mycompany.a3.gameObjects.Dogs;
import com.mycompany.a3.gameObjects.IDrawable;
import com.mycompany.a3.gameObjects.Nets;

public class PlayPause extends Command {
	public PlayPause(String command) {
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
		playOrPause();
		
	}
	//toggles pause play
	public void playOrPause() {
		if(gamePass.getPlayPauseButton().getText() == "Play"){
			gamePass.getPlayPauseButton().setText("Pause");
			
			gamePass.addKeyListener(101, gamePass.getExpandNet());
			gamePass.addKeyListener(117, gamePass.getMoveUp());
			gamePass.addKeyListener(100, gamePass.getMoveDown());
			gamePass.addKeyListener(111, gamePass.getMoveToDog());
			gamePass.addKeyListener(99, gamePass.getContractNet());
			gamePass.addKeyListener(108, gamePass.getMoveLeft());
			gamePass.addKeyListener(114, gamePass.getMoveRight());
			gamePass.addKeyListener(97, gamePass.getMoveToCat());
			gamePass.addKeyListener(115, gamePass.getScoopAnimals());
			
			gamePass.getExpandButton().setEnabled(true);
			gamePass.getUpButton().setEnabled(true);
			gamePass.getDownButton().setEnabled(true);
			gamePass.getJumpToDogButton().setEnabled(true);
			gamePass.getContractButton().setEnabled(true);
			gamePass.getLeftButton().setEnabled(true);
			gamePass.getRightButton().setEnabled(true);
			gamePass.getJumpToACatButton().setEnabled(true);
			gamePass.getScoopButton().setEnabled(true);
			gamePass.getHealButton().setEnabled(false);
			
			gamePass.getExpandButton().getDisabledStyle().setBgColor(ColorUtil.BLUE);
			gamePass.getUpButton().getDisabledStyle().setBgColor(ColorUtil.BLUE);
			gamePass.getDownButton().getDisabledStyle().setBgColor(ColorUtil.BLUE);
			gamePass.getJumpToDogButton().getDisabledStyle().setBgColor(ColorUtil.BLUE);
			gamePass.getContractButton().getDisabledStyle().setBgColor(ColorUtil.BLUE);
			gamePass.getLeftButton().getDisabledStyle().setBgColor(ColorUtil.BLUE);
			gamePass.getRightButton().getDisabledStyle().setBgColor(ColorUtil.BLUE);
			gamePass.getJumpToACatButton().getDisabledStyle().setBgColor(ColorUtil.BLUE);
			gamePass.getScoopButton().getDisabledStyle().setBgColor(ColorUtil.BLUE);
			
			Iterator<GameObject> it = ((GameWorld)gameWorldPass).getGameWorldCollection().getIterator();
			while(it.hasNext()){
				GameObject item = it.next();
				if (item instanceof Dogs){
					((Dogs)item).setSelected(false);
				}
			}
			
			gameWorldPass.setPause(false);
			
			
			
			
		}
		else if (gamePass.getPlayPauseButton().getText() == "Pause"){
			gamePass.getPlayPauseButton().setText("Play");
			
			gamePass.removeKeyListener(101, gamePass.getExpandNet());
			gamePass.removeKeyListener(117, gamePass.getMoveUp());
			gamePass.removeKeyListener(100, gamePass.getMoveDown());
			gamePass.removeKeyListener(111, gamePass.getMoveToDog());
			gamePass.removeKeyListener(99, gamePass.getContractNet());
			gamePass.removeKeyListener(108, gamePass.getMoveLeft());
			gamePass.removeKeyListener(114, gamePass.getMoveRight());
			gamePass.removeKeyListener(97, gamePass.getMoveToCat());
			gamePass.removeKeyListener(115, gamePass.getScoopAnimals());
			
			gamePass.getExpandButton().setEnabled(false);
			gamePass.getUpButton().setEnabled(false);
			gamePass.getDownButton().setEnabled(false);
			gamePass.getJumpToDogButton().setEnabled(false);
			gamePass.getContractButton().setEnabled(false);
			gamePass.getLeftButton().setEnabled(false);
			gamePass.getRightButton().setEnabled(false);
			gamePass.getJumpToACatButton().setEnabled(false);
			gamePass.getScoopButton().setEnabled(false);
			gamePass.getHealButton().setEnabled(true);
			
			gameWorldPass.setPause(true);
			
		}
		
		
		gameWorldPass.notifyObservers();
        System.out.println("I MADE IT HERE pause/play BUTTON");
	}

}
