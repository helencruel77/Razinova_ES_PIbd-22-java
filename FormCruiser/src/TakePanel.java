import java.awt.Graphics;

import javax.swing.JPanel;

public class TakePanel  extends JPanel {
	public ITransport warship;
	public IOrudie orudie;
	
	public void drawWarship(ITransport transport, IOrudie wagon ) {
		this.warship = transport;
		this.orudie = wagon;
	}
	public void clear() {
		warship = null;
		orudie = null;
	}
	public void paint(Graphics g) {
		super.paint(g);
		if (warship != null) {
			warship.DrawWarship(g);
			if (orudie != null) {
				orudie.SetPosition(warship.StartPosX(), warship.StartPosY());
				orudie.KolOrudie(g, orudie.PositionX(), orudie.PositionY(),
						warship.MainColor());
			}
		}
	}
}