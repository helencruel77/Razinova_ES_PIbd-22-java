import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Doki<T extends ITransport, W extends IOrudie> {
	private HashMap<Integer, T> places;
	private HashMap<Integer, W> placesOrudie;
	private int pictureWidth;{Set get;}
	private int pictureHeight; {Set get;}
	private final int placeSizeWidth = 400;
	private final int placeSizeHeight = 80;
	private int maxPlaces;
	
	public Doki(int sizes, int pictureWidth, int pictureHeight)
	{
		places = new HashMap<Integer, T>();
		placesOrudie = new HashMap<Integer, W>();
		this.maxPlaces = 5;
		this.pictureWidth = pictureWidth;
		this.pictureHeight = pictureHeight;
		
	}
	public int plus(T warship, W orudie) {
		for (int i = 0; i < maxPlaces; i++) {
			if (checkFreePlace(i)) {
				places.put(i,warship);
				places.get(i).SetPosition(20 + i / 5 * placeSizeWidth, i % 5 * placeSizeHeight + 50, pictureWidth,
						pictureHeight);
				placesOrudie.put(i,orudie);
				return i;
			}
		}
		return -1;
	}
	
	public int plus(T warship) {
		for (int i = 0; i < maxPlaces; i++)
        {
            if (checkFreePlace(i))
            {
                places.put(i, warship);
                places.get(i).SetPosition(5 + i / 5 * placeSizeWidth + 5, i % 5 * placeSizeHeight + 15, 
                		pictureWidth, pictureHeight);
                return i;
            }
        }

        return -1;
	}
	
	public T minus(int index) {
		if(index<0|| index>maxPlaces)
			return null;
		if(!checkFreePlace(index)) {
			T warship = places.get(index);
			places.put(index,null);
			return warship;
		}
		return null;
	}
	
	public boolean more(Doki<ITransport, IOrudie> value) {
    		return maxPlaces > value.maxPlaces;
	}
    
    public boolean less(Doki<ITransport, IOrudie> value) {
    		return maxPlaces < value.maxPlaces;
    }
	
	private boolean checkFreePlace(int index)
	{
		return places.get(index) == null;
	}
	 private void DrawMarking(Graphics g)
	    {
	    	g.setColor(Color.blue);
	    	g.fillRect(0, 0, 800, 425);
	    	g.setColor(Color.black);
	    	 g.drawLine(0, 0, 400, 0);
	            g.drawLine(0, 425, 400, 425);
	            g.drawLine(0, 0, 0, 425);
	        
	            for (int i = 0; i < maxPlaces  ; i++) {
	            	g.drawLine(0, i * placeSizeHeight + 100 + i, placeSizeWidth, i * placeSizeHeight + 100 + i);
	            }
	            
	    }
	 
	 public void draw(Graphics g)
		{
			DrawMarking(g);
			for (int i = 0; i < maxPlaces; i++)
			{
				if (!checkFreePlace(i))
				{
					places.get(i).DrawWarship(g);
					if (placesOrudie.get(i) != null) {
						placesOrudie.get(i).KolOrudie(g, placesOrudie.get(i).PositionX(),placesOrudie.get(i).PositionY(), places.get(i).MainColor());
					}
				}
			}        
		}
}
