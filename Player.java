import java.util.Random;

public class Player {
	
	String PLAYER_NAME = "";
	static int playerX = MainGame.getCanvasWidth()/2;
	static int playerY = MainGame.getCanvasHeight()/2;
	String checkInput = "";
	
	public static int score = 0;
	
	public Player(String name, int xCoord, int yCoord)
	{
		PLAYER_NAME = name;
		playerX = xCoord;
		playerY = yCoord;
	}
	
	//getting the coords
	
	public int getX()
	{
		return playerX;
	}
	
	public int getY()
	{
		return playerY;
	}
	
	//changing the coords
	public static void setCoords(int xCoord, int yCoord)
	{
		playerX = xCoord;
		playerY = yCoord;
	}
	
	public static void raisePlayerX(int raiseBy)
	{
		playerX = playerX+raiseBy;
	}

	public static void raisePlayerY(int raiseBy)
	{
		playerY = playerY+raiseBy;
	}
	//score
	public int getScore()
	{
		return score;
	}
	


}

