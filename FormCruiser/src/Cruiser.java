
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.Set;

public class Cruiser extends Warship{
	private Guns direction;
    private boolean Rocket;
    private boolean Flag;
    private IOrudie orudie;
    public Cruiser(int maxSpeed, float weight, Color mainColor, Color dopColor,
    		boolean rocket, boolean flag)
    {
    	super(maxSpeed, weight, mainColor);
        Rocket = rocket;
        Flag = flag;
        Random rnd = new Random();
        switch (rnd.nextInt(4)+1) {
		case 1:
			orudie = new DvaCircle();
			break;
		case 2:
			orudie = new TriCircle();
			break;
		case 3:
			orudie = new DvaTower();
			break;
		case 4:
			orudie = new TriTower();
			break;
		}
    }
   
    public void SetPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }
    
    
	public void DrawWarship(Graphics g) {
		
		orudie.KolOrudie(direction, g, Color.BLACK, Color.GRAY);
		super.DrawWarship(g);
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

