
import java.awt.Color;
import java.awt.Graphics;

public class Warship extends Vehicle  {
	protected int warshipWidth = 100;
	protected int warshipHeight = 60;
	
	protected IOrudie orudie;
	
	public Warship(int maxSpeed, float weight, Color mainColor, IOrudie orudie)
	{
		this.MaxSpeed = maxSpeed;
		this.Weight = weight;
		this.MainColor = mainColor;
		this.orudie = orudie;
	}
	
	public void setGuns(IOrudie orudie) {
		this.orudie = orudie;
	}
	
	@Override
	public void DrawWarship(Graphics g) {
		g.setColor(MainColor);
		g.fillRect( _startPosX+5, _startPosY + 30, 90, 15);
		g.setColor(Color.gray);
		g.fillRect(_startPosX + 30, _startPosY, 15, 20);
		g.fillRect(_startPosX + 20, _startPosY + 20, 55, 10);
		orudie.KolOrudie(g, _startPosX, _startPosY, MainColor);
	}
	@Override
	public void MoveTransport(Direction direction) {
		float step = MaxSpeed * 100 / Weight;
		switch (direction)
		{
		case Right:
			if (_startPosX + step < _pictureWidth - warshipWidth)
			{
				_startPosX += step;
			}
			break;
		case Left:
			if (_startPosX - step > 0)
			{
				_startPosX -= step;
			}
			break;
		case Up:
			if (_startPosY - step > 0)
			{
				_startPosY -= step;
			}
			break;
		case Down:
			if (_startPosY + step < _pictureHeight - warshipHeight)
			{
				_startPosY += step;
			}
			break;
		}
	}
}
