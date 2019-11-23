
import java.awt.Color;
import java.awt.Graphics;

public class TriCircle  implements IOrudie{
	
	public void KolOrudie(Guns direction, Graphics g, Color mainColor, Color dopColor) {
		g.setColor(Color.red);
	    g.fillRect(Cruiser._startPosX + 66, Cruiser._startPosY + 10, 13, 3);
	    g.setColor(Warship.MainColor);
	    g.fillRect(Cruiser._startPosX + 55, Cruiser._startPosY + 14, 12, 7);
	    g.fillOval(Cruiser._startPosX + 54, Cruiser._startPosY+7, 13, 12);
	    
	    
		g.setColor(Color.red);
		g.fillRect(Cruiser._startPosX + 92, Cruiser._startPosY + 23, 13, 3);
		g.setColor(Color.GRAY);
	    g.fillRect(Cruiser._startPosX + 80, Cruiser._startPosY + 23, 12, 7);
	    g.fillOval(Cruiser._startPosX + 79, Cruiser._startPosY+18, 13, 12);
	}
	
}
