
import java.awt.Color;
import java.awt.Graphics;

public class Warship extends Vehicle  {
	protected int warshipWidth = 100;
	protected int warshipHeight = 60;
	protected IOrudie orudie;
	protected Guns gun;
	
	public Warship(String save)
    {
        String[] mas = save.split(";");
        if (mas.length == 5)
        {
        	MaxSpeed = Integer.parseInt(mas[0]);
        	MainColor = toColor(mas[1]);
        	Weight = Float.parseFloat(mas[2]);
            orudie = toOrudie(mas[3]);
            gun = toGuns(mas[4]);
        }
    }
	
	public String getNameColor(Color color) {
		if (color.equals(Color.BLACK)) return "BLACK";
		if (color.equals(Color.WHITE)) return "WHITE";
		if (color.equals(Color.ORANGE)) return "ORANGE";
		if (color.equals(Color.YELLOW)) return "YELLOW";
		if (color.equals(Color.PINK)) return "PINK";
		if (color.equals(Color.BLUE)) return "BLUE";
		if (color.equals(Color.GREEN)) return "GREEN";
		if (color.equals(Color.MAGENTA)) return "MAGENTA";

		return "WHITE";
	}
	
	public Color toColor(String info) {
		if (info.contains("BLACK")) return Color.BLACK;
		if (info.contains("WHITE")) return Color.WHITE;
		if (info.contains("BLUE")) return Color.BLUE;
		if (info.contains("GREEN")) return Color.GREEN;
		if (info.contains("YELLOW")) return Color.YELLOW;
		if (info.contains("PINK")) return Color.PINK;
		if (info.contains("ORANGE")) return Color.ORANGE;
		if (info.contains("MAGENTA")) return Color.MAGENTA;
		return Color.BLACK;
	}
	public IOrudie toOrudie(String info) {
		
		if (info.contains("DvaCircle")) return new DvaCircle();
		if (info.contains("TriCircle")) return new TriCircle();
		if (info.contains("DvaTower")) return new DvaTower();
		if (info.contains("TriTower")) return new TriTower();
		
		return new TriTower();
	}

	public Guns toGuns(String info) {
		
		if (info.contains("One")) return Guns.One;
		if (info.contains("Two")) return Guns.Two;
		if (info.contains("Three")) return Guns.Three;
		if (info.contains("Three")) return Guns.Four;
		return Guns.One;
	}
	public String parseGuns(Guns type) {
		if (type.equals(Guns.One)) return "One";
		if (type.equals(Guns.Two)) return "Two";
		if (type.equals(Guns.Three)) return "Three";
		if (type.equals(Guns.Four)) return "Four";
		return "One";
	}

	public Warship(int maxSpeed, float weight, Color mainColor, IOrudie orudie, Guns gun)
	{
		this.MaxSpeed = maxSpeed;
		this.Weight = weight;
		this.MainColor = mainColor;
		this.orudie = orudie;
		this.gun = gun;
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
	@Override
	public String toString()
    {
        return MaxSpeed + ";" + getNameColor(MainColor)+ ";" + Weight + ";" + orudie.toString() + ";" + parseGuns(gun) ;
    }
}
