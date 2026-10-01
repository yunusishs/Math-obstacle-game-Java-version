public class Player {
	
	//String PLAYER_NAME = "";
	static int playerX = MainGame.getCanvasWidth()/2;
	static int playerY = MainGame.getCanvasHeight()/2;
	
	public static int score = 0;
	
	public Player(int xCoord, int yCoord)
	{
		playerX = xCoord;
		playerY = yCoord;
	}
	
	//getting the coords
	
	public static int getX()
	{
		return playerX;
	}
	
	public static int getY()
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
	public static int getScore()
	{
		return score;
	}
	
	public static void setScore(int setValue)
	{
		score = setValue;
	}


}

