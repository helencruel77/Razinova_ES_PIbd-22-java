import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;

public class FormCruiserConfig {

	private JFrame frame;
	private WarshipDelegate eventAddWarship;
	private ITransport getWarship;
	private ITransport curWarship;
	private Color Color;
	private PanelCruiser drawpanel;
	private IOrudie orudie;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCruiserConfig window = new FormCruiserConfig(null);
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
	public JFrame getFrame() {
		return frame;
	}

	public FormCruiserConfig(WarshipDelegate eventAddWarship) {
		initialize();
		this.eventAddWarship = eventAddWarship;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JLabel WarshipLabel = new JLabel("Warship");
		WarshipLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				getWarship =new Warship(100, 1000, Color.BLACK, new DvaCircle());
				getWarship.SetPosition(drawpanel.getWidth() / 3 , drawpanel.getHeight() / 3, drawpanel.getWidth(), drawpanel.getHeight());
				}

			@Override
			public void mouseReleased(MouseEvent e) {
				getWarship = null;
			}
		});
		WarshipLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WarshipLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		WarshipLabel.setBounds(10, 11, 260, 54);
		WarshipLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(WarshipLabel);
		
		JLabel CruiserLabel = new JLabel("Cruiser");
		CruiserLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				getWarship = new Cruiser(100, 1000, Color.BLACK, Color.DARK_GRAY, new DvaCircle(), true, true);
				getWarship.SetPosition(drawpanel.getWidth() / 3 , drawpanel.getHeight() / 3, drawpanel.getWidth(), drawpanel.getHeight());
			
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				getWarship = null;
			}
		});
		CruiserLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CruiserLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		CruiserLabel.setBounds(10, 74, 260, 54);
		CruiserLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(CruiserLabel);
		
		JButton buttonAdd = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		buttonAdd.setFont(new Font("Times New Roman", Font.BOLD, 25));
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eventAddWarship.Invoke(curWarship);
				frame.dispose();
			}
		});
		buttonAdd.setBounds(10, 331, 260, 54);
		frame.getContentPane().add(buttonAdd);
		
		JButton buttonCancel = new JButton("\u041E\u0442\u043C\u0435\u043D\u0430");
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		buttonCancel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		buttonCancel.setBounds(10, 396, 260, 54);
		frame.getContentPane().add(buttonCancel);
		
		drawpanel = new PanelCruiser();
		drawpanel.setBounds(304, 11, 306, 160);
		
		drawpanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (getWarship != null) {
					curWarship = getWarship;
					drawpanel.PanelCruiserSet(curWarship);
					drawpanel.repaint();
				}
			}
		});
		drawpanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(drawpanel);
		
		JPanel panelBlack = new JPanel();
		panelBlack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Color = Color.BLACK;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				Color = null;
			}
		});
		panelBlack.setBackground(Color.BLACK);
		panelBlack.setBounds(672, 11, 50, 50);
		frame.getContentPane().add(panelBlack);
		
		JPanel panelWhite = new JPanel();
		panelWhite.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Color = Color.WHITE;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				Color = null;
			}
		});
		panelWhite.setBackground(Color.WHITE);
		panelWhite.setBounds(771, 11, 50, 50);
		frame.getContentPane().add(panelWhite);
		
		JPanel panelBlue = new JPanel();
		panelBlue.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Color = Color.BLUE;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				Color = null;
			}
		});
		panelBlue.setBackground(Color.BLUE);
		panelBlue.setBounds(672, 74, 50, 50);
		frame.getContentPane().add(panelBlue);
		
		JPanel panelGreen = new JPanel();
		panelGreen.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Color = Color.GREEN;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				Color = null;
			}
		});
		panelGreen.setBackground(Color.GREEN);
		panelGreen.setBounds(771, 74, 50, 50);
		frame.getContentPane().add(panelGreen);
		
		JPanel panelYellow = new JPanel();
		panelYellow.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Color = Color.YELLOW;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				Color = null;
			}
		});
		panelYellow.setBackground(Color.YELLOW);
		panelYellow.setBounds(672, 135, 50, 50);
		frame.getContentPane().add(panelYellow);
		
		JPanel panelPink = new JPanel();
		panelPink.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Color = Color.PINK;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				Color = null;
			}
		});
		panelPink.setBackground(Color.PINK);
		panelPink.setBounds(771, 135, 50, 50);
		frame.getContentPane().add(panelPink);
		
		JPanel panelOrange = new JPanel();
		panelOrange.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Color = Color.ORANGE;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				Color = null;
			}
		});
		panelOrange.setBackground(Color.ORANGE);
		panelOrange.setBounds(672, 196, 50, 50);
		frame.getContentPane().add(panelOrange);
		
		JPanel panelMagenta = new JPanel();
		panelMagenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Color = Color.MAGENTA;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				Color = null;
			}
		});
		panelMagenta.setBackground(Color.MAGENTA);
		panelMagenta.setBounds(771, 196, 50, 50);
		frame.getContentPane().add(panelMagenta);
		
		JLabel labelMainColor = new JLabel("\u041E\u0441\u043D\u043E\u0432\u043D\u043E\u0439 \u0446\u0432\u0435\u0442");
		labelMainColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (Color != null && curWarship != null) {
					curWarship.SetColor(Color);
					drawpanel.repaint();
				}
			}
		});
		labelMainColor.setHorizontalAlignment(SwingConstants.CENTER);
		labelMainColor.setFont(new Font("Times New Roman", Font.BOLD, 25));
		labelMainColor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		labelMainColor.setBounds(328, 182, 260, 54);
		frame.getContentPane().add(labelMainColor);
		
		JLabel labelDopColor = new JLabel("\u0414\u043E\u043F\u043E\u043B\u043D\u0438\u0442\u0435\u043B\u044C\u043D\u044B\u0439 \u0446\u0432\u0435\u0442");
		labelDopColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (Color != null && curWarship != null) {
					((Cruiser)curWarship).setDopColor(Color);
					drawpanel.repaint();
				}
			}
		});
		labelDopColor.setHorizontalAlignment(SwingConstants.CENTER);
		labelDopColor.setFont(new Font("Times New Roman", Font.BOLD, 25));
		labelDopColor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		labelDopColor.setBounds(328, 247, 260, 54);
		frame.getContentPane().add(labelDopColor);
		
		JLabel labelOrudie = new JLabel("\u041E\u0440\u0443\u0434\u0438\u044F");
		labelOrudie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (curWarship != null  ) {
					((Warship)curWarship).setGuns(orudie);
					drawpanel.repaint();
				}
			}
		});
		labelOrudie.setHorizontalAlignment(SwingConstants.CENTER);
		labelOrudie.setFont(new Font("Times New Roman", Font.BOLD, 25));
		labelOrudie.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		labelOrudie.setBounds(328, 312, 260, 54);
		frame.getContentPane().add(labelOrudie);
		
		JLabel labelDvaCircle = new JLabel("\u041E\u0434\u043D\u043E \u043E\u0432\u0430\u043B\u044C\u043D\u043E\u0435");
		labelDvaCircle.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				orudie = new DvaCircle();			
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				orudie = null;			}
		});
		labelDvaCircle.setHorizontalAlignment(SwingConstants.CENTER);
		labelDvaCircle.setFont(new Font("Times New Roman", Font.BOLD, 25));
		labelDvaCircle.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		labelDvaCircle.setBounds(641, 257, 202, 34);
		frame.getContentPane().add(labelDvaCircle);
		
		JLabel labelTriCircle = new JLabel("\u0414\u0432\u0430 \u043E\u0432\u0430\u043B\u044C\u043D\u044B\u0445");
		labelTriCircle.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				orudie = new TriCircle();			
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				orudie = null;			}
		});
		labelTriCircle.setHorizontalAlignment(SwingConstants.CENTER);
		labelTriCircle.setFont(new Font("Times New Roman", Font.BOLD, 25));
		labelTriCircle.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		labelTriCircle.setBounds(641, 302, 202, 34);
		frame.getContentPane().add(labelTriCircle);
		
		JLabel labelDvaTower = new JLabel("\u041E\u0434\u043D\u043E \u043A\u0440\u0443\u0433\u043B\u043E\u0435");
		labelDvaTower.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				orudie = new DvaTower();			
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				orudie = null;			}
		});
		labelDvaTower.setHorizontalAlignment(SwingConstants.CENTER);
		labelDvaTower.setFont(new Font("Times New Roman", Font.BOLD, 25));
		labelDvaTower.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		labelDvaTower.setBounds(641, 347, 202, 34);
		frame.getContentPane().add(labelDvaTower);
		
		JLabel labelTriTower = new JLabel("\u0414\u0432\u0430 \u043A\u0440\u0443\u0433\u043B\u044B\u0445");
		labelTriTower.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				orudie = new TriTower();			
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				orudie = null;			}
		});
		labelTriTower.setHorizontalAlignment(SwingConstants.CENTER);
		labelTriTower.setFont(new Font("Times New Roman", Font.BOLD, 25));
		labelTriTower.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		labelTriTower.setBounds(641, 396, 202, 34);
		frame.getContentPane().add(labelTriTower);
	}
}