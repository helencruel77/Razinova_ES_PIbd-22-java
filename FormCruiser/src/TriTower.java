

import java.awt.Color;
import java.awt.Graphics;

public class TriTower implements IOrudie {
	public void KolOrudie(Guns direction, Graphics g, Color mainColor, Color dopColor) {
		g.setColor(Color.red);
		g.fillRect(Cruiser._startPosX + 65, Cruiser._startPosY + 7, 13, 3);
		g.setColor(Color.GRAY);
	    g.fillOval(Cruiser._startPosX + 53, Cruiser._startPosY+4, 13, 12);
		g.setColor(Warship.MainColor);
	    g.fillOval(Cruiser._startPosX + 50, Cruiser._startPosY + 10, 19, 13);
		
	    
		g.setColor(Color.red);
		g.fillRect(Cruiser._startPosX + 91, Cruiser._startPosY + 19, 13, 3);
		g.setColor(Warship.MainColor);
		g.fillOval(Cruiser._startPosX + 81, Cruiser._startPosY+16, 10, 10);
		g.setColor(Color.GRAY);
	    g.fillOval(Cruiser._startPosX + 78, Cruiser._startPosY + 22, 15, 15);
	    
	}
}
