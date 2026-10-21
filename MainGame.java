import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


/**
 * 
 * @author Yunus Ishs
 * 
 */

public class MainGame extends JPanel implements KeyListener {
		
	public static int canvas_width = 1024;
	public static int canvas_height = 512;
		
	public Timer timer; 
	public int mSeconds = 0;
	public boolean isInGame = false; // if the player is in the game
	public boolean isPaused = false; // if the player paused the game
	public boolean gameOver = false; // if the game is working enough
	
	public int playerSpeed = 8;  // how many pixels the player moves
	public int goal = 0; // the target number
	
	ActionListener taskPerformer = new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if (isInGame && !isPaused && !gameOver) // all of the things that get looped will be run if those conditions are met
					{
						mSeconds +=64; // adds 16 milliseconds to the timer
						//System.out.println(mSeconds);
						if (mSeconds%4096==0) //when all the operators get made
						{
							Operators.makeOperators();
						}
						if (mSeconds%64==0) //when all the operators are moving
						{
							Operators.moveOperators();
						}
					checkHits(); // game needs to constantly check if the player is getting hit
					repaint();
					}
				}
			};
	
	// fonts and colors
	Color black = new Color(0,0,0); // set what black equals
	Color white = new Color(255,255,255); // set what white equals
	Font opFont = new Font("Cambria Math", Font.ITALIC, 32); // set all the fonts
	Font playerFont = new Font("Cambria Math", Font.ITALIC, 32);
	Font statsFont = new Font("Cambria Math", Font.ITALIC, 32);


	
	public static int getCanvasWidth()
	{
		return canvas_width;	
	}
	
	public static int getCanvasHeight()
	{
		return canvas_height;
	}
		
	public void init()
	{
		timer = new Timer(64,taskPerformer);
		timer.start();
	}

	public MainGame()
	{
		addKeyListener(this);
	}
	// method to make the player
	
	
	public void makePlayer(Graphics g, int xCoord, int yCoord)
	{
		g.setColor(new Color(0,0,255)); // set to blue
		g.fillRect(Player.getX()-32, Player.getY()-32, 64, 64); // the player's hitbox
		
		g.setColor(white); // set to white
		g.setFont(playerFont); // the font for the player's face
		g.drawString("x",Player.getX()-10,Player.getY()+10); // the text for the player's face
	}
	
	// method to make dividers
	
	public void makeDivider(Graphics g, int xCoord, int yCoord, 
			int red, int green, int blue)
	{
		g.setColor(new Color(red, green, blue)); // the color for the divider's hitbox
		g.fillRect(xCoord-32, yCoord-32, 64, 64); // the shape for the divider's hitbox
		
		char divisionChar = (char) 247; // get the char for the divide symbol
		String divisionString = String.valueOf(divisionChar); // turn the char into a string
		g.setColor(new Color(255-red, 255-green, 255-blue)); // the color for the divider's face
		g.setFont(opFont); // the font for the divider's face
		g.drawString(divisionString+"0",xCoord-24, yCoord+12); // draw the divider's face
	}
	
	// method to make adders
	
	public void makeAdder(Graphics g, int xCoord, int yCoord, int addValue, 
			int red, int green, int blue)
	{
		//adder box
		g.setColor(new Color(red, green, blue)); // the color for the adder's hitbox
		g.fillRect(xCoord-32, yCoord-32, 64, 64); // the shape for the divider's hitbox
		
		//adder text
		Operators.setAddValue(addValue); // the addValue for the adder's face
		g.setColor(new Color(255-red, 255-green, 255-blue)); // the color for the adder's face
		g.setFont(opFont); // the font for the adder's face
		if (addValue < 0)
		{
			g.drawString(""+addValue,xCoord-32, yCoord+12); // if number is negative
		}
		else
		{
			g.drawString("+"+addValue,xCoord-32, yCoord+12); // if number is positive
		}
	}
	
	// method to make multipliers
	
	public void makeMultiplier(Graphics g, int xCoord, int yCoord, int timesValue,
			int red, int green, int blue)
	{
		g.setColor(new Color(red, green, blue)); // the color for the multiplier's hitbox
		g.fillRect(xCoord-32, yCoord-32, 64, 64); // the shape for the multiplier's hitbox
	
		//multiplier text
		Operators.setTimesValue(timesValue); // the timesValue for the multiplier's face
		char timesChar = (char) 215; // get the char for the multiply symbol
		String timesString = String.valueOf(timesChar); // turn it into a string
		g.setColor(new Color(255-red, 255-green, 255-blue)); // the color for the 
		g.setFont(opFont); // the font for the multiplier
		g.drawString(timesString+timesValue,xCoord-32, yCoord+12); // draw the multiplier's face
	}
	
	//method to make squares
	
	public void makeSquare(Graphics g, int xCoord, int yCoord, 
			int red, int green, int blue)
	{	
		
		//square box
		g.setColor(new Color(red, green, blue)); // the 
		g.fillRect(xCoord-32, yCoord-32, 64, 64);
		
		//square text
		char squareChar = (char) 178;
		String squareString = String.valueOf(squareChar);
		g.setColor(new Color(255-red, 255-green, 255-blue));
		g.setFont(opFont);
		g.drawString("x"+squareString,xCoord-16, yCoord+12);
	}
	
	//method to make cubes
	
	public void makeCube(Graphics g, int xCoord, int yCoord, 
			int red, int green, int blue)
	{	
		//cube box
		g.setColor(new Color(red, green, blue));
		g.fillRect(xCoord-32, yCoord-32, 64, 64);
		
		//cube text
		char cubeChar = (char) 179;
		String cubeString = String.valueOf(cubeChar);
		g.setColor(new Color(255-red, 255-green, 255-blue));
		g.setFont(opFont);
		g.drawString("x"+cubeString,xCoord-16, yCoord+12);
	}
	
	//methods that return whether there is collision
	
	public boolean xCollision(int x1, int x2, int distance)
	{
	    int xdistance = Math.abs(x1 - x2); //find the difference
	  	return xdistance < distance; // check if the difference is close enough
	}
	
	public boolean yCollision(int y1, int y2, int distance)
	{
	    int ydistance = Math.abs(y1 - y2); //find the difference
	  	return ydistance < distance; // check if the difference is close enough
	}
	
	public void collision(int[][] listName)
	{
		for (int i=0; i<4; i+=1)
		{
			if (xCollision(listName[i][0], Player.getX(), 64)
					&& xCollision(listName[i][1], Player.getY(), 64))
			{
				//check for the large number issue
				if (listName == Operators.getDividersList())
				{
					gameOver = true;
					playerSpeed = 0;				}
				if (listName == Operators.getAddersList())
				{
					Player.setScore(Player.getScore()+listName[i][2]);
				}
				if (listName == Operators.getMultipliersList())
				{
					Player.setScore(Player.getScore()*listName[i][2]);
				}
				if (listName == Operators.getSquaresList())
				{
					Player.setScore((int) Math.pow(Player.getScore(),2));
				}
				if (listName == Operators.getCubesList())
				{
					Player.setScore((int) Math.pow(Player.getScore(),3));
				}
				for (int j = 0; j < 2; j+=1) // if it is an adder or multiplier it does not matter only the coordinates matter
					{	listName[i][j] = 0;
				}
			}
		}
	}
	
	public void checkHits()
	{
		// loops done through each operator list to check if the player's coordinates touch an operator's coordinates
		collision(Operators.getDividersList());
		collision(Operators.getAddersList());
		collision(Operators.getMultipliersList());
		collision(Operators.getSquaresList());
		collision(Operators.getCubesList());


	}
	
	// these lines are not necessary

	public void drawBgLines(Graphics g) {
	//horizontal lines
	for (int i=64; i<canvas_height; i+=64)
		g.drawLine(0, i, canvas_width, i);
	//g.drawLine(0, canvas_height/2, canvas_width, canvas_height/2);
	
	//vertical lines
	for (int i=64; i<canvas_width; i+=64)
		g.drawLine(i, 0, i, canvas_height);
	}
	
	public void mainMenuScreen(Graphics g) {
		
		//screen
		g.setColor(black);
		g.fillRect(0, 0, canvas_width, canvas_height*5/4);
		
		//text
		g.setColor(white);

		Font menuFont = new Font("consolas", Font.BOLD, 32);
		g.setFont(menuFont);
		g.drawString("Math Obstacle Game", canvas_width/2, canvas_height/2-64);
		g.drawString("Reach the goal", canvas_width/2, canvas_height/2);
		g.drawString("Press 'space' to start", canvas_width/2, canvas_height/2+64);
	}
		
	public void paintComponent(Graphics g)
	{	
		mainMenuScreen(g);
		if (isInGame)
			{
			// background
			g.setColor(black);
			g.fillRect(0, 0, canvas_width, canvas_height);
			
			// top boundary
			g.setColor(new Color(127,127,127));
			g.fillRect(0, 0, canvas_width, 64);
		
			// lines
			g.setColor(white);

			// this line is for testing purposes only
			drawBgLines(g);
		
		
			makePlayer(g, Player.getX(), getY());

			//spawnOperators(g);
			int[][] dividersList = Operators.getDividersList();
		
			for (int i=0; i<4; i++) 
			{
				if (dividersList[i][0] != 0) {
					makeDivider(g, dividersList[i][0], dividersList[i][1], 
							dividersList[i][2], dividersList[i][3], dividersList[i][4]);
				}
			}
		
			int[][] addersList = Operators.getAddersList();
		
			for (int i=0; i<4; i++) 
			{
				if (addersList[i][0] != 0) {
					makeAdder(g, addersList[i][0], addersList[i][1], 
							addersList[i][2], addersList[i][3], addersList[i][4], addersList[i][5]);
					//System.out.println(addersList[i][0]+" "+ addersList[i][1]+" "+ 
					//		addersList[i][2]+" "+  addersList[i][3]+" "+  addersList[i][4]+" "+  addersList[i][5]);
				}
			}

			int[][] multipliersList = Operators.getMultipliersList();
		
			for (int i=0; i<4; i++) 
			{
				if (multipliersList[i][0] != 0) {
					makeMultiplier(g, multipliersList[i][0], multipliersList[i][1], 
						multipliersList[i][2], multipliersList[i][3], multipliersList[i][4], multipliersList[i][5]);
				}
			}
			
			int[][] squaresList = Operators.getSquaresList();
			
			for (int i=0; i<4; i++) 
			{
				if (squaresList[i][0] != 0) {
					makeSquare(g, squaresList[i][0], squaresList[i][1], 
						squaresList[i][2], squaresList[i][3], squaresList[i][4]);
				}
			}

			int[][] cubesList = Operators.getCubesList();
		
			for (int i=0; i<4; i++) 
			{
				if (cubesList[i][0] != 0) {
					makeCube(g, cubesList[i][0], cubesList[i][1], 
							cubesList[i][2], cubesList[i][3], cubesList[i][4]);
				}
			}
		
			if (gameOver)
			{
				String gameOverString = "Game Over";
				g.setColor(new Color(255,0,0));
				g.setFont(new Font("Cambria Math", Font.ITALIC, 40));
				g.drawString(gameOverString,(canvas_width-gameOverString.length())/2, canvas_height/2);
			}
			//score display
		
			g.setColor(white);
			g.fillRect(0, canvas_height, canvas_width, canvas_height/4);
		
			g.setColor(new Color(0,0,0));
			g.setFont(statsFont);
			g.drawString("x="+Player.getScore(),canvas_width/2, canvas_height+64);
		}
	}
	
	public static void main(String[] args)
	{
		
		//Create the window
		JFrame window = new JFrame();
		//Indicate that closing the window will shut down the program
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Set screen size
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//canvas_width = screenSize.width;
		//canvas_height = screenSize.height;

		//canvas_width = 1024;
		//canvas_height = 512;
		
		window.setSize(canvas_width, canvas_height*5/4);
		//Indicate that the user can't make the window bigger or smaller
		window.setResizable(true);
		//Setup the title which appears at the top of the window
		window.setTitle("Math Obstacle Game");
		
		//Pop the panel inside the window
		MainGame panel = new MainGame();
		panel.init();
		panel.setFocusable(true);
		window.add(panel);
		
		//Decide on a 'relative' starting location for the window
		window.setLocationRelativeTo(null);
		//Make the window visible on the screen
		window.setVisible(true);	
	}
	

	public void keyPressed(KeyEvent e) {
		if ((e.getKeyCode()==KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_UP) &&
				Player.getY() > 32+64)
		{
			Player.raisePlayerY(-playerSpeed);
			repaint();			
		}
		if ((e.getKeyCode()==KeyEvent.VK_A || e.getKeyCode()==KeyEvent.VK_LEFT) &&
				Player.getX() > 32)
		{
			Player.raisePlayerX(-playerSpeed);
			repaint();			}
		if ((e.getKeyCode()==KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_DOWN) &&
				Player.getY() < getCanvasHeight()-32)
		{

			Player.raisePlayerY(playerSpeed);
			repaint();	

		}
		if ((e.getKeyCode()==KeyEvent.VK_D || e.getKeyCode()==KeyEvent.VK_RIGHT) &&
				Player.getX() < getCanvasWidth()-32)

		{
			Player.raisePlayerX(playerSpeed);
			repaint();	
		}
		if (e.getKeyCode()==KeyEvent.VK_SPACE)
		{
			isInGame = true;
		}
		
		if (e.getKeyCode()==KeyEvent.VK_R)
		{
	
			isInGame = false;
			Player.setScore(0);
			Operators.resetOperators();
			repaint();  
		}

	}
	
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}

	
	

}
