import java.util.Random;

public class Player {
	
	String PLAYER_NAME = "";
	static int playerX = MainGame.getCanvasWidth()/2;;
	static int playerY = MainGame.getCanvasHeight()/2;
	String checkInput = "";
	
	public static int x = 0;
	
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
	
	//score
	public int getScore()
	{
		return x;
	}
	


}

