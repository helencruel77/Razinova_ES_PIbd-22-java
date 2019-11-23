
import java.awt.Color;
import java.awt.Graphics;

public class DvaTower  implements IOrudie{
	public void KolOrudie(Guns direction, Graphics g, Color mainColor, Color dopColor) {
		g.setColor(Color.red);
		g.fillRect(Cruiser._startPosX + 65, Cruiser._startPosY + 7, 13, 3);
		g.setColor(Color.GRAY);
	    g.fillOval(Cruiser._startPosX + 53, Cruiser._startPosY+4, 13, 12);
		g.setColor(Warship.MainColor);
	    g.fillOval(Cruiser._startPosX + 50, Cruiser._startPosY + 10, 19, 13);
	}
}
