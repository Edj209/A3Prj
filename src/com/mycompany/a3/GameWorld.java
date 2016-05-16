package com.mycompany.a3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Set;
import java.lang.Math;

import com.codename1.ui.geom.Point2D;
import com.mycompany.a3.gameObjects.Cats;
import com.mycompany.a3.gameObjects.Dogs;
import com.mycompany.a3.gameObjects.IMoving;
import com.mycompany.a3.gameObjects.Nets;

/**
 * Created by Edgar on 2/23/2016.
 */
public class GameWorld extends Observable {
	
	
	//constructor
	public GameWorld () {
		//this now holds the objects
		gameWorldCollection = new GameObjectCollection(); //used to be = new ArrayList<Gameobject>();
	}
	
	//observer list
	public ArrayList<Observer> getObserverList() {
        return observerList;
    }
    private ArrayList<Observer> observerList;
    
    public void addObserver (Observer obs) {
    	observerList.add(obs);
    }
    
    public void notifyObservers() {
    	for (Observer observer : observerList) {
    		observer.update(this, null);
    	}
    }
	
	//getter and adder for gameworld
	public GameObjectCollection getGameWorldCollection() {
        return gameWorldCollection;
    }
    public void addGameWorldCollection(GameObject thingToAdd) {
        this.gameWorldCollection.add(thingToAdd);
    }
	private GameObjectCollection gameWorldCollection;
	
	
    ArrayList<GameObject> GameObjects = new ArrayList(); //THIS IS OBSOLETE
    public ArrayList<GameObject> getGameObjects() {
		return GameObjects;
	}
	
    Random randomNum = new Random();
    private int dogsCaptured;

    public int getDogsCaptured() {
        return dogsCaptured;
    }

    public void setDogsCaptured(int dogsCaptured) {
        this.dogsCaptured = dogsCaptured;
    }

    public int getCatsCaptured() {
        return catsCaptured;
    }

    public void setCatsCaptured(int catsCaptured) {
        this.catsCaptured = catsCaptured;
    }

    public int getDogsRemaining() {
        return dogsRemaining;
    }

    public void setDogsRemaining(int dogsRemaining) {
        this.dogsRemaining = dogsRemaining;
    }

    public int getCatsRemaining() {
        return catsRemaining;
    }

    public void setCatsRemaining(int catsRemaining) {
        this.catsRemaining = catsRemaining;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
    
    public void setSound () { //toggle sound on/off
        if(sound) {
            sound = false;
        } else
            sound = true;
        notifyObservers();
    } //end of sound stuff

    private int catsCaptured;
    private int dogsRemaining;
    private int catsRemaining;
    private int totalScore;
    private boolean sound;
    private boolean pause;

//    public void setSound(boolean sound) {
//		this.sound = sound;
//	}
    
    public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public boolean isSound() {
        return sound;
    }

	//generates the world, adding dogs cats and nets
    public void initLayout() {
    	GameWorld gw = new GameWorld();
    	MapView mv = new MapView(gw);
    	observerList = new ArrayList<Observer>();
    	
    	this.sound = true;
        this.dogsCaptured = 0;
        this.catsCaptured = 0;
        this.dogsRemaining = 3;
        this.catsRemaining = 0;
        this.totalScore = 0;

        //creates dogs
        for(int i=0; i<3; i++){
            Point2D objLocation2 = new Point2D(randomNum.nextInt(mv.getWidth())+mv.getX(),randomNum.nextInt(mv.getHeight())+mv.getY());
            Dogs dog = new Dogs();
            dog.setSize(randInt(20, 50));
            dog.setObjLocation(objLocation2);
            dog.initialColor();

            gameWorldCollection.add(dog);
            //GameObjects.add(dog);
        }
        //creates cats
        for(int i=0; i<2; i++){
            Point2D objLocation = new Point2D(randomNum.nextInt(mv.getWidth())+mv.getX(),randomNum.nextInt(mv.getHeight())+mv.getY());
            Cats cat = new Cats();
            cat.setSize(randInt(20, 50));
            cat.setObjLocation(objLocation);
            cat.initialColor();
            
            gameWorldCollection.add(cat);
//            GameObjects.add(cat);
            catsRemaining++;
        }
        //creates net
        Nets net = new Nets();
        Point2D objLocation = new Point2D(randomNum.nextInt(mv.getWidth())+mv.getX(),randomNum.nextInt(mv.getHeight())+mv.getY());
        net.setObjLocation(objLocation);
        net.setSize(100);
        net.initialColor();

        gameWorldCollection.add(net);
//        GameObjects.add(net);
    }

    //expands the net
    public void expand(){
        for(GameObject net : GameObjects) {
            if (net instanceof Nets) {
                net.setSize(net.getSize()+5);
                if(net.getSize()>1000)
                    net.setSize(1000);
            }
        }
    }

    

	//contracts the net
    public void contract() {
        for(GameObject net : GameObjects) {
            if (net instanceof Nets) {
                net.setSize(net.getSize()-5);
                if(net.getSize()<50)
                    net.setSize(50);
            }
        }
    }

    //scoops up all the animals in the net
    public void scoop() {
        Point2D netObjLocation = new Point2D(0, 0);

        //gets the net location
        for (GameObject item : GameObjects) {
            if (item instanceof Nets) {
                netObjLocation = item.getObjLocation();
            }
        }

        Iterator<GameObject> iter = GameObjects.listIterator();

        while (iter.hasNext()) {
            GameObject object = iter.next();

            if (object.getObjLocation().equals(netObjLocation)) {
                //if a cat is in the net delete it
                if (object instanceof Cats) {
                    catsCaptured++;
                    if(catsRemaining > 0)	
                    	catsRemaining--;
                    totalScore = totalScore - 10;
                    iter.remove();
                    

                } else if (object instanceof Dogs) {
                    dogsCaptured++;
                    dogsRemaining--;
                    totalScore = (totalScore + 10 - ((Dogs) object).getScratches());
                    iter.remove();
                }
            }
        }
    }

//            while (iterator().hasNext()){
//                GameObject object = iter.next();
//
//                if(object instanceof Cats){
//                    catsCaptured++;
//                    catsRemaining--;
//                    totalScore = totalScore - 10;
//                    GameObjects.remove(object);
//                }
//            }
//            if(catDog instanceof Dogs){
//                dogsCaptured++;
//                dogsRemaining--;
//                totalScore = (totalScore + 10 - ((Dogs) catDog).getScratches());
//                GameObjects.remove(catDog);
//            }
//        }


    //next 6 methods concern the movement of the net by the player
    public void right() {
        for(GameObject net : GameObjects){
            if(net instanceof Nets){
                ((Nets) net).right();
            }
        }
    }

    public void left() {
        for(GameObject net : GameObjects){
            if(net instanceof Nets){
                ((Nets) net).left();
            }
        }
    }

    public void up() {
        for(GameObject net : GameObjects){
            if(net instanceof Nets){
                ((Nets) net).up();
            }
        }
    }

    public void down(){
        for(GameObject net : GameObjects){
            if(net instanceof Nets){
                ((Nets) net).down();
            }
        }
    }

    public void netToRandomDog() {
        for (GameObject dogLocation : GameObjects) {
            if (dogLocation instanceof Dogs) {
                Point2D objLocation = dogLocation.getObjLocation();
                for (GameObject net : GameObjects) {
                    if (net instanceof Nets) {
                        ((Nets) net).jumpToRandomDog(objLocation);
                    }
                }
            }
        }
    }

    public void netToRandomCat() {
        Set<Cats> uniqueCats = new HashSet<Cats>();
        for (GameObject cat : GameObjects) {
            if (cat instanceof Cats) {
                Cats uniqueCat = (Cats) cat;
                uniqueCats.add(uniqueCat);
            }
        }

        for (GameObject catLocation : GameObjects) {
            if (catLocation instanceof Cats) {
                Point2D objLocation = catLocation.getObjLocation();
                for (GameObject net : GameObjects) {
                    if (net instanceof Nets) {
                        ((Nets) net).jumpToRandomCat(objLocation);
                    }
                }
            }

        }
        if (uniqueCats.size() <= 0) {
            System.out.println("There are no more cats left.");
        }
    }

    public void catCollision() {
        Set<Cats> uniqueCats = new HashSet<Cats>();
        for(GameObject cat : GameObjects){
            if(cat instanceof Cats){
                Cats uniqueCat = (Cats) cat;
                uniqueCats.add(uniqueCat);
            }
        }
        int uniqueItemCounter = uniqueCats.size();
        if(uniqueItemCounter >= 2){
            for(GameObject cat : GameObjects){
                if(cat instanceof Cats){
                    Point2D objLocation = new Point2D((float) cat.getObjLocation().getX()+5, (float) cat.getObjLocation().getY()+5);
                    Cats kitty = new Cats();
                    kitty.setSize(randInt(20, 50));
                    kitty.setObjLocation(objLocation);
                    kitty.initialColor();

                    gameWorldCollection.add(kitty);
//                    GameObjects.add(kitty);
                    catsRemaining++;
                    break;
                }
            }
        }

    }

    public void catDogFight() {
        Set<Cats> uniqueCats = new HashSet<Cats>();
        for(GameObject cat : GameObjects){
            if(cat instanceof Cats){
                Cats uniqueCat = (Cats) cat;
                uniqueCats.add(uniqueCat);
            }
        }
        int uniqueItemCounter = uniqueCats.size();
        if(uniqueItemCounter > 0) {
            for(GameObject dog : GameObjects) {
                if (dog instanceof Dogs) {
                    ((Dogs) dog).scratched();
                    dog.changeColor();
                    break;
                }
            }
        }
    }

    public void tick() {
    	int m = 15;
        for(GameObject gameObject : GameObjects){
            if(gameObject instanceof IMoving) {
                ((IMoving) gameObject).move(m);
            }
        }
        if (dogsRemaining <=0) {
            System.out.println("Game Over, all dogs captured.");
            System.exit(0);
        }
    }

    public void points() {
        System.out.println("\n\nCurrent Score: " + this.totalScore + "\n");
        System.out.println("Dogs Captured: " + this.dogsCaptured);
        System.out.println("Cats Captured: " + this.catsCaptured + "\n");
        System.out.println("Dogs Remaining: " + this.dogsRemaining);
        System.out.println("Cats Remaining: " + this.catsRemaining + "\n\n");
    }

    public void map() {
        for(GameObject item : GameObjects) {
            if (item instanceof GameObject) {
                System.out.println(((GameObject) item).toString());

            }

        }
        System.out.println();
    }

      //will be reimplemnted elsewhere
//    public void quit() {
//        Label myLabel = new Label("Are you sure you want to quit?");
//        this.addComponent(myLabel);
//        final TextField myTextField = new TextField();
//        this.addComponent(myTextField);
//        this.show();
//
//        myTextField.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                String sCommand = myTextField.getText().toString();
//                myTextField.clear();
//
//                //switch statement to handle the user input
//                switch (sCommand.charAt(0)) {
//                    case 'y':
//                        System.exit(0);
//                        break;
//                    case 'n':
//                        break;
//                    default:
//                        System.out.println("\nPlease enter either y or n\n");
//                        break;
//                }
//            }
//        });
//    }

    public static int randInt(int min, int max) {
        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }


}
