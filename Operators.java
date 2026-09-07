
public class Operators {

	public static int opX = 0;
	public static int opY = 0;
	public static int addBy = 0;
	public static int timesBy = 0;
	public static int red = 0;
	public static int green = 0;
	public static int blue = 0;
	
	public void createAdder(int xCoord, int yCoord, int addValue, int r, int g, int b)
	{
		opX = xCoord;
		opY = yCoord;
		addBy = addValue;
		red = r;
		green = g;
		blue = b;
	}

	public void createMultiplier(int xCoord, int yCoord, int timesValue, int r, int g, int b)
	{
		opX = xCoord;
		opY = yCoord;
		timesBy = timesValue;
		red = r;
		green = g;
		blue = b;
	}

	public void createSquare(int xCoord, int yCoord, int r, int g, int b)
	{
		opX = xCoord;
		opY = yCoord;
		red = r;
		green = g;
		blue = b;
	}
	
	public void createCube(int xCoord, int yCoord, int r, int g, int b)
	{
		opX = xCoord;
		opY = yCoord;
		red = r;
		green = g;
		blue = b;
	}
	
	public static int getX()
	{
		return opX;
	}
	
	public static int getY()
	{
		return opY;
	}

	public static int getAddValue()
	{
		return addBy;
	}
	
	public static int getTimesValue()
	{
		return timesBy;
	}
	public static int getRed()
	{
		return red;
	}
	public static int getGreen()
	{
		return green;
	}
	public static int getBlue()
	{
		return blue;
	}


	public static void setCoords(int xCoord, int yCoord)
	{
		opX = xCoord;
		opY = yCoord;
	}
	
	public static void setColor(int r, int g, int b)
	{
		red = r;
		green = g;
		blue = b;
	}
	
	public static void setAddValue(int addValue)
	{
		addBy = addValue;
	}

	public static void setTimesValue(int timesValue)
	{
		timesBy = timesValue;
	}
	
}
