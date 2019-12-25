import java.awt.Color;
import java.awt.Graphics;

public interface ITransport {
	void SetPosition(int x, int y, int width, int height);
	void MoveTransport(Direction direction);
	void DrawWarship(Graphics g);
	Color MainColor();
	Color DopColor();
	int StartPosX();
	int StartPosY();
}
