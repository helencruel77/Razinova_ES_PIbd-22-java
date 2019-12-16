
import java.awt.Color;
import java.awt.Graphics;

public interface IOrudie {
	void SetPosition(int x, int y);
	public int PositionX();
	public int PositionY();
	public void KolOrudie(Graphics g, int positionX, int positionY, Color mainColor);
}
