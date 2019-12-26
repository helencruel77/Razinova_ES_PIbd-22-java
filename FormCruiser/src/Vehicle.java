
import java.awt.Color;
import java.awt.Graphics;
import java.util.Set;

public abstract class Vehicle implements ITransport {
	int _startPosX;
	int _startPosY;
	protected  int _pictureWidth;
	protected int _pictureHeight;
	public int MaxSpeed; {  Set get;}
	public float Weight; { Set get;}
	public Color MainColor;  
	public Color DopColor; 
	public int StartPosX() {
		return _startPosX;
	}
	public int StartPosY() {
		return _startPosY;
	}
	public Color MainColor() {
		return MainColor;
	}
	public Color DopColor() {
		return DopColor;
	}
	  public void SetColor(Color color)
	    {
		  MainColor = color;
	    }
	public void SetPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }
	public abstract void DrawWarship(Graphics g); 
	public abstract void MoveTransport(Direction direction);
}
