
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class PanelCruiser extends JPanel{
	ITransport warship;
	public PanelCruiser(ITransport in) {
		warship = in;
	}
	public void paint (Graphics g) {
		super.paint(g);
		warship.DrawWarship(g);
	}

}
