
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelCruiser extends JPanel{
	ITransport warship;
	public void PanelCruiserSet(ITransport in) {
		this.warship = in;
	}
	public void paint (Graphics g) {
		super.paint(g);
		if (warship != null)
		warship.DrawWarship(g);
	}

}
