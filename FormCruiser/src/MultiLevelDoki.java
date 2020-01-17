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
	 public boolean Save(String filename) throws IOException
	    {
	    	File file = new File(filename);
	        if (file.exists())
	        {
	            file.delete();
	        }
	        try (FileWriter fs = new FileWriter(filename, false)) {
			    fs.write("CountLeveles:" + parkingStages.size());
			    fs.write("\n");
			    for (Doki<ITransport, IOrudie> level : parkingStages) {
			        fs.write("Level\n");
			        for (int i = 0; i < countPlaces; i++)
			        {
			            ITransport warship = level.getPlace(i);
			            if (warship != null)
			            {
			                if (warship.getClass().getName() == "Warship")
			                {
			                    fs.write(i + ":Warship:");
			                }
			                if (warship.getClass().getName() == "Cruiser")
			                {
			                    fs.write(i + ":Cruiser:");
			                }
			                fs.write(warship.toString() + "\n");   
			            }
			        }
			    }
	        }
	        return true;
	    }
	public boolean Load(String string) throws NumberFormatException, IOException {
		File file = new File(string);
        if (!file.exists())
        {
            return false;
        }
        try (BufferedReader fs = new BufferedReader(new FileReader(file)))
        {
            String line = fs.readLine();
            if (line.contains("CountLeveles"))
            {
                int count = Integer.parseInt(line.split(":")[1]);
                if (parkingStages != null)
                {
                	parkingStages.clear();
                }
                parkingStages = new ArrayList<Doki<ITransport, IOrudie>>(count);
            }
            else
            {
                return false;
            }
            int counter = -1;
            ITransport warship = null;
            while ((line = fs.readLine()) != null)
            {
                if (line.contains("Level"))
                {
                    counter++;
                    parkingStages.add(new Doki<ITransport, IOrudie>(countPlaces, pictureWidth, pictureHeight));
                    continue;
                }
                if (line == null || line == "")
                {
                    continue;
                }
                String[] mas = line.split(":");
                if (line.split(":")[1].contains("Warship"))
                {
                	warship = new Warship(line.split(":")[2]);
                }
                else if (line.split(":")[1].contains("Cruiser"))
                {
                	warship = new Cruiser(line.split(":")[2]);
                }
                parkingStages.get(counter).setPlace(Integer.parseInt(line.split(":")[0]), warship);
            }
        }
        return true;
    }
	 public boolean SaveLevel(String filename, int lvl) throws IOException
    {
    	if (lvl > parkingStages.size() || lvl < 0)
    		return false;
    	File file = new File(filename);
        if (file.exists())
        {
            file.delete();
        }
        try (FileWriter fs = new FileWriter(filename, false)) {
        	Doki<ITransport, IOrudie> level = parkingStages.get(lvl);
        	 for (int i = 0; i < countPlaces; i++)
		        {
		            ITransport warship = level.getPlace(i);
		            if (warship != null)
		            {
		                if (warship.getClass().getName() == "Warship")
		                {
		                    fs.write(i + ":Warship:");
		                }
		                if (warship.getClass().getName() == "Cruiser")
		                {
		                    fs.write(i + ":Cruiser:");
		                }
		                fs.write(warship.toString() + "\n");   
		            }
		        }
        }
        catch (Exception e) {
        	return false;
		}
        return true;
    }
	
	 public boolean LoadLvl(String filename, int lvl) throws NumberFormatException, IOException
	    {
	    	if (lvl > parkingStages.size() || lvl < 0)
	    		return false;
	    	File file = new File(filename);
	        if (!file.exists())
	        {
	            return false;
	        }
	        parkingStages.set(lvl, new Doki<ITransport, IOrudie>(countPlaces, pictureWidth, pictureHeight));
	        try (BufferedReader fs = new BufferedReader(new FileReader(file)))
	        {
	        	String line = "";
	            ITransport warship = null;
	        	while ((line = fs.readLine()) != null) {
	        		if (line == null || line == "")
			        {
			            continue;
			        }
		            String[] mas = line.split(":");
		            if (line.split(":")[1].contains("Warship"))
		            {
		                warship = new Warship(line.split(":")[2]);
		            }
		            else if (line.split(":")[1].contains("Cruiser"))
		            {
		                warship = new Cruiser(line.split(":")[2]);
		            }
		            parkingStages.get(lvl).setPlace(Integer.parseInt(line.split(":")[0]), warship);
		        	}
	        }
	        catch (Exception e) {
	        	return false;
			}
	        return true;
	    }
}
