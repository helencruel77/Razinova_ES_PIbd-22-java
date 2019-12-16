import java.awt.Color;
import java.awt.Graphics;
import java.util.Set;

public class Doki<T extends ITransport, W extends IOrudie> {
	private T[] places;
	private W[] placesOrudie;
	private int pictureWidth;{Set get;}
	private int pictureHeight; {Set get;}
	private final int placeSizeWidth = 400;
	private final int placeSizeHeight = 80;
	
	public Doki(int sizes, int pictureWidth, int pictureHeight)
	{
		this.places = (T[]) new ITransport[5];
		this.placesOrudie = (W[]) new IOrudie[sizes];
		this.pictureWidth = pictureWidth;
		this.pictureHeight = pictureHeight;
		for (int i = 0; i < places.length; i++)
		{
			places[i] = null;
			placesOrudie[i] = null;
		}
	}
	public int add(T warship, W orudie) {
		for (int i = 0; i < places.length; i++)
		{
			if (this.checkFreePlace(i))
			{
				places[i] = warship;
				places[i].SetPosition(5 + i / 5 * placeSizeWidth + 50, 
						i % 5 * placeSizeHeight + 30, this.pictureWidth, this.pictureHeight);
				placesOrudie[i] = orudie;
				placesOrudie[i].SetPosition(5 + i / 5 * placeSizeWidth + 50,
						i % 5 * placeSizeHeight + 30);
				return i;
			}       	
		}

		return -1;
	}
	public T delete(int index) {
		if (index < 0 || index > places.length)
		{
			return null;
		}
		if (!this.checkFreePlace(index))
		{
			T warship = places[index];
			places[index] = null;
			placesOrudie[index] = null;
			return warship;
		}
		return null;
	}
	
	public boolean more(Doki<ITransport, IOrudie> value) {
    	if (placesOrudie.length > value.placesOrudie.length)
    		return true;
    	return false;
    }
    
    public boolean less(Doki<ITransport, IOrudie> value) {
    	if (placesOrudie.length < value.placesOrudie.length)
    		return true;
    	return false;
    }
	
	private boolean checkFreePlace(int index)
	{
		return (places[index] == null);
	}
	 private void DrawMarking(Graphics g)
	    {
	    	g.setColor(Color.blue);
	    	g.fillRect(0, 0, 800, 425);
	    	g.setColor(Color.black);
	    	 g.drawLine(0, 0, 400, 0);
	            g.drawLine(0, 425, 400, 425);
	            g.drawLine(0, 0, 0, 425);
	        
	            for (int i = 0; i < places.length  ; i++) {
	            	g.drawLine(0, i * placeSizeHeight + 100 + i, placeSizeWidth, i * placeSizeHeight + 100 + i);
	            }
	            
	    }
	 
	 public void draw(Graphics g)
		{
			DrawMarking(g);
			for (int i = 0; i < places.length; i++)
			{
				if (!checkFreePlace(i))
				{
					places[i].DrawWarship(g);
					if (placesOrudie[i] != null) {
						placesOrudie[i].KolOrudie(g, placesOrudie[i].PositionX(),placesOrudie[i].PositionY(), places[i].MainColor());
					}
				}
			}        
		}
	 
}
