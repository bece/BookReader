/**
 * 
 */
package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*************************************************
 * @author jeremy Chevrier
 * @date Sep 7, 2011 - 12:24:59 AM
 * @comment
 * 
 *************************************************/
public class Window extends JFrame implements MouseListener, ActionListener {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -3739008754324139579L;
	private JButton				buttonNext, buttonPrev;
	private JLabel				labelPicture;
	private JMenuBar			menuBar;
	private JMenu				menuFile;
	private JMenuItem			menuItemOpenDir;
	private JFileChooser		fileChooserDir;
	private ArrayList<ImageIcon> listImageIcon;
	private int currentPicture = 0;

	/*************************************************
	 * @name : Window
	 * @arguments : none
	 * @comment : Constructor
	 * @return : none
	 *************************************************/
	public Window () {
		super ();

		// Window properties
		this.setSize (1024, 768);
		this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		this.setTitle ("BookReader - Have a good reading !");
		this.setLocationRelativeTo (null);
		this.setLookAndFeel ();
		this.initMenus ();
		this.initComponents ();
		this.pack ();
		this.setVisible (true);
	}

	/*************************************************
	 * @name : initMenus
	 * @arguments : none
	 * @comment :
	 * @return : none
	 *************************************************/
	public void initMenus () {
		menuBar = new JMenuBar ();
		menuFile = new JMenu ("File");
		menuItemOpenDir = new JMenuItem ("Open Directory ...");
		menuItemOpenDir.addActionListener (this);
		menuFile.add (menuItemOpenDir);
		menuBar.add (menuFile);
		this.setJMenuBar (menuBar);
	}

	/*************************************************
	 * @name : initComponents
	 * @arguments : none
	 * @comment :
	 * @return : none
	 *************************************************/
	public void initComponents () {
		labelPicture = new JLabel ();

		buttonNext = new JButton ("Next");
		buttonPrev = new JButton ("Prev");

		JPanel panelPicture = new JPanel ();
		JPanel panelNext = new JPanel ();
		JPanel panelPrev = new JPanel ();
		JPanel panelNextPrev = new JPanel ();
		JPanel container = new JPanel ();

		buttonNext.addMouseListener (this);
		buttonNext.setEnabled(false);
		buttonPrev.addMouseListener (this);
		buttonPrev.setEnabled (false);

		labelPicture.setToolTipText ("Picture Tomb Raider");
		panelPicture.add (labelPicture);

		panelNext.setLayout (new FlowLayout (FlowLayout.LEFT));
		panelNext.add (buttonNext);

		panelPrev.setLayout (new FlowLayout (FlowLayout.RIGHT));
		panelPrev.add (buttonPrev);

		panelNextPrev.setLayout (new BoxLayout (panelNextPrev, BoxLayout.LINE_AXIS));
		panelNextPrev.add (panelPrev);
		panelNextPrev.add (panelNext);

		container.setLayout (new BoxLayout (container, BoxLayout.PAGE_AXIS));
		container.add (panelNextPrev);
		container.add (panelPicture);

		this.setContentPane (container);
	}

	public void setLookAndFeel () {
		try {
			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace ();
		} catch (InstantiationException e) {
			e.printStackTrace ();
		} catch (IllegalAccessException e) {
			e.printStackTrace ();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace ();
		}
	}
	
	public void getPictureFromDirectoy (String path) {
		listImageIcon = new ArrayList<ImageIcon>();
		File directory = new File(path);
		File[] list = directory.listFiles();
		if (list != null) {
			for (int i=0; i < list.length; i++) {
				System.out.println(list[i].getAbsolutePath());
				listImageIcon.add(i, new ImageIcon(list[i].getAbsolutePath()));
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked (MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource ().equals (buttonNext) && buttonNext.isEnabled()) {
			currentPicture++;
			if (currentPicture >= listImageIcon.size() - 1) buttonNext.setEnabled (false);
			labelPicture.setIcon (listImageIcon.get(currentPicture));
			if (!buttonPrev.isEnabled()) buttonPrev.setEnabled (true);
		} else if (arg0.getSource ().equals (buttonPrev) && buttonPrev.isEnabled()) {
			currentPicture--;
			if (currentPicture <= 0) buttonPrev.setEnabled (false);
			labelPicture.setIcon (listImageIcon.get(currentPicture));
			if (!buttonNext.isEnabled()) buttonNext.setEnabled (true);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered (MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited (MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed (MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased (MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed (ActionEvent arg0) {
		if (arg0.getSource ().equals (menuItemOpenDir)) {
			fileChooserDir = new JFileChooser ();
			fileChooserDir.setCurrentDirectory (new File ("~/"));
			fileChooserDir.changeToParentDirectory ();
			fileChooserDir.setFileSelectionMode (JFileChooser.DIRECTORIES_ONLY);
			int fileChooserReturn = fileChooserDir.showOpenDialog (null);
			if (fileChooserReturn == JFileChooser.APPROVE_OPTION) {
				System.out.println (fileChooserDir.getSelectedFile ().getPath ());
				getPictureFromDirectoy(fileChooserDir.getSelectedFile ().getPath ());
				labelPicture.setIcon(listImageIcon.get(0));
				buttonNext.setEnabled(true);
				this.pack();
			}
		}
	}
}
