import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelDoki extends JPanel {
	private Doki<ITransport, IOrudie> doki;
	
	public PanelDoki(Doki<ITransport, IOrudie> doki) {
		this.doki = doki;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		doki.draw(g);
	}

	public void setDoki(Doki<ITransport, IOrudie> doki) {
		this.doki = doki;
	}
}