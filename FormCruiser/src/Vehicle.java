
import java.awt.Color;
import java.awt.Graphics;

public abstract class Vehicle implements ITransport {
	protected static int _startPosX;
    protected static int _startPosY;
    protected int _pictureWidth;
    protected int _pictureHeight;
    protected int MaxSpeed;
    protected int Weight;
    protected static Color MainColor;
    protected static Color DopColor;
    public int getMaxSpeed() {
		return MaxSpeed;
	}
	protected void setMaxSpeed(int MaxSpeed) {
		this.MaxSpeed = MaxSpeed;
	}
	public int getWeight() {
		return Weight;
	}
	protected void setWeight(float weight2) {
		this.Weight = (int) weight2;
	}
	public Color getMainColor() {
		return MainColor;
	}
	protected void setMainColor(Color MainColor) {
		this.MainColor = MainColor;
	}
	public Color getDopColor() {
		return DopColor;
	}
	protected void setDopColor(Color dopColor) {
		this.DopColor = dopColor;
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
