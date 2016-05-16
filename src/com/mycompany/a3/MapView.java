package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.a3.gameObjects.Dogs;
import com.mycompany.a3.gameObjects.IDrawable;
import com.mycompany.a3.gameObjects.ISelectable;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class MapView extends Container implements Observer{
	
	
	private final GameWorld gameWorldPass;
	public MapView (GameWorld g) {
		gameWorldPass = g;
		//set background color
		this.getAllStyles().setBgColor(ColorUtil.GRAY);
		this.getAllStyles().setBgTransparency(255);
		this.setWidth(1000);
		this.setHeight(610);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Point pCmpRelPrnt = new Point(this.getX(), this.getY());
		Iterator<GameObject> it = ((GameWorld)gameWorldPass).getGameWorldCollection().getIterator();
		while(it.hasNext()){
			GameObject item = it.next();
			if (item instanceof IDrawable){
				((IDrawable)item).draw(g, pCmpRelPrnt);
			}
		}
	}
   
    public void update(Observable o, Object arg) {
    	Iterator<GameObject> it = gameWorldPass.getGameWorldCollection().getIterator();
    	
    		while(it.hasNext()){
    			GameObject item = it.next();
                if (item instanceof GameObject) {
                    System.out.println(((GameObject) item).toString());
                }

            }
    		this.repaint();
            System.out.println();
        
    }
    
    public void pointerPressed(int x, int y) {
		x = x - getParent().getAbsoluteX();
		y = y - getParent().getAbsoluteY();
		Point pPtrRelPrnt = new Point(x, y);
		Point pCmpRelPrnt = new Point(getX(), getY());
		
		Iterator<GameObject> it = gameWorldPass.getGameWorldCollection().getIterator();
		while(it.hasNext()){
			GameObject item = it.next();
            if (item instanceof ISelectable && gameWorldPass.isPause()) {
                if(((ISelectable)item).contains(pPtrRelPrnt, pCmpRelPrnt)){
                	((ISelectable)item).setSelected(true);
                }
                else
                	((ISelectable)item).setSelected(false);
            }

        }
		repaint();
	}
}
