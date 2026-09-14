import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

/**
 * 
 * @author Yunus Ishs
 * 
 */

public class MainGame extends JPanel implements KeyListener {
	
	//public Operators operator;
	//canvas configurations
	public static int canvas_width = 1280;
	public static int canvas_height = 640;
	
	// fonts and colors
	Color black = new Color(0,0,0);
	Color white = new Color(255,255,255);
	Font opFont = new Font("Cambria Math", Font.ITALIC, 40);
	Font playerFont = new Font("Cambria Math", Font.ITALIC, 40);
	Font statsFont = new Font("Cambria Math", Font.ITALIC, 32);

	private Player player1;

	
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
		player1 = new Player(MainGame.getCanvasWidth()/2, MainGame.getCanvasHeight()/2);
	}

	public MainGame()
	{
		addKeyListener(this);
	}
	// method to make the player
	
	
	public void makePlayer(Graphics g, int xCoord, int yCoord)
	{
		// player box
		g.setColor(new Color(0,0,255));
		g.fillRect(player1.getX()-32, player1.getY()-32, 64, 64);

		//player symbol
		g.setColor(white);
		g.setFont(playerFont);
		g.drawString("x",player1.getX()-10,player1.getY()+10);
	}
	// method to make dividers
	
	public void makeDivider(Graphics g, int xCoord, int yCoord, 
			int red, int green, int blue)
	{
		//division box
		g.setColor(new Color(Operators.getRed(), Operators.getGreen(), Operators.getBlue()));
		g.fillRect(Operators.getX()-32, Operators.getY()-32, 64, 64);
		
		//division text
		char divisionChar = (char) 247;
		String divisionString = String.valueOf(divisionChar);
		g.setColor(new Color(255-Operators.getRed(), 255-Operators.getGreen(), 255-Operators.getBlue()));
		g.setFont(opFont);
		g.drawString(divisionString+"0",Operators.getX()-24, Operators.getY()+12);
	}
	
	// method to make adders
	
	public void makeAdder(Graphics g, int addValue, int xCoord, int yCoord, 
			int red, int green, int blue)
	{
		//adder box
		Operators.setCoords(xCoord, yCoord);
		Operators.setColor(red, green, blue);
		g.setColor(new Color(Operators.getRed(), Operators.getGreen(), Operators.getBlue()));
		g.fillRect(Operators.getX()-32, Operators.getY()-32, 64, 64);
		
		//adder text
		Operators.setAddValue(addValue);
		g.setColor(new Color(255-Operators.getRed(), 255-Operators.getGreen(), 255-Operators.getBlue()));
		g.setFont(opFont);
		g.drawString("+"+Operators.getAddValue(),Operators.getX()-32, Operators.getY()+12);
	}
	
	// method to make multipliers
	
	public void makeMultiplier(Graphics g, int timesValue, int xCoord, int yCoord,
			int red, int green, int blue)
	{
		//multiplier box
		Operators.setCoords(xCoord, yCoord);
		Operators.setColor(red, green, blue);
		g.setColor(new Color(Operators.getRed(), Operators.getGreen(), Operators.getBlue()));
		g.fillRect(Operators.getX()-32, Operators.getY()-32, 64, 64);
	
		//multiplier text
		Operators.setTimesValue(timesValue);
		char timesChar = (char) 215;
		String timesString = String.valueOf(timesChar);
		g.setColor(new Color(255-Operators.getRed(), 255-Operators.getGreen(), 255-Operators.getBlue()));
		g.setFont(opFont);
		g.drawString(timesString+Operators.getTimesValue(),Operators.getX()-32, Operators.getY()+12);
	}
	
	//method to make squares
	
	public void makeSquare(Graphics g, int xCoord, int yCoord, 
			int red, int green, int blue)
	{		
		//square box
		Operators.setCoords(xCoord, yCoord);
		Operators.setColor(red, green, blue);
		g.setColor(new Color(Operators.getRed(), Operators.getGreen(), Operators.getBlue()));
		g.fillRect(Operators.getX()-32, Operators.getY()-32, 64, 64);
		
		//square text
		char squareChar = (char) 178;
		String squareString = String.valueOf(squareChar);
		g.setColor(new Color(255-Operators.getRed(), 255-Operators.getGreen(), 255-Operators.getBlue()));
		g.setFont(opFont);
		g.drawString("x"+squareString,Operators.getX()-16, Operators.getY()+12);
	}
	
	//method to make cubes
	
	public void makeCube(Graphics g, int xCoord, int yCoord, 
			int red, int green, int blue)
	{	//cube box
		Operators.setCoords(xCoord, yCoord);
		Operators.setColor(red, green, blue);
		g.setColor(new Color(Operators.getRed(), Operators.getGreen(), Operators.getBlue()));
		g.fillRect(Operators.getX()-32, Operators.getY()-32, 64, 64);
		
		//cube text
		char cubeChar = (char) 179;
		String cubeString = String.valueOf(cubeChar);
		g.setColor(new Color(255-Operators.getRed(), 255-Operators.getGreen(), 255-Operators.getBlue()));
		g.setFont(opFont);
		g.drawString("x"+cubeString,Operators.getX()-16, Operators.getY()+12);
	}
	
	// these lines are not necessary

	public void drawBgLines(Graphics g) {
	//horizontal lines
	for (int i=64; i<canvas_height; i+=64)
		g.drawLine(0, i, canvas_width, i);
	g.drawLine(0, canvas_height/2, canvas_width, canvas_height/2);
	
	//vertical lines
	for (int i=64; i<canvas_width; i+=64)
		g.drawLine(i, 0, i, canvas_height);
	}
	
	public void makeOperators(Graphics g)
	{
		Random rand = new Random();
		int[] colorValues =  {32, 64, 96, 192, 224, 256};
		
		//for (int i=0; i<4; i+=1)
			
		Operators.operatorConfigs(); // make random configurations
		int xPosition = rand.nextInt(20); // random x coordinate
		makeDivider(g, 64*xPosition-32, 0, 95,95, 95); // spawn it
		
		//Operators.operatorConfigs();
		//xPosition = rand.nextInt(20);
		//makeAdder(g, 0, 64*xPosition-32, 128, 31,31, 31);
		
		//xPosition = rand.nextInt(20);
		//makeMultiplier(g, 0, 64*xPosition-32, 128, 63,63, 63);
		//xPosition = rand.nextInt(20);
		//makeDivider(g, 64*xPosition-32, 128, 95,95, 95);
		//xPosition = rand.nextInt(20);
		//makeSquare(g, 64*xPosition-32, 128, 223,223, 223);
		//xPosition = rand.nextInt(20);
		//makeCube(g, 64*xPosition-32, 128, 255,255, 255);
		
		
	}
	
	public void moveOperators(Graphics g)
	{
		//Random rand = new Random();
		
		
	}
	
	public void paintComponent(Graphics g)
	{
		//set colors

		
	
		// background
		g.setColor(black);
		g.fillRect(0, 0, canvas_width, canvas_height);
		
		g.setColor(white);
		
		//drawBgLines(g);
		
		
		makePlayer(g, player1.getX(), getY());
		
		
		//score display
		g.setColor(new Color(0,0,0));
		g.setFont(statsFont);
		g.drawString("x="+player1.getScore(),canvas_width/2, canvas_height+64);
	
	}
	
	public static void main(String[] args)
	{
		
		//Create the window
		JFrame window = new JFrame();
		//Indicate that closing the window will shut down the program
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Set screen size
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
		if (e.getKeyCode()==KeyEvent.VK_W)
		{
			System.out.print("Jordan, ");
			player1.raisePlayerY(-8);
			repaint();			
		}
		if (e.getKeyCode()==KeyEvent.VK_A)
		{
			System.out.print("that ");
			player1.raisePlayerX(-8);
			repaint();			}
		if (e.getKeyCode()==KeyEvent.VK_S)
		{
			System.out.print("is ");

			player1.raisePlayerY(8);
			repaint();	

		}
		if (e.getKeyCode()==KeyEvent.VK_D)
		{
			System.out.print("enough!");
			player1.raisePlayerX(8);
			repaint();	
		}
	}
	
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}

	
	

}
