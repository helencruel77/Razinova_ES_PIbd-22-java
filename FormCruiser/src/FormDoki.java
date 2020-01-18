
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class FormDoki {

	private JFrame frame;
	private final int panelDokiWidth = 870;
	private final int panelDokiHeight = 460;
	private final int countLevels = 5;
	private MultiLevelDoki doki;
	private TakePanel panelTake;
	private PanelDoki paneldoki;
	private JTextField textField;
	private JList<String> list;
	int index = 0;
	private JButton buttonCreate;
	
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
		frame.getContentPane().setLayout(null);
		
		
		textField = new JTextField();
		textField.setBounds(801, 190, 57, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u041C\u0435\u0441\u0442\u043E: ");
		label.setBounds(726, 193, 48, 14);
		frame.getContentPane().add(label);
		
		String[] levels = new String[countLevels];
		for(int i = 0; i < countLevels; i++) {
			levels[i] = "Óðîâåíü" + (i + 1);
		}
		list = new JList(levels);
		list.setSelectedIndex(0);
		list.setBounds(726, 11, 125, 114);
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
						transport.SetPosition(panelTake.getWidth() / 2 - 40 , panelTake.getHeight() / 2 - 20, panelTake.getWidth(),
								panelTake.getHeight());
						panelTake.Set(transport);
						
						paneldoki.repaint();
						panelTake.repaint();
					}
				}
			}
		});
		buttonTake.setBounds(740, 218, 89, 23);
		frame.getContentPane().add(buttonTake);
		
		paneldoki = new PanelDoki(doki.getDoki(0));
		paneldoki.setBounds(10, 35, 672, 415);
		frame.getContentPane().add(paneldoki);
		
		panelTake = new TakePanel();
		panelTake.setBounds(692, 253, 182, 197);
		frame.getContentPane().add(panelTake);
		panelTake.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		buttonCreate = new JButton("\u0417\u0430\u043A\u0430\u0437\u0430\u0442\u044C");
		buttonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormCruiserConfig config = new FormCruiserConfig(new WarshipDelegate() {
					@Override
					public void Invoke(ITransport transport) {
						if (transport != null && list.getSelectedIndex() > -1) {
							int place = doki.getDoki(list.getSelectedIndex()).plus(transport);
							if (place > -1)
								paneldoki.repaint();
						}
					}
					
				});
				config.getFrame().setVisible(true);
			}
		});
		buttonCreate.setBounds(736, 136, 89, 23);
		frame.getContentPane().add(buttonCreate);

		
		JMenuBar menuBar = new JMenuBar();
		
		menuBar.setBounds(10, 11, 99, 22);
		frame.getContentPane().add(menuBar);
		
		JMenu menuSaveLoad = new JMenu("SaveLoad");
		
		menuBar.add(menuSaveLoad);
		
		JMenuItem mntmSaveall = new JMenuItem("SaveAll");
		mntmSaveall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 try {
					 
					FileDialog fileDialog = new FileDialog(new Frame(), "Save", FileDialog.SAVE);
			        fileDialog.setVisible(true);
			        if (fileDialog.getFile() != null)
			        {
		           
						if (doki.Save(fileDialog.getDirectory() + fileDialog.getFile()))
						{
							JOptionPane.showMessageDialog(null,"ok");
						}
						else
						{
							JOptionPane.showMessageDialog(null,"not ok");
						}
			        }
				 } catch (HeadlessException | IOException e1) {
						e1.printStackTrace();
					}
		        }
		});
		menuSaveLoad.add(mntmSaveall);
		
		JMenuItem mntmLoadall = new JMenuItem("LoadAll");
		mntmLoadall.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					LoadAll();
				} catch (NumberFormatException | HeadlessException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		menuSaveLoad.add(mntmLoadall);
		
		JMenuItem mntmSavelevel = new JMenuItem("SaveLevel");
		mntmSavelevel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					FileDialog fileDialog = new FileDialog(new Frame(), "Save", FileDialog.SAVE);
					fileDialog.setVisible(true);
					if (fileDialog.getFile() != null)
					{
					    if (doki.SaveLevel(fileDialog.getDirectory() + fileDialog.getFile(), list.getSelectedIndex()))
					    {
							JOptionPane.showMessageDialog(null,"ok");
					    }
					    else
					    {
							JOptionPane.showMessageDialog(null,"not ok");
					    }
					}
				} catch (NumberFormatException | HeadlessException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		menuSaveLoad.add(mntmSavelevel);
		
		JMenuItem mntmLoadlevel = new JMenuItem("LoadLevel");
		mntmLoadlevel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					LoadLevel();
				} catch (NumberFormatException | HeadlessException | IOException e1 ) {
					e1.printStackTrace();
				}
				paneldoki.repaint();
			}
		});
		menuSaveLoad.add(mntmLoadlevel);
	}
	
	private void LoadAll() throws HeadlessException, IOException {
		
		FileDialog fileDialog = new FileDialog(new Frame(), "Save", FileDialog.LOAD);
        fileDialog.setVisible(true);
        if (fileDialog.getFile() != null)
        {
            try {
				if (doki.Load(fileDialog.getDirectory() + fileDialog.getFile()))
				{
					JOptionPane.showMessageDialog(null,"ok");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"not ok");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
            paneldoki.setDoki(doki.getDoki(list.getSelectedIndex()));
            paneldoki.repaint();
        }
    }
	
	private void LoadLevel() throws HeadlessException, IOException {
		
		FileDialog fileDialog = new FileDialog(new Frame(), "Save", FileDialog.LOAD);
		fileDialog.setVisible(true);
	    if (fileDialog.getFile() != null)
	    {
	        try {
				if (doki.LoadLvl(fileDialog.getDirectory() + fileDialog.getFile(), list.getSelectedIndex()))
				{
					JOptionPane.showMessageDialog(null,"ok");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"not ok");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	        
	    }
    }



}
