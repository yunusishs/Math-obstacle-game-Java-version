import java.util.Random;

public class Operators {

	public static int opX = 0;
	public static int opY = 0;
	public static int addBy = 0;
	public static int timesBy = 0;
	public static int red = 0;
	public static int green = 0;
	public static int blue = 0;
	
	public static int[][] dividersList = {
			//{0=x, 1=y, 2=red, 3=green, 4=blue}
			{0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0},
	};
	
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

	public static int[][] getDividersList()
	{
		return dividersList;
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
	
	public static void editOperatorList(int[][] listName) 
	{
		for (int i=0; i<4; i+=1) // this makes space for the new item
		{
			if (i < 4)
				for (int j = 0; j <5; j+=1)
					
					listName[i][j] = listName[i+1][j];
		}
		
		listName[0][0] = getX(); // put the new item in.
		listName[0][1] = getY();
		listName[0][2] = getRed();
		listName[0][3] = getGreen();
		listName[0][4] = getBlue();
	}
	
	
			
	public static void operatorConfigs()
	{
		Random rand = new Random();
		
		// set position
		int opX = rand.nextInt(20);
		setCoords(64*opX-32, 128);
	
		// set color
		int[] colorValues =  {32, 64, 96, 192, 224, 256};
		int randomRedIndex = rand.nextInt(6);
		int randomGreenIndex = rand.nextInt(6);
		int randomBlueIndex = rand.nextInt(6);
		setColor(colorValues[randomRedIndex], colorValues[randomGreenIndex],
				colorValues[randomBlueIndex]);
	}

	public static void makeOperators()
	{
		Random rand = new Random();		
	
		// The dividers
		operatorConfigs(); // make random configurations
		opX = rand.nextInt(20); // random x coordinate		
		editOperatorList(dividersList); // make space for the new item and put it in. 
		
	}
}
