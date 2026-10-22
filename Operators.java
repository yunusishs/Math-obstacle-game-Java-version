import java.util.Random;

public class Operators {

	public static int opX = 0;
	public static int opY = 0;
	public static int addBy = 0;
	public static int timesBy = 0;
	public static int red = 0;
	public static int green = 0;
	public static int blue = 0;
	
	public static int[][] dividersList;
	public static int[][] addersList;
	public static int[][] multipliersList;
	public static int[][] squaresList;
	public static int[][] cubesList;	
	
	public static void resetOperators()
	{
		dividersList = new int[][] {
			//{0=x, 1=y, 2=red, 3=green, 4=blue}
			
			{416, -160, 31, 31, 31},
			{608, -160, 31, 31, 31},
			{416, -160, 31, 31, 31},
			{608, -160, 31, 31, 31},
		};
	
		addersList = new int[][] {
			//{0=x, 1=y, 2=addvalue, 3=red, 4=green, 5=blue}
			
			{288, -32, 0, 255, 0, 0},
			{288, -32, 0, 255, 0, 0},
			{288, -32, 0, 255, 0, 0},
			{288, -32, 0, 255, 0, 0},
		};


		multipliersList = new int[][] {
			//{0=x, 1=y, 2=multiplyValue, 3=red, 4=green, 5=blue}
			
			{416, -32, 1, 255, 255, 0},
			{416, -32, 1, 255, 255, 0},
			{416, -32, 1, 255, 255, 0},
			{416, -32, 1, 255, 255, 0},
		};
	

		squaresList = new int[][] {
			//{0=x, 1=y, 2=red, 3=green, 4=blue}
			
			{608, -32, 0, 255, 0},
			{608, -32, 0, 255, 0},
			{608, -32, 0, 255, 0},
			{608, -32, 0, 255, 0},
		};

		cubesList = new int [][]{
			//{0=x, 1=y, 2=red, 3=green, 4=blue}
			
			{736, -32, 0, 0, 255},
			{736, -32, 0, 0, 255},
			{736, -32, 0, 0, 255},
			{736, -32, 0, 0, 255},
		};
	} 
		
	public static int[][] getDividersList()
	{
		return dividersList;
	}
	
	public static int[][] getAddersList()
	{
		return addersList;
	}
	
	public static int[][] getMultipliersList()
	{
		return multipliersList;
	}
	public static int[][] getSquaresList()
	{
		return squaresList;
	}

	public static int[][] getCubesList()
	{
		return cubesList;
	}
	
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
	
	public static void editOperatorList(int[][] listName) 
	{
		// each item is its array
		// 0th item in each 2D array is the newest item
		// each item moves one up the index number
		for (int i=3; i>0; i--) // this makes space for the new item
		{
			if (listName == addersList || listName == multipliersList)
			{
				for (int j = 0; j <6; j+=1) // item properties
				{
					listName[i][j] = listName[i-1][j];
				}
			}
			
			else
			{
				for (int j = 0; j <5; j+=1) // item properties
				{
					listName[i][j] = listName[i-1][j];
				}
			}
		}
		
		if (listName == addersList)
		{
			listName[0][0] = getX(); // put the new item in.
			listName[0][1] = getY();
			listName[0][2] = getAddValue();
			listName[0][3] = getRed();
			listName[0][4] = getGreen();
			listName[0][5] = getBlue();

		}

		else if (listName == multipliersList)
		{
			listName[0][0] = getX(); // put the new item in.
			listName[0][1] = getY();
			listName[0][2] = getTimesValue();
			listName[0][3] = getRed();
			listName[0][4] = getGreen();
			listName[0][5] = getBlue();
 
		}
		else
		{
			listName[0][0] = getX(); // put the new item in.
			listName[0][1] = getY();
			listName[0][2] = getRed();
			listName[0][3] = getGreen();
			listName[0][4] = getBlue();
		}
		//System.out.println(listName[0][0]+","+listName[1][0]+","+listName[2][0]+","+listName[3][0]);

	}
	
	
			
	public static void operatorConfigs()
	{
		Random rand = new Random();
		
		// set position
		int opX = rand.nextInt(16)+1;
		setCoords(64*opX-32, 0);
	
		// set color
		int[] colorValues =  {0, 31, 63, 95, 159, 191, 223, 255};
		int randomRedIndex = rand.nextInt(6);
		int randomGreenIndex = rand.nextInt(6);
		int randomBlueIndex = rand.nextInt(6);
		while (randomRedIndex+randomGreenIndex+randomBlueIndex==0) {
			randomRedIndex = rand.nextInt(6);
			randomGreenIndex = rand.nextInt(6);
			randomBlueIndex = rand.nextInt(6);
		}
		setColor(colorValues[randomRedIndex], colorValues[randomGreenIndex],
				colorValues[randomBlueIndex]);
	}

	public static void makeOperators() // this makes their variables but does not spawn them
	{
		Random rand = new Random();
		// The dividers
		operatorConfigs(); // make random configurations
		opY = -32;
		editOperatorList(dividersList); // make space for the new item and put it in. 
		
		// The adders
		operatorConfigs(); // make random configurations
		opY = -96; 
		setAddValue(rand.nextInt(64)-32);
		editOperatorList(addersList);		
		
		// the multipliers
		operatorConfigs(); // make random configurations
		opY = -160; 
		setTimesValue(rand.nextInt(12)-2);
		editOperatorList(multipliersList);		

		// The squares
		int squareOrCube = rand.nextInt(8);
		//if that is 0, spawn a square, if it is 2, spawn a cube, else spawn nothing
		if (squareOrCube ==0)
		{
			operatorConfigs(); // make random configurations
			opY = -224;
			editOperatorList(squaresList);
		}		

		else if (squareOrCube ==1)
		{
			// The cubes
			operatorConfigs(); // make random configurations
			opY = -224;
			editOperatorList(cubesList);	
		}
	
	}
	
	public static void moveOperators(int speed)
	{
		for (int i = 0; i < 4; i+=1)
		{
			dividersList[i][1] += speed;
			addersList[i][1] += speed;
			multipliersList[i][1] += speed;
			squaresList[i][1] += speed;
			cubesList[i][1] += speed;
		}	
	}
	
}
