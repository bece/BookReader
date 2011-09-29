/**
 * 
 */
package view;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*************************************************
 * @author jeremy Chevrier
 * @date Sep 7, 2011 - 12:24:59 AM
 * @comment
 * 
 *************************************************/
public class Window extends JFrame implements MouseListener {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -3739008754324139579L;
	private JButton buttonNext, buttonPrev;
	private ImageIcon iiPicture1, iiPicture2;
	private JLabel labelPicture;

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
		this.setLookAndFeel();
		this.initComponents ();
		this.pack();
		this.setVisible (true);
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
		
		iiPicture1 = new ImageIcon ("etc/pictures/lara-croft-tomb-raider.jpg");
		iiPicture2 = new ImageIcon ("etc/pictures/tomb-raider.jpg");
		
		buttonNext.addMouseListener(this);
		buttonPrev.addMouseListener(this);
		buttonPrev.setEnabled(false);
		
		labelPicture.setToolTipText ("Picture Tomb Raider");
		labelPicture.setIcon (iiPicture1);
		panelPicture.add (labelPicture);
		
		panelNext.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelNext.add (buttonNext);
		
		panelPrev.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelPrev.add (buttonPrev);
		
		panelNextPrev.setLayout(new BoxLayout(panelNextPrev, BoxLayout.LINE_AXIS));
		panelNextPrev.add(panelPrev);
		panelNextPrev.add(panelNext);
		
		container.setLayout (new BoxLayout (container, BoxLayout.PAGE_AXIS));
		container.add (panelNextPrev);
		container.add (panelPicture);
		
		this.setContentPane (container);
	}
	
	public void setLookAndFeel () {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource().equals(buttonNext)) {
			buttonNext.setEnabled(false);
			labelPicture.setIcon (iiPicture2);
			buttonPrev.setEnabled(true);
		} else if (arg0.getSource().equals(buttonPrev)){
			buttonPrev.setEnabled(false);
			labelPicture.setIcon(iiPicture1);
			buttonNext.setEnabled(true);
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
