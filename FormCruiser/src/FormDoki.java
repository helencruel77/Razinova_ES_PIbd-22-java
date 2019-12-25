import java.awt.Color;
import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;

public class FormDoki {

	private JFrame frame;
	private final int panelDokiWidth = 870;
	private final int panelDokiHeight = 460;
	private final int countLevels = 5;
	private MultiLevelDoki doki;
	private ITransport warship;
	private IOrudie orudie;
	private TakePanel panelTake;
	private PanelDoki paneldoki;
	private JTextField textField;
	private JList<String> list;
	int index = 0;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDoki window = new FormDoki();
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
	public FormDoki() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		doki = new MultiLevelDoki(countLevels, panelDokiWidth, panelDokiHeight);
		
		
		
		JButton buttonWarship = new JButton("\u0412\u043E\u0435\u043D\u043D\u044B\u0439 \u043A\u043E\u0440\u0430\u0431\u043B\u044C");
		buttonWarship.setBounds(692, 11, 182, 20);
		buttonWarship.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color newColor = JColorChooser.showDialog(frame, null, Color.blue);
				if (newColor != null) {
					Random rnd = new Random();
					warship = new Warship(rnd.nextInt(30)+20, rnd.nextInt(60)+140, newColor);	
					switch (rnd.nextInt(4) + 1) {
					case 1:
						orudie = new DvaCircle();
						break;
					case 2:
						orudie = new DvaTower();
						break;
					case 3:
						orudie = new TriCircle();
						break;
					case 4:
						orudie = new TriTower();
						break;
					} 
					int place = doki.getDoki(list.getSelectedIndex()).plus(warship, orudie);
					paneldoki.repaint();
				
				}
				
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(buttonWarship);
		
		JButton buttonCruiser = new JButton("\u041A\u0440\u0435\u0439\u0441\u0435\u0440");
		buttonCruiser.setBounds(692, 34, 182, 20);
		buttonCruiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color mainColor = JColorChooser.showDialog(frame, null, Color.blue);
				if (mainColor != null) {
					Color dopColor = JColorChooser.showDialog(frame, null, Color.blue);
					if (dopColor != null) {
						Random rnd = new Random();
						warship = new Cruiser(100, 1000,mainColor, dopColor, true, true);
						switch (rnd.nextInt(4) + 1) {
						case 1:
							orudie = new DvaCircle();
							break;
						case 2:
							orudie = new DvaTower();
							break;
						case 3:
							orudie = new TriCircle();
							break;
						case 4:
							orudie = new TriTower();
							break;
						}
						int place = doki.getDoki(list.getSelectedIndex()).plus(warship, orudie);
						paneldoki.repaint();
					}
				}
			}
		});
		frame.getContentPane().add(buttonCruiser);
		
		textField = new JTextField();
		textField.setBounds(801, 190, 57, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u041C\u0435\u0441\u0442\u043E: ");
		label.setBounds(726, 193, 48, 14);
		frame.getContentPane().add(label);
		
		String[] levels = new String[countLevels];
		for(int i = 0; i < countLevels; i++) {
			levels[i] = "Уровень" + (i + 1);
		}
		list = new JList(levels);
		list.setSelectedIndex(0);
		list.setBounds(700, 65, 125, 114);
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				index = list.getSelectedIndex();
				paneldoki.setDoki(doki.getDoki(index));
				paneldoki.repaint();
			}
		});
		frame.getContentPane().add(list);
		
		JButton buttonTake = new JButton("\u0417\u0430\u0431\u0440\u0430\u0442\u044C");
		buttonTake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText() != "") {
					ITransport transport = doki.getDoki(index).minus(Integer.parseInt(textField.getText()));
			
					if (transport != null) {
						panelTake.clear();
						panelTake.drawWarship(warship, orudie);
						
						panelTake.warship.SetPosition(30, 90, panelDokiWidth, panelDokiHeight);
						paneldoki.repaint();
						panelTake.repaint();
					}
				}
			}
		});
		buttonTake.setBounds(740, 218, 89, 23);
		frame.getContentPane().add(buttonTake);
		
		paneldoki = new PanelDoki(doki.getDoki(0));
		paneldoki.setBounds(10, 11, 672, 439);
		frame.getContentPane().add(paneldoki);
		
		panelTake = new TakePanel();
		panelTake.setBounds(692, 253, 182, 197);
		frame.getContentPane().add(panelTake);
		
	}
}
