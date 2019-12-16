
import java.awt.Color;
import java.awt.Graphics;

public class TriCircle  implements IOrudie{
	private int positionX;
	private int positionY;
	
	public void SetPosition(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}
	@Override
	public int PositionX() {
		return positionX;
	}
	@Override
	public int PositionY() {
		return positionY;
	}
	@Override
	public void KolOrudie(Graphics g, int positionX, int positionY, Color mainColor) {
		g.setColor(Color.red);
	    g.fillRect(positionX + 66, positionY + 10, 13, 3);
	    g.setColor(mainColor);
	    g.fillRect(positionX + 55, positionY + 14, 12, 7);
	    g.fillOval(positionX + 54, positionY + 7, 13, 12);
	    
	    
		g.setColor(Color.red);
		g.fillRect(positionX + 92, positionY + 23, 13, 3);
		g.setColor(Color.GRAY);
	    g.fillRect(positionX + 80, positionY + 23, 12, 7);
	    g.fillOval(positionX + 79, positionY+18, 13, 12);
	}
	
}
