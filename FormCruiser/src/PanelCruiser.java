
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class PanelCruiser extends JPanel{
	public PanelCruiser(Cruiser array) {
		
	}
	Random rnd = new Random();
	int kol = rnd.nextInt(3)+1;
	
	public void paint (Graphics g) {
		super.paint(g);
		Cruiser.DrawCruiser(g);
		switch (kol) {
		case 1:
			Orudie.ORudie(Guns.One, g);
			break;
		case 2:
			Orudie.ORudie(Guns.Two, g);
			break;
		case 3:
			Orudie.ORudie(Guns.Three, g);
		}
	}

}
