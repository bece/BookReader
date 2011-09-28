/**
 * 
 */
package launcher;

import view.Window;

/*************************************************
 * @author jeremy Chevrier
 * @date Sep 7, 2011 - 12:02:59 AM
 * @comment This is an application to read comic books.
 * 
 *************************************************/

public class BookReader {

	/*************************************************
	 * @name : main
	 * @arguments : String[] args
	 * @comment : No comment for the Main !
	 * @return : void
	 *************************************************/
	public static void main (String[] args) {
		System.out.println ("BookReader hopes you enjoy about this application !");
		Window window = new Window ();
		window.setVisible (true); // Show the window
	}

}
