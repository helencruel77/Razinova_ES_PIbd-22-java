
import java.awt.Color;
import java.awt.Graphics;

public class DvaTower  implements IOrudie{
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
		g.fillRect(positionX + 65, positionY + 7, 13, 3);
		g.setColor(Color.GRAY);
	    g.fillOval(positionX + 53, positionY + 4, 13, 12);
		g.setColor(mainColor);
	    g.fillOval(positionX + 50, positionY + 10, 19, 13);
	}
}
