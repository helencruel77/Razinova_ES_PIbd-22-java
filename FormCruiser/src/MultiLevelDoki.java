import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MultiLevelDoki {
	ArrayList<Doki<ITransport, IOrudie>> parkingStages;
	private int pictureWidth;
    private int pictureHeight;
	
	private int countPlaces = 5;
	 public MultiLevelDoki(int countStages, int pictureWidth, int pictureHeight)
     {
		 parkingStages = new ArrayList<Doki<ITransport, IOrudie>>();
         for (int i = 0; i < countStages; ++i)
         {
             parkingStages.add(new Doki<ITransport, IOrudie>(countPlaces, pictureWidth,
            pictureHeight));
         }
     }
	 public Doki<ITransport, IOrudie> getDoki(int ind)
	    {
	    	if (ind > -1 && ind < parkingStages.size())
	        {
	            return parkingStages.get(ind);
	        }
	        return null;
	    }
	 
	 public ITransport getTransport(int index, int level) {
			if (level > -1 && level < parkingStages.size()) {
				ITransport plane = parkingStages.get(level).minus(index);
				return plane;
			}
			return null;
		}

}
