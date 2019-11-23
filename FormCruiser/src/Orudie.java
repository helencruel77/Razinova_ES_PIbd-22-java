
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class Orudie {
	
	public static void ORudie(Guns direction, Graphics g) {
		 switch (direction)
	     {
	     	case One:
	     		Odin(g);
	     		break;
     		case Two:
            	Dva(g);
            	break;
 			case Three:
     			Tri(g);
     			break;
	     }
	}
	
	public static void Odin (Graphics g ) {
    	g.setColor(Cruiser.MainColor);
        g.fillOval(Cruiser._startPosX + 55, Cruiser._startPosY + 10, 15, 15);
        g.setColor(Color.red);
        g.fillRect(Cruiser._startPosX + 70, Cruiser._startPosY + 15, 15, 3);
    }
	
    public static void Dva (Graphics g) {
    	 Odin(g);
         g.setColor(Cruiser.DopColor);
         g.fillOval(Cruiser._startPosX, Cruiser._startPosY + 20, 15, 15);
         g.setColor(Color.red);
         g.fillRect( Cruiser._startPosX - 10, Cruiser._startPosY + 25, 11, 3);
    }
    
    public static void Tri (Graphics g) {
    	Dva(g);
        g.setColor(Cruiser.DopColor);
        g.fillOval(Cruiser._startPosX+27, Cruiser._startPosY-18 , 20, 20);
        g.setColor(Color.red);
        g.fillRect(Cruiser._startPosX + 47, Cruiser._startPosY-9 , 15, 3);
    }
}

