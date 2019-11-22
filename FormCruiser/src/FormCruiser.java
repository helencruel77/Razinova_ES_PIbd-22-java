
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
public class FormCruiser {

	private JFrame frame;
	private JPanel panel;
	private ITransport warship;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCruiser window = new FormCruiser();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormCruiser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton buttonCreateWarship = new JButton("\u0441\u043E\u0437\u0434\u0430\u0442\u044C \u0432\u043E\u0435\u043D\u043D\u044B\u0439 \u043A\u043E\u0440\u0430\u0431\u043B\u044C");
		buttonCreateWarship.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random rnd = new Random();
				warship = new Warship(rnd.nextInt(30)+20, rnd.nextInt(60)+140, Color.black);				
				panel = new PanelCruiser(warship);
				panel.setBounds(10, 10, 900, 500);
				frame.getContentPane().add(panel);
				warship.SetPosition(rnd.nextInt(50)+50, rnd.nextInt(50)+50, 
				panel.getWidth(), panel.getHeight());				
				panel.repaint();
			}
		});
		buttonCreateWarship.setBounds(10, 11, 216, 23);
		frame.getContentPane().add(buttonCreateWarship);
		
		JButton buttonUp = new JButton("");
		buttonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				warship.MoveTransport(Direction.Up);
				panel.repaint();
			}
		});
		buttonUp.setFont(new Font("Tahoma", Font.PLAIN, 8));
		buttonUp.setBounds(775, 335, 40, 40);
		frame.getContentPane().add(buttonUp);
		
		JButton btnRight = new JButton("");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				warship.MoveTransport(Direction.Right);
				panel.repaint();
			}
		});
		btnRight.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnRight.setBounds(813, 372, 40, 40);
		frame.getContentPane().add(btnRight);
		
		JButton buttonDown = new JButton("");
		buttonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				warship.MoveTransport(Direction.Down);
				panel.repaint();
			}
		});
		buttonDown.setFont(new Font("Tahoma", Font.PLAIN, 8));
		buttonDown.setBounds(775, 410, 40, 40);
		frame.getContentPane().add(buttonDown);
		
		JButton buttonLeft = new JButton("");
		buttonLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				warship.MoveTransport(Direction.Left);
				panel.repaint();
			}
		});
		buttonLeft.setFont(new Font("Tahoma", Font.PLAIN, 8));
		buttonLeft.setBounds(737, 372, 40, 40);
		frame.getContentPane().add(buttonLeft);
		
		JButton button = new JButton("\u0441\u043E\u0437\u0434\u0430\u0442\u044C \u043A\u0440\u0435\u0439\u0441\u0435\u0440");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Random rnd = new Random();
				warship = new Cruiser(rnd.nextInt(30)+20, rnd.nextInt(60)+140,
						Color.black, Color.gray, true, true);				
				panel = new PanelCruiser(warship);
				panel.setBounds(10, 10, 900, 500);
				frame.getContentPane().add(panel);
				warship.SetPosition(rnd.nextInt(50)+50, rnd.nextInt(50)+50, 
		                panel.getWidth(), panel.getHeight());				
				panel.repaint();
			}
		});
		button.setBounds(236, 11, 173, 23);
		frame.getContentPane().add(button);
	}
}
