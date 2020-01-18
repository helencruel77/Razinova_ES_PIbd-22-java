
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.Set;

public class Cruiser extends Warship{
	
    private boolean Rocket;
    private boolean Flag;
    public Color DopColor;
    public Cruiser(int maxSpeed, float weight, Color mainColor,  IOrudie orudie,Guns gun, Color dopColor,
    		boolean rocket, boolean flag)
    {
    	super(maxSpeed, weight, mainColor, orudie, gun);
        Rocket = rocket;
        Flag = flag;
        DopColor = dopColor;
    }
    public Cruiser(String save)
    {
    	super(save);
        String[] mas = save.split(";");
        if (mas.length == 8)
        {
        	MaxSpeed = Integer.parseInt(mas[0]);
        	MainColor = toColor(mas[1]);
        	Weight = Float.parseFloat(mas[2]);
        	orudie = toOrudie(mas[3]);
        	gun = toGuns(mas[4]);
        	DopColor=toColor(mas[5]);
            Rocket=Boolean.parseBoolean(mas[6]);
            Flag=Boolean.parseBoolean(mas[7]);
        }
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
	
	@Override
	public String toString()
    {
        return super.toString() + ";" + getNameColor(DopColor)+ ";" + Rocket + ";" + Flag;
    }
}

