/**
 * 
 */
package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*************************************************
 * @author jeremy Chevrier
 * @date Sep 7, 2011 - 12:24:59 AM
 * @comment
 * 
 *************************************************/
public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -3739008754324139579L;

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
		this.initComponents ();
		this.setVisible (true);
	}

	/*************************************************
	 * @name : initComponents
	 * @arguments : none
	 * @comment :
	 * @return : none
	 *************************************************/
	public void initComponents () {
		JLabel labelPicture = new JLabel ();
		JPanel panelPicture = new JPanel ();
		ImageIcon iiPicture = new ImageIcon ("/home/jeremy/Pictures/Wallpapers/lara-croft-tomb-raider.jpg");
		
		labelPicture.setText ("Picture");
		labelPicture.setToolTipText ("Picture Tomb Raider");
		labelPicture.setIcon (iiPicture);
		
		panelPicture.add (labelPicture);		
		this.setContentPane (panelPicture);
	}
}
