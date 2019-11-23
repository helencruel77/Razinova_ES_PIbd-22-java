

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.Set;

public class Cruiser {
    public static int _startPosX;
  
    public static int _startPosY;
   
    private int _pictureWidth;
 
    private int _pictureHeight;
    
    private  int carWidth = 100;
    
    private  int carHeight = 60;
    
    public int MaxSpeed; { Set get; }
    
    public float Weight; { Set get1; }
    
    public static Color MainColor; { Set get2; }
    
    public static Color DopColor; {  Set get3; }
    
    public static  boolean Rocket; { Set get4; }
    
    public static boolean Flag; { Set get6; }

    public Cruiser(int maxSpeed, float weight, Color mainColor, Color dopColor,
    		boolean rocket, boolean flag)
    {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        DopColor = dopColor;
        Rocket = rocket;
        Flag = flag;
    }
   
    public void SetPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }
    
    public void MoveTransport(Direction direction)
    {
        float step = MaxSpeed * 100 / Weight;
        switch (direction)
        {
           
            case Right:
                if (_startPosX + step < _pictureWidth - carWidth)
                {
                    _startPosX += step;
                }
                
                break;
            
            case Left:
                if (_startPosX - step > 0)

                {
                    _startPosX -= step;
                }
                break;
            
            case Up:
                if (_startPosY - step > 0)
                {
                    _startPosY -= step;
                }
                break;
            
            case Down:
                if (_startPosY + step < _pictureHeight - carHeight)
                {
                    _startPosY += step;
                }
                break;
        }
    }
	
	public static void DrawCruiser(Graphics g) {
		g.setColor(MainColor);
		g.fillRect( _startPosX, _startPosY + 30, 90, 15);
		g.setColor(DopColor);
		g.fillRect(_startPosX + 20, _startPosY + 20, 55, 10);
		g.setColor(MainColor);
	    g.fillRect(_startPosX + 30, _startPosY,15, 20);

	    if (Rocket)
        {
        	g.setColor(DopColor);
        	
        	g.fillRect( _startPosX+30, _startPosY + 45, 3, 10);
        	
        	g.setColor(Color.DARK_GRAY);
        	g.fillOval( _startPosX+15, _startPosY + 53, 35, 5);
        	g.fillOval( _startPosX+45, _startPosY + 53, 5, 5);
        	g.setColor(Color.RED);
        	g.fillRect( _startPosX+45, _startPosY + 54, 3, 4);
        }
		if(Flag)
		{
			g.setColor(Color.white);
		    g.fillRect(_startPosX + 35, _startPosY + 33, 18, 3);
		    g.setColor(Color.blue);
		    g.fillRect( _startPosX + 35, _startPosY + 36, 18, 3);
		    g.setColor(Color.red);
		    g.fillRect(_startPosX + 35, _startPosY + 39, 18, 3);
		}
	}
}

