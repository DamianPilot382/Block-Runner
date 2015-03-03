package com.pilotcraftmc.blockrunner;

//IMPORT
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import com.pilotcraftmc.blockrunner.entities.BasicEnemy;
import com.pilotcraftmc.blockrunner.entities.MenuEnemy;
import com.pilotcraftmc.blockrunner.entities.Player;
import com.pilotcraftmc.blockrunner.gui.Character;
import com.pilotcraftmc.blockrunner.gui.Credits;
import com.pilotcraftmc.blockrunner.gui.Help;
import com.pilotcraftmc.blockrunner.gui.Menu;
import com.pilotcraftmc.blockrunner.gui.Pause;
import com.pilotcraftmc.blockrunner.gui.Store;
import com.pilotcraftmc.blockrunner.input.KeyInput;
import com.pilotcraftmc.blockrunner.input.MouseInput;

//Game Class Declaration
public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	//WIDTH and HEIGHT of the game
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	//Thread
	private static Thread thread;
	
	//Running boolean
	static boolean running = false;
		
	//Declarations
	private Random r;
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	public static Handler menuHandler;
	
	//GUI Declarations
	static Menu menu;
	static Credits credits;
	static Help help;
	static Character character;
	static Pause pause;
	static Store store;
		
	
	//Game State Declaration
	public static STATE State = STATE.MENU;
	
	//Game Constructor
	public Game(){
		
		//GUI Initialization
		menu = new Menu();
		credits = new Credits();
		help = new Help();
		character = new Character();
		pause = new Pause();
		store = new Store();
		
		//Handler Initialization
		menuHandler = new Handler();
		handler = new Handler();
		
		//Input Initialization
		this.addMouseListener(new MouseInput());
		this.addKeyListener(new KeyInput(handler));
		
		//Window Initialization
		new Window(WIDTH,HEIGHT, "Block Runner", this);
		
		//Initializations
		hud = new HUD();
		spawner = new Spawn(handler, hud);
		r = new Random();
		
		//Player added to the MAIN HANDLER
		handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
		
		//First Enemy added to the MAIN HANDLER
		handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler));
		
		//Enemies added to the MENU HANDLER
		this.drawMenuEnemies();
		
	}//End of Game Constructor
	
	//Start Method
	public synchronized void start(){
		//Start Thread
		thread = new Thread(this);
		thread.start();
		//Set running boolean to TRUE
		running = true;
	}//End of Start Method
	
	//Stop Method
	public synchronized static void stop(){
		try{
			//Stop Thread
			thread.join();
			
			//Running boolean set to FALSE;
			running = false;
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}//End of Stop Method
	
	//Run Method
	public void run(){
		
		//MAIN GAME LOOP
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				
				//Printer
				System.out.println(frames);
				System.out.println("STATE: " + State);
			}
		}//End of the game loop WHILE RUNNING
		stop(); //End of Game Loop
	}//End of Run Method
	
	//Tick Method
	private void tick(){
		
		//Tick if the game started
		if(State == STATE.GAME){
		
			handler.tick();
			hud.tick();
			spawner.tick();
			
		}else if(State == STATE.MENU){ //Tick if user is on the Main Menu
			menuHandler.tick();
		}else if(State == STATE.GAME_OVER){
			resetGame();
		}
		
	}//End of Tick Method
	
	//Render Method
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		//Get Graphics
		Graphics g = bs.getDrawGraphics();
		
		//Set Background
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		//Render if user is on Game
		if(State == STATE.GAME){
							
			handler.render(g);
		
			hud.render(g);
			
			g.dispose();
			bs.show();
		
		//render if user is on MAIN MENU
		}else if(State == STATE.MENU){
			
			g.setColor(Color.orange);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			
			menuHandler.render(g);
			menu.render(g);
			g.dispose();
			bs.show();
			
		//Render if user is on CHARACTER MENU
		}else if(State == STATE.CHARACTER){
			character.render(g);
			g.dispose();
			bs.show();
			
		//Render if user is on CREDITS MENU
		}else if(State == STATE.CREDITS){
			credits.render(g);
			g.dispose();
			bs.show();
			
		//Render if user is on HELP MENU
		}else if(State == STATE.HELP){
			help.render(g);
			g.dispose();
			bs.show();
			
		//Render if user is on PAUSE MENU
		}else if(State == STATE.PAUSE){
			pause.render(g);
			g.dispose();
			bs.show();
		}else if(State == STATE.STORE){
			store.render(g);
			g.dispose();
			bs.show();
		}else if(State == STATE.GAME_OVER){
			resetGame();
		}
		
		
		
	}//End of Render Method
	
	
	private void drawMenuEnemies(){
		
		for(int i = 1; i <= 10; i++){
			menuHandler.addObject(new MenuEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.menuEnemy, menuHandler));
		}

	}
	
	//Clamp Method
	public static float clamp(float var, float min, float max){
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else
			return var;
	}//End of Clamp Method
	
	public void resetGame(){
		handler = null;
		handler = new Handler();
		
		//Player added to the MAIN HANDLER
		handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
		
		//First Enemy added to the MAIN HANDLER
		handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler));
		
		HUD.greenValue = 255;
		HUD.HEALTH = 100;
		HUD.level = 1;
		HUD.coins = 1;
		HUD.score = 0;
		this.addKeyListener(new KeyInput(handler));
		Spawn.scoreKeep = 0;

		Game.State = STATE.MENU;
		
	}
	
	
}//End of GAME CLASS