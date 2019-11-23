
import java.awt.Color;
import java.awt.Graphics;

public class DvaCircle implements IOrudie {
	public void KolOrudie(Guns direction, Graphics g, Color mainColor, Color dopColor) {
		g.setColor(Color.red);
	    g.fillRect(Cruiser._startPosX + 66, Cruiser._startPosY + 10, 13, 3);
	    g.setColor(Warship.MainColor);
	    g.fillRect(Cruiser._startPosX + 55, Cruiser._startPosY + 14, 12, 7);
	    g.fillOval(Cruiser._startPosX + 54, Cruiser._startPosY+7, 13, 12);
	}
}
