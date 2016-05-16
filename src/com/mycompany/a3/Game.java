package com.mycompany.a3;

import java.util.Iterator;
import java.util.Timer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.UITimer;
import com.mycompany.a3.gameCommands.About;
import com.mycompany.a3.gameCommands.CatDogFight;
import com.mycompany.a3.gameCommands.ContractNet;
import com.mycompany.a3.gameCommands.ExitGame;
import com.mycompany.a3.gameCommands.ExpandNet;
import com.mycompany.a3.gameCommands.Heal;
import com.mycompany.a3.gameCommands.Help;
import com.mycompany.a3.gameCommands.MoveDown;
import com.mycompany.a3.gameCommands.MoveLeft;
import com.mycompany.a3.gameCommands.MoveRight;
import com.mycompany.a3.gameCommands.MoveToCat;
import com.mycompany.a3.gameCommands.MoveToDog;
import com.mycompany.a3.gameCommands.MoveUp;
import com.mycompany.a3.gameCommands.PlayPause;
import com.mycompany.a3.gameCommands.ProduceKitten;
import com.mycompany.a3.gameCommands.ScoopAnimals;
import com.mycompany.a3.gameCommands.Sound;
import com.mycompany.a3.gameCommands.Tick;
import com.mycompany.a3.gameObjects.Cats;
import com.mycompany.a3.gameObjects.ICollider;
import com.mycompany.a3.gameObjects.IMoving;

/**
 * Created by Edgar on 2/23/2016.
 */
public class Game extends Form implements Runnable{
	private int millisec = 20;
    private GameWorld gw;
    private MapView mv;
    private ScoreView sv;
    
    CheckBox soundCheckBox;
    
    public CheckBox getSoundCheckBox() {
		return soundCheckBox;
	}
	public void setSoundCheckBox(CheckBox soundCheckBox) {
		this.soundCheckBox = soundCheckBox;
	}




	Button playPauseButton;
    
    public Button getPlayPauseButton() {
		return playPauseButton;
	}
	public void setPlayPauseButton(Button playPauseButton) {
		this.playPauseButton = playPauseButton;
	}
	
	Button healButton;
	
	public Button getHealButton() {
		return healButton;
	}
	public void setHealButton(Button healButton) {
		this.healButton = healButton;
	}




	Heal heal;




	private Container boxContainerSouth;
    
    public Container getBoxContainerSouth() {
		return boxContainerSouth;
	}
	public void setBoxContainerSouth(Container boxContainerSouth) {
		this.boxContainerSouth = boxContainerSouth;
	}




	private PlayPause playPause;
	public Button getExpandButton() {
		return expandButton;
	}
	public void setExpandButton(Button expandButton) {
		this.expandButton = expandButton;
	}
	public Button getUpButton() {
		return upButton;
	}
	public void setUpButton(Button upButton) {
		this.upButton = upButton;
	}
	public Button getDownButton() {
		return downButton;
	}
	public void setDownButton(Button downButton) {
		this.downButton = downButton;
	}
	public Button getJumpToDogButton() {
		return jumpToDogButton;
	}
	public void setJumpToDogButton(Button jumpToDogButton) {
		this.jumpToDogButton = jumpToDogButton;
	}
	public Button getContractButton() {
		return contractButton;
	}
	public void setContractButton(Button contractButton) {
		this.contractButton = contractButton;
	}
	public Button getLeftButton() {
		return leftButton;
	}
	public void setLeftButton(Button leftButton) {
		this.leftButton = leftButton;
	}
	public Button getRightButton() {
		return rightButton;
	}
	public void setRightButton(Button rightButton) {
		this.rightButton = rightButton;
	}
	public Button getJumpToACatButton() {
		return jumpToACatButton;
	}
	public void setJumpToACatButton(Button jumpToACatButton) {
		this.jumpToACatButton = jumpToACatButton;
	}
	public Button getScoopButton() {
		return scoopButton;
	}
	public void setScoopButton(Button scoopButton) {
		this.scoopButton = scoopButton;
	}




	private Button expandButton;
	private Button upButton;
	private Button downButton;
	private Button jumpToDogButton;
	private Button contractButton;
	private Button leftButton;
	private Button rightButton;
	private Button jumpToACatButton;
	private Button scoopButton;
	private Tick tick;
	private ExpandNet expandNet;
	private MoveUp moveUp;
	private MoveDown moveDown;
	private MoveToDog moveToDog;
	private ContractNet contractNet;
	private MoveLeft moveLeft;
	public ExpandNet getExpandNet() {
		return expandNet;
	}
	public void setExpandNet(ExpandNet expandNet) {
		this.expandNet = expandNet;
	}
	public MoveUp getMoveUp() {
		return moveUp;
	}
	public void setMoveUp(MoveUp moveUp) {
		this.moveUp = moveUp;
	}
	public MoveDown getMoveDown() {
		return moveDown;
	}
	public void setMoveDown(MoveDown moveDown) {
		this.moveDown = moveDown;
	}
	public MoveToDog getMoveToDog() {
		return moveToDog;
	}
	public void setMoveToDog(MoveToDog moveToDog) {
		this.moveToDog = moveToDog;
	}
	public ContractNet getContractNet() {
		return contractNet;
	}
	public void setContractNet(ContractNet contractNet) {
		this.contractNet = contractNet;
	}
	public MoveLeft getMoveLeft() {
		return moveLeft;
	}
	public void setMoveLeft(MoveLeft moveLeft) {
		this.moveLeft = moveLeft;
	}
	public MoveRight getMoveRight() {
		return moveRight;
	}
	public void setMoveRight(MoveRight moveRight) {
		this.moveRight = moveRight;
	}
	public MoveToCat getMoveToCat() {
		return moveToCat;
	}
	public void setMoveToCat(MoveToCat moveToCat) {
		this.moveToCat = moveToCat;
	}
	public ScoopAnimals getScoopAnimals() {
		return scoopAnimals;
	}
	public void setScoopAnimals(ScoopAnimals scoopAnimals) {
		this.scoopAnimals = scoopAnimals;
	}




	private MoveRight moveRight;
	private MoveToCat moveToCat;
	private ScoopAnimals scoopAnimals;
    public Tick getTick() {
		return tick;
	}
	public void setTick(Tick tick) {
		this.tick = tick;
	}
	public PlayPause getPlayPause() {
		return playPause;
	}
	public void setPlayPause(PlayPause playPause) {
		this.playPause = playPause;
	}





	public Game() {
        gw = new GameWorld();
        gw.initLayout();
        mv = new MapView(gw);
        sv = new ScoreView(gw);
        gw.addObserver(mv);
        gw.addObserver(sv);

        //gui stuff
        //title
        this.setTitle("Dog Catcher");
        //setting the layouts
        this.setLayout(new BorderLayout());
        
        //setting the containers
        BoxLayout boxLayoutYAxis = new BoxLayout(BoxLayout.Y_AXIS);
        BoxLayout boxLayoutXAxis = new BoxLayout(BoxLayout.X_AXIS);
        
        Container boxContainerWest = new Container(boxLayoutYAxis);
        Container boxContainerEast = new Container(boxLayoutYAxis);
        this.boxContainerSouth = new Container(boxLayoutXAxis);
        
        //toolbar
        Toolbar myToolBar = new Toolbar();
        this.setToolbar(myToolBar);
        

        //buttons, add padding and color
        //west buttons
        this.expandButton = new Button("Expand");
        expandButton.getAllStyles().setPadding(Component.TOP, 25);
        expandButton.getAllStyles().setPadding(Component.BOTTOM, 25);
        //set command
        this.expandNet = new ExpandNet("Expand");
        expandNet.setTarget(gw);
        this.addKeyListener(101, expandNet);
        expandButton.setCommand(expandNet);
        //add button to container
        boxContainerWest.add(expandButton);
        
               
        this.upButton = new Button("Up");
        upButton.getAllStyles().setPadding(Component.TOP, 25);
        upButton.getAllStyles().setPadding(Component.BOTTOM, 25);
        //set command
        this.moveUp = new MoveUp("Up");
        moveUp.setTarget(gw);
        this.addKeyListener(117, moveUp);
        upButton.setCommand(moveUp);
        //add button to container
        boxContainerWest.add(upButton);
        
        this.downButton = new Button("Down");
        downButton.getAllStyles().setPadding(Component.TOP, 25);
        downButton.getAllStyles().setPadding(Component.BOTTOM, 25);
        //set command
        this.moveDown = new MoveDown("Down");
        moveDown.setTarget(gw);
        this.addKeyListener(100, moveDown);
        downButton.setCommand(moveDown);
        //add button to container
        boxContainerWest.add(downButton);
        
        this.jumpToDogButton = new Button("Jump to a Dog");
        jumpToDogButton.getAllStyles().setPadding(Component.TOP, 25);
        jumpToDogButton.getAllStyles().setPadding(Component.BOTTOM, 25);
        //set command
        this.moveToDog = new MoveToDog("Jump to a Dog");
        moveToDog.setTarget(gw);
        this.addKeyListener(111, moveToDog);
        jumpToDogButton.setCommand(moveToDog);
        //add button to container
        boxContainerWest.add(jumpToDogButton);
//        
//      //add all the buttons to flowlayout and add them to the west panel, also add border
        boxContainerWest.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
        this.add(BorderLayout.WEST, boxContainerWest);
//        
        //east buttons
        this.contractButton = new Button("Contract");
        contractButton.getAllStyles().setPadding(Component.TOP, 20);
        contractButton.getAllStyles().setPadding(Component.BOTTOM, 20);
        //set command
        this.contractNet = new ContractNet("Contract");
        contractNet.setTarget(gw);
        this.addKeyListener(99, contractNet);
        contractButton.setCommand(contractNet);
        //add button to container
        boxContainerEast.add(contractButton);
        
        this.leftButton = new Button("Left");
        leftButton.getAllStyles().setPadding(Component.TOP, 20);
        leftButton.getAllStyles().setPadding(Component.BOTTOM, 20);
      //set command
        this.moveLeft = new MoveLeft("Left");
        moveLeft.setTarget(gw);
        this.addKeyListener(108, moveLeft);
        leftButton.setCommand(moveLeft);
        //add button to container
        boxContainerEast.add(leftButton);
        
        this.rightButton = new Button("Right");
        rightButton.getAllStyles().setPadding(Component.TOP, 20);
        rightButton.getAllStyles().setPadding(Component.BOTTOM, 20);
        //set command
        this.moveRight = new MoveRight("Right");
        moveRight.setTarget(gw);
        this.addKeyListener(114, moveRight);
        rightButton.setCommand(moveRight);
        //add button to container
        boxContainerEast.add(rightButton);
        
        this.jumpToACatButton = new Button("Jump to a cat");
        jumpToACatButton.getAllStyles().setPadding(Component.TOP, 20);
        jumpToACatButton.getAllStyles().setPadding(Component.BOTTOM, 20);
        //set command
        this.moveToCat = new MoveToCat("Jump to a cat");
        moveToCat.setTarget(gw);
        this.addKeyListener(97, moveToCat);
        jumpToACatButton.setCommand(moveToCat);
        //add button to container
        boxContainerEast.add(jumpToACatButton);
        
        this.scoopButton = new Button("Scoop");
        scoopButton.getAllStyles().setPadding(Component.TOP, 20);
        scoopButton.getAllStyles().setPadding(Component.BOTTOM, 20);
        //set command
        this.scoopAnimals = new ScoopAnimals("Scoop");
        scoopAnimals.setTarget(gw);
        this.addKeyListener(115, scoopAnimals);
        scoopButton.setCommand(scoopAnimals);
        //toolbar
        myToolBar.addCommandToSideMenu(scoopAnimals);
        //add button to container
        boxContainerEast.add(scoopButton);
        
        boxContainerEast.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
        this.addComponent(BorderLayout.EAST, boxContainerEast);
        
        //south buttons
        Button kittenButton = new Button("Kitten");
        kittenButton.getAllStyles().setPadding(Component.TOP, 10);
        kittenButton.getAllStyles().setPadding(Component.BOTTOM, 10);
        kittenButton.getAllStyles().setMargin(Component.LEFT, 400);
        //set command
        ProduceKitten produceKitten = ProduceKitten.getInstance();
        produceKitten.setTarget(gw);
        this.addKeyListener(107, produceKitten);
        kittenButton.setCommand(produceKitten);
        //add button to container
//        boxContainerSouth.add(kittenButton);
        
        Button fightButton = new Button("Fight");
        fightButton.getAllStyles().setPadding(Component.TOP, 10);
        fightButton.getAllStyles().setPadding(Component.BOTTOM, 10);
        fightButton.getAllStyles().setAlignment(Component.CENTER);
        //set command
        CatDogFight catDogFight = new CatDogFight("Fight");
        catDogFight.setTarget(gw);
        this.addKeyListener(102, catDogFight);
        fightButton.setCommand(catDogFight);
        //add button to container
//        boxContainerSouth.add(fightButton);
        
        Button tickButton = new Button("Tick");
        tickButton.getAllStyles().setPadding(Component.TOP, 10);
        tickButton.getAllStyles().setPadding(Component.BOTTOM, 10);
        tickButton.getAllStyles().setAlignment(Component.CENTER);
        //set command
        this.tick = new Tick("Tick");
        tick.setTarget(gw);
        this.addKeyListener(116, tick);
        tickButton.setCommand(tick);
        //add button to container
//        boxContainerSouth.add(tickButton);
        
        this.playPauseButton = new Button("Play");
        playPauseButton.getAllStyles().setPadding(Component.TOP, 10);
        playPauseButton.getAllStyles().setPadding(Component.BOTTOM, 10);
        playPauseButton.getAllStyles().setAlignment(Component.CENTER);
        playPauseButton.getAllStyles().setMargin(Component.LEFT, 400);
        //set command
        this.playPause = new PlayPause("Pause");
        playPause.setTarget(this);
        playPause.setTarget(gw);
//        this.addKeyListener(102, catDogFight);
        playPauseButton.setCommand(playPause);
        //add button to container
        boxContainerSouth.add(playPauseButton);
        
        this.healButton = new Button("Heal");
        healButton.getAllStyles().setPadding(Component.TOP, 10);
        healButton.getAllStyles().setPadding(Component.BOTTOM, 10);
        healButton.getAllStyles().setAlignment(Component.CENTER);
        //set command
        this.heal = new Heal("Heal");
        heal.setTarget(this);
        heal.setTarget(gw);
//        this.addKeyListener(102, catDogFight);
        healButton.setCommand(heal);
        //add button to container
        boxContainerSouth.add(healButton);
        healButton.setEnabled(false);
        healButton.getDisabledStyle().setBgColor(ColorUtil.BLUE);
        
        //side menu commands including exit game, sound, about, and help
        ExitGame exitGame = new ExitGame("Exit Game");
        myToolBar.addCommandToSideMenu(exitGame);
        this.addKeyListener(120, exitGame);
        
        Sound sound = new Sound("sound");
        sound.setTarget(this);
        sound.setTarget(gw);
        this.soundCheckBox = new CheckBox("sound");
        soundCheckBox.setSelected(true);
        soundCheckBox.setCommand(sound);
        myToolBar.addComponentToSideMenu(soundCheckBox, sound);
        this.bgSound = new BGSound("backgroundMusic.mp3");
        bgSound.play();
        
        About about = new About("about");
        about.setTarget(gw);
        Button aboutButton = new Button("About");
        aboutButton.setCommand(about);
        myToolBar.addComponentToSideMenu(aboutButton);
        
        
        Help help = new Help("help");
        help.setTarget(gw);
        Button helpButton = new Button("help");
        helpButton.setCommand(help);
        myToolBar.addComponentToSideMenu(helpButton);
        
        
//        myToolBar.addCommandToSideMenu(sound);
        
        
        
        
        boxContainerSouth.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
        boxContainerSouth.getAllStyles().setAlignment(Component.RIGHT);
        this.addComponent(BorderLayout.SOUTH, boxContainerSouth);
        
        //add mapview to the center panel, and scoreview to north panel also add toolbar
        this.addComponent(BorderLayout.CENTER, mv);
        this.addComponent(BorderLayout.NORTH, sv);
        
        // objects that need this as a target
        Cats cat = new Cats();
        cat.setTarget(gw);
        
        
      
        
        
        
        

        this.show();
        
        UITimer timer = new UITimer(this);
        timer.schedule(millisec, true, this);
        

        //play(); //obsolete
    }
    
    
    
   

    private void play() {
        Label myLabel = new Label("Enter a command:");
        this.addComponent(myLabel);
        final TextField myTextField = new TextField();
        this.addComponent(myTextField);
        this.show();

        myTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String sCommand = myTextField.getText().toString();
                myTextField.clear();

                //switch statement to handle the user input
                switch (sCommand.charAt(0)) {
                    case 'e':
                        gw.expand();
                        break;
                    case 'c':
                        gw.contract();
                        break;
                    case 's':
                        gw.scoop();
                        break;
                    case 'r':
                        gw.right();
                        break;
                    case 'l':
                        gw.left();
                        break;
                    case 'u':
                        gw.up();
                        break;
                    case 'd':
                        gw.down();
                        break;
                    case 'o':
                        gw.netToRandomDog();
                        break;
                    case 'a':
                        gw.netToRandomCat();
                        break;
                    case 'k':
                        gw.catCollision();
                        break;
                    case 'f':
                        gw.catDogFight();
                        break;
                    case 't':
                        gw.tick();
                        break;
                    case 'p':
                        gw.points();
                        break;
                    case 'm':
                        gw.map();
                        break;
                    case 'q':
                        //gw.quit();
                        break;
                    default:
                        System.out.println("\n\n please enter valid input\n\n");

                        break;

                }
            }
        });


    }
    



	public void run() {
		// TODO Auto-generated method stub
		Iterator<GameObject> it = gw.getGameWorldCollection().getIterator();
		Dimension dCmpSize = new Dimension(mv.getWidth(), mv.getHeight());
		
		if(playPauseButton.getText() == "Pause")
		Tick.tick(millisec);
		
		while(it.hasNext()){
			ICollider curObj = (ICollider)it.next();
			Iterator<GameObject> it2 = gw.getGameWorldCollection().getIterator();
			while(it2.hasNext()){
				ICollider otherObj = (ICollider) it2.next();
				if(otherObj != curObj) {
					if(curObj.collidesWith((GameObject)otherObj)){
						curObj.handleCollision(otherObj);
					}
				}
			}
		}
		this.repaint();
		
	}
	
	private BGSound bgSound;
	private boolean bPause = false;

	public BGSound getBgSound() {
		return bgSound;
	}
	public void setBgSound(BGSound bgSound) {
		this.bgSound = bgSound;
	}
	public boolean isbPause() {
		return bPause;
	}
	public void setbPause(boolean bPause) {
		this.bPause = bPause;
	}
	
	

}
