

import java.awt.Color;
import java.awt.Graphics;

public class TriTower implements IOrudie {
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
	public String toString() {
		return this.getClass().getName();
	}
	@Override
	public void KolOrudie(Graphics g, int positionX, int positionY, Color mainColor) {
		g.setColor(Color.red);
		g.fillRect(positionX + 65, positionY + 7, 13, 3);
		g.setColor(Color.GRAY);
	    g.fillOval(positionX + 53, positionY+4, 13, 12);
		g.setColor(mainColor);
	    g.fillOval(positionX + 50, positionY + 10, 19, 13);
		
	    
		g.setColor(Color.red);
		g.fillRect(positionX + 91, positionY + 19, 13, 3);
		g.setColor(mainColor);
		g.fillOval(positionX + 81, positionY + 16, 10, 10);
		g.setColor(Color.GRAY);
	    g.fillOval(positionX + 78, positionY + 22, 15, 15);
	    
	}
}
