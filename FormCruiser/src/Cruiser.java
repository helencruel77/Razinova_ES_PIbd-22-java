
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.Set;

public class Cruiser extends Warship{
	private Guns direction;
    private boolean Rocket;
    private boolean Flag;
    public Color DopColor;
    private IOrudie orudie;
    public Cruiser(int maxSpeed, float weight, Color mainColor, Color dopColor, IOrudie orudie,
    		boolean rocket, boolean flag)
    {
    	super(maxSpeed, weight, mainColor, orudie);
        Rocket = rocket;
        Flag = flag;
        DopColor = dopColor;
    }
   
    public void setOrudie(IOrudie orudie) {
    	orudie = orudie;
		
	}
    
	public void DrawWarship(Graphics g) {
		
		super.DrawWarship(g);
	    if (Rocket)
        {
        	g.setColor(MainColor);
        	g.fillRect( _startPosX+30, _startPosY + 45, 3, 10);
        	g.setColor(DopColor);
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
	
	public void setDopColor(Color DopColor) {
		this.DopColor = DopColor;
	}
}

